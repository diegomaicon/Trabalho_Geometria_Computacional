package modelo;

/**
 *  @author Déborah A. Resende
 *  @author Diego Maicon
 *
 *  Classe modelo qu representa itens na mochila;
 *
 */
public class ItemMochila {
    private int numItem;
    private int peso;

    public ItemMochila(int numItem, int peso) {
        this.numItem = numItem;
        this.peso = peso;
    }

    public ItemMochila() {
    }

    public int getNumItem() {
        return numItem;
    }

    public void setNumItem(int numItem) {
        this.numItem = numItem;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
