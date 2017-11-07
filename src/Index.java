import libs.AlgGraham;
import modelo.Operacoes;
import modelo.Par;
import modelo.Ponto;
import modelo.SegmentoReta;
import plot.GnuPlotComandos;
import plot.Graphic;
import plot.GravaArquivo;

import java.util.ArrayList;

public class Index {



    /* A utility function to print array of size n */
    static void printArray(Ponto arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print("["+arr[i].getX() + " "+arr[i].getY()+"]");
        System.out.println();
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

        GnuPlotComandos plotComandos = new GnuPlotComandos();



        // Gera Segmento de Reta
        SegmentoReta sr1 = new SegmentoReta();
        sr1.setpSR1(new Ponto(2,1));
        sr1.setpSR2(new Ponto(2,6));
        //GravaArquivo.GravaPontos(sr1);

        SegmentoReta sr2 = new SegmentoReta();
        sr2.setpSR1(new Ponto(1,4));
        sr2.setpSR2(new Ponto(3,4));
        //GravaArquivo.GravaPontos(sr1);

        //GravaArquivo.GravaPontos(sr1,sr2);
        Operacoes.intersecaoSegRetas(sr1,sr2);


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
        int i=0;
        for (Ponto tp: conjuntoPontos) {
            pontos[i] = tp;
            i++;
        }

        Par par = new Par();
        par = operacoes.parMaisProximo(pontos);
        System.out.println("Menor distancia = " +par.toString());
        GravaArquivo.GravaPontos(conjuntoPontos,par);

        // Menor distancia entre dois pontos
        //plotComandos.plotHeatMap(1024,600,3);
        //---------------------------------------------------------------



        //Problema do fecho convexo
        ///-----------------------------------------------------------

        AlgGraham algGraham = new AlgGraham();
        ArrayList<Ponto> fechoConvexo = new ArrayList<Ponto>();
        fechoConvexo  = algGraham.procuraFecho((ArrayList<Ponto>) conjuntoPontos.clone());
        System.out.println("The points in the Convex hull using Quick Hull are: ");
        for (i = 0; i < fechoConvexo.size(); i++)
            System.out.println("(" + fechoConvexo.get(i).getX() + ", " + fechoConvexo.get(i).getY() + ")");

        GravaArquivo.GravaPontos(conjuntoPontos,fechoConvexo);
        plotComandos.plotHeatMap(1024,600,4);

        //----------------------------------------








       // Duas retas
        //plotComandos.plotHeatMap(1024,600,2);





        //Conjunto de Pontos
        //plotComandos.plotHeatMap(1024,600,1);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Graphic().setVisible(true);
            }
        });

    }
}
