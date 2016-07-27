/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JefsLoloModel;
import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Fase2;
import java.awt.Graphics;
/**
 *
 * @author JeffGoes
 */
public class MonstroRosa extends Elemento{   
    private int iContaIntervalos;
    private Fase2 tTelaParaLancarFogo;
 
    public MonstroRosa(String sNomeImagePNG, Fase2 t) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
         this.iContaIntervalos = 0;
        this.tTelaParaLancarFogo = t;
    }
    public void autoDesenho(Graphics g){
       Desenho.desenhar(g, this.iImage, pPosicao.getColuna(), pPosicao.getLinha()); //vai desenhar
       
       this.iContaIntervalos++;
        if(this.iContaIntervalos == Consts.TIMER_FOGO){
            this.iContaIntervalos = 0;
            Fogo f = new Fogo("fire.png", this.tTelaParaLancarFogo);
            f.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()+1);
            this.tTelaParaLancarFogo.addElemento(f);
        }
    }
}
