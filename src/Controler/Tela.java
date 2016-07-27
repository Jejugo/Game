/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Tela.java
 *
 * Created on 03/03/2011, 18:28:20
 */
package Controler;

import JefsLoloModel.Intransponivel;
import JefsLoloModel.Elemento;
import JefsLoloModel.LoloSingleton;
import Controler.Fase1;

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
 * @author junio
 */
public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener {

    private ArrayList<Elemento> e;
    private ControleDeJogo cj = new ControleDeJogo();

    /**
     * Creates new form tabuleiro
     */
    public Tela() {
        initComponents();
        this.addMouseListener(this); /*mouse*/

        this.addKeyListener(this);   /*teclado*/
        /*Cria a janela do tamanho do tabuleiro + insets (bordas) da janela*/

        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        e = new ArrayList<Elemento>(100);

        /*Cria e adiciona elementos*/
        
        LoloSingleton.getInstance("lolo.png").setPosicao(0, 7);
        this.addElemento(LoloSingleton.getInstance("lolo.png"));

        Intransponivel textoNovo = new Intransponivel("NOVO.png");
        textoNovo.setPosicao(6, 6);
        this.addElemento(textoNovo);

        Intransponivel Flecha1 = new Intransponivel("SETA.png");
        Flecha1.setPosicao(6, 7);
        this.addElemento(Flecha1);

        Intransponivel textoN = new Intransponivel("N.png");
        textoN.setPosicao(6, 8);
        this.addElemento(textoN);

        Intransponivel textoCarregar = new Intransponivel("CARREGAR.png");
        textoCarregar.setPosicao(7, 6);
        this.addElemento(textoCarregar);

        Intransponivel Flecha2 = new Intransponivel("SETA.png");
        Flecha2.setPosicao(7, 7);
        this.addElemento(Flecha2);

        Intransponivel textoC = new Intransponivel("C.png");
        textoC.setPosicao(7, 8);
        this.addElemento(textoC);
        
        Intransponivel textoAutoSave = new Intransponivel("AUTOSAVE.png");
        textoAutoSave.setPosicao(8, 6);
        this.addElemento(textoAutoSave);

        Intransponivel Flecha3 = new Intransponivel("SETA.png");
        Flecha3.setPosicao(8, 7);
        this.addElemento(Flecha3);

        Intransponivel textoA = new Intransponivel("A.png");
        textoA.setPosicao(8, 8);
        this.addElemento(textoA);

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
        /*Desenha cenário*/
        for (int i = 0; i < Consts.RES; i++) {
            for (int j = 0; j < Consts.RES; j++) {
                try {
                    Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "bricks.png");
                    g2.drawImage(newImage,
                            j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        this.cj.desenhaTudo(e, g2);
        this.cj.processaTudo(e);

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
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

    public void keyPressed(KeyEvent e) {
        final ArrayList <Elemento> ele= new ArrayList<Elemento>(100);
        if (e.getKeyCode() == KeyEvent.VK_N) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    sair();
                    Fase1 tTela;
                    tTela = new Fase1(5, 1,false,false,false,false);
                    tTela.setVisible(true);
                    tTela.createBufferStrategy(2);
                    tTela.go();
                    tTela.auto_save();
                    
                }
            });
        }
        if(e.getKeyCode() == KeyEvent.VK_C){
            CarregarSalvarJogo cg = new CarregarSalvarJogo();
            sair();
            cg.carregar();
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            CarregarSalvarJogo cg = new CarregarSalvarJogo();
            sair();
            cg.autosave_carregar();
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
    
    public void sair() {
        this.dispose();
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
        setPreferredSize(new java.awt.Dimension(500, 500));
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

    void carregarArquivo(String readLine) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
