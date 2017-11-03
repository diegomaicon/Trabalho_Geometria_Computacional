package modelo;

import com.ibm.jsse2.P;

public class Ponto {
    private int x;
    private int y;

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
