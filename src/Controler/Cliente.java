/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author JeffGoes
 */
public class Cliente implements Runnable{

private Tela tela;
	private int port;
	
	public Cliente(int port) {
		this.port = port;
	}

	@Override
	public void run() {

		Runnable serverTask = new Runnable() {

			@Override
			public void run() {
                            try {
                                ServerSocket servidor = new ServerSocket(port);
                                while(true){
                                    Socket cliente = servidor.accept();
                                    BufferedReader in = new BufferedReader(new InputStreamReader(new DataInputStream(cliente.getInputStream())));
                                    tela.carregarArquivo(in.readLine());
                                    JOptionPane.showMessageDialog(null, "Arquivo recebido com sucesso! Fechando conexão.");
                                    cliente.close();
                                    servidor.close();
                                }
                            } catch (Exception e) {
                                    e.printStackTrace();
                            }
			}

		};
		Thread serverThread = new Thread(serverTask);
		serverThread.start();
        }
}
    
  
