/*
 * To change this template, choose Tools | Templates
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
 * @author Junio
 */
public class BichinhoVaiVemHorizontal extends Elemento{
    private boolean bRight;

    public BichinhoVaiVemHorizontal(String sNomeImagePNG) {
        super(sNomeImagePNG);
        bRight = true;
    }
    public void autoDesenho(Graphics g){
      /*  if(bRight)
            this.getPosicao().setPosicao(pPosicao.getLinha(), pPosicao.getColuna()+1);
        else
            this.getPosicao().setPosicao(pPosicao.getLinha(), pPosicao.getColuna()-1);           
*/ //pra caso quiser que ele fique andando de um lado pro outro
        Desenho.desenhar(g, this.iImage, pPosicao.getColuna(), pPosicao.getLinha());
        bRight = !bRight;
    }
}
