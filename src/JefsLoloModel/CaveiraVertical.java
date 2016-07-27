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
public class CaveiraVertical extends Elemento{
    private boolean bRight;
    
    public CaveiraVertical(String sNomeImagePNG) {
        super(sNomeImagePNG);
    }
    public void autoDesenho(Graphics g){
        if(bRight)
            this.getPosicao().setPosicao(pPosicao.getLinha()+1, pPosicao.getColuna());
        else
            this.getPosicao().setPosicao(pPosicao.getLinha()-1, pPosicao.getColuna());           

        Desenho.desenhar(g, this.iImage, pPosicao.getColuna(), pPosicao.getLinha());
        bRight = !bRight;
    }
    
}
