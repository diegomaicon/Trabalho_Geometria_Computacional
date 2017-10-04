package modelo;

public class SegmentoReta {

    private Ponto pSR1;
    private Ponto pSR2;

    public SegmentoReta(Ponto pSR1, Ponto pSR2) {
        this.pSR1 = pSR1;
        this.pSR2 = pSR2;
    }

    public SegmentoReta() {
    }


    public Ponto getpSR1() {
        return pSR1;
    }

    public void setpSR1(Ponto pSR1) {
        this.pSR1 = pSR1;
    }

    public Ponto getpSR2() {
        return pSR2;
    }

    public void setpSR2(Ponto pSR2) {
        this.pSR2 = pSR2;
    }
}
