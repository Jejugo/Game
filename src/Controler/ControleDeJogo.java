/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controler;

import JefsLoloModel.Elemento;
import JefsLoloModel.LoloSingleton;
import auxiliar.Posicao;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author junio
 */
public class ControleDeJogo {

    
    public void desenhaTudo(ArrayList<Elemento> e, Graphics g){
        for(int i = 0; i < e.size(); i++){
            e.get(i).autoDesenho(g);
        }
    }
    public void processaTudo(ArrayList<Elemento> e){
        LoloSingleton.getInstance("lolo.png").setPosicao(e.get(0).getPosicao().getLinha(), e.get(0).getPosicao().getColuna());
        Elemento eTemp;
        
        for(int i = 1; i < e.size(); i++){
            eTemp = e.get(i);
            if(LoloSingleton.getInstance("lolo.png").getPosicao().igual(eTemp.getPosicao()))
                if(eTemp.isbTransponivel())
                    e.remove(eTemp);
          
        }        
    }
    public boolean ehPosicaoValida(ArrayList<Elemento> e, Posicao p){
        Elemento eTemp;
        for(int i = 1; i < e.size(); i++){
            eTemp = e.get(i);            
            if(!eTemp.isbTransponivel())
                if(eTemp.getPosicao().igual(p))
                    return false;
        }        
        return true;
    }
}
