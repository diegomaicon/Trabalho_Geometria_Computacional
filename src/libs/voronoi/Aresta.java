package libs.voronoi;

import modelo.Ponto;

//uma borda no diagrama de Voronoi
public class Aresta {


	private Ponto start;
	private Ponto end;
	Ponto site_left;
	Ponto site_right;
	Ponto direction; /* borda é realmente um vetor normal para os pontos esquerdo e direito */
	
	Aresta vizinho; /* a mesma borda, mas apontando na direção oposta*/
	
	int declive;
	int yint;
	
	public Aresta(Ponto primeiro, Ponto esquerdo, Ponto direito) {
		start = primeiro;
		site_left = esquerdo;
		site_right = direito;
		direction = new Ponto(direito.getY() - esquerdo.getX(), - (direito.getX() - esquerdo.getX()));
		end = null;

		declive = (direito.getX() - esquerdo.getX()) / (esquerdo.getY() - direito.getY());

		Ponto mid = new Ponto ((direito.getX() + esquerdo.getX())/2, (esquerdo.getY()+direito.getY())/2);
		yint = mid.getY() - declive *mid.getX();
	}

	public Ponto getStart() {
		return start;
	}

	public void setStart(Ponto start) {
		this.start = start;
	}

	public void setEnd(Ponto end) {
		this.end = end;
	}

	public Ponto getEnd() {
		return end;
	}

	public String toString() {
		return start + ", " + end;
	}
}
