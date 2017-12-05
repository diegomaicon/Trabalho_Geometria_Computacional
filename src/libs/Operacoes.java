package libs;


import modelo.*;

import java.util.ArrayList;



/**
 * Created by Debora and Diego on 17/10/2017.
 *
 *  @author Déborah A. Resende
 *  @author Diego Maicon
 *
 *
 *
 */
public class Operacoes {

    /**
     *  Calcula a área de um circulo
     *
     * @param raio
     * @return
     */
    public double areaCirculo(int raio) {
        return Math.PI * (raio * raio);
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

    /**
     *  o cálculo dos coeficientes, pesquise, em um livro de
     *  matemática (geometria analítica) como determinar a equação geral
     *  da reta a partir de dois pontos
     *
     *
     * @param p1
     * @param p2
     * @return
     */
    private static double[] calculoEquacaoGeralReta2(Ponto p1, Ponto p2){
        double[] cofs = new double[3];

        cofs[0] = p1.getY() - p2.getY();
        cofs[1] = p2.getX() - p1.getX() ;
        cofs[2] = p1.getX() * p2.getY() - p2.getX() * p1.getY();

        return cofs;
    }

    private Ponto maisProximo(EquacaoReta e, Ponto p){
        double den = e.getA()*e.getA() + e.getB()*e.getB();
        Double x = (e.getB()*(e.getB()*p.getX() - e.getA()*p.getY()) - e.getA()*e.getC())/den;
        Double y = (e.getA()*(-e.getB()*p.getX() + e.getA()*p.getY()) - e.getB()*e.getC())/den;

        return new Ponto((int) Math.abs(x), (int) Math.abs(y));
    }

    /**
     * Calcula a Distancia netre um ponto e uma REta
     *
     * @param ponto
     * @param reta
     * @return
     */
    public float distanciaPontoReta(Ponto ponto, SegmentoReta reta) {
        double[] resultEquacao;
        resultEquacao = calculoEquacaoGeralReta2(reta.getpSR1(), reta.getpSR2());
        EquacaoReta equacaoReta = new EquacaoReta(resultEquacao[0],resultEquacao[1],resultEquacao[2]);

        double parte1 = (equacaoReta.getA() * ponto.getX()) + (equacaoReta.getB() * ponto.getY()) + (equacaoReta.getC());
        parte1 = Math.abs(parte1);
        double parte2 = ((equacaoReta.getA() * equacaoReta.getA()) + (equacaoReta.getB() * equacaoReta.getB()));

        parte2 = Math.sqrt(parte2);


         return (float) (parte1 / parte2);
    }

    /**
     * O perímetro do triângulo será P = AB + AC + BC,
     *  para obter o seu valor, precisamos calcular as
     *  distâncias ou os comprimentos dos três lados
     *
     *
     * @param sR
     * @param p
     * @param ab
     * @return
     */
    public float petrimetro(SegmentoReta sR , Ponto p, Double ab){
        float ac = (float) Par.distancia(sR.getpSR1(),p);
        float bc = (float) Par.distancia(sR.getpSR2(),p);

        return (float) (ac+ab+bc);
    }

    /**  Algoritimo de Força Bruta.
     *
     *
     *       Procura entre todos os pontos o pronto mais proximo do segmento de reta.
     *
     *         Complexidade O(n)
     *
     *
     * @param pontos
     * @param reta
     * @return
     */
    public  Ponto pontoMaisProximoSegmentoReta(ArrayList<Ponto> pontos, SegmentoReta reta){

        float menorDistancia = Float.MAX_VALUE;
        float aux;
        Ponto mPonto = null;

        Double ab = Par.distancia(reta.getpSR1(),reta.getpSR2());

        for (Ponto p :pontos) {
            aux = petrimetro(reta,p,ab);
            System.out.println(p.getX()+","+p.getY()+"-> Distancia: "+aux);
            if (aux>0)
                if(aux <= menorDistancia){
                    menorDistancia = aux;
                    mPonto = p;
                }
        }
        return mPonto;
    }



    /**
     * Predicado orientação 2D. (slides 29-31 do pdf auxiliar)
     *
     * @param ponto1
     * @param ponto2
     * @param ponto3
     * @return
     */
    public String predicadoOrientacao2D(Ponto ponto1, Ponto ponto2,Ponto ponto3) { //MUDAR >>> VOID
        int[][] matriz = new int[3][5];
        matriz[0][0] = ponto1.getX();
        matriz[0][1] = ponto2.getX();
        matriz[0][2] = ponto3.getX();
        matriz[0][3] = ponto1.getX();
        matriz[0][4] = ponto2.getX();

        matriz[1][0] = ponto1.getY();
        matriz[1][1] = ponto2.getY();
        matriz[1][2] = ponto3.getY();
        matriz[1][3] = ponto1.getY();
        matriz[1][4] = ponto2.getY();

        matriz[2][0] = 1;
        matriz[2][1] = 1;
        matriz[2][2] = 1;
        matriz[2][3] = 1;
        matriz[2][4] = 1;

        int soma1[] = {(matriz[0][0] * matriz[1][1] * matriz[2][2]), (matriz[0][1] * matriz[1][2] * matriz[2][3]), (matriz[0][2] * matriz[1][3] * matriz[2][4])};
        int soma2[] = {(matriz[2][0] * matriz[1][1] * matriz[0][2]), (matriz[0][3] * matriz[1][2] * matriz[2][1]), (matriz[2][2] * matriz[1][3] * matriz[0][4])};
        int resultado = (soma1[0]+soma1[1]+soma1[2]) - (soma2[0]+soma2[1]+soma2[2]);

        if (resultado == 0){
            return  resultado + " COLINEAR";
        } else if (resultado>0){
            return resultado + " Está a ESQQUERDA da reta";
        } else {
            return resultado + " Está a DIREITA da reta";
        }
    }

    /**
     *  Verifica se exixte uma interseção entre duas Retas
     * @param reta1
     * @param reta2
     * @return
     */
    public  String intersecaoSegRetas(SegmentoReta reta1, SegmentoReta reta2) {//MUDAR O VOID

        float[] eqGR1;
        float[] eqGR2;
        eqGR1 = calculoEquacaoGeralReta(reta1.getpSR1(), reta1.getpSR2());
        eqGR2 = calculoEquacaoGeralReta(reta2.getpSR1(), reta2.getpSR2());
        float parteB = ((eqGR1[0] * eqGR2[1]) - (eqGR2[0] * eqGR1[1]));
        if (parteB == 0) {
            return "As retas são paralelas";
        } else {
            float xp = ((eqGR2[2] * eqGR1[1]) - (eqGR1[2] * eqGR2[1]));
            xp = xp / parteB;
            float yp = ((eqGR2[0] * eqGR1[2]) - (eqGR1[0]) * eqGR2[2]);
            yp = yp / parteB;
            Ponto pontoIntersecao = new Ponto();
            pontoIntersecao.setX((int) xp);
            pontoIntersecao.setY((int) yp);
            return "Interseção no  [" + pontoIntersecao.getX() + "," + pontoIntersecao.getY() + "]";
        }

    }

    /**
     * Recebe uma Lista de Ponto XY e retorna um Vetor de pontos Ordenados pelo X
     *
     *  Complexidade O(n log n)
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
     * Complexidade O(n log n)
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

    /**
     * Divide o VEtor de Pontos em dois e Ordena por X e por Y;
     *
     * @param pontos
     * @return
     */

    public static Par parMaisProximo(Ponto[] pontos) {
        Ponto[] pX,pY;
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
     *
     * Problema do par mais próximo
     * Adaptação do Algoritmo de Shamos-Hoey
     * Algoritmo  Complexidade O(nlog-n) tempo.
     *
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

    /**
     * O Predicado em qual Lado do Círculo
     *
     * @param ponto
     * @param pontosCirculo
     * @return
     */

    public String predicadoQualLadoCirculo(Ponto ponto, Ponto[] pontosCirculo){

        int det1 = calculaDet3x3(pontosCirculo[0].getX(), pontosCirculo[0].getY(), 1, pontosCirculo[1].getX(), pontosCirculo[1].getY(), 1, pontosCirculo[2].getX(), pontosCirculo[2].getY(), 1);
        int det2 = calculaDet3x3((pontosCirculo[0].getX()*pontosCirculo[0].getX()) + (pontosCirculo[0].getY()*pontosCirculo[0].getY()), pontosCirculo[0].getY(), 1, (pontosCirculo[1].getX()*pontosCirculo[1].getX()) + (pontosCirculo[1].getY()*pontosCirculo[1].getY()), pontosCirculo[1].getY(), 1, (pontosCirculo[2].getX()*pontosCirculo[2].getX()) + (pontosCirculo[2].getY()*pontosCirculo[2].getY()), pontosCirculo[2].getY(), 1 );
        int det3 = calculaDet3x3((pontosCirculo[0].getX()*pontosCirculo[0].getX()) + (pontosCirculo[0].getY()*pontosCirculo[0].getY()), pontosCirculo[0].getX(), 1, (pontosCirculo[1].getX()*pontosCirculo[1].getX()) + (pontosCirculo[1].getY()*pontosCirculo[1].getY()), pontosCirculo[1].getX(), 1, (pontosCirculo[2].getX()*pontosCirculo[2].getX()) + (pontosCirculo[2].getY()*pontosCirculo[2].getY()), pontosCirculo[2].getX(), 1);
        int det4 = calculaDet3x3((pontosCirculo[0].getX()*pontosCirculo[0].getX()) + (pontosCirculo[0].getY()*pontosCirculo[0].getY()), pontosCirculo[0].getX(), pontosCirculo[0].getY(), (pontosCirculo[1].getX()*pontosCirculo[1].getX()) + (pontosCirculo[1].getY()*pontosCirculo[1].getY()), pontosCirculo[1].getX(), pontosCirculo[1].getY(), (pontosCirculo[2].getX()*pontosCirculo[2].getX()) + (pontosCirculo[2].getY()*pontosCirculo[2].getY()), pontosCirculo[2].getX(), pontosCirculo[2].getY());

        double determinante = 0;

        if (((ponto.getX()*ponto.getX()) + (ponto.getY()*ponto.getY())) != 0){
            determinante = (Math.pow((-1), 2)) * ((ponto.getX()*ponto.getX()) + (ponto.getY()*ponto.getY())) * det1 ;
        }
        if (ponto.getX()!= 0){
            determinante = determinante +  ((Math.pow(-1,3)) * (ponto.getX()) *det2);
        }
        if (ponto.getY()!= 0){
            determinante = determinante + ((Math.pow(-1,4))* ponto.getY() * det3);
        }
        determinante = determinante + ((Math.pow(-1,5))*1*det4);
        int determinante2 = calculaDet3x3(pontosCirculo[0].getX(), pontosCirculo[0].getY(), 1, pontosCirculo[1].getX(), pontosCirculo[1].getY(), 1, pontosCirculo[2].getX(), pontosCirculo[2].getY(), 1);

        double resultado = determinante * determinante2;

        if (resultado > 0){
            return resultado + "Ponto FORA do círculo";
        }else if (resultado == 0){
            return resultado + "O ponto está na BORDA do círculo";
        }else{
            return resultado + "O ponto está DENTRO do círculo";
        }

    }

    int calculaDet3x3 (int a, int b, int c, int d, int e, int f, int g, int h, int i){
        int dir = ((a * e * i) + (b * f * g) + (c * d * h));
        int esq = ((c * e * g) + (a * f * h) + (b * d * i));
        return dir-esq;
    }

    /**
     *   Predicado ponto dentro do polígono.
     *
     *   Complexidade O(n)
     *
     * @param ponto
     * @param poligono
     * @return
     */
    public String predicadoPontoDentroPoligono(Ponto ponto, ArrayList<Ponto> poligono){
        int cruzamentos = 0 ;
        Ponto p1, p2;
        int x1, x2, y1, y2;

        p1 = poligono.get(0);

        //Para cada segmento do poligono faça..
        for (int i = 1 ; i < poligono.size() ; i++){
            //p1 = poligono.get(i);
            p2= poligono.get(i);


            x1 = p1.getX() - ponto.getX();
            y1 = p1.getY() - ponto.getY();
            x2 = p2.getX() - ponto.getX();
            y2 = p2.getY() - ponto.getY();

            float xInter;
            if ((y1 > 0) && (y2 <= 0) || (y2 > 0) && (y1 <= 0)) {
                xInter = ((x1 * y2) - (x2 * y1));
                xInter = xInter / (y2 - y1);
                if (xInter > 0.0) {
                    cruzamentos++;
                }
            }

            p1 = p2;

        }
        System.out.println("quantidade cruzamentos: "+cruzamentos);
        if ((cruzamentos % 2) == 1) {
            return "Quantidade cruzamentos: " +cruzamentos+ "\nO ponto está dentro do poligono";
        }
        else{
            return "Quantidade cruzamentos: " +cruzamentos+ "\nO ponto NÃO está dentro do poligono";
        }

    }

    /**
     * Verifica se um Poligono pe convexo
     *
     *   Complexidade O(n)
     *
     * @param poligono
     * @return
     */
    public boolean poligonoConvexo(Poligono poligono){
        if (poligono.getPol().size()< 4){
            return true;
        }
        boolean sign = false;
        int n = poligono.getPol().size();
        for(int i=0; i<n; i++)
        {
            double dx1 = poligono.getPol().get((i+2)%n).getX() - poligono.getPol().get((i+1)%n).getX();
            double dy1 = poligono.getPol().get((i+2)%n).getY() - poligono.getPol().get((i+1)%n).getY();

            double dx2 = poligono.getPol().get(i).getX() - poligono.getPol().get((i+1)%n).getX();
            double dy2 = poligono.getPol().get(i).getY() - poligono.getPol().get((i+1)%n).getY();

            double produtocruzado = dx1*dy2 - dy1*dx2;
            if (i == 0)
                sign = produtocruzado > 0;
            else if (sign != (produtocruzado > 0))
                return false;
        }

        return true;
    }

    /**
     *  Algoritimo que Calcula área de um poligono
     *
     *   Complexidade n+n = O(n)
     *
     * @param pL
     * @return
     */
    public double areaPoligono(Poligono pL ){
        int v1=0,v2=0;
        Ponto aux = pL.getPol().get(0);
        ArrayList<Ponto> list = pL.getPol();
        list.add(aux);

        //Multiplique a coordenada x de cada vértice pela coordenada y de cada vértice.
        for (int i = 0; i < list.size()-1 ; i++) {
            v1 += list.get(i).getX() * list.get(i+1).getY();
        }

        //Multiplique a coordenada y de cada vértice pela coordenada x do vértice
        for (int i = 0; i < list.size()-1 ; i++) {
            v2 += list.get(i+1).getX() * list.get(i).getY();
        }
        return (v1-v2)/2;
    }


}
