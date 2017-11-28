package modelo;

public class Item {
    private int peso;
    private int valor;

    public Item(int peso, int valor) {
        this.peso = peso;
        this.valor = valor;
    }

    public Item() {
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
