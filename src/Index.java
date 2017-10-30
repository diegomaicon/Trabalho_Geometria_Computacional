import modelo.Ponto;
import modelo.SegmentoReta;
import plot.GnuPlotComandos;
import plot.Graphic;

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


        GnuPlotComandos plotComandos = new GnuPlotComandos();

        plotComandos.plotHeatMap(1024,600,1);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Graphic().setVisible(true);
            }
        });

    }
}
