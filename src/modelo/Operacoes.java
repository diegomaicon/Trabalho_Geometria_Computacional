package modelo;

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

    public float calculoCoefAngularReta(Ponto p1, Ponto p2) {
        int x = p2.getX() - p1.getX();
        int y = p2.getY() - p1.getY();
        return y / x;
    }

    public float[] calculoEquacaoGeralReta(Ponto p1, Ponto p2) {
        float result[] = new float[3];
        float coef = calculoCoefAngularReta(p1, p2);
        result[0] = -coef;
        float mx1 = -(coef * p1.getX());
        //Continuar

        return result;
    }


    //AQUIIIIIIIIII

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
            if (vetor[i].getX()+vetor[i].getY() <= pivo.getX()+pivo.getY())
                i++;
            else if (pivo.getX()+pivo.getY() < vetor[f].getX()+vetor[f].getY())
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
        Ponto[] vetor = new Ponto[ListaPonto.size()];
        int i = 0;
        for (Ponto p : ListaPonto) { // O(n)
            System.out.println(p.toString());
            vetor[i] = p;
            i++;
        }

        quickSortPonto(vetor, 0, vetor.length - 1); // Caso médio: O( n log n)

        System.out.println("Depois: ");
        for (i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i].toString());
        }
        return (buscaBPonto(vetor, ponto)); //Caso médio O(log n)
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
            //System.out.println("encontrou: "+valorMeio.toString());
            return true;
        }else if (valorMeio.getX()+valorMeio.getY() <= ponto.getX()+ponto.getY()) {
            return buscaBinariaRecursiva(array, media + 1, maior, ponto);
        }else {
            return buscaBinariaRecursiva(array, menor, media - 1, ponto);
        }
    }

    private static boolean delete(ArrayList<Ponto> array, Ponto ponto){
        Ponto[] vetor = new Ponto[array.size()];
        int i = 0;
        for (Ponto p : array) { // O(n)
            System.out.println(p.toString());
            vetor[i] = p;
            i++;
        }

        quickSortPonto(vetor, 0, vetor.length - 1); // Caso médio: O( n log n)

        System.out.println("Depois: ");
        for (i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i].toString());
        }
        return (buscaBPonto(vetor, ponto)); //Caso médio O(log n)
    }
}
