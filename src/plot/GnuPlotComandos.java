package plot;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;



    public class GnuPlotComandos {

        private static final int PONTO = 1;


        private static void exec(String[] comando) {
            try {
                System.out.println("entrou");
                Process proc = Runtime.getRuntime().exec("/usr/bin/gnuplot");
                OutputStream outputStream = proc.getOutputStream(); //process p
                PrintWriter gp = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
                for (String comando1 : comando) {
                    gp.println(comando1);
                    gp.flush();
                }
                gp.close();

                proc.waitFor();
            } catch (Exception x) {
                System.out.println(x.getMessage());
            }
        }
        public static void plotHeatMap(int LARGURA, int ALTURA, int FILTRO) {

            if (FILTRO == PONTO) {
                System.out.println("plotando os pontos da medicao");
                //"set terminal pngcairo transparent enhanced size "+LARGURA*1.326213592+", "+ALTURA*1.542857143+" \n" ,
                String[] scriptPontos = {
                        "set terminal pngcairo transparent size 1366, 819 \n" ,
                        "set view map\n" ,

                        "set dgrid2d 1000, 600,2\n" ,
                        "set size 1,1",
                        "set xrange [-15:15]\n",
                        "set yrange [-15:15]\n" ,
                        "set grid \n",
                        //  "set palette defined (0 0 0 0.5, 1 0 0 1, 2 0 0.5 1, 3 0 1 1, 4 0.5 1 0.5, 5 1 1 0, 6 1 0.5 0, 7 1 0 0, 8 0.5 0 0)",
                        "set output 'plano.png'\n" ,

                        "plot \"dados-plot.txt\"  u 1:2 with lp lt 10 pt 6 lw 3 point  ps 1 t\"\""+"\n" ,

                        "exit"

                };
                System.out.println("pronto");
                GnuPlotComandos.exec(scriptPontos);
                //plota pontos

            }
        }

        public static void plotPontosMedicao(int LARGURA, int ALTURA) {
            plotHeatMap(LARGURA, ALTURA, PONTO);
        }


    }

