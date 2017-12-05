package libs;

import modelo.Ponto;

import java.util.ArrayList;

/**
 * As operações tamanho , isEmpty , get , set , iterator e listIterator são executadas em tempo constante.
 * A operação de adicionar funciona em tempo constante amortizado , ou seja, adicionar n elementos requer tempo de O (n).
 * Todas as outras operações funcionam em tempo linear (grosso modo).
 *
 *
 *   https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
 *
 *
 */


public class ManiputationConjunto {


    private static Operacoes operacoes;

    /**
     * Acrescenta o elemento especificado ao final desta lista.
     *
     * @param pontos
     * @param elemento
     * @return
     */
    public static ArrayList<Ponto> insert(ArrayList<Ponto> pontos, Ponto elemento) {
        pontos.add(elemento);
        return pontos;
    }

    /**
     * Remove a primeira ocorrência do elemento especificado desta lista, se estiver presente.
     *
     * @param pontos
     * @param elemento
     * @return
     */
    public static ArrayList<Ponto> delete(ArrayList<Ponto> pontos, Ponto elemento) {

        ArrayList<Ponto> novo = (ArrayList<Ponto>) pontos.clone();
        for (Ponto p : pontos) {
            if ((p.getX() == elemento.getX()) && (p.getY() == elemento.getY())) {
                novo.remove(p);
            }
        }
        return novo;
    }

    /**
     * Retorna true se esta lista contiver o elemento especificado.
     * <p>
     * Complexidade O(n)
     *
     * @param pontos
     * @param elemento
     * @return
     */
    public static boolean member(ArrayList<Ponto> pontos, Ponto elemento) {
        for (Ponto p : pontos) {
            if ((p.getY() == elemento.getY()) && (p.getX() == elemento.getX())) {
                return true;
            }
        }
        return false;
    }


    public static Ponto minX(ArrayList<Ponto> conjuntoPontos) {
        Ponto[] vetor = operacoes.retornaVetorPontoOrdenado(conjuntoPontos, 'x');
        return vetor[0];
    }

    public static Ponto minY(ArrayList<Ponto> conjuntoPontos) {
        Ponto[] vetor = operacoes.retornaVetorPontoOrdenado(conjuntoPontos, 'y');
        return vetor[0];
    }


    public static ArrayList<ArrayList<Ponto>> insert(ArrayList<ArrayList<Ponto>> ConjConjPontos, ArrayList<Ponto> ConjPontos) {
        ConjConjPontos.add(ConjPontos);
        return ConjConjPontos;
    }

    public static ArrayList<ArrayList<Ponto>> delete(ArrayList<ArrayList<Ponto>> ConjConjPontos, ArrayList<Ponto> ConjPontos) {
        ConjConjPontos.remove(ConjPontos);
        return ConjConjPontos;
    }


    public static ArrayList<Ponto> union(ArrayList<Ponto> Conj1, ArrayList<Ponto> Conj2) {
        for (Ponto p : Conj2) {
            if (!member(Conj1, p)) {
                Conj1.add(p);
            }
        }
        return Conj1;
    }

    public static ArrayList<Ponto> intersection(ArrayList<Ponto> Conj1, ArrayList<Ponto> Conj2) {
        ArrayList<Ponto> novo = new ArrayList<Ponto>();
        for (Ponto p : Conj2) {
            if (member(Conj1, p)) {
                novo.add(p);
            }
        }
        return novo;
    }

    public static ArrayList<Ponto> difference(ArrayList<Ponto> Conj1, ArrayList<Ponto> Conj2) {
        for (Ponto p : Conj2) {
            if (member(Conj1, p)) {
                Conj1.remove(p);
            }
        }
        return Conj1;
    }

    /**
     *  Separa a lista de Pontos em Duas listas.
     *
     *  Complexidade O(n)
     *
     * @param conjPontos
     * @param u
     * @return
     */
    public static ArrayList<ArrayList<Ponto>> split(ArrayList<Ponto> conjPontos, int u){
        ArrayList<Ponto> s1 = new ArrayList<Ponto>();
        ArrayList<Ponto> s2 = new ArrayList<Ponto>();
        int i=1;
        for (Ponto p : conjPontos){
            if (i <= u ){
                s1.add(p);
            }else{
                s2.add(p);
            }
            i++;
        }
        ArrayList<ArrayList<Ponto>> ConjConj = new ArrayList<ArrayList<Ponto>>();
        ConjConj.add(s1);
        ConjConj.add(s2);

        return ConjConj;
    }

    /**
     * Concatena  dois conjuntos S U A
     *
     *  Complexidade O(n)
     *
     * @param S
     * @param A
     * @return
     */
    public static ArrayList<Ponto> concatenate(ArrayList<Ponto> S,ArrayList<Ponto> A){
        ArrayList<Ponto> aux = new ArrayList<Ponto>();
        aux.addAll(S);
        aux.addAll(A);
        return aux;
    }

}
