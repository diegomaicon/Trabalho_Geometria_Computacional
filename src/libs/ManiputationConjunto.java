package libs;

import modelo.Linha;
import modelo.Poligono;
import modelo.Ponto;
import modelo.SegmentoReta;

import java.util.ArrayList;

/**
 *  @author Déborah A. Resende
 *  @author Diego Maicon
 *
 *
 * As operações tamanho , isEmpty , get , set , iterator e listIterator são executadas em tempo constante.
 * A operação de adicionar funciona em tempo constante amortizado , ou seja, adicionar n elementos requer tempo de O (n).
 * Todas as outras operações funcionam em tempo linear (grosso modo).
 *
 *
 * Fonte: https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
 *
 *
 */


public class ManiputationConjunto {


    private static Operacoes operacoes;

    /*************************   TAD PONTOS   **************************************************************************************/

    /**
     * Acrescenta o elemento especificado ao final desta lista de Pontos.
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

    /**
     *  Retorna o Min pelo eixo X
     *
     * @param conjuntoPontos
     * @return
     */
    public static Ponto minX(ArrayList<Ponto> conjuntoPontos) {
        Ponto[] vetor = operacoes.retornaVetorPontoOrdenado(conjuntoPontos, 'x');
        return vetor[0];
    }

    /**
     * Retorna o Min pelo eixo Y
     *
     * @param conjuntoPontos
     * @return
     */
    public static Ponto minY(ArrayList<Ponto> conjuntoPontos) {
        Ponto[] vetor = operacoes.retornaVetorPontoOrdenado(conjuntoPontos, 'y');
        return vetor[0];
    }

    /**
     *  Operação de união de conjuntos.
     *
     *  Complexidade O(n).
     *
     * @param Conj1
     * @param Conj2
     * @return
     */
    public static ArrayList<Ponto> union(ArrayList<Ponto> Conj1, ArrayList<Ponto> Conj2) {
        ArrayList<Ponto> novoConj = new ArrayList<Ponto>();
        novoConj = Conj1;
        for (Ponto p : Conj2) {
            if (!member(Conj1, p)) {
                novoConj.add(p);
            }
        }
        return novoConj;
    }

    /**
     *  Operação de intercecção entre dois conjuntos.
     *
     *      Complexidade O(n).
     *
     * @param Conj1
     * @param Conj2
     * @return
     */
    public static ArrayList<Ponto> intersection(ArrayList<Ponto> Conj1, ArrayList<Ponto> Conj2) {
        ArrayList<Ponto> novo = new ArrayList<Ponto>();
        for (Ponto p : Conj2) {
            if (member(Conj1, p)) {
                novo.add(p);
            }
        }
        return novo;
    }

    /**
     *  Operação de diferença entre dois conjuntos
     *
     *  Complexidade O(n)
     *
     * @param conj1
     * @param conj2
     * @return
     */
    public static ArrayList<Ponto> difference(ArrayList<Ponto> conj1, ArrayList<Ponto> conj2) {
        ArrayList<Ponto> novo = new ArrayList<Ponto>();
        novo = conj1;
        for (Ponto p : conj2) {
            if (member(conj1, p)) {
                novo = delete(novo,p);
                //System.out.println("achou "+p.toString());
            }
        }
        return novo;
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
        Ponto[] conj = operacoes.retornaVetorPontoOrdenado(conjPontos, 'x');
        for (i=0 ; i<conj.length; i++){
            if (i <= u ){
                s1.add(conj[i]);
            }else{
                s2.add(conj[i]);
            }
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


    /************************* TAD SEGMENTO DE RETA  **************************************************************************************/



    /**
     * Acrescenta o elemento especificado ao final desta lista de Segmentos de Reta.
     *
     * @param segmentosReta
     * @param elemento
     * @return
     */
    public static ArrayList<SegmentoReta> insert(ArrayList<SegmentoReta> segmentosReta, SegmentoReta elemento) {
        segmentosReta.add(elemento);
        return segmentosReta;
    }


    /**
     * Remove a primeira ocorrência do elemento especificado da Lista de Segmento de Retas, se estiver presente.
     *
     * @param segmentoRetas
     * @param elemento
     * @return
     */
    public static ArrayList<SegmentoReta> delete(ArrayList<SegmentoReta> segmentoRetas, SegmentoReta elemento) {
        ArrayList<SegmentoReta> novo = (ArrayList<SegmentoReta>) segmentoRetas.clone();
        for (SegmentoReta s : segmentoRetas) {
            if ((s.getpSR1().getX()==elemento.getpSR1().getX()) && (s.getpSR1().getY()==elemento.getpSR1().getY()) && (s.getpSR2().getY()==elemento.getpSR2().getY()) && (s.getpSR2().getX()==elemento.getpSR2().getX())) {
                novo.remove(s);
            }
        }
        return novo;
    }

    /**
     * Retorna true se esta lista conter o elemento especificado.
     * <p>
     * Complexidade O(n)
     *
     * @param segmentosRetas
     * @param elemento
     * @return
     */
    public static boolean member(ArrayList<SegmentoReta> segmentosRetas, SegmentoReta elemento) {
        for (SegmentoReta s : segmentosRetas) {
            if ((s.getpSR1().getX()==elemento.getpSR1().getX()) && (s.getpSR1().getY()==elemento.getpSR1().getY()) && (s.getpSR2().getY()==elemento.getpSR2().getY()) && (s.getpSR2().getX()==elemento.getpSR2().getX())) {
                return true;
            }
        }
        return false;
    }

    /**
     *  Operação de união de conjuntos.
     *
     *  Complexidade O(n).
     *
     * @param Conjunto1
     * @param Conjunto2
     * @return
     */
    public static ArrayList<SegmentoReta> unionSR(ArrayList<SegmentoReta> Conjunto1, ArrayList<SegmentoReta> Conjunto2) {
        ArrayList<SegmentoReta> novoConj = new ArrayList<SegmentoReta>();
        novoConj = Conjunto1;
        for (SegmentoReta s : Conjunto1) {
            if (!member(Conjunto2, s)) {
                novoConj.add(s);
            }
        }
        return novoConj;
    }

    /**
     *  Operação de intercecção entre dois conjuntos.
     *
     *      Complexidade O(n).
     *
     * @param Conj1
     * @param Conj2
     * @return
     */
    public static ArrayList<SegmentoReta> intersectionSR(ArrayList<SegmentoReta> Conj1, ArrayList<SegmentoReta> Conj2) {
        ArrayList<SegmentoReta> novo = new ArrayList<SegmentoReta>();
        for (SegmentoReta s : Conj2) {
            if (member(Conj1, s)) {
                novo.add(s);
            }
        }
        return novo;
    }

    /**
     *  Operação de diferença entre dois conjuntos
     *
     *  Complexidade O(n)
     *
     * @param conj1
     * @param conj2
     * @return
     */
    public static ArrayList<SegmentoReta> differenceSR(ArrayList<SegmentoReta> conj1, ArrayList<SegmentoReta> conj2) {
        ArrayList<SegmentoReta> novo = new ArrayList<SegmentoReta>();
        novo = conj1;
        for (SegmentoReta s : conj2) {
            if (member(conj1, s)) {
                novo = delete(novo,s);
                //System.out.println("achou "+p.toString());
            }
        }
        return novo;
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
    public static ArrayList<SegmentoReta> concatenateSR(ArrayList<SegmentoReta> S,ArrayList<SegmentoReta> A){
        ArrayList<SegmentoReta> aux = new ArrayList<SegmentoReta>();
        aux.addAll(S);
        aux.addAll(A);
        return aux;
    }


    /*************************  TAD LINHA  **************************************************************************************/



    /**
     * Acrescenta o elemento especificado ao final desta lista de Linhas
     *
     * @param conjLinha
     * @param elemento
     * @return
     */
    public static ArrayList<Linha> insert(ArrayList<Linha> conjLinha, Linha elemento) {
        conjLinha.add(elemento);
        return conjLinha;
    }

    /**
     * Remove a primeira ocorrência do elemento especificado da Lista de Linhas, se estiver presente.
     *
     * @param conjLinhas
     * @param elemento
     * @return
     */
    public static ArrayList<Linha> delete(ArrayList<Linha> conjLinhas, Linha elemento) {
        ArrayList<Linha> novo = (ArrayList<Linha>) conjLinhas.clone();
        for (Linha l : conjLinhas) {
            if ((l.getpL1().getX()==elemento.getpL1().getX()) && (l.getpL1().getY()==elemento.getpL1().getY()) && (l.getpL2().getY()==elemento.getpL2().getY()) && (l.getpL2().getX()==elemento.getpL2().getX())) {
                novo.remove(l);
            }
        }
        return novo;
    }

    /**
     * Retorna true se esta lista conter o elemento especificado.
     * <p>
     * Complexidade O(n)
     *
     * @param conjLinhas
     * @param elemento
     * @return
     */
    public static boolean member(ArrayList<Linha> conjLinhas, Linha elemento) {
        for (Linha l : conjLinhas) {
            if ((l.getpL1().getX()==elemento.getpL1().getX()) && (l.getpL1().getY()==elemento.getpL1().getY()) && (l.getpL2().getY()==elemento.getpL2().getY()) && (l.getpL2().getX()==elemento.getpL2().getX())) {
                return true;
            }
        }
        return false;
    }

    /**
     *  Operação de união de conjuntos.
     *
     *  Complexidade O(n).
     *
     * @param Conjunto1
     * @param Conjunto2
     * @return
     */
    public static ArrayList<Linha> unionL(ArrayList<Linha> Conjunto1, ArrayList<Linha> Conjunto2) {
        ArrayList<Linha> novoConj = new ArrayList<Linha>();
        novoConj = Conjunto1;
        for (Linha l : Conjunto1) {
            if (!member(Conjunto2, l)) {
                novoConj.add(l);
            }
        }
        return novoConj;
    }

    /**
     *  Operação de intercecção entre dois conjuntos.
     *
     *      Complexidade O(n).
     *
     * @param Conj1
     * @param Conj2
     * @return
     */
    public static ArrayList<Linha> intersectionL(ArrayList<Linha> Conj1, ArrayList<Linha> Conj2) {
        ArrayList<Linha> novo = new ArrayList<Linha>();
        for (Linha l : Conj2) {
            if (member(Conj1, l)) {
                novo.add(l);
            }
        }
        return novo;
    }

    /**
     *  Operação de diferença entre dois conjuntos
     *
     *  Complexidade O(n)
     *
     * @param conj1
     * @param conj2
     * @return
     */
    public static ArrayList<Linha> differenceL(ArrayList<Linha> conj1, ArrayList<Linha> conj2) {
        ArrayList<Linha> novo = new ArrayList<Linha>();
        novo = conj1;
        for (Linha l : conj2) {
            if (member(conj1, l)) {
                novo = delete(novo,l);
                //System.out.println("achou "+p.toString());
            }
        }
        return novo;
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
    public static ArrayList<Linha> concatenateL(ArrayList<Linha> S,ArrayList<Linha> A){
        ArrayList<Linha> aux = new ArrayList<Linha>();
        aux.addAll(S);
        aux.addAll(A);
        return aux;
    }




    /****************************************  TAD POLIGONOS   **************************************************************************************/

    /**
     * Acrescenta o elemento especificado ao final desta lista de Poligonos
     *
     * @param conjPoligonos
     * @param elemento
     * @return
     */
    public static ArrayList<Poligono> insert(ArrayList<Poligono> conjPoligonos, Poligono elemento) {
        conjPoligonos.add(elemento);
        return conjPoligonos;
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
    public static ArrayList<Poligono> concatenateP(ArrayList<Poligono> S,ArrayList<Poligono> A) {
        ArrayList<Poligono> aux = new ArrayList<Poligono>();
        aux.addAll(S);
        aux.addAll(A);
        return aux;
    }


}