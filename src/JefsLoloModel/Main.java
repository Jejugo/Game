/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JefsLoloModel;

import java.io.File;
import javax.sound.sampled.Clip;

import Controler.Fase2;
import Controler.Fase1;
import Controler.Tela;

/**
 *
 * @author junio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela tTela = new Tela();
                tTela.setVisible(true);
                tTela.createBufferStrategy(2);
                tTela.go();
            }
        });
    }


}