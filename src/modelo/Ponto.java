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

    public Ponto(float abs, float v) {
    }

    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Ponto() {

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


    public int compareTo(Ponto other) {
        if (this.y == other.y) {
            if (this.x == other.x) return 0;
            else if (this.x > other.x) return 1;
            else return -1;
        }
        else if (this.y > other.y) {
            return 1;
        }
        else {
            return -1;
        }
    }

    public String toString()
    {
        return " (" + x + ", " + y + ")";
    }


}
