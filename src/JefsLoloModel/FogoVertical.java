/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JefsLoloModel;

import Auxiliar.Desenho;
import Controler.Fase2;
import java.awt.Graphics;

/**
 *
 * @author JeffGoes
 */
public class FogoVertical extends Elemento{
    private Fase2 tTelaOndeOFogoAnda;

    public FogoVertical(String sNomeImagePNG,Fase2 t) {
        super(sNomeImagePNG);
        tTelaOndeOFogoAnda = t;
        this.bMortal = true;
    }
    @Override
    public void autoDesenho(Graphics g) {
        Desenho.desenhar(g, this.iImage, pPosicao.getColuna(), pPosicao.getLinha());
        if(!this.moveDown())
            tTelaOndeOFogoAnda.removeElemento(this);
        if(LoloSingleton.getInstance("lolo.png").getPosicao().getColuna() == this.getPosicao().getColuna() && 
            LoloSingleton.getInstance("lolo.png").getPosicao().getLinha() == this.getPosicao().getLinha()){
            //Lolo morreu com o fogo
            tTelaOndeOFogoAnda.loloMorreu();
        }
    }
    

    
    
}
