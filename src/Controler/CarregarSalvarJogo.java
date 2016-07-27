/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import JefsLoloModel.Elemento;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.Serializable;

/**
 *
 * @author JeffGoes
 */
public class CarregarSalvarJogo implements Serializable {

    int vidas;
    int fase;
    boolean cora1;
    boolean cora2;
    boolean cora3;
    boolean cora4;
    boolean cora5;
    boolean pegouperola;
    boolean pegoubichovaivemhorizontal1;
    boolean pegoucaveira2;
    boolean cav1;
    boolean cav2;
    boolean cav;
    boolean fantas1;
    boolean fantas2;
    boolean caixa1;
    int cx1_l;
    int cx1_c;
    boolean caixa3;
    int cx3_l;
    int cx3_c;
    boolean caixa4;
    int cx4_l;
    int cx4_c;
    boolean caixa5;
    int cx5_l;
    int cx5_c;

    public CarregarSalvarJogo() {

    }

    public void salvar_fase1(int vidas, int fase, boolean cora1, boolean cora2, boolean pegouperola, boolean pegoubichovaivemhorizontal1) {

        try {
            File arq = new File("FaseSalva.zip");
            arq.createNewFile();
            FileOutputStream out = new FileOutputStream(arq);
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeInt(fase);
            objOut.writeInt(vidas);
            objOut.writeBoolean(cora1);
            objOut.writeBoolean(cora2);
            objOut.writeBoolean(pegouperola);
            objOut.writeBoolean(pegoubichovaivemhorizontal1);

            objOut.close();

            System.out.println("Fase Salva!");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar_fase2(int vidas, int fase, boolean cora1, boolean cora2, boolean cora3, boolean cora4, boolean pegouperola, boolean pegoubichovaivemhorizontal1) {
        try {
            File arq = new File("FaseSalva.zip");
            arq.createNewFile();
            FileOutputStream out = new FileOutputStream(arq);
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeInt(fase);
            objOut.writeInt(vidas);
            objOut.writeBoolean(cora1);
            objOut.writeBoolean(cora2);
            objOut.writeBoolean(cora3);
            objOut.writeBoolean(cora4);
            objOut.writeBoolean(pegouperola);
            objOut.writeBoolean(pegoubichovaivemhorizontal1);

            objOut.close();

            System.out.println("Fase Salva!");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void salvar_fase3(int vidas, int fase, boolean cora1, boolean cora2, boolean cora3, boolean cora4, boolean cora5, boolean pegouperola, boolean pegoubichovaivemhorizontal1, boolean pegoucaveira2) {
        try {
            File arq = new File("FaseSalva.zip");
            arq.createNewFile();
            FileOutputStream out = new FileOutputStream(arq);
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeInt(fase);
            objOut.writeInt(vidas);
            objOut.writeBoolean(cora1);
            objOut.writeBoolean(cora2);
            objOut.writeBoolean(cora3);
            objOut.writeBoolean(cora4);
            objOut.writeBoolean(cora5);
            objOut.writeBoolean(pegouperola);
            objOut.writeBoolean(pegoubichovaivemhorizontal1);
            objOut.writeBoolean(pegoucaveira2);
            objOut.close();

            System.out.println("Fase Salva!");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salva_fase4(int vidas, int fase, boolean cora1, boolean cora2, boolean cora3, boolean cora4, boolean cora5,
            boolean pegouperola, boolean cav1, boolean cav2, boolean cav, boolean caixa3, int cx3_l, int cx3_c,
            boolean caixa4, int cx4_l, int cx4_c, boolean caixa5, int cx5_l, int cx5_c) {
        try {
            File arq = new File("FaseSalva.zip");
            arq.createNewFile();
            FileOutputStream out = new FileOutputStream(arq);
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeInt(fase);
            objOut.writeInt(vidas);
            objOut.writeBoolean(cora1);
            objOut.writeBoolean(cora2);
            objOut.writeBoolean(cora3);
            objOut.writeBoolean(cora4);
            objOut.writeBoolean(cora5);
            objOut.writeBoolean(pegouperola);
            objOut.writeBoolean(cav1);
            objOut.writeBoolean(cav2);
            objOut.writeBoolean(cav);
            objOut.writeBoolean(caixa3);
            objOut.writeInt(cx3_l);
            objOut.writeInt(cx3_c);
            objOut.writeBoolean(caixa4);
            objOut.writeInt(cx4_l);
            objOut.writeInt(cx4_c);
            objOut.writeBoolean(caixa5);
            objOut.writeInt(cx5_l);
            objOut.writeInt(cx5_c);
            objOut.close();

            System.out.println("Fase Salva!");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void salvar_fase5(int vidas, int fase, boolean cora1, boolean cora2, boolean cora3, boolean cora4, boolean pegouperola,
            boolean fantas1, boolean fantas2,
            boolean caixa1, int cx1_l, int cx1_c,
            boolean caixa4, int cx4_l, int cx4_c,
            boolean caixa5, int cx5_l, int cx5_c){
         try {
            File arq = new File("FaseSalva.zip");
            arq.createNewFile();
            FileOutputStream out = new FileOutputStream(arq);
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeInt(fase);
            objOut.writeInt(vidas);
            objOut.writeBoolean(cora1);
            objOut.writeBoolean(cora2);
            objOut.writeBoolean(cora3);
            objOut.writeBoolean(cora4);
            objOut.writeBoolean(pegouperola);
            objOut.writeBoolean(fantas1);
            objOut.writeBoolean(fantas2);
            objOut.writeBoolean(caixa1);
            objOut.writeInt(cx1_l);
            objOut.writeInt(cx1_c);
            objOut.writeBoolean(caixa4);
            objOut.writeInt(cx4_l);
            objOut.writeInt(cx4_c);
            objOut.writeBoolean(caixa5);
            objOut.writeInt(cx5_l);
            objOut.writeInt(cx5_c);
            objOut.close();

            System.out.println("Fase Salva!");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void autosalvar_fase1(int vidas, int fase, boolean cora1, boolean cora2, boolean pegouperola, boolean pegoubichovaivemhorizontal1) {

        try {
            File arq = new File("AutoFaseSalva.zip");
            arq.createNewFile();
            FileOutputStream out = new FileOutputStream(arq);
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeInt(fase);
            objOut.writeInt(vidas);
            objOut.writeBoolean(cora1);
            objOut.writeBoolean(cora2);
            objOut.writeBoolean(pegouperola);
            objOut.writeBoolean(pegoubichovaivemhorizontal1);

            objOut.close();

            System.out.println("Fase Salva!");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void autosalvar_fase2(int vidas, int fase, boolean cora1, boolean cora2, boolean cora3, boolean cora4, boolean pegouperola, boolean pegoubichovaivemhorizontal1) {
        try {
            File arq = new File("AutoFaseSalva.zip");
            arq.createNewFile();
            FileOutputStream out = new FileOutputStream(arq);
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeInt(fase);
            objOut.writeInt(vidas);
            objOut.writeBoolean(cora1);
            objOut.writeBoolean(cora2);
            objOut.writeBoolean(cora3);
            objOut.writeBoolean(cora4);
            objOut.writeBoolean(pegouperola);
            objOut.writeBoolean(pegoubichovaivemhorizontal1);

            objOut.close();

            System.out.println("Fase Salva!");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void autosalvar_fase3(int vidas, int fase, boolean cora1, boolean cora2, boolean cora3, boolean cora4, boolean cora5, boolean pegouperola, boolean pegoubichovaivemhorizontal1, boolean pegoucaveira2) {
        try {
            File arq = new File("AutoFaseSalva.zip");
            arq.createNewFile();
            FileOutputStream out = new FileOutputStream(arq);
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeInt(fase);
            objOut.writeInt(vidas);
            objOut.writeBoolean(cora1);
            objOut.writeBoolean(cora2);
            objOut.writeBoolean(cora3);
            objOut.writeBoolean(cora4);
            objOut.writeBoolean(cora5);
            objOut.writeBoolean(pegouperola);
            objOut.writeBoolean(pegoubichovaivemhorizontal1);
            objOut.writeBoolean(pegoucaveira2);
            objOut.close();

            System.out.println("Fase Salva!");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void autosalva_fase4(int vidas, int fase, boolean cora1, boolean cora2, boolean cora3, boolean cora4, boolean cora5,
            boolean pegouperola, boolean cav1, boolean cav2, boolean cav, boolean caixa3, int cx3_l, int cx3_c,
            boolean caixa4, int cx4_l, int cx4_c, boolean caixa5, int cx5_l, int cx5_c) {
        try {
            File arq = new File("AutoFaseSalva.zip");
            arq.createNewFile();
            FileOutputStream out = new FileOutputStream(arq);
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeInt(fase);
            objOut.writeInt(vidas);
            objOut.writeBoolean(cora1);
            objOut.writeBoolean(cora2);
            objOut.writeBoolean(cora3);
            objOut.writeBoolean(cora4);
            objOut.writeBoolean(cora5);
            objOut.writeBoolean(pegouperola);
            objOut.writeBoolean(cav1);
            objOut.writeBoolean(cav2);
            objOut.writeBoolean(cav);
            objOut.writeBoolean(caixa3);
            objOut.writeInt(cx3_l);
            objOut.writeInt(cx3_c);
            objOut.writeBoolean(caixa4);
            objOut.writeInt(cx4_l);
            objOut.writeInt(cx4_c);
            objOut.writeBoolean(caixa5);
            objOut.writeInt(cx5_l);
            objOut.writeInt(cx5_c);
            objOut.close();

            System.out.println("Fase Salva!");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void autosalvar_fase5(int vidas, int fase, boolean cora1, boolean cora2, boolean cora3, boolean cora4, boolean pegouperola,
            boolean fantas1, boolean fantas2,
            boolean caixa1, int cx1_l, int cx1_c,
            boolean caixa4, int cx4_l, int cx4_c,
            boolean caixa5, int cx5_l, int cx5_c){
         try {
            File arq = new File("AutoFaseSalva.zip");
            arq.createNewFile();
            FileOutputStream out = new FileOutputStream(arq);
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeInt(fase);
            objOut.writeInt(vidas);
            objOut.writeBoolean(cora1);
            objOut.writeBoolean(cora2);
            objOut.writeBoolean(cora3);
            objOut.writeBoolean(cora4);
            objOut.writeBoolean(pegouperola);
            objOut.writeBoolean(fantas1);
            objOut.writeBoolean(fantas2);
            objOut.writeBoolean(caixa1);
            objOut.writeInt(cx1_l);
            objOut.writeInt(cx1_c);
            objOut.writeBoolean(caixa4);
            objOut.writeInt(cx4_l);
            objOut.writeInt(cx4_c);
            objOut.writeBoolean(caixa5);
            objOut.writeInt(cx5_l);
            objOut.writeInt(cx5_c);
            objOut.close();

            System.out.println("Fase Salva!");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void carregar() {
        try {
            File arq = new File("FaseSalva.zip");
            FileInputStream entrada = new FileInputStream(arq);
            ObjectInputStream objIn = new ObjectInputStream(entrada);

            fase = objIn.readInt();
            vidas = objIn.readInt();

            if (fase == 1) {
                cora1 = objIn.readBoolean();
                cora2 = objIn.readBoolean();
                pegouperola = objIn.readBoolean();
                pegoubichovaivemhorizontal1 = objIn.readBoolean();
                Fase1 tTela;
                tTela = new Fase1(vidas, 2, cora1, cora2, pegouperola, pegoubichovaivemhorizontal1);
                tTela.setVisible(true);
                tTela.createBufferStrategy(2);
                tTela.go();
                tTela.auto_save();
                
                
            } else if (fase == 2) {
                cora1 = objIn.readBoolean();
                cora2 = objIn.readBoolean();
                cora3 = objIn.readBoolean();
                cora4 = objIn.readBoolean();
                pegouperola = objIn.readBoolean();
                pegoubichovaivemhorizontal1 = objIn.readBoolean();
                Fase2 tTela;
                tTela = new Fase2(vidas, 2, cora1, cora2, cora3, cora4, pegouperola, pegoubichovaivemhorizontal1);
                tTela.setVisible(true);
                tTela.createBufferStrategy(2);
                tTela.go();
                tTela.auto_save();
                
            } else if (fase == 3) {
                cora1 = objIn.readBoolean();
                cora2 = objIn.readBoolean();
                cora3 = objIn.readBoolean();
                cora4 = objIn.readBoolean();
                cora5 = objIn.readBoolean();
                pegouperola = objIn.readBoolean();
                pegoubichovaivemhorizontal1 = objIn.readBoolean();
                pegoucaveira2 = objIn.readBoolean();
                Fase3 tTela;
                tTela = new Fase3(vidas, 2, cora1, cora2, cora3, cora4, cora5, pegouperola, pegoubichovaivemhorizontal1, pegoucaveira2);
                tTela.setVisible(true);
                tTela.createBufferStrategy(2);
                tTela.go();
                tTela.auto_save();
                
            } else if (fase == 4) {
                cora1 = objIn.readBoolean();
                cora2 = objIn.readBoolean();
                cora3 = objIn.readBoolean();
                cora4 = objIn.readBoolean();
                cora5 = objIn.readBoolean();
                pegouperola = objIn.readBoolean();
                cav1 = objIn.readBoolean();
                cav2 = objIn.readBoolean();
                cav = objIn.readBoolean();
                caixa3 = objIn.readBoolean();
                cx3_l = objIn.readInt();
                cx3_c = objIn.readInt();
                caixa4 = objIn.readBoolean();
                cx4_l = objIn.readInt();
                cx4_c = objIn.readInt();
                caixa5 = objIn.readBoolean();
                cx5_l = objIn.readInt();
                cx5_c = objIn.readInt();
                Fase4 tTela;
                tTela = new Fase4(vidas,2,cora1,cora2,cora3,cora4,cora5,pegouperola,cav1,cav2,cav,caixa3,cx3_l,cx3_c,
                caixa4,cx4_l,cx4_c,caixa5,cx5_l,cx5_c);
                tTela.setVisible(true);
                tTela.createBufferStrategy(2);
                tTela.go();
                tTela.auto_save();
                
                
            }
            else if(fase == 5){
                cora1 = objIn.readBoolean();
                cora2 = objIn.readBoolean();
                cora3 = objIn.readBoolean();
                cora4 = objIn.readBoolean();
                pegouperola = objIn.readBoolean();
                fantas1 = objIn.readBoolean();
                fantas2 = objIn.readBoolean();
                caixa1 = objIn.readBoolean();
                cx1_l = objIn.readInt();
                cx1_c = objIn.readInt();
                caixa4 = objIn.readBoolean();
                cx4_l = objIn.readInt();
                cx4_c = objIn.readInt();
                caixa5 = objIn.readBoolean();
                cx5_l = objIn.readInt();
                cx5_c = objIn.readInt();
                
                Fase5 tTela;
                tTela = new Fase5(vidas, 5, cora1, cora2, cora3, cora4, pegouperola, fantas1, fantas2, 
                     caixa1, cx1_l, cx1_c, 
                     caixa4, cx4_l, cx4_c,
                     caixa5, cx5_l, cx5_c);
                tTela.setVisible(true);
                tTela.createBufferStrategy(2);
                tTela.go();
                tTela.auto_save();
                
                
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }



 public void autosave_carregar() {
        try {
            File arq = new File("AutoFaseSalva.zip");
            FileInputStream entrada = new FileInputStream(arq);
            ObjectInputStream objIn = new ObjectInputStream(entrada);

            fase = objIn.readInt();
            vidas = objIn.readInt();

            if (fase == 1) {
                cora1 = objIn.readBoolean();
                cora2 = objIn.readBoolean();
                pegouperola = objIn.readBoolean();
                pegoubichovaivemhorizontal1 = objIn.readBoolean();
                Fase1 tTela;
                tTela = new Fase1(vidas, 2, cora1, cora2, pegouperola, pegoubichovaivemhorizontal1);
                tTela.setVisible(true);
                tTela.createBufferStrategy(2);
                tTela.go();
                tTela.auto_save();
                
                
            } else if (fase == 2) {
                cora1 = objIn.readBoolean();
                cora2 = objIn.readBoolean();
                cora3 = objIn.readBoolean();
                cora4 = objIn.readBoolean();
                pegouperola = objIn.readBoolean();
                pegoubichovaivemhorizontal1 = objIn.readBoolean();
                Fase2 tTela;
                tTela = new Fase2(vidas, 2, cora1, cora2, cora3, cora4, pegouperola, pegoubichovaivemhorizontal1);
                tTela.setVisible(true);
                tTela.createBufferStrategy(2);
                tTela.go();
                tTela.auto_save();
                
                
            } else if (fase == 3) {
                cora1 = objIn.readBoolean();
                cora2 = objIn.readBoolean();
                cora3 = objIn.readBoolean();
                cora4 = objIn.readBoolean();
                cora5 = objIn.readBoolean();
                pegouperola = objIn.readBoolean();
                pegoubichovaivemhorizontal1 = objIn.readBoolean();
                pegoucaveira2 = objIn.readBoolean();
                Fase3 tTela;
                tTela = new Fase3(vidas, 2, cora1, cora2, cora3, cora4, cora5, pegouperola, pegoubichovaivemhorizontal1, pegoucaveira2);
                tTela.setVisible(true);
                tTela.createBufferStrategy(2);
                tTela.go();
                tTela.auto_save();
                
                
            } else if (fase == 4) {
                cora1 = objIn.readBoolean();
                cora2 = objIn.readBoolean();
                cora3 = objIn.readBoolean();
                cora4 = objIn.readBoolean();
                cora5 = objIn.readBoolean();
                pegouperola = objIn.readBoolean();
                cav1 = objIn.readBoolean();
                cav2 = objIn.readBoolean();
                cav = objIn.readBoolean();
                caixa3 = objIn.readBoolean();
                cx3_l = objIn.readInt();
                cx3_c = objIn.readInt();
                caixa4 = objIn.readBoolean();
                cx4_l = objIn.readInt();
                cx4_c = objIn.readInt();
                caixa5 = objIn.readBoolean();
                cx5_l = objIn.readInt();
                cx5_c = objIn.readInt();
                Fase4 tTela;
                tTela = new Fase4(vidas,2,cora1,cora2,cora3,cora4,cora5,pegouperola,cav1,cav2,cav,caixa3,cx3_l,cx3_c,
                caixa4,cx4_l,cx4_c,caixa5,cx5_l,cx5_c);
                tTela.setVisible(true);
                tTela.createBufferStrategy(2);
                tTela.go();
                tTela.auto_save();
                
                
            }
            else if(fase == 5){
                cora1 = objIn.readBoolean();
                cora2 = objIn.readBoolean();
                cora3 = objIn.readBoolean();
                cora4 = objIn.readBoolean();
                pegouperola = objIn.readBoolean();
                fantas1 = objIn.readBoolean();
                fantas2 = objIn.readBoolean();
                caixa1 = objIn.readBoolean();
                cx1_l = objIn.readInt();
                cx1_c = objIn.readInt();
                caixa4 = objIn.readBoolean();
                cx4_l = objIn.readInt();
                cx4_c = objIn.readInt();
                caixa5 = objIn.readBoolean();
                cx5_l = objIn.readInt();
                cx5_c = objIn.readInt();
                
                Fase5 tTela;
                tTela = new Fase5(vidas, 5, cora1, cora2, cora3, cora4, pegouperola, fantas1, fantas2, 
                     caixa1, cx1_l, cx1_c, 
                     caixa4, cx4_l, cx4_c,
                     caixa5, cx5_l, cx5_c);
                tTela.setVisible(true);
                tTela.createBufferStrategy(2);
                tTela.go();
                tTela.auto_save();
                
                
                
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CarregarSalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
