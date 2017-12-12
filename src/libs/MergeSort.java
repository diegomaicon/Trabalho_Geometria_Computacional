package libs;

import modelo.Linha;
import modelo.Poligono;
import modelo.Ponto;
import modelo.SegmentoReta;

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
    private  void mergeX(Ponto vetorP[], int indiceInicio, int meio, int indiceFim) {
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
    public Ponto[] sortX(Ponto vetorP[], int indiceInicio, int indiceFim) {
        // Condicional que verifica a validade dos parâmetros passados.
        if (vetorP != null && indiceInicio < indiceFim && indiceInicio >= 0 &&
                indiceFim < vetorP.length && vetorP.length != 0) {

            int meio = (indiceInicio+indiceFim)/2;

            sortX(vetorP, indiceInicio, meio);
            sortX(vetorP , meio+1, indiceFim);

            mergeX(vetorP, indiceInicio, meio, indiceFim);
        }

        return vetorP;
    }


    /**
     * O merge consiste na junção de duas listas já ordenadas.
     * Usa um array auxiliar.
     *
     * @param vetorP
     * @param indiceInicio
     * @param meio
     * @param indiceFim
     */
    private  void mergeY(Ponto vetorP[], int indiceInicio, int meio, int indiceFim) {
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
            if (L[i].getY() <= R[j].getY())
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
    public Ponto[] sortY(Ponto vetorP[], int indiceInicio, int indiceFim) {
        // Condicional que verifica a validade dos parâmetros passados.
        if (vetorP != null && indiceInicio < indiceFim && indiceInicio >= 0 &&
                indiceFim < vetorP.length && vetorP.length != 0) {

            int meio = (indiceInicio+indiceFim)/2;

            sortY(vetorP, indiceInicio, meio);
            sortY(vetorP , meio+1, indiceFim);

            mergeY(vetorP, indiceInicio, meio, indiceFim);
        }

        return vetorP;
    }

    private  void mergeSegRetaX1(SegmentoReta vetor[], int indiceInicio, int meio, int indiceFim) {
        //Índices auxiliares
        int n1 = meio - indiceInicio + 1;
        int n2 = indiceFim - meio;

        /* Vetor Temporarios */
        SegmentoReta L[] = new SegmentoReta[n1];
        SegmentoReta R[] = new SegmentoReta[n2];

        for (int i=0; i<n1; ++i)
            L[i] = vetor[indiceInicio + i];
        for (int j=0; j<n2; ++j)
            R[j] = vetor[meio + 1+ j];


        int i = 0, j = 0;


        int k = indiceInicio;
        while (i < n1 && j < n2)
        {
            if (L[i].getpSR1().getX() <= R[j].getpSR1().getX())
            {
                vetor[k] = L[i];
                i++;
            }
            else
            {
                vetor[k] = R[j];
                j++;
            }
            k++;
        }

        //Append de itens que não foram usados na Junção
        while (i < n1)
        {
            vetor[k] = L[i];
            i++;
            k++;
        }

        //Append de itens que não foram usados na Junção
        while (j < n2)
        {
            vetor[k] = R[j];
            j++;
            k++;
        }
    }

    public SegmentoReta[] sortX(SegmentoReta vetorSR[], int indiceInicio, int indiceFim) {
        // Condicional que verifica a validade dos parâmetros passados.
        if (vetorSR != null && indiceInicio < indiceFim && indiceInicio >= 0 &&
                indiceFim < vetorSR.length && vetorSR.length != 0) {

            int meio = (indiceInicio+indiceFim)/2;

            sortX(vetorSR, indiceInicio, meio);
            sortX(vetorSR , meio+1, indiceFim);

            mergeSegRetaX1(vetorSR, indiceInicio, meio, indiceFim);
        }

        return vetorSR;
    }


    private  void mergeLinhaX1(Linha vetor[], int indiceInicio, int meio, int indiceFim) {
        //Índices auxiliares
        int n1 = meio - indiceInicio + 1;
        int n2 = indiceFim - meio;

        /* Vetor Temporarios */
        Linha L[] = new Linha[n1];
        Linha R[] = new Linha[n2];
        for (int i=0; i<n1; ++i)
            L[i] = vetor[indiceInicio + i];
        for (int j=0; j<n2; ++j)
            R[j] = vetor[meio + 1+ j];
        int i = 0, j = 0;
        int k = indiceInicio;
        while (i < n1 && j < n2)
        {
            if (L[i].getpL1().getX() <= R[j].getpL1().getX())
            {
                vetor[k] = L[i];
                i++;
            }
            else
            {
                vetor[k] = R[j];
                j++;
            }
            k++;
        }

        //Append de itens que não foram usados na Junção
        while (i < n1)
        {
            vetor[k] = L[i];
            i++;
            k++;
        }

        //Append de itens que não foram usados na Junção
        while (j < n2)
        {
            vetor[k] = R[j];
            j++;
            k++;
        }
    }



    public Linha[] sortX(Linha vetorLinha[], int indiceInicio, int indiceFim) {
        // Condicional que verifica a validade dos parâmetros passados.
        if (vetorLinha != null && indiceInicio < indiceFim && indiceInicio >= 0 &&
                indiceFim < vetorLinha.length && vetorLinha.length != 0) {

            int meio = (indiceInicio+indiceFim)/2;

            sortX(vetorLinha, indiceInicio, meio);
            sortX(vetorLinha , meio+1, indiceFim);

            mergeLinhaX1(vetorLinha, indiceInicio, meio, indiceFim);
        }

        return vetorLinha;
    }


    private  void mergePoligonoP1X(Poligono vetor[], int indiceInicio, int meio, int indiceFim) {
        //Índices auxiliares
        int n1 = meio - indiceInicio + 1;
        int n2 = indiceFim - meio;

        /* Vetor Temporarios */
        Poligono L[] = new Poligono[n1];
        Poligono R[] = new Poligono[n2];
        for (int i=0; i<n1; ++i)
            L[i] = vetor[indiceInicio + i];
        for (int j=0; j<n2; ++j)
            R[j] = vetor[meio + 1+ j];
        int i = 0, j = 0;
        int k = indiceInicio;
        while (i < n1 && j < n2)
        {
            if (L[i].getPol().get(0).getX() <= R[j].getPol().get(0).getX())
            {
                vetor[k] = L[i];
                i++;
            }
            else
            {
                vetor[k] = R[j];
                j++;
            }
            k++;
        }

        //Append de itens que não foram usados na Junção
        while (i < n1)
        {
            vetor[k] = L[i];
            i++;
            k++;
        }

        //Append de itens que não foram usados na Junção
        while (j < n2)
        {
            vetor[k] = R[j];
            j++;
            k++;
        }
    }


    public Poligono[] sortX(Poligono vetorPoligono[], int indiceInicio, int indiceFim) {
        // Condicional que verifica a validade dos parâmetros passados.
        if (vetorPoligono != null && indiceInicio < indiceFim && indiceInicio >= 0 &&
                indiceFim < vetorPoligono.length && vetorPoligono.length != 0) {

            int meio = (indiceInicio+indiceFim)/2;

            sortX(vetorPoligono, indiceInicio, meio);
            sortX(vetorPoligono , meio+1, indiceFim);

            mergePoligonoP1X(vetorPoligono, indiceInicio, meio, indiceFim);
        }

        return vetorPoligono;
    }



}
