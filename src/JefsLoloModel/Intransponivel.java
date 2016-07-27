/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JefsLoloModel;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import java.awt.Graphics;
/**
 *
 * @author JeffGoes
 */
public class Intransponivel extends Elemento{
    public Intransponivel(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
    }
    public void autoDesenho(Graphics g){
       Desenho.desenhar(g, this.iImage, pPosicao.getColuna(), pPosicao.getLinha()); //vai desenhar

    }
}
