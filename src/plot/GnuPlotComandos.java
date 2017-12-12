package plot;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 *  @author Déborah A. Resende
 *  @author Diego Maicon
 *
 *  Classe onde é enviado ao Gnuplot, que é um utilitário de gráficos com linha de comando portátil para Linux, OS / 2, MS Windows, OSX, VMS e muitas outras plataformas.
 *  O código-fonte é protegido por direitos autorais, mas distribuído gratuitamente (ou seja, você não precisa pagar por isso).
 *  Foi originalmente criado para permitir que cientistas e alunos visualizem funções matemáticas e dados de forma interativa,
 *  mas cresceu para suportar muitos usos não interativos, como scripts na web.
 *  Também é usado como um mecanismo de gráficos por aplicativos de terceiros, como Octave.
 *  O Gnuplot foi apoiado e em desenvolvimento ativo desde 1986.
 *
 */

    public class GnuPlotComandos {

        private static final int PONTO = 1;
        private static final int DUASRETAS = 2;
        private static final int MENORPONTOS = 3;
        private static final int FECHOCONVEXO = 4;
        private static final int PONTOERETA = 5;
        private static final int PREDICADO2D = 6;
        private static final int POLIGONOPONTO = 7;
        private static final int PONTOS_PONTO_RETA = 8;
        private static final int POLIGONO = 9;
        private static final int VORONOI = 10;

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
        public static void plot(int FILTRO) {

            if (FILTRO == PONTO) {
               // System.out.println("plotando os pontos da medicao");
                //"set terminal pngcairo transparent enhanced size "+LARGURA*1.326213592+", "+ALTURA*1.542857143+" \n" ,
                String[] scriptPontos = {
                        "set terminal pngcairo transparent size 800, 600 \n" ,
                        "set view map\n" ,

                        "set dgrid2d 600, 600, 2\n" ,
                        "set size 1,1",
                        "set xlabel \"eixo X\"",
                        "set ylabel \"eixo Y\"",
                        "set xrange [-15:15]\n",
                        "set yrange [-15:15]\n" ,
                        "set grid \n",
                        "set output 'plano.png'\n" ,

                        "plot \"dados-plot.txt\"  u 1:2 with lp lt 10 pt 6 lw 3 point  ps 1 t\"\""+"\n" ,

                        "exit"

                };
                GnuPlotComandos.exec(scriptPontos);


            } else if (FILTRO == DUASRETAS) {
                String[] scriptPontos = {
                        "set terminal pngcairo transparent size 800, 600 \n" ,
                        "set view map\n" ,

                        "set dgrid2d 600, 600, 2\n" ,
                        "set size 1,1",
                        "set xlabel \"eixo X\"",
                        "set ylabel \"eixo Y\"",
                        "set xrange [-15:15]\n",
                        "set yrange [-15:15]\n" ,
                        "set grid \n",
                        "set output 'plano.png'\n" ,

                        "plot \"dados-plot.txt\"  u 1:2 with lp lt 10 pt 7 lw 1  ps 1 title \"Segmento de reta 1\",\"dados-plot.txt\"  u 3:4 with lp lt 4 pt 7 lw 1  ps 1 t\"Segmento de reta 2\""+"\n" ,
                        "exit"

                };
                GnuPlotComandos.exec(scriptPontos);

            } else if (FILTRO == MENORPONTOS) {
                String[] scriptPontos = {
                        "set terminal pngcairo transparent size 800, 600 \n",
                        "set view map\n",

                        "set dgrid2d 600, 600, 2\n",
                        "set size 1,1",
                        "set xlabel \"eixo X\"",
                        "set ylabel \"eixo Y\"",
                        "set xrange [-15:15]\n",
                        "set yrange [-15:15]\n",
                        "set grid \n",
                        "set output 'plano.png'\n",

                        "plot \"dados-plot.txt\"  u 1:2 with p lt 10 pt 7   ps 1 title \"Pontos\",\"dados-plot.txt\"  u 3:4 with lp lt 4 pt 7 lw 1  ps 1 t\"Par mais Próximos\"" + "\n",
                        "exit"

                };
                System.out.println("pronto");
                GnuPlotComandos.exec(scriptPontos);
            } else if (FILTRO == FECHOCONVEXO) {
                String[] scriptPontos = {
                        "set terminal pngcairo transparent size 800, 600 \n",
                        "set view map\n",

                        "set dgrid2d 600, 600, 2\n",
                        "set size 1,1",
                        "set xlabel \"eixo X\"",
                        "set ylabel \"eixo Y\"",
                        "set xrange [-15:15]\n",
                        "set yrange [-15:15]\n",
                        "set grid \n",
                        "set output 'plano.png'\n",

                        "plot \"dados-plot.txt\"  u 1:2 with p lt 10 pt 7   ps 1 title \"Pontos\",\"dados-plot.txt\"  u 3:4 with lp lt 4 pt 7 lw 1  ps 1 t\"Fecho Convexo\"" + "\n",
                        "exit"

                };
                System.out.println("pronto");
                GnuPlotComandos.exec(scriptPontos);
            }else if (FILTRO == PONTOERETA) {
                String[] scriptPontos = {
                        "set terminal pngcairo transparent size 800, 600 \n",
                        "set view map\n",

                        "set dgrid2d 600, 600, 2\n",
                        "set size 1,1",
                        "set xlabel \"eixo X\"",
                        "set ylabel \"eixo Y\"",
                        "set xrange [-15:15]\n",
                        "set yrange [-15:15]\n",
                        "set grid \n",
                        "set output 'plano.png'\n",

                        "plot \"dados-plot.txt\"  u 1:2 with lp lt 10 pt 7  lw 1  ps 1 title \"Segmento de reta\",\"dados-plot.txt\"  u 3:4 with p lt 4 pt 7   ps 1 t\"Ponto\"" + "\n",
                        "exit"
                };

                GnuPlotComandos.exec(scriptPontos);
            }else if (FILTRO == PREDICADO2D) {
                String[] scriptPontos = {
                        "set terminal pngcairo transparent size 800, 600 \n",
                        "set view map\n",

                        "set dgrid2d 600, 600, 2\n",
                        "set size 1,1",
                        "set xlabel \"eixo X\"",
                        "set ylabel \"eixo Y\"",
                        "set xrange [-15:15]\n",
                        "set yrange [-15:15]\n",
                        "set grid \n",
                        "set output 'plano.png'\n",

                        "plot \"dados-plot.txt\"  u 1:2 with lp lt 10 pt 7  lw 1  ps 1 title \"Predicado Orientação 2D\" \n",
                        "exit"
                };

                GnuPlotComandos.exec(scriptPontos);
            }else if (FILTRO == POLIGONOPONTO) {
                String[] scriptPontos = {
                        "set terminal pngcairo transparent size 800, 600 \n",
                        "set view map\n",

                        "set dgrid2d 600, 600, 2\n",
                        "set size 1,1",
                        "set xlabel \"eixo X\"",
                        "set ylabel \"eixo Y\"",
                        "set xrange [-15:15]\n",
                        "set yrange [-15:15]\n",
                        "set grid \n",
                        "set output 'plano.png'\n",

                        "plot \"dados-plot.txt\"  u 1:2 with lp lt 10 pt 7  lw 1  ps 1 title \"Polígono\",\"dados-plot.txt\"  u 3:4 with p lt 4 pt 7   ps 1 t\"Ponto\"" + "\n",
                        "exit"
                };

                GnuPlotComandos.exec(scriptPontos);
            }else if (FILTRO == PONTOS_PONTO_RETA) {
                String[] scriptPontos = {
                        "set terminal pngcairo transparent size 800, 600 \n",
                        "set view map\n",

                        "set dgrid2d 600, 600, 2\n",
                        "set size 1,1",
                        "set xlabel \"eixo X\"",
                        "set ylabel \"eixo Y\"",
                        "set xrange [-15:15]\n",
                        "set yrange [-15:15]\n",
                        "set grid \n",
                        "set output 'plano.png'\n",

                        "plot \"dados-plot.txt\"  u 1:2 with p lt 10 pt 7 ps 1 title \"Pontos\",\"dados-plot.txt\"  u 3:4 with lp lt 12 pt 2 ps 2 title \"Segmento de Reta\",\"dados-plot.txt\"  u 5:6 with p lt 12 pt 2 ps 2 t\"Ponto mais Proximo\"" + "\n",
                        "exit"
                };

                GnuPlotComandos.exec(scriptPontos);
            } else if (FILTRO == POLIGONO) {
                String[] scriptPontos = {
                        "set terminal pngcairo transparent size 800, 600 \n",
                        "set view map\n",
                        "set dgrid2d 600, 600, 2\n",
                        "set size 1,1",
                        "set xlabel \"eixo X\"",
                        "set ylabel \"eixo Y\"",
                        "set xrange [-15:15]\n",
                        "set yrange [-15:15]\n",
                        "set grid \n",
                        "set output 'plano.png'\n",

                        "plot \"dados-plot.txt\"  u 1:2 with lp lt 10 pt 7 ps 1 title \"POLIGONO\"" + "\n",
                        "exit"
                };

                GnuPlotComandos.exec(scriptPontos);
            }else if (FILTRO == VORONOI) {
                String[] scriptPontos = {
                        "set terminal pngcairo transparent size 800, 600 \n",
                        "set view map\n",

                        "set dgrid2d 600, 600, 2\n",
                        "set size 1,1",
                        "set xlabel \"eixo X\"",
                        "set ylabel \"eixo Y\"",
                        "set xrange [-15:15]\n",
                        "set yrange [-15:15]\n",
                        "set grid \n",
                        "set output 'plano.png'\n",

                        "plot \"dados-plot.txt\"  u 1:2 with p lt 10 pt 7   ps 1 title \"Pontos\",\"dados-plot.txt\"  u 3:4 with lp lt 4 pt 7 lw 1  ps 1 t\"Diagrama Voronoi\"" + "\n",
                        "exit"

                };
                System.out.println("pronto");
                GnuPlotComandos.exec(scriptPontos);
            }
        }

        public static void plotPontosMedicao(int LARGURA, int ALTURA) {
            plot(PONTO);
        }


    }

