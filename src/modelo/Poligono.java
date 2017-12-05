package modelo;

import java.util.ArrayList;

/**
 *  @author Déborah A. Resende
 *  @author Diego Maicon
 * Classe modelo de um polifono, Conjunto maior que 3 pontos
 *
 */
public class Poligono {

    private ArrayList<Ponto> pol;

    public Poligono(ArrayList<Ponto> pol) {
        this.pol = pol;
    }

    public ArrayList<Ponto> getPol() {
        return pol;
    }

    public void setPol(ArrayList<Ponto> pol) {
        this.pol = pol;
    }
}
