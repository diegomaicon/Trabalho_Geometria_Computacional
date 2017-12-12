package libs.voronoi;

import modelo.Ponto;

/**
 *  Um evento é um evento de local ou círculo para a linha de varredura para processar
 *
 *  Um ponto-evento ocorre quando a linha de varredura passa por um ponto qualquer.
 *  Depois que isso acontece, um novo arco é adicionado à linha de praia.
 *  Esse novo arco pode quebrar um arco já existente em dois.
 *
 */
public class Event implements Comparable <Event>{
	
	// um evento do local é quando o ponto é um local
	public static int SITE_EVENT = 0;
	
	// Um evento em círculo é quando o ponto é um vértice do diagrama / parábola voronoi
	public static int CIRCLE_EVENT = 1;
	
	Ponto p;
	int type;
	Parabola arc; //apenas se evento de círculo
	
	public Event (Ponto p, int type) {
		this.p = p;
		this.type = type;
		arc = null;
	}
	
	public int compareTo(Event other) {
		return this.p.compareTo(other.p);
	}

}
