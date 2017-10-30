import modelo.Operacoes;
import modelo.Ponto;
import modelo.SegmentoReta;
import plot.GnuPlotComandos;
import plot.Graphic;

import java.util.ArrayList;

public class Index {


    public static void main(String[] args) {
      /*  Avl s = new Avl();

        s.insert(1);
        s.insert(2);

        System.out.println(s.member(3));

        s.insert(3);
        s.delete(2);
        System.out.println(s.member(3));

*/






        SegmentoReta sr1 = new SegmentoReta();

        sr1.setpSR1(new Ponto(1,2));
        sr1.setpSR1(new Ponto(5,7));
        Plano p = new Plano().init();

        Ponto p1 = new Ponto(1, 9);
        Ponto p2 = new Ponto(10, 5);
        Ponto p3 = new Ponto(12, 3);
        Ponto p4 = new Ponto(1, 1);
        Ponto p5 = new Ponto(14, 1);
        Operacoes operacoes = new Operacoes();
        ArrayList<Ponto> ConjuntoPontos = new ArrayList();
        ConjuntoPontos.add(p1);
        ConjuntoPontos.add(p2);
        ConjuntoPontos.add(p3);
        ConjuntoPontos.add(p4);
        // ConjuntoPontos.add(p5);
        System.out.println(operacoes.member(ConjuntoPontos, p5));





        GnuPlotComandos plotComandos = new GnuPlotComandos();

        plotComandos.plotHeatMap(1024,600,1);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Graphic().setVisible(true);
            }
        });

    }
}
