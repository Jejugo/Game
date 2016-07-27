/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JefsLoloModel;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author JeffGoes
 */
public class Coracao extends Elemento{
    private boolean bRight;
    
    public Coracao(String sNomeImagePNG) {
        super(sNomeImagePNG);
        bRight = true;
    }
    
    public void autoDesenho(Graphics g){
       Desenho.desenhar(g, this.iImage, pPosicao.getColuna(), pPosicao.getLinha()); //vai desenhar
        bRight = !bRight; //assim que o Lolo chegar em cima do coração, ele vai sumir       
    }
}
