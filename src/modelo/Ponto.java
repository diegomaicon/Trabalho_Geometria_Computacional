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

    // classificar primeiro em x, então em y
    public int compareTo(Ponto other)
    {
        if( x == other.x)
            return y - other.y;
        else
            return x - other.x;
    }

    // // produto cruzado de dois vetores
    public int cross( Ponto p)
    {
        return x * p.y - y * p.x;
    }

    //  subtração de dois pontos
    public Ponto sub( Ponto p)
    {
        return new Ponto( x - p.x, y - p.y );
    }

    public String toString()
    {
        return "Point[x=" + x + ",y=" + y + "]";
    }


}
