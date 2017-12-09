package modelo;

public class Circulo {
    private Ponto ponto;
    private float raio;

    public Circulo(Ponto ponto, float raio) {
        this.ponto = ponto;
        this.raio = raio;
    }

    public Circulo() {

    }

    public Ponto getPonto() {
        return ponto;
    }

    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }

    public float getRaio() {
        return raio;
    }

    public void setRaio(float raio) {
        this.raio = raio;
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "ponto=" + ponto +
                ", raio=" + raio +
                '}';
    }
}
