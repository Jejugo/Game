/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package JefsLoloModel;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Junio
 */
public class LoloSingleton extends Elemento {
    private static LoloSingleton instance = null;
    public LoloSingleton(String sNomeImagePNG) {
        super(sNomeImagePNG);
    }
    
    public static LoloSingleton getInstance(String sNomeImagePNG){
        if(instance == null) {
         instance = new LoloSingleton(sNomeImagePNG);
      }
      return instance;
    }
    public void autoDesenho(Graphics g){
        Desenho.desenhar(g, this.iImage, pPosicao.getColuna(), pPosicao.getLinha());
    }

    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}
