import jdk.nashorn.internal.scripts.JO;
import libs.AlgGraham;
import modelo.Operacoes;
import modelo.Par;
import modelo.Ponto;
import modelo.SegmentoReta;
import plot.GnuPlotComandos;
import plot.Graphic;
import plot.GravaArquivo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Index {






    /* A utility function to print array of size n */
       private static void printArray(Ponto arr[]) {
            int n = arr.length;
            for (int i=0; i<n; ++i)
                System.out.print("["+arr[i].getX() + " "+arr[i].getY()+"]");
            System.out.println();
        }

    private static ArrayList<Ponto> carregaPontos(){

        Ponto p1 = new Ponto(1, 9);
        Ponto p2 = new Ponto(10, 5);
        Ponto p3 = new Ponto(12, 3);
        Ponto p4 = new Ponto(1, 1);
        Ponto p5 = new Ponto(8, 9);
        Ponto p6 = new Ponto(2, 3);
        Ponto p7 = new Ponto(1, 2);
        Ponto p8 = new Ponto(4, 1);
        Ponto p9 = new Ponto(5, 5);
        Ponto p10 = new Ponto(1, 0);
        ArrayList<Ponto> conjuntoPontos = new ArrayList();
        conjuntoPontos.add(p1);
        conjuntoPontos.add(p2);
        conjuntoPontos.add(p3);
        conjuntoPontos.add(p4);
        conjuntoPontos.add(p5);
        conjuntoPontos.add(p6);
        conjuntoPontos.add(p7);
        conjuntoPontos.add(p8);
        conjuntoPontos.add(p9);
        conjuntoPontos.add(p10);

         return conjuntoPontos;
    }

    private static void start(){
       String op = "100";
       GnuPlotComandos plotComandos = new GnuPlotComandos();
       ArrayList<Ponto> conjuntoPontos = null;
       AlgGraham algGraham = new AlgGraham();
       Graphic grafico = null;
       Operacoes operacoes = new Operacoes();
       StringTokenizer st1,st2;


        do {
            op = JOptionPane.showInputDialog(null," Digite a opção:\n" +
                    " [ 1 ]   Calcular a distância entre dois pontos.\n" +
                    " [ 2 ]   Calcular a distância entre um ponto e uma reta.\n" +
                    " [ 3 ]   Calcular a área de uma círculo.\n" +
                    " [ 4 ]   Predicado convexidade de um polígono. (slide 27-28 do pdf auxiliar).\n" +
                    " [ 5 ]   Dobrar polígonos em triângulos até um único triângulo. (slide 25 do pdf auxiliar).\n" +
                    " [ 6 ]   Predicado orientação 2D. (slides 29-31 do pdf auxiliar).\n" +
                    " [ 7 ]   Predicado qual lado do círculo. (slides 32-33 do pdf auxiliar).\n" +
                    " [ 8 ]   Encontrar ponto mais próximo de um segmento de reta. (slide 35 do pdf auxiliar).\n" +
                    " [ 9 ]   Determinar a interseção de segmentos de reta. (slide 37-44 do pdf auxiliar) \n"+
                    " [ 10 ]   Predicado ponto dentro do polígono. (slides 46-47 do pdf auxiliar).\n\n" +

                    " [ 11 ]  Problema do par mais próximo.\n" +
                    " [ 12 ]  Problema do fecho convexo.\n" +
                    " [ 13 ]  Diagrama de Voronoi.\n\n" +

                    " [ -1 ]  Fecha Gráfico.\n\n" +
                    " [ 0 ]   SAIR \n");

            switch (Integer.parseInt(op)) {
                //Distância entre dois pontos
                case 1:
                        st1 = new StringTokenizer(JOptionPane.showInputDialog(null,"Informe ponto 1  'x,y'"),",");
                        st2 = new StringTokenizer(JOptionPane.showInputDialog(null,"Informe ponto 2  'x,y'"),",");
                        Double d = Par.distancia(new Ponto(Integer.parseInt(st1.nextToken()),Integer.parseInt(st1.nextToken())) ,
                                      new Ponto(Integer.parseInt(st2.nextToken()),Integer.parseInt(st2.nextToken())));
                        JOptionPane.showMessageDialog(null,"A Distancia entre P1 e P2 é : "+ d);

                    break;
                //Distância entre ponte e segmento de Reta
                case 2:
                        st1 = new StringTokenizer(JOptionPane.showInputDialog(null,"Informe Ponto   'x,y'"),",");
                        Ponto p2 = new Ponto(Integer.parseInt(st1.nextToken()),Integer.parseInt(st1.nextToken()));
                        do {
                            st2 = new StringTokenizer(JOptionPane.showInputDialog(null, "Informe os dois pontos do Segmento de Reta 'x1,y1' - 'x2,y2'"), ",- ");
                        } while (st2.countTokens() != 4);
                        SegmentoReta sR2 = new SegmentoReta(new Ponto(Integer.parseInt(st2.nextToken()),Integer.parseInt(st2.nextToken())),
                                new Ponto(Integer.parseInt(st2.nextToken()),Integer.parseInt(st2.nextToken())));

                        GravaArquivo.GravaPontos(sR2,p2);
                        plotComandos.plotHeatMap(1024,600,5);
                        grafico = new Graphic();
                        grafico.setVisible(true);

                        JOptionPane.showMessageDialog(null,"Distancia entre Ponto e Segmento de Reta é: " +
                                                        operacoes.distanciaPontoReta(p2,sR2));

                        break;

                //Área de um círculo
                case 3:
                       JOptionPane.showMessageDialog(null ,"Área do Círculo: " +
                               operacoes.areaCirculo(Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o Raio"))) + " cm2");
                break;



                //predicado Orientacao 2D
                case 6:


                    do {
                        st2 = new StringTokenizer(JOptionPane.showInputDialog(null, "Informe os três pontos 'x1,y1' - 'x2,y2' - 'x3,y3'"), ",- ");
                    } while (st2.countTokens() != 6);

                    ArrayList<Ponto> pts = new ArrayList<Ponto>();
                    pts.add(new Ponto(Integer.parseInt(st2.nextToken()),Integer.parseInt(st2.nextToken())));
                    pts.add(new Ponto(Integer.parseInt(st2.nextToken()),Integer.parseInt(st2.nextToken())));
                    pts.add(new Ponto(Integer.parseInt(st2.nextToken()),Integer.parseInt(st2.nextToken())));
                    JOptionPane.showMessageDialog(null,""+operacoes.predicadoOrientacao2D(pts.get(0),pts.get(1),pts.get(2)));

                    GravaArquivo.GravaPontos(pts);
                    plotComandos.plotHeatMap(1024,600,6);
                    grafico = new Graphic();
                    grafico.setVisible(true);

                    break;

                    //Interceção de reta
                case 9:
                    // Gera Segmento de Reta
                    SegmentoReta sr1 = new SegmentoReta();
                    sr1.setpSR1(new Ponto(2,1));
                    sr1.setpSR2(new Ponto(2,6));

                    SegmentoReta sr2 = new SegmentoReta();
                    sr2.setpSR1(new Ponto(1,4));
                    sr2.setpSR2(new Ponto(3,4));

                    JOptionPane.showMessageDialog(null,""+operacoes.intersecaoSegRetas(sr1,sr2));

                    GravaArquivo.GravaPontos(sr1,sr2);

                    // Duas retas
                    plotComandos.plotHeatMap(1024,600,2);
                    grafico = new Graphic();
                    grafico.setVisible(true);
                    break;

                //Problema do par mais próximo.
                case 11:

                    conjuntoPontos = carregaPontos();
                    ArrayList<Ponto> fechoConvexo  = algGraham.procuraFecho((ArrayList<Ponto>) conjuntoPontos.clone());
                    System.out.println("OS PONTOS DO FECHO CONVESO SÃO: ");
                    for (int i = 0; i < fechoConvexo.size(); i++)
                        System.out.print("(" + fechoConvexo.get(i).getX() + ", " + fechoConvexo.get(i).getY() + ")");

                    GravaArquivo.GravaPontos(conjuntoPontos,fechoConvexo);
                    plotComandos.plotHeatMap(1024,600,4);

                    grafico = new Graphic();
                    grafico.setVisible(true);

                    conjuntoPontos.clear();
                break;

                //Menor distancia entre dois pontos
                case 12:

                    conjuntoPontos = carregaPontos();
                    Ponto[] pontos = new Ponto[conjuntoPontos.size()];
                    int aux = 0;
                    for (Ponto tp: conjuntoPontos) {
                        pontos[aux] = tp;
                        aux++;
                    }

                    Par par = operacoes.parMaisProximo(pontos);
                    System.out.println("Menor distancia = "+ par.toString());
                    GravaArquivo.GravaPontos(conjuntoPontos,par);
                    plotComandos.plotHeatMap(1024,600,3);

                    grafico = new Graphic();
                    grafico.setVisible(true);

                    conjuntoPontos.clear();


                    break;
                case -1:
                    grafico.dispose();
                break;

            }


        }while (Integer.parseInt(op) != 0);

    }


    public static void main(String[] args) {
      /*  Avl s = new Avl();

        s.insert(1);
        s.insert(2);

        System.out.println(s.member(3));

        s.insert(3);
        s.delete(2);
        System.out.println(s.member(3));

*/


        Index.start();

        // Gera Segmento de Reta
        SegmentoReta sr1 = new SegmentoReta();
        sr1.setpSR1(new Ponto(2,1));
        sr1.setpSR2(new Ponto(2,6));
        //GravaArquivo.GravaPontos(sr1);




        //Gera Poligono
        Ponto p1 = new Ponto(1, 9);
        Ponto p2 = new Ponto(10, 5);
        Ponto p3 = new Ponto(12, 3);
        Ponto p4 = new Ponto(1, 1);
        Ponto p5 = new Ponto(8, 9);
        Ponto p6 = new Ponto(2, 3);
        Ponto p7 = new Ponto(1, 2);
        Ponto p8 = new Ponto(4, 1);
        Ponto p9 = new Ponto(5, 5);
        Ponto p10 = new Ponto(1, 0);
        Operacoes operacoes = new Operacoes();
        ArrayList<Ponto> conjuntoPontos = new ArrayList();
        conjuntoPontos.add(p1);
        conjuntoPontos.add(p2);
        conjuntoPontos.add(p3);
        conjuntoPontos.add(p4);
        conjuntoPontos.add(p5);
        conjuntoPontos.add(p6);
        conjuntoPontos.add(p7);
        conjuntoPontos.add(p8);
        conjuntoPontos.add(p9);
        conjuntoPontos.add(p10);
        System.out.println(operacoes.member(conjuntoPontos, p5));

        GravaArquivo.GravaPontos(conjuntoPontos);

        printArray(operacoes.retornaVetorPontoOrdenado(conjuntoPontos,'x'));
        printArray(operacoes.retornaVetorPontoOrdenado(conjuntoPontos,'y'));

        Ponto[] pontos = new Ponto[conjuntoPontos.size()];

        //Problema do par mais próximo
        //----------------------------------------------------------------------

        // Menor distancia entre dois pontos
        //plotComandos.plotHeatMap(1024,600,3);
        //---------------------------------------------------------------



        //Problema do fecho convexo
        ///-----------------------------------------------------------



        //----------------------------------------














        //Conjunto de Pontos
        //plotComandos.plotHeatMap(1024,600,1);


        System.out.close();
    }
}
