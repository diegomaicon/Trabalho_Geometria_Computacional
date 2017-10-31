package plot;

import modelo.Ponto;
import modelo.SegmentoReta;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GravaArquivo {


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