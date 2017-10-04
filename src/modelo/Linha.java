package modelo;

public class Linha {
    private Ponto pL1;
    private Ponto pL2;

    public Linha(Ponto pL1, Ponto pL2) {
        this.pL1 = pL1;
        this.pL2 = pL2;
    }

    public Linha() {
    }

    public Ponto getpL1() {
        return pL1;
    }

    public void setpL1(Ponto pL1) {
        this.pL1 = pL1;
    }

    public Ponto getpL2() {
        return pL2;
    }

    public void setpL2(Ponto pL2) {
        this.pL2 = pL2;
    }
}
