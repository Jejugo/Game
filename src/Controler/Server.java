/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import javax.swing.JFileChooser;
import java.io.OutputStreamWriter;
import javax.swing.JOptionPane;


/**
 *
 * @author jeffgoes
 */
public class Server  implements Runnable{
   
	
	private String server;
	private int port;

	@Override
	public void run() {
		try {
			Socket cliente = new Socket(server, port);
			System.out.println("Client On");
			
			JFileChooser fileChooser = new JFileChooser();  
			fileChooser.showOpenDialog(null);
            		JsonObject objectArchive = (JsonObject) new JsonParser().parse(new FileReader(fileChooser.getSelectedFile().getAbsolutePath()));
			
			try (OutputStreamWriter out = new OutputStreamWriter(cliente.getOutputStream(), StandardCharsets.UTF_8)) {
			    out.write(objectArchive.toString());
			}
			
			cliente.close();
			JOptionPane.showMessageDialog(null, "Arquivo de save enviado com sucesso");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao enviar o arquivo de save atual");
			e.printStackTrace();
		}
	}

	public void setServer(String server, int port) {
		this.server = server;
		this.port = port;
	}
}
