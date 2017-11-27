package modelo;

public class EstrategiasPA {


    /**
     * Prova ENADE 2017
     * Suponha que tenhamos dispon´ıveis moedas com valores de 50, 25, 10, 5 e 1. O problema
       e criar um algoritmo que para conseguir obter um determinado valor com o menor n ´ umero de moedas ´
       possível (problema do troco).
     *
     *
     * @param valor
     * @return
     */

    public static int[] gulosoProblemaTroco(float valor){
        int[] moedas = new int[5];

        moedas[0] = (int) (valor / 0.50);
        valor = (float) (valor % 0.50);

        moedas[1] = (int) (valor / 0.25);
        valor = (float) (valor % 0.25);

        moedas[2] = (int) (valor / 0.10);
        valor = (float) (valor % 0.10);

        moedas[3] = (int) (valor / 0.5);
        valor = (float) (valor % 0.5);

        moedas[4] = (int) (valor / 0.1);

        return moedas;

    }
}
