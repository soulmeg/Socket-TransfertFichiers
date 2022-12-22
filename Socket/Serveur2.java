package serveur;
import listener.*;
import affichage.*;
import java.io.*;
import java.net.*;
import client.*;
public class Serveur2 {
	Socket finalServeur;
	String findChemin;

	
	public Socket getFinalServeur() {
		return finalServeur;
	}
	public void setFinalServeur(Socket finalServeur) {
		this.finalServeur = finalServeur;
	}
	
	public String getFindChemin() {
		return findChemin;
	}
	public void setFindChemin(String findChemin) {
		this.findChemin = findChemin;
	}
	
	public Serveur2(String s)throws Exception {
		setFindChemin(s);
		// finalServeur=final_sock();
	}
    public Serveur2()throws Exception {
        Server_sock2();
    }

    public static void main(String[] args) throws Exception{
        new Serveur2();
    }

    public void receive(DataInputStream str){
		try {
			DataInputStream in = str;
			int lim=in.readInt();
			String titre_one=in.readUTF();
			String path="D:\\MR NAINA\\Socket\\file2\\Part_2_"+titre_one;
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

    public void Server_sock2(){
		int port = 4002;
		int connected = 0;
		try (ServerSocket serverSocke = new ServerSocket(port)) {
			System.out.println("port : "+port);
			
			while( true ){
				connected++;
				Socket s = serverSocke.accept();
				System.out.println("connected : " + connected);
				DataInputStream obj = new DataInputStream(s.getInputStream());
				receive(obj); 
				s.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	
	public Socket final_sock() throws Exception{
		int port = 200;
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



	
    
}