package serveur;
import listener.*;
import affichage.*;
import java.io.*;
import java.net.*;
import client.*;
public class Serveur1 {

	String findChemin;
	String c;
	int port=4001;
	
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int c) {
		this.port = c;
	}
	
	
	public String getFindChemin() {
		return findChemin;
	}
	public void setFindChemin(String findChemin) {
		this.findChemin = findChemin;
	}
	
	public Serveur1(String s)throws Exception {
		setC(s);
		// finalServeur=final_sock();
	}
	
    public Serveur1()throws Exception {
        Server_sock1();

    }


    public static void main(String[] args) throws Exception{
        new Serveur1();
    }


    public void receive(DataInputStream str){
		try {
			DataInputStream in = str;
			int lim=in.readInt();
			String titre_one=in.readUTF();
			String path="D:\\MR NAINA\\Socket\\file1\\Part_1_"+titre_one;
			File file=new File(path);
			FileOutputStream out = new FileOutputStream(file); //hanoratra
			byte buffer[] = new byte[lim];
			in.read(buffer);
			out.write(buffer,0,lim);  
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}	

    public void Server_sock1(){
		// int port = 4001;
		int connected = 0;
		try (ServerSocket serverSocke = new ServerSocket(port)) {
			System.out.println("port : "+port);
			
			while( true ){
				Socket s = serverSocke.accept();
				connected++;
				System.out.println("connected : " + connected);
				DataInputStream obj = new DataInputStream(s.getInputStream());
				receive(obj);
				s.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	

}