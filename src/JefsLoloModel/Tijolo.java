/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JefsLoloModel;

/**
 *
 * @author JeffGoes
 */
import Auxiliar.Consts;
import Auxiliar.Desenho;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tijolo extends Elemento{

    public Tijolo(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
    }
    public void autoDesenho(Graphics g){    
        Desenho.desenhar(g, this.iImage, pPosicao.getColuna(), pPosicao.getLinha());
    }
    
}
