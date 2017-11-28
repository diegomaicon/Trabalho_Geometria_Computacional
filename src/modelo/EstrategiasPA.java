package modelo;

import java.util.ArrayList;

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

    /**
     *  A Complexidade do algoritmo de programacão
     *  dinâmica para o problema da mochila  é O(nW)

        O numero total máximo de subproblemas a serem  computados é nW.
        Isso porque tanto o tamanho dos itens quanto a capacidade da mochila são inteiros!

        Podemos entao usar programacão dinâmica para evitar o recalculo de subproblemas.
     *
     * @param itens
     * @param capacidade
     * @return
     */
    public static int[][] proDinamica(ArrayList<Item> itens, int capacidade ){

        //Referência: https://www.youtube.com/watch?v=pEH5uuC4nlw

        int[][] matrix = new int[itens.size() + 1][capacidade + 1];

        //Inicia primeira linha com 0
        for (int i = 0; i < capacidade; i++) {
            matrix[0][i] = 0;
        }
        //Inicia primeira coluna com 0
        for (int i = 0; i < itens.size(); i++) {
            matrix[i][0] = 0;
        }

        for (int i = 1; i < itens.size()+1; i++) {   //Itera sobre as linhas da matriz, exceto a primeira

            int k = i - 1; //Índice correto do item

            for (int j = 0; j < capacidade+1; j++) {   //Itera sobre as colunas (pesos, w=0 até W)

                if (itens.get(k).getPeso() <= j) {   //Se o item cabe na mochila de peso w

                    //Calcula o valor do bloco
                    int value = itens.get(k).getValor() + matrix[i - 1][j - itens.get(k).getPeso()];

                    //Atribui na matriz o maior valor entre o calculado no codigo acima e o da linha anterior da matriz.
                    matrix[i][j] = (value < matrix[i - 1][j]) ? (matrix[i - 1][j]) : value;

                } else {    //Se o item não cabe na mochila de peso w

                    //Atribui a matriz o valor da linha acima.
                    matrix[i][j] = matrix[i - 1][j];

                }

            }

        }

        return matrix;
    }

}