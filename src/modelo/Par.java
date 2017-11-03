package modelo;

public class Par {

    public Ponto p1 = null;
    public Ponto p2 = null;
    public double distancia = 0.0;

    public Par(){
    }

    public Par(Ponto p1, Ponto p2) {
        this.p1 = p1;
        this.p2 = p2;
        calcDistance();
    }

    public void update(Ponto p1, Ponto p2, double distancia) {
        this.p1 = p1;
        this.p2 = p2;
        this.distancia = distancia;
    }

    public static double distancia(Ponto p1, Ponto p2){
        return Math.sqrt(Math.pow(p1.getX()-p2.getX(),2) + Math.pow((p1.getY() - p2.getY()),2) );
    }

    public void calcDistance() {
        this.distancia = distancia(p1, p2);
    }

    public String toString() {
        return p1 + "-" + p2 + " : " + distancia;
    }
}
