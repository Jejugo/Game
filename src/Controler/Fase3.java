/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Fase2.java
 *
 * Created on 21/04/2015••••••••••••
 */
package Controler;

import JefsLoloModel.CaveiraVertical;
import JefsLoloModel.Tijolo;
import JefsLoloModel.VidasContador;
import JefsLoloModel.Bau;
import JefsLoloModel.Intransponivel;
import JefsLoloModel.Portao;
import JefsLoloModel.Elemento;
import JefsLoloModel.LoloSingleton;
import JefsLoloModel.BichinhoVaiVemHorizontal;
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
public class Fase3 extends javax.swing.JFrame implements MouseListener, KeyListener {

    private ArrayList<Elemento> e;
    private ControleDeJogo cj = new ControleDeJogo();
    CarregarSalvarJogo cg = new CarregarSalvarJogo();
    public int contador = 0;
    public boolean cora1 = false, cora2 = false, cora3 = false, cora4 = false, cora5 = false, pegouperola = false;
    public boolean pegoubichovaivemhorizontal1 = false;
    boolean pegoucaveira2 = false;
    public int vidas;

    public Fase3(int vidas, int de_onde_vem, boolean cora1, boolean cora2, boolean cora3, boolean cora4, boolean cora5, boolean pegouperola, boolean pegoubichovaivemhorizontal1, boolean pegoucaveira2) {
        this.vidas = vidas;
        this.cora1 = cora1;
        this.cora2 = cora2;
        this.cora3 = cora3;
        this.cora4 = cora4;
        this.cora5 = cora5;
        this.pegouperola = pegouperola;
        this.pegoubichovaivemhorizontal1 = pegoubichovaivemhorizontal1;
        this.pegoucaveira2 = pegoucaveira2;
        initComponents();
        this.addMouseListener(this); /*mouse*/

        this.addKeyListener(this);   /*teclado*/
        /*Cria a janela do tamanho do tabuleiro + insets (bordas) da janela*/

        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right, Consts.RESCOMP * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);
        e = new ArrayList<Elemento>(100);

        /*Cria e adiciona elementos*/
        LoloSingleton.getInstance("lolo.png").setPosicao(11, 4);
        this.addElemento(LoloSingleton.getInstance("lolo.png"));

        if (de_onde_vem == 1) {
            Coracao coracao1 = new Coracao("coracao2.png");
            coracao1.setPosicao(3, 7);
            this.addElemento(coracao1);

            Coracao coracao2 = new Coracao("coracao2.png");
            coracao2.setPosicao(7, 5);
            this.addElemento(coracao2);

            Coracao coracao3 = new Coracao("coracao2.png");
            coracao3.setPosicao(7, 7);
            this.addElemento(coracao3);

            Coracao coracao4 = new Coracao("coracao2.png");
            coracao4.setPosicao(10, 11);
            this.addElemento(coracao4);

            Coracao coracao5 = new Coracao("coracao2.png");
            coracao5.setPosicao(11, 8);
            this.addElemento(coracao5);

            BichinhoVaiVemHorizontal bBichinhoH = new BichinhoVaiVemHorizontal("bichinho.png");
            bBichinhoH.setPosicao(5, 6);
            this.addElemento(bBichinhoH);

            CaveiraVertical caveira2 = new CaveiraVertical("monstroverde.png");
            caveira2.setPosicao(9, 1);
            this.addElemento(caveira2);
        } else {
            if (cora1 == false) {
                Coracao coracao1 = new Coracao("coracao2.png");
                coracao1.setPosicao(3, 7);
                this.addElemento(coracao1);
            }

            if (cora2 == false) {
                Coracao coracao2 = new Coracao("coracao2.png");
                coracao2.setPosicao(7, 5);
                this.addElemento(coracao2);
            }

            if (cora3 == false) {
                Coracao coracao3 = new Coracao("coracao2.png");
                coracao3.setPosicao(7, 7);
                this.addElemento(coracao3);
            }

            if (cora4 == false) {
                Coracao coracao4 = new Coracao("coracao2.png");
                coracao4.setPosicao(10, 11);
                this.addElemento(coracao4);
            }

            if (cora5 == false) {
                Coracao coracao5 = new Coracao("coracao2.png");
                coracao5.setPosicao(11, 8);
                this.addElemento(coracao5);
            }

            if (pegoubichovaivemhorizontal1 == false) {
                BichinhoVaiVemHorizontal bBichinhoH = new BichinhoVaiVemHorizontal("bichinho.png");
                bBichinhoH.setPosicao(5, 6);
                this.addElemento(bBichinhoH);
            }

            if (pegoucaveira2 == false) {
                CaveiraVertical caveira2 = new CaveiraVertical("monstroverde.png");
                caveira2.setPosicao(9, 1);
                this.addElemento(caveira2);
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
        pedra1.setPosicao(6, 4);
        this.addElemento(pedra1);
        Intransponivel pedra2 = new Intransponivel("pedra.png");
        pedra2.setPosicao(6, 6);
        this.addElemento(pedra2);
        Intransponivel pedra3 = new Intransponivel("pedra.png");
        pedra3.setPosicao(7, 4);
        this.addElemento(pedra3);
        Intransponivel pedra4 = new Intransponivel("pedra.png");
        pedra4.setPosicao(7, 6);
        this.addElemento(pedra4);
        Intransponivel pedra5 = new Intransponivel("pedra.png");
        pedra5.setPosicao(8, 4);
        this.addElemento(pedra5);
        Intransponivel pedra6 = new Intransponivel("pedra.png");
        pedra6.setPosicao(8, 6);
        this.addElemento(pedra6);

        Intransponivel arv01 = new Intransponivel("arvore2.png");
        arv01.setPosicao(2, 3);
        this.addElemento(arv01);
        Intransponivel arv02 = new Intransponivel("arvore2.png");
        arv02.setPosicao(2, 4);
        this.addElemento(arv02);
        Intransponivel arv03 = new Intransponivel("arvore2.png");
        arv03.setPosicao(2, 5);
        this.addElemento(arv03);
        Intransponivel arv04 = new Intransponivel("arvore2.png");
        arv04.setPosicao(2, 6);
        this.addElemento(arv04);
        Intransponivel arv05 = new Intransponivel("arvore2.png");
        arv05.setPosicao(3, 3);
        this.addElemento(arv05);
        Intransponivel arv06 = new Intransponivel("arvore2.png");
        arv06.setPosicao(3, 4);
        this.addElemento(arv06);
        Intransponivel arv07 = new Intransponivel("arvore2.png");
        arv07.setPosicao(3, 5);
        this.addElemento(arv07);
        Intransponivel arv08 = new Intransponivel("arvore2.png");
        arv08.setPosicao(3, 6);
        this.addElemento(arv08);
        Intransponivel arv09 = new Intransponivel("arvore2.png");
        arv09.setPosicao(5, 4);
        this.addElemento(arv09);
        Intransponivel arv10 = new Intransponivel("arvore2.png");
        arv10.setPosicao(5, 8);
        this.addElemento(arv10);
        Intransponivel arv11 = new Intransponivel("arvore2.png");
        arv11.setPosicao(6, 8);
        this.addElemento(arv11);
        Intransponivel arv12 = new Intransponivel("arvore2.png");
        arv12.setPosicao(8, 7);
        this.addElemento(arv12);
        Intransponivel arv13 = new Intransponivel("arvore2.png");
        arv13.setPosicao(9, 4);
        this.addElemento(arv13);
        Intransponivel arv14 = new Intransponivel("arvore2.png");
        arv14.setPosicao(11, 11);
        this.addElemento(arv14);

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

        Intransponivel agua1 = new Intransponivel("agua.png");
        agua1.setPosicao(2, 8);
        this.addElemento(agua1);
        Intransponivel agua2 = new Intransponivel("agua.png");
        agua2.setPosicao(2, 9);
        this.addElemento(agua2);
        Intransponivel agua3 = new Intransponivel("agua.png");
        agua3.setPosicao(2, 10);
        this.addElemento(agua3);
        Intransponivel agua4 = new Intransponivel("agua.png");
        agua4.setPosicao(3, 2);
        this.addElemento(agua4);
        Intransponivel agua5 = new Intransponivel("agua.png");
        agua5.setPosicao(3, 8);
        this.addElemento(agua5);
        Intransponivel agua6 = new Intransponivel("agua.png");
        agua6.setPosicao(3, 9);
        this.addElemento(agua6);
        Intransponivel agua7 = new Intransponivel("agua.png");
        agua7.setPosicao(3, 10);
        this.addElemento(agua7);
        Intransponivel agua8 = new Intransponivel("agua.png");
        agua8.setPosicao(4, 2);
        this.addElemento(agua8);
        Intransponivel agua9 = new Intransponivel("agua.png");
        agua9.setPosicao(4, 3);
        this.addElemento(agua9);
        Intransponivel agua10 = new Intransponivel("agua.png");
        agua10.setPosicao(4, 4);
        this.addElemento(agua10);
        Intransponivel agua11 = new Intransponivel("agua.png");
        agua11.setPosicao(4, 5);
        this.addElemento(agua11);
        Intransponivel agua12 = new Intransponivel("agua.png");
        agua12.setPosicao(4, 6);
        this.addElemento(agua12);
        Intransponivel agua13 = new Intransponivel("agua.png");
        agua13.setPosicao(4, 7);
        this.addElemento(agua13);
        Intransponivel agua14 = new Intransponivel("agua.png");
        agua14.setPosicao(4, 8);
        this.addElemento(agua14);
        Intransponivel agua15 = new Intransponivel("agua.png");
        agua15.setPosicao(4, 9);
        this.addElemento(agua15);
        Intransponivel agua16 = new Intransponivel("agua.png");
        agua16.setPosicao(4, 10);
        this.addElemento(agua16);
        Intransponivel agua17 = new Intransponivel("agua.png");
        agua17.setPosicao(5, 2);
        this.addElemento(agua17);
//            Intransponivel agua18 = new Intransponivel("agua.png");
//            agua18.setPosicao(6, 2);
//            this.addElemento(agua18);
        Intransponivel agua19 = new Intransponivel("agua.png");
        agua19.setPosicao(7, 2);
        this.addElemento(agua19);
        Intransponivel agua20 = new Intransponivel("agua.png");
        agua20.setPosicao(8, 2);
        this.addElemento(agua20);
        Intransponivel agua21 = new Intransponivel("agua.png");
        agua21.setPosicao(9, 2);
        this.addElemento(agua21);
        Intransponivel agua22 = new Intransponivel("agua.png");
        agua22.setPosicao(8, 8);
        this.addElemento(agua22);
        Intransponivel agua23 = new Intransponivel("agua.png");
        agua23.setPosicao(8, 9);
        this.addElemento(agua23);
        Intransponivel agua24 = new Intransponivel("agua.png");
        agua24.setPosicao(8, 10);
        this.addElemento(agua24);
        Intransponivel agua25 = new Intransponivel("agua.png");
        agua25.setPosicao(9, 8);
        this.addElemento(agua25);
        Intransponivel agua26 = new Intransponivel("agua.png");
        agua26.setPosicao(9, 9);
        this.addElemento(agua26);
        Intransponivel agua27 = new Intransponivel("agua.png");
        agua27.setPosicao(9, 10);
        this.addElemento(agua27);
        Intransponivel agua28 = new Intransponivel("agua.png");
        agua28.setPosicao(10, 2);
        this.addElemento(agua28);
//            Intransponivel agua29 = new Intransponivel("agua.png");
//            agua29.setPosicao(10, 3);
//            this.addElemento(agua29);
        Intransponivel agua30 = new Intransponivel("agua.png");
        agua30.setPosicao(10, 4);
        this.addElemento(agua30);
        Intransponivel agua31 = new Intransponivel("agua.png");
        agua31.setPosicao(10, 5);
        this.addElemento(agua31);
        Intransponivel agua32 = new Intransponivel("agua.png");
        agua32.setPosicao(10, 6);
        this.addElemento(agua32);//
        Intransponivel agua33 = new Intransponivel("agua.png");
        agua33.setPosicao(10, 7);
        this.addElemento(agua33);
        Intransponivel agua34 = new Intransponivel("agua.png");
        agua34.setPosicao(10, 8);
        this.addElemento(agua34);
        Intransponivel agua35 = new Intransponivel("agua.png");
        agua35.setPosicao(10, 9);
        this.addElemento(agua35);
        Intransponivel agua36 = new Intransponivel("agua.png");
        agua36.setPosicao(10, 10);
        this.addElemento(agua36);
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

            Image ponte = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "ponte.png");
            g2.drawImage(ponte, 3 * Consts.CELL_SIDE, 10 * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

            Image ponteHorizontal = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "ponteh.png");
            g2.drawImage(ponteHorizontal, 2 * Consts.CELL_SIDE, 6 * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

            //para imagem do lolo, representando sua vida
            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "lolo.png");
            g2.drawImage(newImage, 13 * Consts.CELL_SIDE, 2 * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

            Bau bau = new Bau("baufechado.png");
            bau.setPosicao(5, 3);
            this.addElemento(bau);

            Portao pt = new Portao("porta.png");
            pt.setPosicao(0, 6);
            this.addElemento(pt);

            if (this.cora1 == true && this.cora2 == true && this.cora3 == true && this.cora4 == true && this.cora5 == true) {
                BauPerola perola = new BauPerola("baucomperola.png");
                perola.setPosicao(5, 3);
                this.addElemento(perola);
            }
            if (pegouperola == true) {
                BauPerola bauvazio = new BauPerola("bauvazio.png");
                bauvazio.setPosicao(5, 3);
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
                cg.autosalvar_fase3(vidas, 3, cora1, cora2, cora3, cora4, cora5, pegouperola, pegoubichovaivemhorizontal1, pegoucaveira2);
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
                    Fase3 tTela = new Fase3(vidas, 1, false, false, false, false, false, false, false, false);
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
            
            cg.salvar_fase3(vidas, 3, cora1, cora2, cora3, cora4, cora5, pegouperola, pegoubichovaivemhorizontal1, pegoucaveira2);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            LoloSingleton.getInstance("lolo.png").moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            LoloSingleton.getInstance("lolo.png").moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            LoloSingleton.getInstance("lolo.png").moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            LoloSingleton.getInstance("lolo.png").moveRight();
        }
        if (!cj.ehPosicaoValida(this.e, LoloSingleton.getInstance("lolo.png").getPosicao())) {
            LoloSingleton.getInstance("lolo.png").voltaAUltimaPosicao();
        }

        this.setTitle("-> Cell: " + (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna()) + ", "
                + (LoloSingleton.getInstance("lolo.png").getPosicao().getLinha()));

        if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 6 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 5) {
            if (pegoubichovaivemhorizontal1 == false) {
                pegoubichovaivemhorizontal1 = true;
            }
        }
        if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 1 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 9) {
            if (pegoucaveira2 == false) {
                pegoucaveira2 = true;
            }
        }
        if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 7 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 3) {
            if (cora1 == false) {
                cora1 = true;
            }
        }
        if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 5 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 7) {
            if (cora2 == false) {
                cora2 = true;
            }
        }
        if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 7 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 7) {
            if (cora3 == false) {
                cora3 = true;
            }
        }
        if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 11 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 10) {
            if (cora4 == false) {
                cora4 = true;
            }
        }
        if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 8 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 11) {
            if (cora5 == false) {
                cora5 = true;
            }
        }
        if (this.cora1 == true && this.cora2 == true && this.cora3 == true && this.cora4 == true && this.cora5 == true) {
            repaint();
            if (LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == 3 && LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == 5) {
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
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        sair();
                        Fase4 tTela = new Fase4(vidas, 1, false, false, false, false, false, false, false, false, false, false, 0, 0,
                                false, 0, 0, false, 0, 0);
                        tTela.setVisible(true);
                        tTela.createBufferStrategy(2);
                        tTela.go();
                        tTela.auto_save();

                    }
                });
            }
        }

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
