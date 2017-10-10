package modelo;

import java.util.ArrayList;

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
