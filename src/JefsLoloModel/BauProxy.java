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

public class BauProxy extends Elemento {

    private String sNomeImagePNG;
    private BauPerola bau;
    int lin;
    int col;

    public BauProxy(String saNomeImagePNG, int linha, int coluna) {
        super(saNomeImagePNG);
        this.sNomeImagePNG = saNomeImagePNG;
        this.lin = linha;
        this.col = coluna;
    }

    public void autoDesenho(Graphics g) {

        if (bau == null) {

            bau = new BauPerola(sNomeImagePNG);
            bau.setPosicao(lin, col);
            bau.autoDesenho(g);
        }
    }

}
