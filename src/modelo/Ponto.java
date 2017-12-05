package modelo;


import java.io.Serializable;

/**
 *  @author Déborah A. Resende
 *  @author Diego Maicon
 *
 *  Classe modelo de um plonto no plano Cartesiano
 *
 */

public class Ponto implements Serializable{
    private int x;
    private int y;

    public Ponto(int i) {
    }

    public Ponto() {
    }

    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public String toString()
    {
        return "Point[x=" + x + ",y=" + y + "]";
    }


}
