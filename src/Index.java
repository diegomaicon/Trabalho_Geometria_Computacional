import modelo.Operacoes;
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





        // Gera Segmento de Reta
        SegmentoReta sr1 = new SegmentoReta();
        sr1.setpSR1(new Ponto(2,1));
        sr1.setpSR2(new Ponto(2,6));
        //GravaArquivo.GravaPontos(sr1);

        SegmentoReta sr2 = new SegmentoReta();
        sr2.setpSR1(new Ponto(1,4));
        sr2.setpSR2(new Ponto(3,4));
        //GravaArquivo.GravaPontos(sr1);

        GravaArquivo.GravaPontos(sr1,sr2);
        Operacoes.intersecaoSegRetas(sr1,sr2);


        //Gera Poligono
        Ponto p1 = new Ponto(1, 9);
        Ponto p2 = new Ponto(10, 5);
        Ponto p3 = new Ponto(12, 3);
        Ponto p4 = new Ponto(1, 1);
        Ponto p5 = new Ponto(1, 9);
        Operacoes operacoes = new Operacoes();
        ArrayList<Ponto> conjuntoPontos = new ArrayList();
        conjuntoPontos.add(p1);
        conjuntoPontos.add(p2);
        conjuntoPontos.add(p3);
        conjuntoPontos.add(p4);
        conjuntoPontos.add(p5);
        System.out.println(operacoes.member(conjuntoPontos, p5));

        //GravaArquivo.GravaPontos(conjuntoPontos);

        printArray(operacoes.retornaVetorPontoOrdenado(conjuntoPontos));


        GnuPlotComandos plotComandos = new GnuPlotComandos();

       // Duas retas
        plotComandos.plotHeatMap(1024,600,2);

        //Conjunto de Pontos
        //plotComandos.plotHeatMap(1024,600,1);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Graphic().setVisible(true);
            }
        });

    }
}
