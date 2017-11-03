package modelo;

import libs.MergeSort;

import java.util.ArrayList;

/**
 * Created by Debora on 17/10/2017.
 */
public class Operacoes {


    public double distanciaDoisPontos(Ponto p1, Ponto p2) {
        int x, y;
        x = p1.getX() - p2.getX();
        y = p1.getY() - p2.getY();
        x = x * x;
        y = y * y;
        return (float) Math.sqrt(x + y);
    }

    public double areaCirculo(int raio) {
        return Math.PI * (raio * raio);
    }

    public ArrayList<Ponto> insert(ArrayList<Ponto> ConjuntoPontos, Ponto ponto) {
        if (ConjuntoPontos.size() > 0) {
            ConjuntoPontos.add(ponto);
            Ponto[] vetor = new Ponto[ConjuntoPontos.size()];
            int i = 0;
            for (Ponto p : ConjuntoPontos) { // O(n)
                vetor[i] = p;
                i++;
            }
            quickSortPonto(vetor, 0, vetor.length - 1); // Caso médio: O( n log n)
            ArrayList<Ponto> ConjuntoNovo = new ArrayList<Ponto>();
            for (i = 0; i < vetor.length; i++) {
                ConjuntoNovo.add(vetor[i]);
            }
            return ConjuntoNovo;
        } else {
            ConjuntoPontos.add(ponto);
            return ConjuntoPontos;
        }
    }

    public static void quickSortPonto(Ponto[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separarPonto(vetor, inicio, fim);
            quickSortPonto(vetor, inicio, posicaoPivo - 1);
            quickSortPonto(vetor, posicaoPivo + 1, fim);
        }
    }

    private static int separarPonto(Ponto[] vetor, int inicio, int fim) {
        Ponto pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i].getX() + vetor[i].getY() <= pivo.getX() + pivo.getY())
                i++;
            else if (pivo.getX() + pivo.getY() < vetor[f].getX() + vetor[f].getY())
                f--;
            else {
                Ponto troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }


    public boolean member(ArrayList<Ponto> ListaPonto, Ponto ponto) {
        if (ListaPonto.size() > 0) {
            Ponto[] vetor = new Ponto[ListaPonto.size()];
            int i = 0;
            for (Ponto p : ListaPonto) { // O(n)
                vetor[i] = p;
                i++;
            }
            return (buscaBPonto(vetor, ponto)); //Caso médio O(log n)
        }
        return false;
    }

    private static boolean buscaBPonto(Ponto[] vetor, Ponto ponto) {
        return buscaBinariaRecursiva(vetor, 0, vetor.length - 1, ponto);
    }

    private static boolean buscaBinariaRecursiva(Ponto[] array, int menor, int maior, Ponto ponto) {
        int media = (maior + menor) / 2;
        Ponto valorMeio = array[media];
        if (menor > maior) {
            return false;
        } else if (valorMeio.equals(ponto)) {
            return true;
        } else if (valorMeio.getX() + valorMeio.getY() <= ponto.getX() + ponto.getY()) {
            return buscaBinariaRecursiva(array, media + 1, maior, ponto);
        } else {
            return buscaBinariaRecursiva(array, menor, media - 1, ponto);
        }
    }

    public static ArrayList<Ponto> delete(ArrayList<Ponto> array, Ponto ponto) {
        Ponto[] vetor = new Ponto[array.size()];
        int i = 0;
        for (Ponto p : array) { // O(n)
            System.out.println(p.toString());
            vetor[i] = p;
            i++;
        }
        if (buscaBPonto(vetor, ponto)) { //Caso médio O(log n)
            int posicao = posicaoPontoNoVetor(vetor, 0, vetor.length - 1, ponto);
            System.out.println("Posicao: " + posicao);
            ArrayList<Ponto> ConjuntoNovo = new ArrayList<Ponto>();
            for (i = 0; i < vetor.length; i++) {
                if (i != posicao) {
                    ConjuntoNovo.add(vetor[i]);
                }
            }
            return ConjuntoNovo;
        }
        return array;
    }

    private static int posicaoPontoNoVetor(Ponto[] array, int menor, int maior, Ponto ponto) {
        int media = (maior + menor) / 2;
        Ponto valorMeio = array[media];
        if (menor > maior) {
            return -1;
        } else if (valorMeio.equals(ponto)) {
            return media;
        } else if (valorMeio.getX() + valorMeio.getY() <= ponto.getX() + ponto.getY()) {
            return posicaoPontoNoVetor(array, media + 1, maior, ponto);
        } else {
            return posicaoPontoNoVetor(array, menor, media - 1, ponto);
        }
    }

    public float calculoCoefAngularReta(Ponto p1, Ponto p2) {
        int x = p2.getX() - p1.getX();
        int y = p2.getY() - p1.getY();
        return y / x;
    }

    private static float[] calculoEquacaoGeralReta(Ponto p1, Ponto p2) {
        float result[] = new float[3];
        int[][] matriz = new int[3][5];
        matriz[0][0] = p1.getX();
        matriz[0][1] = p1.getY();
        matriz[1][0] = p2.getX();
        matriz[1][1] = p2.getY();
        matriz[2][0] = 1;
        matriz[2][1] = 1;
        matriz[0][2] = 1;
        matriz[1][2] = 1;
        matriz[2][2] = 1;
        matriz[0][3] = p1.getX();
        matriz[0][4] = p1.getY();
        matriz[1][3] = p2.getX();
        matriz[1][4] = p2.getY();
        matriz[2][3] = 1;
        matriz[2][4] = 1;
        int soma1[] = {(matriz[0][0] * matriz[1][1] * matriz[2][2]), (matriz[0][1] * matriz[1][2] * matriz[2][3]), (matriz[0][2] * matriz[1][3] * matriz[2][4])};
        int soma2[] = {(matriz[2][0] * matriz[1][1] * matriz[0][2]), (matriz[0][3] * matriz[1][2] * matriz[2][1]), (matriz[2][2] * matriz[1][3] * matriz[0][4])};
        result[0] = soma1[1] - soma2[0];
        result[1] = soma1[2] - soma2[1];
        result[2] = soma1[0] - soma2[2];
        return result;
    }

    public float distanciaPontoReta(Ponto ponto, SegmentoReta reta) {
        float[] resultEquacao = new float[3];
        resultEquacao = calculoEquacaoGeralReta(reta.getpSR1(), reta.getpSR2());
        float parte1 = (resultEquacao[0] * ponto.getX()) + (resultEquacao[1] * ponto.getY()) + (resultEquacao[2]);
        parte1 = Math.abs(parte1);
        double parte2 = ((resultEquacao[0] * resultEquacao[0]) + (resultEquacao[1] * resultEquacao[1]));
        parte2 = Math.sqrt(parte2);
        return (float) (parte1 / parte2);
    }

    public static void intersecaoSegRetas(SegmentoReta reta1, SegmentoReta reta2) {//MUDAR O VOID
        float[] eqGR1;
        float[] eqGR2;
        eqGR1 = calculoEquacaoGeralReta(reta1.getpSR1(), reta1.getpSR2());
        eqGR2 = calculoEquacaoGeralReta(reta2.getpSR1(), reta2.getpSR2());
        float parteB = ((eqGR1[0] * eqGR2[1]) - (eqGR2[0] * eqGR1[1]));
        if (parteB == 0) {
            System.out.println("As retas são paralelas");
        } else {
            float xp = ((eqGR2[2] * eqGR1[1]) - (eqGR1[2] * eqGR2[1]));
            xp = xp / parteB;
            float yp = ((eqGR2[0] * eqGR1[2]) - (eqGR1[0]) * eqGR2[2]);
            yp = yp / parteB;
            Ponto pontoIntersecao = new Ponto();
            pontoIntersecao.setX((int) xp);
            pontoIntersecao.setY((int) yp);
            System.out.println("Ponto in [" + pontoIntersecao.getX() + "," + pontoIntersecao.getY() + "]");
        }

    }

    /**
     * Recebe uma Lista de Ponto XY e retorna um Vetor de pontos Ordenados pelo X
     *
     * @param p
     * @return
     */
    public static Ponto[] retornaVetorPontoOrdenado(ArrayList<Ponto> p, Character pelo) {
        Ponto[] v = new Ponto[p.size()];
        int i = 0;
        for (Ponto tp : p) {
            v[i] = tp;
            i++;
        }

        MergeSort mS = new MergeSort();

        if (pelo.equals('x')) {
            return mS.sortX(v, 0, v.length - 1);
        } else if (pelo.equals('y')) {
            return mS.sortY(v, 0, v.length - 1);
        }

        return v;
    }

    /**
     * Recebe uma Lista de Ponto XY e retorna um Vetor de pontos Ordenados pelo X
     *
     * @param v
     * @return
     */
    public static Ponto[] retornaVetorPontoOrdenado(Ponto[] v, Character pelo) {


        MergeSort mS = new MergeSort();

        if (pelo.equals('x')) {
            return mS.sortX(v, 0, v.length - 1);
        } else if (pelo.equals('y')) {
            return mS.sortY(v, 0, v.length - 1);
        }

        return v;
    }


//############################################################################################################
    /**
     * Divide o VEtor de Pontos em dois e Ordena por X e por Y;
     *
     * @param pontos
     * @return
     */

    public static Par parMaisProximo(Ponto[] pontos) {
        Ponto[] pX = new Ponto[pontos.length];
        Ponto[] pY = new Ponto[pontos.length];
        pX = retornaVetorPontoOrdenado(pontos, 'x');
        pY = retornaVetorPontoOrdenado(pontos, 'y');
        return parMaisProximo(pX, pY);
    }

    /**
     * Retorna par com menor distancia
     *
     * @param pontos
     * @return
     */
    public static Par retornaPAR(Ponto[] pontos) {
        int numPoints = pontos.length;
        if (numPoints < 2)
            return null;
        Par par = new Par(pontos[0], pontos[1]);
        if (numPoints > 2) {
            for (int i = 0; i < numPoints - 1; i++) {
                Ponto ponto1 = pontos[i];
                for (int j = i + 1; j < numPoints; j++) {
                    Ponto ponto2 = pontos[j];
                    double distancia = Par.distancia(ponto1, ponto2);
                    if (distancia < par.distancia)
                        par.update(ponto1, ponto2, distancia);
                }
            }
        }
        return par;
    }

    /**
     * Problema do par mais próximo
     *  Adaptação do Algoritmo de Shamos-Hoey
     * Algoritmo precisa apenas de Em)espaço e é executado no O (nlog-n)tempo.
     * @param pontosSortedByX
     * @param pontosSortedByY
     * @return
     */
    private static Par parMaisProximo(Ponto[] pontosSortedByX, Ponto[] pontosSortedByY) {
        int numPoints = pontosSortedByX.length;

        if (numPoints <= 3)
            return retornaPAR(pontosSortedByX);


        int dividingIndex = numPoints >>> 1;

        int n1 = dividingIndex - 0;
        int n2 = numPoints - dividingIndex;

        /* Vetor Temporarios */
        Ponto L[] = new Ponto[n1];
        Ponto R[] = new Ponto[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = pontosSortedByX[0 + i];
        for (int j = 0; j < n2; ++j)
            R[j] = pontosSortedByX[dividingIndex + j];


        Ponto[] tempList = retornaVetorPontoOrdenado(R, 'y');

        Par parMaisProximo = parMaisProximo(L, tempList);

        tempList = new Ponto[tempList.length];
        for (int i = 0; i < tempList.length; ++i) {
            tempList[i] = R[i];
        }


        tempList = retornaVetorPontoOrdenado(tempList, 'y');
        Par menorParDireita = parMaisProximo(R, tempList);

        if (menorParDireita.distancia < parMaisProximo.distancia)
            parMaisProximo = menorParDireita;

        tempList = new Ponto[pontosSortedByY.length];

        double menortDistancia = parMaisProximo.distancia;
        double centerX = R[0].getX();
        int aux = 0;
        for (int i = 0; i < pontosSortedByY.length; ++i) {
            if (Math.abs(centerX - pontosSortedByX[i].getX()) < menortDistancia) {
                tempList[aux] = pontosSortedByY[i];
                aux++;
            }
        }

        for (int i = 0; i < aux - 1; i++) {
            Ponto ponto1 = tempList[i];
            for (int j = i + 1; j < aux; j++) {
                Ponto ponto2 = tempList[j];
                if ((ponto1.getY() - ponto2.getY()) >= menortDistancia)
                    break;
                double distance = Par.distancia(ponto1, ponto2);
                if (distance < parMaisProximo.distancia) {
                    parMaisProximo.update(ponto1, ponto2, distance);
                    menortDistancia = distance;
                }
            }
        }
        return parMaisProximo;
    }
//############################################################################################################
}
