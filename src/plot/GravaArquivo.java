package plot;

import modelo.Par;
import modelo.Ponto;
import modelo.SegmentoReta;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GravaArquivo {


    public static void GravaPontos(ArrayList<Ponto> pontos,ArrayList<Ponto> fecho) {

        try {

            FileWriter arq = new FileWriter("dados-plot.txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf("x1\ty1\tx2\ty2\n");
            for (int i = 0; i < pontos.size() ; i++) {
                if(i < fecho.size()) {
                    gravarArq.print(pontos.get(i).getX() + "\t" + pontos.get(i).getY() + "\t" + fecho.get(i).getX() + "\t" + fecho.get(i).getY() + "\n");
                }if(i == fecho.size()) {
                    gravarArq.print(pontos.get(i).getX() + "\t" + pontos.get(i).getY() + "\t" + fecho.get(0).getX() + "\t" + fecho.get(0).getY() + "\n");
                } else {
                    gravarArq.print(pontos.get(i).getX()+"\t"+pontos.get(i).getY()+"\n");
                }

            }


            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void GravaPontos(ArrayList<Ponto> pontos) {

        try {

            FileWriter arq = new FileWriter("dados-plot.txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf("x\ty\n");
            for (Ponto p:pontos) {
                gravarArq.print(p.getX()+"\t"+p.getY()+"\n");
            }
            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void GravaPontos(ArrayList<Ponto> pontos, Par par) {

        try {

            FileWriter arq = new FileWriter("dados-plot.txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf("x1\ty1\tx2\ty2\n");
            int aux=0;
            for (Ponto p:pontos) {
                if (aux == 1){
                    gravarArq.print(p.getX()+"\t"+p.getY()+"\t"+par.p1.getX()+"\t"+par.p1.getY()+"\n");
                } if (aux == 2){
                    gravarArq.print(p.getX()+"\t"+p.getY()+"\t"+par.p2.getX()+"\t"+par.p2.getY()+"\n");
                } else{
                    gravarArq.print(p.getX()+"\t"+p.getY()+"\n");
                }
                aux++;
            }
            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void GravaPontos(SegmentoReta segmentoReta) {

        try {

            FileWriter arq = new FileWriter("dados-plot.txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf("x\ty\n");

                gravarArq.print(segmentoReta.getpSR1().getX()+"\t"+segmentoReta.getpSR1().getY()+"\n");
                gravarArq.print(segmentoReta.getpSR2().getX()+"\t"+segmentoReta.getpSR2().getY()+"\n");

            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void GravaPontos(SegmentoReta segmentoReta,Ponto ponto) {

        try {

            FileWriter arq = new FileWriter("dados-plot.txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf("x1\ty1\tx2\ty2\n");

            gravarArq.print(segmentoReta.getpSR1().getX()+"\t"+segmentoReta.getpSR1().getY()+"\t"+ponto.getX()+"\t"+ponto.getY()+"\n");
            gravarArq.print(segmentoReta.getpSR2().getX()+"\t"+segmentoReta.getpSR2().getY()+"\n");

            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void GravaPontos(SegmentoReta seg1,SegmentoReta seg2) {

        try {

            FileWriter arq = new FileWriter("dados-plot.txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf("x1\ty1\tx2\ty2\n");

            gravarArq.print(seg1.getpSR1().getX()+"\t"+seg1.getpSR1().getY()+"\t");
            gravarArq.print(seg2.getpSR1().getX()+"\t"+seg2.getpSR1().getY()+"\n");

            gravarArq.print(seg1.getpSR2().getX()+"\t"+seg1.getpSR2().getY()+"\t");
            gravarArq.print(seg2.getpSR2().getX()+"\t"+seg2.getpSR2().getY()+"\n");

            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void GravaPontos(Ponto ponto) {

        try {

            FileWriter arq = new FileWriter("dados-plot.txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf("x\ty\n");
            gravarArq.print(ponto.getX()+"\t"+ponto.getY()+"\n");

            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
