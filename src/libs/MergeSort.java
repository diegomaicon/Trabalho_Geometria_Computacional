package libs;

import modelo.Ponto;

public class MergeSort<T extends Comparable<T>>{

    /**
     * O merge consiste na junção de duas listas já ordenadas.
     * Usa um array auxiliar.
     *
     * @param vetorP
     * @param indiceInicio
     * @param meio
     * @param indiceFim
     */
    private  void merge(Ponto vetorP[], int indiceInicio, int meio, int indiceFim) {
        //Índices auxiliares
        int n1 = meio - indiceInicio + 1;
        int n2 = indiceFim - meio;

        /* Vetor Temporarios */
        Ponto L[] = new Ponto[n1];
        Ponto R[] = new Ponto[n2];

        for (int i=0; i<n1; ++i)
            L[i] = vetorP[indiceInicio + i];
        for (int j=0; j<n2; ++j)
            R[j] = vetorP[meio + 1+ j];


        int i = 0, j = 0;


        int k = indiceInicio;
        while (i < n1 && j < n2)
        {
            if (L[i].getX() <= R[j].getX())
            {
                vetorP[k] = L[i];
                i++;
            }
            else
            {
                vetorP[k] = R[j];
                j++;
            }
            k++;
        }

        //Append de itens que não foram usados na Junção
        while (i < n1)
        {
            vetorP[k] = L[i];
            i++;
            k++;
        }

        //Append de itens que não foram usados na Junção
        while (j < n2)
        {
            vetorP[k] = R[j];
            j++;
            k++;
        }
    }



    /**
    * Método que recebe um array de inteiros e dois inteiros referentes ao início e ao fim
	* da ordenação desse array, o que nos garante o poder de escolher uma faixa do array
	* para ser ordenado.
	*
     * @param vetorP
	* @param indiceInicio
	* @param indiceFim
	*
     */
   public Ponto[] sort(Ponto vetorP[], int indiceInicio, int indiceFim) {
        // Condicional que verifica a validade dos parâmetros passados.
        if (vetorP != null && indiceInicio < indiceFim && indiceInicio >= 0 &&
                indiceFim < vetorP.length && vetorP.length != 0) {

            int meio = (indiceInicio+indiceFim)/2;

            sort(vetorP, indiceInicio, meio);
            sort(vetorP , meio+1, indiceFim);

            merge(vetorP, indiceInicio, meio, indiceFim);
        }

     return vetorP;
   }
}
