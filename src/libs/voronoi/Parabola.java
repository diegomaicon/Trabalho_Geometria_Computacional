package libs.voronoi;

import modelo.Ponto;

/**
 *  Representa a linha da praia
 *  pode ser um locais que é o centro de uma parábola
 *  ou pode ser um vértice que divide dois locais
 */
public class Parabola {
	
	public static int IS_FOCUS = 0;
	public static int IS_VERTEX = 1;
	
	int tipo;
	Ponto ponto; // este é o foco
	Aresta aresta; // este é o vertice
	Event event; //uma parábola com foco pode desaparecer em um evento de círculo
	
	Parabola parent;
	Parabola filhoEsquerdo;
	Parabola filhoDireito;
	
	public Parabola () {
		tipo = IS_VERTEX;
	}
	
	public Parabola (Ponto p) {
		ponto = p;
		tipo = IS_FOCUS;
	}

	public void setLeftChild (Parabola p) {
		filhoEsquerdo = p;
		p.parent = this;
	}

	public void setRightChild (Parabola p) {
		filhoDireito = p;
		p.parent = this;
	}

	public String toString() {
		if (tipo == IS_FOCUS) {
			return "Concentre-se em " +ponto;
		}
		else{
			return "Vertice|Aresta começando em " + aresta.getStart();
		}
	}

	/**
	 * 	Retorna o local mais próximo do lado esquerdo (foco da parábola)
	 *
	 * @param p
	 * @return
	 */
	public static Parabola getLeft(Parabola p) {
		return getLeftChild(getLeftParent(p));
	}

	/**
	 * Retorna o lugar certo mais próximo (foco da parábola)
	 *
 	 * @param p
	 * @return
	 */
	public static Parabola getRight(Parabola p) {
		return getRightChild(getRightParent(p));
	}

	/**
	 * Retorna o pai mais próximo à esquerda
	 *
	 * @param p
	 * @return
	 */
	public static Parabola getLeftParent(Parabola p) {
		Parabola parent = p.parent;
		if (parent == null) return null;
		Parabola last = p;
		while (parent.filhoEsquerdo == last) {
			if(parent.parent == null) return null;
			last = parent;
			parent = parent.parent;
		}
		return parent;
	}

	/**
	 * Retorna o pai mais próximo à direita
	 *
	 * @param p
	 * @return
	 */
	public static Parabola getRightParent(Parabola p) {
		Parabola parent = p.parent;
		if (parent == null) return null;
		Parabola last = p;
		while (parent.filhoDireito == last) {
			if(parent.parent == null) return null;
			last = parent;
			parent = parent.parent;
		}
		return parent;
	}

	/**
	 * Retorna o local mais próximo (foco de outra parábola) para a esquerda
	 *
	 * @param p
	 * @return
	 */
	public static Parabola getLeftChild(Parabola p) {
		if (p == null) return null;
		Parabola child = p.filhoEsquerdo;
		while(child.tipo == IS_VERTEX) child = child.filhoDireito;
		return child;
	}

	/**
	 *  Retorna o local mais próximo (foco de outra parábola) para a direita
	 *
	 * @param p
	 * @return
	 */
	public static Parabola getRightChild(Parabola p) {
		if (p == null) return null;
		Parabola child = p.filhoDireito;
		while(child.tipo == IS_VERTEX) child = child.filhoEsquerdo;
		return child;	
	}

}
