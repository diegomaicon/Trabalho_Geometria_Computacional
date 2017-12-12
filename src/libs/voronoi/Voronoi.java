package libs.voronoi;// the voronoi diagram (a set of arestas) for a set of points (locais)


import modelo.Ponto;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;




/**
 * O diagrama voronoi (um conjunto de arestas) para um conjunto de pontos (locais)
 *
 *
 * 	A estrutura de dados principal usada no algoritmo da linha de varredura da Fortune é uma árvore binária que
 	representa uma linha de praia, que é composta por uma série de parábolas (equidistantes de cada
 	local processado e a linha de varredura) e vértices que dividem locais adjacentes.

 	Quando o algoritmo lida com um novo local ou um novo vértice, o processo exige adicionar ou remover nó (s) do
 	árvore, que leva O (log n). Como o número total de eventos é linear (o número de faces
 	no diagrama de Voronoi é igual ao número de sites N, de modo que o número máximo de vértices em
 	qualquer face será um múltiplo de N), o tempo de execução geral do algoritmo é O (n log n).

 O algoritmo roda em O(nlogn) e usa O(n) de memoria
 	• Classificacao em Y: O(nlogn)
 	• Estrutura de dados
 	• Operacoes em T: O(logn)
 	• Operacoes na lista de aresta: constante
 	• Operacoes na fila de eventos: O(logn)
 	• Operacoes em eventos: constante
 	• Custo de um evento: O(logn)
	• n eventos de sitio
 	• numero de eventos de circulo: 2n-5 no maximo

 */
public class Voronoi {

	List<Ponto> locais;
	private ArrayList<Aresta> arestas; // arestas do Voronoi diagram
	PriorityQueue<Event> events; //a fila de prioridade representa a linha de varredura
	Parabola root; // árvore de pesquisa binária representa linha de praia

	// Tamanho da Janela
	int width = 1;
	int height = 1;

	int ycurr; // atual y-coord da linha de varredura

	public ArrayList<Aresta> getArestas() {
		return arestas;
	}

	public void setArestas(ArrayList<Aresta> arestas) {
		this.arestas = arestas;
	}

	public Voronoi(List<Ponto> locais) {
		this.locais = locais;
		arestas = new ArrayList<Aresta>();
		generateVoronoi();
	}

	private void generateVoronoi() {

		events = new PriorityQueue<Event>();
		for (Ponto p : locais) {
			events.add(new Event(p, Event.SITE_EVENT));
		}

		// eventos de processo (linha de varredura)
		int count = 0;
		while (!events.isEmpty()) {
			//System.out.println();
			Event e = events.remove();
			ycurr = e.p.getY();
			count++;
			if (e.type == Event.SITE_EVENT) {
				//System.out.println(count + ". SITE_EVENT " + e.p);
				handleSite(e.p);
			} else {
				//System.out.println(count + ". CIRCLE_EVENT " + e.p);
				handleCircle(e);
			}
		}

		ycurr = width + height;

		endArestas(root); // close off any dangling arestas

		// get rid of those crazy inifinte lines
		for (Aresta e : arestas) {
			if (e.vizinho != null) {
				e.setStart(e.vizinho.getEnd());
				e.vizinho = null;
			}
		}
	}

	/**
	 * Termine todas as arestas inacabadas
	 *
	 * @param p
	 */

	private void endArestas(Parabola p) {
		if (p.tipo == Parabola.IS_FOCUS) {
			p = null;
			return;
		}

		int x = getXofAresta(p);
		p.aresta.setEnd(new Ponto(x, p.aresta.declive * x + p.aresta.yint));
		arestas.add(p.aresta);

		endArestas(p.filhoEsquerdo);
		endArestas(p.filhoDireito);

		p = null;
	}

	/**
	 * Buscar em T o arco a verticalmente acima de pi, e deletar todos eventos
	   de circulo associados a ele (ponteiros para a priority queue)
	 *
	 *
	 * Trocar a folha pj que representa p em T representando a por tres folhas.
	   A folha do meio contem o sitio pi, e as outras duas contem pj.
	 	Atualizar os nodos com <pj,pi> e <pi,pj>.Rebalancear !
	 * @param p
	 */
	private void handleSite(Ponto p) {
		// base case
		if (root == null) {
			root = new Parabola(p);
			return;
		}

		// Encontre a parábola na linha da praia logo acima p
		Parabola par = getParabolaByX(p.getX());
		if (par.event != null) {
			events.remove(par.event);
			par.event = null;
		}

		// Criar novo aresta pendurado; divide o foco da parábola e p
		Ponto start = new Ponto(p.getX(), getY(par.ponto, p.getX()));
		Aresta el = new Aresta(start, par.ponto, p);
		Aresta er = new Aresta(start, p, par.ponto);
		el.vizinho = er;
		er.vizinho = el;
		par.aresta = el;
		par.tipo = Parabola.IS_VERTEX;

		// Substitua parabola par original com p0, p1, p2
		Parabola p0 = new Parabola(par.ponto);
		Parabola p1 = new Parabola(p);
		Parabola p2 = new Parabola(par.ponto);

		par.setLeftChild(p0);
		par.setRightChild(new Parabola());
		par.filhoDireito.aresta = er;
		par.filhoDireito.setLeftChild(p1);
		par.filhoDireito.setRightChild(p2);

		checkCircleEvent(p0);
		checkCircleEvent(p2);
	}

	// process circle event
	private void handleCircle(Event e) {

		// Encontre p0, p1, p2 que geram esse evento da esquerda para a direita
		Parabola p1 = e.arc;
		Parabola xl = Parabola.getLeftParent(p1);
		Parabola xr = Parabola.getRightParent(p1);
		Parabola p0 = Parabola.getLeftChild(xl);
		Parabola p2 = Parabola.getRightChild(xr);

		// Remover eventos associados, uma vez que os pontos serão alterados
		if (p0.event != null) {
			events.remove(p0.event);
			p0.event = null;
		}
		if (p2.event != null) {
			events.remove(p2.event);
			p2.event = null;
		}

		Ponto p = new Ponto(e.p.getX(), getY(p1.ponto, e.p.getX())); // novo Vertice

		// Fim arestas!
		xl.aresta.setEnd(p);
		xr.aresta.setEnd(p);
		arestas.add(xl.aresta);
		arestas.add(xr.aresta);

		// Começa uma nova aresta a partir deste vértice em que aresta sempre original é maior na árvore
		Parabola maisAlto = new Parabola();
		Parabola par = p1;
		while (par != root) {
			par = par.parent;
			if (par == xl) maisAlto = xl;
			if (par == xr) maisAlto = xr;
		}
		maisAlto.aresta = new Aresta(p, p0.ponto, p2.ponto);

		// Apagar p1 e pai fronteira aresta da linha da praia
		Parabola gparent = p1.parent.parent;
		if (p1.parent.filhoEsquerdo == p1) {
			if (gparent.filhoEsquerdo == p1.parent) gparent.setLeftChild(p1.parent.filhoDireito);
			if (gparent.filhoDireito == p1.parent) gparent.setRightChild(p1.parent.filhoDireito);
		} else {
			if (gparent.filhoEsquerdo == p1.parent) gparent.setLeftChild(p1.parent.filhoEsquerdo);
			if (gparent.filhoDireito == p1.parent) gparent.setRightChild(p1.parent.filhoEsquerdo);
		}

		Ponto op = p1.ponto;
		p1.parent = null;
		p1 = null;

		checkCircleEvent(p0);
		checkCircleEvent(p2);
	}

	// Adiciona evento de círculo se os focos a, b, c se encontram no mesmo círculo
	private void checkCircleEvent(Parabola b) {

		Parabola lp = Parabola.getLeftParent(b);
		Parabola rp = Parabola.getRightParent(b);

		if (lp == null || rp == null) return;

		Parabola a = Parabola.getLeftChild(lp);
		Parabola c = Parabola.getRightChild(rp);

		if (a == null || c == null || a.ponto == c.ponto) return;

		if (ccw(a.ponto, b.ponto, c.ponto) != 1) return;

		// Arestas se cruzarão para formar um vértice para um evento de círculo
		Ponto start = getArestaIntersection(lp.aresta, rp.aresta);
		if (start == null) return;

		// raio de cálculo
		int dx = b.ponto.getX() - start.getX();
		int dy = b.ponto.getY() - start.getY();
		int d = (int) Math.sqrt((dx * dx) + (dy * dy));
		if (start.getY() + d < ycurr) return; // Deve ser após a linha de varredura

		Ponto ep = new Ponto(start.getX(), start.getY() + d);
		//System.out.println("added circle event "+ ep);

		// add circle event
		Event e = new Event(ep, Event.CIRCLE_EVENT);
		e.arc = b;
		b.event = e;
		events.add(e);
	}

	/**
	 * É a-> b-> c uma voltagem no sentido anti-horário?
	 * +1 se no sentido anti-horário, -1 no sentido horário, 0 se colinear
	 *
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public int ccw(Ponto a, Ponto b, Ponto c) {
		double area2 = (b.getX() - a.getX()) * (c.getY() - a.getY()) - (b.getY() - a.getY()) * (c.getX() - a.getX());
		if (area2 < 0) return -1;
		else if (area2 > 0) return 1;
		else return 0;
	}

	/**
	 * Retorna a intersecção das linhas de com os vetores a e b
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	private Ponto getArestaIntersection(Aresta a, Aresta b) {

		if (b.declive == a.declive && b.yint != a.yint) return null;


		int x	= (b.yint - a.yint) / (a.declive - b.declive);


		int y = a.declive * x + a.yint;

		return new Ponto(x, y);
	}


	/**
	 * Retorna a atual x-coordenada de uma aresta inacabada@param par
	 *
	 * @return
	 */
	private int getXofAresta(Parabola par) {

		// encontra interseção de duas parábolas

		Parabola left = Parabola.getLeftChild(par);
		Parabola right = Parabola.getRightChild(par);

		Ponto p = left.ponto;
		Ponto r = right.ponto;

		double dp = 2 * (p.getY() - ycurr);
		double a1 = 1 / dp;
		double b1 = -2 * p.getX() / dp;
		double c1 = (p.getX() * p.getX() + p.getY() * p.getY() - ycurr * ycurr) / dp;

		double dp2 = 2 * (r.getY() - ycurr);
		double a2 = 1 / dp2;
		double b2 = -2 * r.getX() / dp2;
		double c2 = (r.getX() * r.getX() + r.getY() * r.getY() - ycurr * ycurr) / dp2;

		double a = a1 - a2;
		double b = b1 - b2;
		double c = c1 - c2;

		double disc = b * b - 4 * a * c;
		double x1 = (-b + Math.sqrt(disc)) / (2 * a);
		double x2 = (-b - Math.sqrt(disc)) / (2 * a);

		double ry;
		if (p.getY() > r.getY()) ry = Math.max(x1, x2);
		else ry = Math.min(x1, x2);

		return (int) ry;
	}

	/**
	 * Retorna a parábola acima desta coordenada x na linha da praia
	 *
	 * @param xx
	 * @return
	 */
	private Parabola getParabolaByX(double xx) {
		Parabola par = root;
		double x = 0;
		while (par.tipo == Parabola.IS_VERTEX) {
			x = getXofAresta(par);
			if (x > xx) par = par.filhoEsquerdo;
			else par = par.filhoDireito;
		}
		return par;
	}

	/**
	 * Encontre a coordenada-y correspondente para x na parábola com foco p
	 *
	 * @param p
	 * @param x
	 * @return
	 */
	private int getY(Ponto p, double x) {
		// eterminar equação para a parábola em torno do foco p
		double dp = 2 * (p.getY() - ycurr);
		double a1 = 1 / dp;
		double b1 = -2 * p.getX() / dp;
		double c1 = (p.getX() * p.getX() + p.getY() * p.getY() - ycurr * ycurr) / dp;
		return (int) (a1 * x * x + b1 * x + c1);
	}
}
