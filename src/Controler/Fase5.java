/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Fase5.java
 *
 * Created on 21/04/2015••••••••••••
 */
package Controler;

import JefsLoloModel.CaveiraVertical;
import JefsLoloModel.Tijolo;
import JefsLoloModel.VidasContador;
import JefsLoloModel.Bau;
import JefsLoloModel.Intransponivel;
import JefsLoloModel.CaixaVerde;
import JefsLoloModel.Portao;
import JefsLoloModel.Elemento;
import JefsLoloModel.LoloSingleton;
import JefsLoloModel.BauPerola;
import JefsLoloModel.Coracao;
import Auxiliar.Consts;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JeffGoes
 */
public class Fase5 extends javax.swing.JFrame implements MouseListener, KeyListener {

    private CaixaVerde cx1, cx4, cx5;
    private ArrayList<Elemento> e;
    private ControleDeJogo cj = new ControleDeJogo();
    CarregarSalvarJogo cg = new CarregarSalvarJogo();

    private boolean cora1 = false, cora2 = false, cora3 = false, cora4 = false, pegouperola = false,
            caixa1 = false, caixa4 = false, caixa5 = false;
    public int vidas;
    private boolean fantas1, fantas2;

    public Fase5(int vidas, int de_onde_vem, boolean cora1, boolean cora2, boolean cora3, boolean cora4, boolean pegouperola,
            boolean fantas1, boolean fantas2,
            boolean caixa1, int cx1_l, int cx1_c,
            boolean caixa4, int cx4_l, int cx4_c,
            boolean caixa5, int cx5_l, int cx5_c) {
        this.vidas = vidas;
        this.cora1 = cora1;
        this.cora2 = cora2;
        this.cora3 = cora3;
        this.cora4 = cora4;
        this.pegouperola = pegouperola;
        this.fantas1 = fantas1;
        this.fantas2 = fantas2;
        this.caixa1 = caixa1;
        this.caixa4 = caixa4;
        this.caixa5 = caixa5;

        initComponents();
        this.addMouseListener(this); /*mouse*/

        this.addKeyListener(this);   /*teclado*/
        /*Cria a janela do tamanho do tabuleiro + insets (bordas) da janela*/

        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right, Consts.RESCOMP * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);
        e = new ArrayList<Elemento>(100);

        /*Cria e adiciona elementos*/
        LoloSingleton.getInstance("lolo.png").setPosicao(11, 6);
        this.addElemento(LoloSingleton.getInstance("lolo.png"));

        if (de_onde_vem == 1) {
            Coracao coracao1 = new Coracao("coracao2.png");
            coracao1.setPosicao(2, 2);
            this.addElemento(coracao1);

            Coracao coracao2 = new Coracao("coracao2.png");
            coracao2.setPosicao(2, 9);
            this.addElemento(coracao2);

            Coracao coracao3 = new Coracao("coracao2.png");
            coracao3.setPosicao(11, 2);
            this.addElemento(coracao3);

            Coracao coracao4 = new Coracao("coracao2.png");
            coracao4.setPosicao(10, 9);
            this.addElemento(coracao4);

            CaveiraVertical fantasma1 = new CaveiraVertical("fantasma.png");
            fantasma1.setPosicao(6, 4);
            this.addElemento(fantasma1);
            CaveiraVertical fantasma2 = new CaveiraVertical("fantasma.png");
            fantasma2.setPosicao(6, 8);
            this.addElemento(fantasma2);

            cx1 = new CaixaVerde("caixinhaverde.png");
            cx1.setPosicao(1, 8);
            this.addElemento(cx1);

            cx4 = new CaixaVerde("caixinhaverde.png");
            cx4.setPosicao(9, 10);
            this.addElemento(cx4);

            cx5 = new CaixaVerde("caixinhaverde.png");
            cx5.setPosicao(10, 4);
            this.addElemento(cx5);
        } else {
            if (cora1 == false) {
                Coracao coracao1 = new Coracao("coracao2.png");
                coracao1.setPosicao(2, 2);
                this.addElemento(coracao1);
            }

            if (cora2 == false) {
                Coracao coracao2 = new Coracao("coracao2.png");
                coracao2.setPosicao(2, 9);
                this.addElemento(coracao2);
            }

            if (cora3 == false) {
                Coracao coracao3 = new Coracao("coracao2.png");
                coracao3.setPosicao(11, 2);
                this.addElemento(coracao3);
            }

            if (cora4 == false) {
                Coracao coracao4 = new Coracao("coracao2.png");
                coracao4.setPosicao(10, 9);
                this.addElemento(coracao4);
            }

            if (fantas1 == false) {
                CaveiraVertical fantasma1 = new CaveiraVertical("fantasma.png");
                fantasma1.setPosicao(6, 4);
                this.addElemento(fantasma1);
            }

            if (fantas2 == false) {
                CaveiraVertical fantasma2 = new CaveiraVertical("fantasma.png");
                fantasma2.setPosicao(6, 8);
                this.addElemento(fantasma2);
            }

            if (caixa1 == false) {
                cx1 = new CaixaVerde("caixinhaverde.png");
                cx1.setPosicao(1, 8);
                this.addElemento(cx1);
            } else {
                cx1 = new CaixaVerde("caixinhaverde.png");
                cx1.setPosicao(cx1_l, cx1_c);
                this.addElemento(cx1);
            }

            if (caixa4 == false) {
                cx4 = new CaixaVerde("caixinhaverde.png");
                cx4.setPosicao(9, 10);
                this.addElemento(cx4);
            } else {
                cx4 = new CaixaVerde("caixinhaverde.png");
                cx4.setPosicao(cx4_l, cx4_c);
                this.addElemento(cx4);
            }

            if (caixa5 == false) {
                cx5 = new CaixaVerde("caixinhaverde.png");
                cx5.setPosicao(10, 4);
                this.addElemento(cx5);
            } else {
                cx5 = new CaixaVerde("caixinhaverde.png");
                cx5.setPosicao(cx5_l, cx5_c);
                this.addElemento(cx5);
            }
        }
        switch (this.vidas) {
            case 5:
                VidasContador vc5 = new VidasContador("num5.png");
                vc5.setPosicao(3, 13);
                this.addElemento(vc5);
                break;
            case 4:
                VidasContador vc4 = new VidasContador("num4.png");
                vc4.setPosicao(3, 13);
                this.addElemento(vc4);
                break;
            case 3:
                VidasContador vc3 = new VidasContador("num3.png");
                vc3.setPosicao(3, 13);
                this.addElemento(vc3);
                break;
            case 2:
                VidasContador vc2 = new VidasContador("num2.png");
                vc2.setPosicao(3, 13);
                this.addElemento(vc2);
                break;
            case 1:
                VidasContador vc1 = new VidasContador("num1.png");
                vc1.setPosicao(3, 13);
                this.addElemento(vc1);
                break;

        }

        Intransponivel salvarjogo = new Intransponivel("SALVAR.png");
        salvarjogo.setPosicao(5, 13);
        this.addElemento(salvarjogo);

        Intransponivel S = new Intransponivel("S.png");
        S.setPosicao(6, 13);
        this.addElemento(S);

        Intransponivel pedra1 = new Intransponivel("pedra.png");
        pedra1.setPosicao(1, 1);
        this.addElemento(pedra1);
        Intransponivel pedra2 = new Intransponivel("pedra.png");
        pedra2.setPosicao(1, 2);
        this.addElemento(pedra2);
        Intransponivel pedra3 = new Intransponivel("pedra.png");
        pedra3.setPosicao(1, 3);
        this.addElemento(pedra3);
        Intransponivel pedra4 = new Intransponivel("pedra.png");
        pedra4.setPosicao(1, 4);
        this.addElemento(pedra4);
        Intransponivel pedra5 = new Intransponivel("pedra.png");
        pedra5.setPosicao(1, 11);
        this.addElemento(pedra5);
        Intransponivel pedra6 = new Intransponivel("pedra.png");
        pedra6.setPosicao(3, 1);
        this.addElemento(pedra6);
        Intransponivel pedra7 = new Intransponivel("pedra.png");
        pedra7.setPosicao(3, 2);
        this.addElemento(pedra7);
        Intransponivel pedra8 = new Intransponivel("pedra.png");
        pedra8.setPosicao(3, 4);
        this.addElemento(pedra8);
        Intransponivel pedra9 = new Intransponivel("pedra.png");
        pedra9.setPosicao(3, 8);
        this.addElemento(pedra9);
        Intransponivel pedra10 = new Intransponivel("pedra.png");
        pedra10.setPosicao(3, 9);
        this.addElemento(pedra10);
        Intransponivel pedra11 = new Intransponivel("pedra.png");
        pedra11.setPosicao(3, 10);
        this.addElemento(pedra11);
        Intransponivel pedra12 = new Intransponivel("pedra.png");
        pedra12.setPosicao(3, 11);
        this.addElemento(pedra12);
        Intransponivel pedra13 = new Intransponivel("pedra.png");
        pedra13.setPosicao(8, 1);
        this.addElemento(pedra13);
        Intransponivel pedra14 = new Intransponivel("pedra.png");
        pedra14.setPosicao(8, 3);
        this.addElemento(pedra14);
        Intransponivel pedra15 = new Intransponivel("pedra.png");
        pedra15.setPosicao(9, 1);
        this.addElemento(pedra15);
        Intransponivel pedra16 = new Intransponivel("pedra.png");
        pedra16.setPosicao(9, 3);
        this.addElemento(pedra16);
        Intransponivel pedra17 = new Intransponivel("pedra.png");
        pedra17.setPosicao(9, 4);
        this.addElemento(pedra17);
        Intransponivel pedra18 = new Intransponivel("pedra.png");
        pedra18.setPosicao(9, 8);
        this.addElemento(pedra18);
        Intransponivel pedra19 = new Intransponivel("pedra.png");
        pedra19.setPosicao(9, 9);
        this.addElemento(pedra19);
        Intransponivel pedra20 = new Intransponivel("pedra.png");
        pedra20.setPosicao(9, 11);
        this.addElemento(pedra20);
        Intransponivel pedra21 = new Intransponivel("pedra.png");
        pedra21.setPosicao(10, 8);
        this.addElemento(pedra21);
        Intransponivel pedra22 = new Intransponivel("pedra.png");
        pedra22.setPosicao(10, 11);
        this.addElemento(pedra22);
        Intransponivel pedra23 = new Intransponivel("pedra.png");
        pedra23.setPosicao(11, 1);
        this.addElemento(pedra23);
        Intransponivel pedra24 = new Intransponivel("pedra.png");
        pedra24.setPosicao(11, 3);
        this.addElemento(pedra24);
        Intransponivel pedra25 = new Intransponivel("pedra.png");
        pedra25.setPosicao(11, 4);
        this.addElemento(pedra25);
        Intransponivel pedra26 = new Intransponivel("pedra.png");
        pedra26.setPosicao(11, 8);
        this.addElemento(pedra26);
        Intransponivel pedra27 = new Intransponivel("pedra.png");
        pedra27.setPosicao(11, 9);
        this.addElemento(pedra27);
        Intransponivel pedra28 = new Intransponivel("pedra.png");
        pedra28.setPosicao(11, 11);
        this.addElemento(pedra28);
        Intransponivel pedra29 = new Intransponivel("pedra.png");
        pedra29.setPosicao(2, 1);
        this.addElemento(pedra29);
        Intransponivel pedra30 = new Intransponivel("pedra.png");
        pedra30.setPosicao(2, 8);
        this.addElemento(pedra30);
        Intransponivel pedra31 = new Intransponivel("pedra.png");
        pedra31.setPosicao(2, 10);
        this.addElemento(pedra31);
        Intransponivel pedra32 = new Intransponivel("pedra.png");
        pedra32.setPosicao(2, 11);
        this.addElemento(pedra32);
        Intransponivel pedra33 = new Intransponivel("pedra.png");
        pedra33.setPosicao(4, 9);
        this.addElemento(pedra33);
        Intransponivel pedra34 = new Intransponivel("pedra.png");
        pedra34.setPosicao(4, 10);
        this.addElemento(pedra34);
        Intransponivel pedra35 = new Intransponivel("pedra.png");
        pedra35.setPosicao(4, 11);
        this.addElemento(pedra35);

        Tijolo tj01 = new Tijolo("tijolos1.png");
        tj01.setPosicao(1, 12);
        this.addElemento(tj01);
        Tijolo tj02 = new Tijolo("tijolos1.png");
        tj02.setPosicao(2, 12);
        this.addElemento(tj02);
        Tijolo tj03 = new Tijolo("tijolos1.png");
        tj03.setPosicao(3, 12);
        this.addElemento(tj03);
        Tijolo tj04 = new Tijolo("tijolos1.png");
        tj04.setPosicao(4, 12);
        this.addElemento(tj04);
        Tijolo tj05 = new Tijolo("tijolos1.png");
        tj05.setPosicao(5, 12);
        this.addElemento(tj05);
        Tijolo tj06 = new Tijolo("tijolos1.png");
        tj06.setPosicao(6, 12);
        this.addElemento(tj06);
        Tijolo tj07 = new Tijolo("tijolos1.png");
        tj07.setPosicao(7, 12);
        this.addElemento(tj07);
        Tijolo tj08 = new Tijolo("tijolos1.png");
        tj08.setPosicao(8, 12);
        this.addElemento(tj08);
        Tijolo tj09 = new Tijolo("tijolos1.png");
        tj09.setPosicao(9, 12);
        this.addElemento(tj09);
        Tijolo tj10 = new Tijolo("tijolos1.png");
        tj10.setPosicao(10, 12);
        this.addElemento(tj10);
        Tijolo tj11 = new Tijolo("tijolos1.png");
        tj11.setPosicao(11, 12);
        this.addElemento(tj11);

        Tijolo tj12 = new Tijolo("tijolos2.png");
        tj12.setPosicao(1, 0);
        this.addElemento(tj12);
        Tijolo tj13 = new Tijolo("tijolos2.png");
        tj13.setPosicao(2, 0);
        this.addElemento(tj13);
        Tijolo tj14 = new Tijolo("tijolos2.png");
        tj14.setPosicao(3, 0);
        this.addElemento(tj14);
        Tijolo tj15 = new Tijolo("tijolos2.png");
        tj15.setPosicao(4, 0);
        this.addElemento(tj15);
        Tijolo tj16 = new Tijolo("tijolos2.png");
        tj16.setPosicao(5, 0);
        this.addElemento(tj16);
        Tijolo tj17 = new Tijolo("tijolos2.png");
        tj17.setPosicao(6, 0);
        this.addElemento(tj17);
        Tijolo tj18 = new Tijolo("tijolos2.png");
        tj18.setPosicao(7, 0);
        this.addElemento(tj18);
        Tijolo tj19 = new Tijolo("tijolos2.png");
        tj19.setPosicao(8, 0);
        this.addElemento(tj19);
        Tijolo tj20 = new Tijolo("tijolos2.png");
        tj20.setPosicao(9, 0);
        this.addElemento(tj20);
        Tijolo tj21 = new Tijolo("tijolos2.png");
        tj21.setPosicao(10, 0);
        this.addElemento(tj21);
        Tijolo tj22 = new Tijolo("tijolos2.png");
        tj22.setPosicao(11, 0);
        this.addElemento(tj22);

        Tijolo tj23 = new Tijolo("tijolos3.png");
        tj23.setPosicao(0, 1);
        this.addElemento(tj23);
        Tijolo tj24 = new Tijolo("tijolos3.png");
        tj24.setPosicao(0, 2);
        this.addElemento(tj24);
        Tijolo tj25 = new Tijolo("tijolos3.png");
        tj25.setPosicao(0, 3);
        this.addElemento(tj25);
        Tijolo tj26 = new Tijolo("tijolos3.png");
        tj26.setPosicao(0, 4);
        this.addElemento(tj26);
        Tijolo tj27 = new Tijolo("tijolos3.png");
        tj27.setPosicao(0, 5);
        this.addElemento(tj27);
        Tijolo tj28 = new Tijolo("tijolos3.png");
        tj28.setPosicao(0, 6);
        this.addElemento(tj28);
        Tijolo tj29 = new Tijolo("tijolos3.png");
        tj29.setPosicao(0, 7);
        this.addElemento(tj29);
        Tijolo tj30 = new Tijolo("tijolos3.png");
        tj30.setPosicao(0, 8);
        this.addElemento(tj30);
        Tijolo tj31 = new Tijolo("tijolos3.png");
        tj31.setPosicao(0, 9);
        this.addElemento(tj31);
        Tijolo tj32 = new Tijolo("tijolos3.png");
        tj32.setPosicao(0, 10);
        this.addElemento(tj32);
        Tijolo tj33 = new Tijolo("tijolos3.png");
        tj33.setPosicao(0, 11);
        this.addElemento(tj33);

        Tijolo tj34 = new Tijolo("tijolos4.png");
        tj34.setPosicao(12, 1);
        this.addElemento(tj34);
        Tijolo tj35 = new Tijolo("tijolos4.png");
        tj35.setPosicao(12, 2);
        this.addElemento(tj35);
        Tijolo tj36 = new Tijolo("tijolos4.png");
        tj36.setPosicao(12, 3);
        this.addElemento(tj36);
        Tijolo tj37 = new Tijolo("tijolos4.png");
        tj37.setPosicao(12, 4);
        this.addElemento(tj37);
        Tijolo tj38 = new Tijolo("tijolos4.png");
        tj38.setPosicao(12, 5);
        this.addElemento(tj38);
        Tijolo tj39 = new Tijolo("tijolos4.png");
        tj39.setPosicao(12, 6);
        this.addElemento(tj39);
        Tijolo tj40 = new Tijolo("tijolos4.png");
        tj40.setPosicao(12, 7);
        this.addElemento(tj40);
        Tijolo tj41 = new Tijolo("tijolos4.png");
        tj41.setPosicao(12, 8);
        this.addElemento(tj41);
        Tijolo tj42 = new Tijolo("tijolos4.png");
        tj42.setPosicao(12, 9);
        this.addElemento(tj42);
        Tijolo tj43 = new Tijolo("tijolos4.png");
        tj43.setPosicao(12, 10);
        this.addElemento(tj43);
        Tijolo tj44 = new Tijolo("tijolos4.png");
        tj44.setPosicao(12, 11);
        this.addElemento(tj44);

        Tijolo tj45 = new Tijolo("tijolos7.png");
        tj45.setPosicao(0, 0);
        this.addElemento(tj45);
        Tijolo tj46 = new Tijolo("tijolos6.png");
        tj46.setPosicao(12, 0);
        this.addElemento(tj46);
        Tijolo tj47 = new Tijolo("tijolos8.png");
        tj47.setPosicao(12, 12);
        this.addElemento(tj47);
        Tijolo tj48 = new Tijolo("tijolos5.png");
        tj48.setPosicao(0, 12);
        this.addElemento(tj48);
    }

    public void addElemento(Elemento umElemento) {
        e.add(umElemento);
    }

    public void removeElemento(Elemento umElemento) {
        e.remove(umElemento);
    }

    public void paint(Graphics gOld) {
        Graphics g = getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        Graphics g2 = g.create(getInsets().right, getInsets().top, getWidth() - getInsets().left, getHeight() - getInsets().bottom);

        try {
            for (int i = 0; i < Consts.RES; i++) {
                for (int j = 0; j < Consts.RESCOMP; j++) {
                    Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "bricks.png");
                    g2.drawImage(newImage,
                            j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                }
            }
            for (int i = 0; i < Consts.RES; i++) { //para imagem preta de fundo do lado
                Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "preto.png");
                g2.drawImage(newImage, 13 * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
            }

            //para imagem do lolo, representando sua vida
            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "lolo.png");
            g2.drawImage(newImage, 13 * Consts.CELL_SIDE, 2 * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

            CaixaVerde caixinhaVerde2 = new CaixaVerde("caixinhaverde.png");
            caixinhaVerde2.setPosicao(2, 4);
            this.addElemento(caixinhaVerde2);

            CaixaVerde caixinhaVerde3 = new CaixaVerde("caixinhaverde.png");
            caixinhaVerde3.setPosicao(8, 2);
            this.addElemento(caixinhaVerde3);

            Bau bau = new Bau("baufechado.png");
            bau.setPosicao(6, 6);
            this.addElemento(bau);

            Portao pt = new Portao("porta.png");
            pt.setPosicao(0, 6);
            this.addElemento(pt);

            if (this.cora1 == true && this.cora2 == true && this.cora3 == true && this.cora4 == true) {
                BauPerola perola = new BauPerola("baucomperola.png");
                perola.setPosicao(6, 6);
                this.addElemento(perola);
            }
            if (pegouperola == true) {
                BauPerola bauvazio = new BauPerola("bauvazio.png");
                bauvazio.setPosicao(6, 6);
                this.addElemento(bauvazio);

                Portao pt1 = new Portao("portaaberta.png");
                pt1.setPosicao(0, 6);
                this.addElemento(pt1);
            }

        } catch (IOException ex) {
            Logger.getLogger(Fase1.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.cj.desenhaTudo(e, g2);

        this.cj.processaTudo(e);

        g.dispose();

        g2.dispose();

        if (!getBufferStrategy()
                .contentsLost()) {
            getBufferStrategy().show();
        }
    }

    public void go() {
        TimerTask task = new TimerTask() {

            public void run() {
                repaint();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, Consts.DELAY);
    }

    public void auto_save() {
        TimerTask task = new TimerTask() {

            public void run() {
                cg.salvar_fase5(vidas, 5, cora1, cora2, cora3, cora4, pegouperola, fantas1, fantas2,
                        caixa1, cx1.getPosicao().getLinha(), cx1.getPosicao().getColuna(),
                        caixa4, cx4.getPosicao().getLinha(), cx4.getPosicao().getColuna(),
                        caixa5, cx5.getPosicao().getLinha(), cx5.getPosicao().getColuna());
            }

        };

        Timer timer = new Timer();
        timer.schedule(task, 0, Consts.SEGUNDOS_SAVE * 1000);

    }

    public void loloMorreu() {
        this.vidas--;
        if (0 < this.vidas) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    sair();
                    Fase5 tTela = new Fase5(vidas, 1, false, false, false, false, false, false, false, false, 0, 0, false, 0, 0, false, 0, 0);
                    tTela.setVisible(true);
                    tTela.createBufferStrategy(2);
                    tTela.go();
                    tTela.auto_save();
                }
            });
        } else {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    sair();
                }
            });
        }
    }

    public void sair() {
        this.dispose();
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_S) {

            cg.salvar_fase5(vidas, 5, cora1, cora2, cora3, cora4, pegouperola, fantas1, fantas2,
                    caixa1, cx1.getPosicao().getLinha(), cx1.getPosicao().getColuna(),
                    caixa4, cx4.getPosicao().getLinha(), cx4.getPosicao().getColuna(),
                    caixa5, cx5.getPosicao().getLinha(), cx5.getPosicao().getColuna());
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            LoloSingleton.getInstance("lolo.png").moveUp();

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 10 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 8 && caixa4 == false) {
                this.removeElemento(cx4);
                cx4.setPosicao(10, 10);
                this.addElemento(cx4);
            }
            if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 10 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 9 && caixa4 == false) {
                caixa4 = true;
                this.removeElemento(cx4);
                cx4.setPosicao(11, 10);
                this.addElemento(cx4);
            }
            LoloSingleton.getInstance("lolo.png").moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 5 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 10 && caixa5 == false) {
                this.removeElemento(cx5);
                cx5.setPosicao(10, 3);
                this.addElemento(cx5);
            }
            if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 4 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 10 && caixa5 == false) {
                this.removeElemento(cx5);
                cx5.setPosicao(10, 2);
                this.addElemento(cx5);
            }
            if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 3 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 10 && caixa5 == false) {
                caixa5 = true;
                this.removeElemento(cx5);
                cx5.setPosicao(10, 1);
                this.addElemento(cx5);
            }

            LoloSingleton.getInstance("lolo.png").moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 7 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 1 && caixa1 == false) {
                this.removeElemento(cx1);
                cx1.setPosicao(1, 9);
                this.addElemento(cx1);
            }
            if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 8 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 1 && caixa1 == false) {
                caixa1 = true;
                this.removeElemento(cx1);
                cx1.setPosicao(1, 10);
                this.addElemento(cx1);
            }
            LoloSingleton.getInstance("lolo.png").moveRight();
        }
        if (!cj.ehPosicaoValida(this.e, LoloSingleton.getInstance("lolo.png").getPosicao())) {
            LoloSingleton.getInstance("lolo.png").voltaAUltimaPosicao();
        }

        this.setTitle("-> Cell: " + (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna()) + ", "
                + (LoloSingleton.getInstance("lolo.png").getPosicao().getLinha()));

        if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 4 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 6) {
            if (fantas1 == false) {
                fantas1 = true;
            }
        }
        if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 8 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 6) {
            if (fantas2 == false) {
                fantas2 = true;
            }
        }

        if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 2 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 2) {
            if (cora1 == false) {
                cora1 = true;
            }
        }
        if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 9 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 2) {
            if (cora2 == false) {
                cora2 = true;
            }
        }
        if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 2 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 11) {
            if (cora3 == false) {
                cora3 = true;
            }
        }
        if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 9 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 10) {
            if (cora4 == false) {
                cora4 = true;
            }
        }
        if (this.cora1 == true && this.cora2 == true && this.cora3 == true && this.cora4 == true) {
            repaint();
            if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 6 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 6) {
                if (pegouperola == false) {
                    pegouperola = true;
                }
            }
        }
        if (pegouperola == true) {
            Portao pt1 = new Portao("portaaberta");
            pt1.setPosicao(0, 6);
            this.addElemento(pt1);
            if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 6 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 1) {
                fim();
            }
        }

        //repaint(); /*invoca o paint imediatamente, sem aguardar o refresh*/
    }

    public void mousePressed(MouseEvent e) {
        /* Clique do mouse desligado
         int x = e.getX();
         int y = e.getY();
     
         this.setTitle("X: "+ x + ", Y: " + y +
         " -> Cell: " + (y/Consts.CELL_SIDE) + ", " + (x/Consts.CELL_SIDE));
        
         this.lLolo.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);
         */
        repaint();
    }

    public void fim() {

        Tijolo tj01 = new Tijolo("tijolos1.png");
        tj01.setPosicao(5, 8);
        this.addElemento(tj01);
        Tijolo tj02 = new Tijolo("tijolos1.png");
        tj02.setPosicao(6, 8);
        this.addElemento(tj02);

        Tijolo tj12 = new Tijolo("tijolos2.png");
        tj12.setPosicao(5, 4);
        this.addElemento(tj12);
        Tijolo tj13 = new Tijolo("tijolos2.png");
        tj13.setPosicao(6, 4);
        this.addElemento(tj13);

        Tijolo tj23 = new Tijolo("tijolos3.png");
        tj23.setPosicao(4, 5);
        this.addElemento(tj23);
        Tijolo tj24 = new Tijolo("tijolos3.png");
        tj24.setPosicao(4, 6);
        this.addElemento(tj24);
        Tijolo tj25 = new Tijolo("tijolos3.png");
        tj25.setPosicao(4, 7);
        this.addElemento(tj25);
        Tijolo tj26 = new Tijolo("tijolos3.png");

        Tijolo tj34 = new Tijolo("tijolos4.png");
        tj34.setPosicao(7, 5);
        this.addElemento(tj34);
        Tijolo tj35 = new Tijolo("tijolos4.png");
        tj35.setPosicao(7, 6);
        this.addElemento(tj35);
        Tijolo tj36 = new Tijolo("tijolos4.png");
        tj36.setPosicao(7, 7);
        this.addElemento(tj36);

        Tijolo tj45 = new Tijolo("tijolos7.png");
        tj45.setPosicao(4, 4);
        this.addElemento(tj45);
        Tijolo tj46 = new Tijolo("tijolos6.png");
        tj46.setPosicao(7, 4);
        this.addElemento(tj46);
        Tijolo tj47 = new Tijolo("tijolos8.png");
        tj47.setPosicao(7, 8);
        this.addElemento(tj47);
        Tijolo tj48 = new Tijolo("tijolos5.png");
        tj48.setPosicao(4, 8);
        this.addElemento(tj48);

        Tijolo tj60 = new Tijolo("fimF.png");
        tj60.setPosicao(5, 5);
        this.addElemento(tj60);
        Tijolo tj61 = new Tijolo("fimI.png");
        tj61.setPosicao(5, 6);
        this.addElemento(tj61);
        Tijolo tj62 = new Tijolo("fimM.png");
        tj62.setPosicao(5, 7);
        this.addElemento(tj62);

        Tijolo tj71 = new Tijolo("fundofim.png");
        tj71.setPosicao(6, 5);
        this.addElemento(tj71);
        Tijolo tj72 = new Tijolo("fundofim.png");
        tj72.setPosicao(6, 7);
        this.addElemento(tj72);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2015-1 - Adventures of lolo");
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
