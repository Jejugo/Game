/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Auxiliar;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author junio
 */
public class Desenho {
    public static void desenhar(Graphics g, ImageIcon iImage, int iColuna, int iLinha){
        iImage.paintIcon(null,g,iColuna * Consts.CELL_SIDE,iLinha * Consts.CELL_SIDE);
    }
}
