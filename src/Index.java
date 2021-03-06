import libs.AlgGraham;
import libs.EstrategiasPA;
import libs.ManiputationConjunto;
import libs.Operacoes;
import libs.voronoi.Voronoi;
import modelo.*;
import plot.GnuPlotComandos;
import plot.Graphic;
import plot.GravaArquivo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *  @author Déborah A. Resende
 *  @author Diego Maicon
 *
 */

public class Index {


    /**
     *  Uma função de utilidade para imprimir matriz de tamanho n
     **/
    private static void printArray(Ponto arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print("[" + arr[i].getX() + " " + arr[i].getY() + "]");
        System.out.println();
    }

    private static ArrayList<Ponto> carregaPontos() {

        Ponto p1 = new Ponto(1, 3);
        Ponto p2 = new Ponto(3, 2);
        Ponto p3 = new Ponto(5, 9);
        Ponto p7 = new Ponto(1, 5);
        Ponto p8 = new Ponto(4, 1);
        Ponto p9 = new Ponto(5, 5);
        Ponto p10 = new Ponto(1, 0);

        /*Ponto p1 = new Ponto(-3,-2);
        Ponto p2 = new Ponto(-1,4);
        Ponto p3 = new Ponto(6,1);
        Ponto p4 = new Ponto(3,10);
       // Ponto p5 = new Ponto(-4,9);
       // Ponto p6 = new Ponto(4,1);
*/
        ArrayList<Ponto> conjuntoPontos = new ArrayList();
        conjuntoPontos.add(p1);
        conjuntoPontos.add(p2);
        conjuntoPontos.add(p3);
      //  conjuntoPontos.add(p4);
        // conjuntoPontos.add(p5);
        //conjuntoPontos.add(p6);
     //   conjuntoPontos.add(p7);
       // conjuntoPontos.add(p8);
        //conjuntoPontos.add(p9);
        //conjuntoPontos.add(p10);

        return conjuntoPontos;
    }
    private static ArrayList<Ponto> carregaPontos2() {
        Ponto p1 = new Ponto(-3,-2);
        Ponto p2 = new Ponto(-1,4);
        Ponto p3 = new Ponto(6,1);
        Ponto p4 = new Ponto(3,10);
        Ponto p5 = new Ponto(-4,9);
        Ponto p6 = new Ponto(1,1);

        ArrayList<Ponto> conjuntoPontos = new ArrayList();
        conjuntoPontos.add(p1);
        conjuntoPontos.add(p2);
        conjuntoPontos.add(p3);
        conjuntoPontos.add(p4);
        conjuntoPontos.add(p5);
        conjuntoPontos.add(p6);
        return conjuntoPontos;

    }

    /**
     *  Cria menu inicial
     *
     * @param pontos
     */
    private static void manipulaConjuntos(ArrayList<Ponto> pontos) {
        StringTokenizer st1;
        ArrayList<Ponto> conjPonto = (ArrayList<Ponto>) pontos.clone();
        String op = "100",print="";
        do {
            op = JOptionPane.showInputDialog(null, "Menu de manipulação de conjuntos\n\n" +
                    " • [1] S:member(u) – Tem-se que u 2 S? (resposta sim/não))\n" +
                    " • [2] S:insert(u) – Adiciona u em S\n" +
                    " • [3] S:delete(u) – Remove u de S\n\n" +

                    " • [4] Cancelado C:member(A) – Tem-se que A ⊆ C? (resposta sim/não)\n" +
                    " • [5] Cancelado C:insert(A) – Adiciona A em C, se A \\ Si = ? para todo 1 <= i <= k. \n" +
                    " • [6] Cancelado C:delete(A) – Remove A de C.\n" +
                    " • [7] Cancelado C:find(u) – Retorna Sj, se u 2 Sj.\n\n" +

                    " • [8] union(A; B) – Retorna A U B.\n" +
                    " • [9] intersection(A; B) – Retorna A  B.\n" +
                    " • [10] difference(A; B) – Retorna A − B.\n\n" +

                    " • [11] S:min() – Retorna o elemento mínimo de S.\n" +
                    " • [12] S:split(u) – Particiona S em fS1; S2g tal que S1 = fv j v 2 S e v ≤ ug e S2 = S − S1. Retorna  C = fS1; S2g \n" +
                    " • [13] S:concatenate(A) – Assumindo que, para arbitrários u0 2 S e u00 2 A, tem-se que u0 <= u00, faz S = S [ A.)\n");
            if(op == null){
                break;
            }
            switch (Integer.parseInt(op)) {
                case 1:
                    do {
                        st1 = new StringTokenizer(JOptionPane.showInputDialog(null, "Informe as coordenadas dos pontos 'X,Y'."), ", ");
                    } while (st1.countTokens() != 2);
                    if (ManiputationConjunto.member(conjPonto, new Ponto(Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken())))) {
                        JOptionPane.showMessageDialog(null, "SIM - é membro");
                    } else {
                        JOptionPane.showMessageDialog(null, "NÃO - é membro");
                    }
                    break;

                case 2:
                    do {
                        st1 = new StringTokenizer(JOptionPane.showInputDialog(null, "Informe as coordenadas dos pontos 'X,Y'."), ",");
                    } while (st1.countTokens() != 2);
                    conjPonto = ManiputationConjunto.insert(conjPonto, new Ponto(Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken())));
                    break;
                case 3:
                    do {
                        st1 = new StringTokenizer(JOptionPane.showInputDialog(null, "Informe as coordenadas dos pontos 'X,Y'."), ",");
                    } while (st1.countTokens() != 2);
                    conjPonto = ManiputationConjunto.delete(conjPonto, new Ponto(Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken())));
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    print = "Uniao S A \n [";
                    for (Ponto p: ManiputationConjunto.union(carregaPontos(),carregaPontos2())) {
                        print += "("+p.getX()+","+p.getY()+")";
                    }
                        print+="]";
                    JOptionPane.showMessageDialog(null,print);
                    print="";
                    break;
                case 9:
                    print = "Intersecção S A \n [";
                    for (Ponto p: ManiputationConjunto.intersection(carregaPontos(),carregaPontos2())) {
                        print += "("+p.getX()+","+p.getY()+")";
                    }
                    print +="]";
                    JOptionPane.showMessageDialog(null,print);
                    print ="";

                    break;
                case 10:
                    print = "Diferença S - A \n [";
                    for (Ponto p: ManiputationConjunto.difference(carregaPontos(),carregaPontos2())) {
                        print += "("+p.getX()+","+p.getY()+")";
                    }
                    print +="]";
                    JOptionPane.showMessageDialog(null,print);
                    print ="";

                    break;
                case 11:
                    Ponto p11;
                    int op11 = Integer.parseInt(JOptionPane.showInputDialog(null,"Min 1-eixo X  | 2-eixo Y"));
                    if (op11 == 1){
                       p11 = ManiputationConjunto.minX(conjPonto);
                        JOptionPane.showMessageDialog(null,"Menor ponto eixo X ponto ["+p11.getX()+","+p11.getY()+"]");
                    } else if (op11 == 2){
                        p11 =  ManiputationConjunto.minY(conjPonto);
                        JOptionPane.showMessageDialog(null,"Menor ponto eixo Y ponto ["+p11.getX()+","+p11.getY()+"]");
                    }

                    break;
                case 12:
                    int u = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a posição para Split"));
                    ArrayList<ArrayList<Ponto>> conjConj = ManiputationConjunto.split(carregaPontos(),u);
                    print = "Conjunto S1\n[";
                    for (Ponto ps1: conjConj.get(0)) {
                        print += "("+ps1.getX()+","+ps1.getX()+")";
                    }
                        print += "]\n Conjunto S2\n[";

                    for (Ponto ps2: conjConj.get(1)) {
                        print += "("+ps2.getX()+","+ps2.getX()+")";
                    }
                        print += "]";
                    JOptionPane.showMessageDialog(null,print);
                    print = "";

                    break;
                case 13:
                    ArrayList<Ponto> S = ManiputationConjunto.concatenate(carregaPontos(),carregaPontos2());
                    print = "Concatenate S = A \nConjunto [";
                    for (Ponto p: S) {
                        print +=  "("+p.getX()+","+p.getY()+")";
                    }
                    print+="]";
                    JOptionPane.showMessageDialog(null,print);
                    print="";
                    break;
            }

        } while (op.equals("0"));


    }

    private static void start() {
        String op = "100";
        GnuPlotComandos plotComandos = new GnuPlotComandos();
        ArrayList<Ponto> conjuntoPontos = null;
        AlgGraham algGraham = new AlgGraham();
        Graphic grafico = null;
        Operacoes operacoes = new Operacoes();
        StringTokenizer st1, st2;


        do {
            op = JOptionPane.showInputDialog(null, " Digite a opção:\n" +
                    " ok [ 1 ]   Calcular a distância entre dois pontos.\n" +
                    " ok [ 2 ]   Calcular a distância entre um ponto e uma reta.\n" +
                    " ok [ 3 ]   Calcular a área de um polígono. \n" +
                    " ok [ 4 ]   Calcular a área de uma círculo.\n" +
                    " ok [ 5 ]   Predicado convexidade de um polígono. (slide 27-28 do pdf auxiliar).\n" +
                    " --- [ 6 ]   Dobrar polígonos em triângulos até um único triângulo. (slide 25 do pdf auxiliar).\n" +
                    " ok [ 7 ]   Predicado orientação 2D. (slides 29-31 do pdf auxiliar).\n" +
                    " ok [ 8 ]   Predicado qual lado do círculo. (slides 32-33 do pdf auxiliar).\n" +
                    " ok [ 9 ]   Encontrar ponto mais próximo de um segmento de reta. (slide 35 do pdf auxiliar).\n" +
                    " ok [ 10 ]   Determinar a interseção de segmentos de reta. (slide 37-44 do pdf auxiliar) \n" +
                    " ok [ 11 ]  Predicado ponto dentro do polígono. (slides 46-47 do pdf auxiliar).\n\n" +

                    " ok [ 12 ]  Problema do par mais próximo.\n" +
                    " ok [ 13 ]  Problema do fecho convexo.\n" +
                    " ok [ 14 ]  Diagrama de Voronoi.\n\n" +

                    " ----- Estratégias de Projeto de Algoritmos.\n" +
                    " ok [ 15 ]  Guloso - Problema do Troco.\n" +
                    " ok [ 16 ]  Programação Dinâmica - Problema do Mochila.\n\n" +

                    " ok [ 20 ]  Manipulação de conjuntos.\n\n" +

                    " [ -1 ]  Fecha Gráfico.\n\n" +
                    " [ 0 ]   SAIR \n");
            if(op == null){
                break;
            }

            switch (Integer.parseInt(op)) {
                //Distância entre dois pontos
                case 1:
                    do {
                        st1 = new StringTokenizer(JOptionPane.showInputDialog(null, "Informe ponto 1  'x,y'"), ",");
                    } while (st1.countTokens() != 2);
                    do {
                        st2 = new StringTokenizer(JOptionPane.showInputDialog(null, "Informe ponto 2  'x,y'"), ",");
                    } while (st1.countTokens() != 2);
                    Double d = Par.distancia(new Ponto(Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken())),
                            new Ponto(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken())));
                    JOptionPane.showMessageDialog(null, "A Distancia entre P1 e P2 é : " + d);

                    break;
                //Distância entre ponte e segmento de Reta
                case 2:
                    st1 = new StringTokenizer(JOptionPane.showInputDialog(null, "Informe Ponto   'x,y'"), ",");
                    Ponto p2 = new Ponto(Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken()));
                    do {
                        st2 = new StringTokenizer(JOptionPane.showInputDialog(null, "Informe os dois pontos do Segmento de Reta 'x1,y1' : 'x2,y2'"), ",: ");
                    } while (st2.countTokens() != 4);
                    SegmentoReta sR2 = new SegmentoReta(new Ponto(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken())),
                            new Ponto(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken())));

                    GravaArquivo.GravaPontos(sR2, p2);
                    plotComandos.plot(5);
                    grafico = new Graphic();
                    grafico.setVisible(true);

                    JOptionPane.showMessageDialog(null, "Distancia entre Ponto e Segmento de Reta é: " +
                            operacoes.distanciaPontoReta(p2, sR2));

                    break;

                //Área de um poligono
                case 3:
                    conjuntoPontos = carregaPontos();
                    if (conjuntoPontos.size() >= 3) {
                        JOptionPane.showMessageDialog(null, "Área do polígono: " + operacoes.areaPoligono(new Poligono(conjuntoPontos)) + " cm2");

                        GravaArquivo.GravaPontos(conjuntoPontos, true);
                        plotComandos.plot(9);
                        grafico = new Graphic();
                        grafico.setVisible(true);

                        conjuntoPontos.clear();
                    }
                    break;

                //Área de um círculo
                case 4:
                    JOptionPane.showMessageDialog(null, "Área do Círculo: " +
                            operacoes.areaCirculo(Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o Raio"))) + " cm2");
                    break;

                //Predicado convexidade de um polígono.
                case 5:
                    conjuntoPontos = carregaPontos();
                    Poligono p = new Poligono(conjuntoPontos);
                    if (operacoes.poligonoConvexo(p)) {
                        JOptionPane.showMessageDialog(null, "Pologono Convexo");
                        GravaArquivo.GravaPontos(p.getPol(), true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Pologono NÃO Convexo");
                        GravaArquivo.GravaPontos(p.getPol(), true);
                    }

                    plotComandos.plot(9);
                    grafico = new Graphic();
                    grafico.setVisible(true);

                    conjuntoPontos.clear();
                    break;
                //Dobrar polígonos em triângulos até um único triângulo..
                case 6:
                    break;

                //predicado Orientacao 2D
                case 7:

                    do {
                        st2 = new StringTokenizer(JOptionPane.showInputDialog(null, "Informe os três pontos 'x1,y1' : 'x2,y2' : 'x3,y3'"), ",: ");
                    } while (st2.countTokens() != 6);

                    ArrayList<Ponto> pts = new ArrayList<Ponto>();
                    pts.add(new Ponto(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken())));
                    pts.add(new Ponto(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken())));
                    pts.add(new Ponto(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken())));
                    JOptionPane.showMessageDialog(null, "O Ponto " + operacoes.predicadoOrientacao2D(pts.get(0), pts.get(1), pts.get(2)));

                    GravaArquivo.GravaPontos(pts);
                    plotComandos.plot(6);
                    grafico = new Graphic();
                    grafico.setVisible(true);
                    pts.clear();

                    break;
                // Predicado qual lado do círculo.
                case 8:
                    st1 = new StringTokenizer(JOptionPane.showInputDialog(null, "Informe Ponto   'x,y'"), ",");
                    Ponto p7 = new Ponto(Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken()));

                    do {
                        st2 = new StringTokenizer(JOptionPane.showInputDialog(null, "Informe os três pontos 'x1,y1' : 'x2,y2' : 'x3,y3'"), ",: ");
                    } while (st2.countTokens() != 6);

                    Ponto[] pts7 = new Ponto[3];
                    pts7[0] = new Ponto(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken()));
                    pts7[1] = new Ponto(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken()));
                    pts7[2] = new Ponto(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken()));

                    JOptionPane.showMessageDialog(null, operacoes.predicadoQualLadoCirculo(p7, pts7));
                    break;

                case 9:
                    do {
                        st2 = new StringTokenizer(JOptionPane.showInputDialog(null, "Informe os dois pontos do Segmento de Reta 'x1,y1' : 'x2,y2'"), ",: ");
                    } while (st2.countTokens() != 4);

                    SegmentoReta sR9 = new SegmentoReta(new Ponto(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken())),
                            new Ponto(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken())));
                    conjuntoPontos = carregaPontos();

                    Ponto p9 = operacoes.pontoMaisProximoSegmentoReta(conjuntoPontos, sR9);

                    JOptionPane.showMessageDialog(null, "O ponto mais proximo da reta é: (" +
                            p9.getX() + "," + p9.getY() + ") com a distância: " +
                            operacoes.distanciaPontoReta(p9, sR9));
                    GravaArquivo.GravaPontos(conjuntoPontos, p9, sR9);
                    plotComandos.plot(8);
                    grafico = new Graphic();
                    grafico.setVisible(true);
                    conjuntoPontos.clear();

                    break;

                //Interceção de reta
                case 10:
                    // Gera Segmento de Reta
                    do {
                        st1 = new StringTokenizer(JOptionPane.showInputDialog(null, "Informe os dois pontos do Segmento de Reta 1 'x1,y1' : 'x2,y2'"), ",: ");
                    } while (st1.countTokens() != 4);
                    SegmentoReta sr9_1 = new SegmentoReta(new Ponto(Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken())),
                            new Ponto(Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken())));

                    do {
                        st2 = new StringTokenizer(JOptionPane.showInputDialog(null, "Informe os dois pontos do Segmento de Reta 2 'x1,y1' : 'x2,y2'"), ",: ");
                    } while (st2.countTokens() != 4);

                    SegmentoReta sr9_2 = new SegmentoReta(new Ponto(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken())),
                            new Ponto(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken())));


                   JOptionPane.showMessageDialog(null, operacoes.intersecaoSegRetas(sr9_1, sr9_2)+"");


                    GravaArquivo.GravaPontos(sr9_1, sr9_2);

                    // Duas retas
                    plotComandos.plot(2);
                    grafico = new Graphic();
                    grafico.setVisible(true);

                    break;

                // Predicado ponto dentro do polígono.
                case 11:
                    st1 = new StringTokenizer(JOptionPane.showInputDialog(null, "Informe Ponto   'x,y'"), ",");
                    Ponto p11 = new Ponto(Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken()));

                    conjuntoPontos = carregaPontos();

                    JOptionPane.showMessageDialog(null, "" + operacoes.predicadoPontoDentroPoligono(p11, conjuntoPontos));

                    GravaArquivo.GravaPontos(conjuntoPontos, p11);

                    // poligono e ponto
                    plotComandos.plot(7);
                    grafico = new Graphic();
                    grafico.setVisible(true);


                    conjuntoPontos.clear();
                    break;

                //Problema do par mais próximo.
                case 12:

                    conjuntoPontos = carregaPontos();
                    Ponto[] pontos = new Ponto[conjuntoPontos.size()];
                    int aux = 0;
                    for (Ponto tp : conjuntoPontos) {
                        pontos[aux] = tp;
                        aux++;
                    }

                    Par par = operacoes.parMaisProximo(pontos);
                    System.out.println("Menor distancia = " + par.toString());
                    GravaArquivo.GravaPontos(conjuntoPontos, par);
                    plotComandos.plot(3);
                    grafico = new Graphic();
                    grafico.setVisible(true);

                    conjuntoPontos.clear();
                    break;

                //FEcho Convexo
                case 13:
                    conjuntoPontos = carregaPontos();
                    ArrayList<Ponto> fechoConvexo = algGraham.procuraFecho((ArrayList<Ponto>) conjuntoPontos.clone());
                    System.out.println("OS PONTOS DO FECHO CONVESO SÃO: ");
                    for (int i = 0; i < fechoConvexo.size(); i++)
                        System.out.print("(" + fechoConvexo.get(i).getX() + ", " + fechoConvexo.get(i).getY() + ")");

                    GravaArquivo.GravaPontos(conjuntoPontos, fechoConvexo);
                    plotComandos.plot(4);

                    grafico = new Graphic();
                    grafico.setVisible(true);

                    conjuntoPontos.clear();
                    break;
                case 14:
                    Voronoi diagram = new Voronoi (carregaPontos());

                    GravaArquivo.GravaPontosV(carregaPontos(),  diagram.getArestas());
                    plotComandos.plot(10);

                    grafico = new Graphic();
                    grafico.setVisible(true);


                    break;
                case 15:
                    int[] moedas = EstrategiasPA.gulosoProblemaTroco(Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o Valor Troco  0.00")));
                    int cont = 0;
                    for (int i = 0; i < moedas.length; i++) {
                        cont += moedas[i];
                    }

                    JOptionPane.showMessageDialog(null, "Quantidade de moeda: " + cont +
                            "\n$0,50: " + moedas[0] + "\n" +
                            "$0,25: " + moedas[1] + "\n" +
                            "$0,10: " + moedas[2] + "\n" +
                            "$0,05: " + moedas[3] + "\n" +
                            "$0,01: " + moedas[4] + "\n");
                    break;


                case 16:

                    ArrayList<Item> itens = new ArrayList<Item>();
                    itens.add(new Item(1, 1));
                    itens.add(new Item(2, 6));
                    itens.add(new Item(5, 18));
                    itens.add(new Item(6, 22));
                    itens.add(new Item(7, 28));
                    itens.add(new Item(9, 40));
                    itens.add(new Item(11, 60));


                    int matrix[][];
                    int capacidade = 23;

                    matrix = EstrategiasPA.proDinamica(itens, capacidade);

                    //Calcula e preenche a lista de itens da solução
                    int j = capacidade;
                    String itensSelec = "";
                    for (int i = itens.size(); i > 0; i--) {

                        if (matrix[i][j] != matrix[i - 1][j]) {
                            itensSelec += "Item: " + (i + 1) + " - Peso: " + itens.get(i - 1).getPeso() + " - Valor R$" + itens.get(i - 1).getValor() + "\n";
                            j -= itens.get(i - 1).getPeso();
                        }
                    }


                    JOptionPane.showMessageDialog(null, "Valor Máximo: " + matrix[itens.size()][capacidade] + "\n\n" + itensSelec);

                    break;

                case 20:
                    manipulaConjuntos(carregaPontos());
                    break;
                case -1:
                    grafico.dispose();
                    break;

            }


        } while (Integer.parseInt(op) != 0);

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


        printArray(operacoes.retornaVetorPontoOrdenado(conjuntoPontos, 'x'));
        printArray(operacoes.retornaVetorPontoOrdenado(conjuntoPontos, 'y'));


        System.out.close();
    }
}
