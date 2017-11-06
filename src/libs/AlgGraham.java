package libs;

import modelo.Ponto;

import java.util.ArrayList;

/**
 * o algoritmo de Graham que obtém o fecho convexo de um dado conjunto de pontos.
 * O algoritmo possui complexidade de tempo da ordem de O(n log n), onde n é a quantidade de pontos do conjunto
 */
public class AlgGraham {

    /**
     *  Procura pontos para formar o Feco convexo
     * @param pontos
     * @return
     */
    public ArrayList<Ponto> procuraFecho(ArrayList<Ponto> pontos) {

        ArrayList<Ponto> fechoConvexo = new ArrayList<Ponto>();

        //Se for apenas 3 ponto, já á o fecho convexo.
        if (pontos.size() < 3)
            return (ArrayList) pontos.clone();

        int minPonto = -1, maxPonto = -1;
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        //Encontra maior ponto X e Y
        for (int i = 0; i < pontos.size(); i++) {
            if (pontos.get(i).getX() < minX) {
                minX = pontos.get(i).getX();
                minPonto = i;
            }

            if (pontos.get(i).getX() > maxX) {
                maxX = pontos.get(i).getX();
                maxPonto = i;
            }
        }

        Ponto A = pontos.get(minPonto);
        Ponto B = pontos.get(maxPonto);
        fechoConvexo.add(A);
        fechoConvexo.add(B);
        pontos.remove(A);
        pontos.remove(B);

        ArrayList<Ponto> pontosEsqueda = new ArrayList<Ponto>();
        ArrayList<Ponto> pontosDireita = new ArrayList<Ponto>();

        for (int i = 0; i < pontos.size(); i++) {
            Ponto p = pontos.get(i);
            if (posicaoPontos(A, B, p) == -1)
                pontosEsqueda.add(p);
            else if (posicaoPontos(A, B, p) == 1)
                pontosDireita.add(p);
        }
        pontosConvexo(A, B, pontosDireita, fechoConvexo);
        pontosConvexo(B, A, pontosEsqueda, fechoConvexo);

        return fechoConvexo;
    }

    public int distance(Ponto A, Ponto B, Ponto C) {
        int ABx = B.getX() - A.getX();
        int ABy = B.getY() - A.getY();
        int num = ABx * (A.getY() - C.getY()) - ABy * (A.getX() - C.getX());
        if (num < 0)
            num = -num;
        return num;
    }

    public void pontosConvexo(Ponto A, Ponto B, ArrayList<Ponto> set, ArrayList<Ponto> fecho) {
        int posicao = fecho.indexOf(B);

        if (set.size() == 0)
            return;
        if (set.size() == 1) {
            Ponto p = set.get(0);
            set.remove(p);
            fecho.add(posicao, p);
            return;
        }
        int dist = Integer.MIN_VALUE;
        int pontoMaisDistante = -1;
        for (int i = 0; i < set.size(); i++) {
            Ponto p = set.get(i);
            int distance = distance(A, B, p);
            if (distance > dist)
            {
                dist = distance;
                pontoMaisDistante = i;
            }
        }
        Ponto P = set.get(pontoMaisDistante);
        set.remove(pontoMaisDistante);
        fecho.add(posicao, P);

        // Determine quem está à esquerda do PA
        ArrayList<Ponto> pontosEsquerdaPA = new ArrayList<Ponto>();
        for (int i = 0; i < set.size(); i++) {
            Ponto M = set.get(i);
            if (posicaoPontos(A, P, M) == 1)
            {
                pontosEsquerdaPA.add(M);
            }
        }

        //Determine quem está à esquerda do PB
        ArrayList<Ponto> pontosEsquerdaPB = new ArrayList<Ponto>();
        for (int i = 0; i < set.size(); i++)
        {
            Ponto M = set.get(i);
            if (posicaoPontos(P, B, M) == 1)
            {
                pontosEsquerdaPB.add(M);
            }
        }
        pontosConvexo(A, P, pontosEsquerdaPA, fecho);
        pontosConvexo(P, B, pontosEsquerdaPB, fecho);

    }

    public int posicaoPontos(Ponto A, Ponto B, Ponto P)
    {
        int cp1 = (B.getX() - A.getX() ) * (P.getY() - A.getY() ) - (B.getY() - A.getY() ) * (P.getX() - A.getX() );
        if (cp1 > 0)
            return 1;
        else if (cp1 == 0)
            return 0;
        else
            return -1;
    }

}
