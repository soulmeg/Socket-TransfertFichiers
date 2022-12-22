package client;
import affichage.*;
import listener.*;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.net.*;
import client.*;

public class ClientSocket {

	Socket socket;
	String fileName;
	
	public static void main(String[] args) {
		new ClientSocket();		
	}

	public Socket getSocket(){
		return socket;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public ClientSocket(){
		try {
			
			Send s = new Send();
			socket = this.Client_sock();
			MyFrame frame = new MyFrame();
			Mouse m = new Mouse(frame.getP(),s);
			m.setClient(this);
			frame.getP().getBtn()[0].addMouseListener(m);
			frame.getP().getBtn()[1].addMouseListener(m);
			frame.setVisible(true);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public Socket Client_sock() throws Exception{
		int port = 5001;
		Socket sockets = null;
		try {
			sockets =  new Socket("127.0.0.1",port);
				return sockets;
			} 
			catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Can't connect to the server ");
			}
	}


    public void send(String lalana) throws Exception{
	    try{	

			OutputStream out = this.getSocket().getOutputStream();
			DataOutputStream o=new DataOutputStream(out);
			
			File file = new File(lalana);
			FileInputStream input = new FileInputStream(file);
			byte buffer[] = new byte[(int) file.length()];
			int n;
			if( file.length() == 0 ){
				return;
			} 
		    o.writeUTF(this.getFileName());
			while( ( n = input.read(buffer) ) != -1 ){
				o.write(buffer,0,n);
			}

			o.flush();
			out.flush();
			input.close();
		}catch(Exception e){
			e.printStackTrace();
		}
    }


		
	

	

	
}
