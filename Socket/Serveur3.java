package serveur;
import listener.*;
import affichage.*;
import java.io.*;
import java.net.*;
import client.*;
public class Serveur3 {
	
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
	
	public Serveur3(String s)throws Exception {
		setFindChemin(s);
		// finalServeur=final_sock();
	}
    public Serveur3()throws Exception {
        Server_sock3();
    }

    public static void main(String[] args) throws Exception{
        new Serveur3();
    }

    public void receive(DataInputStream str){
		try {
			DataInputStream in = str;
			int lim=in.readInt();
			String titre_one=in.readUTF();
			String path="D:\\MR NAINA\\Socket\\file3\\Part_3_"+titre_one;
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

    public void Server_sock3(){
		int port = 4003;
		int connected = 0;
		try (ServerSocket serverSocke = new ServerSocket(port)) {
			System.out.println("port : "+port);
			
			while( true ){
				Socket s = serverSocke.accept();
				connected++;
				System.out.println("connected : " + connected);
				DataInputStream obj = new DataInputStream(s.getInputStream());
				receive(obj); //Atao anaty paath ilay obj azo avy any amny client
				// obj.close();
				s.close();
				// serverSocke.close();	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }


	
	
    
}