package serveur;
import listener.*;
import affichage.*;
import java.io.*;
import java.net.*;
import client.*;
public class FinalServer {

	Socket receive_client;
	String lalana;

	public Socket getReceive_client() {
		return receive_client;
	}
	public void setReceive_client(Socket serv) {
		this.receive_client = serv;
	}
	public String getLalana() {
		return lalana;
	}
	public void setLalana(String lalana) {
		this.lalana = lalana;
	}
    public FinalServer()throws Exception {
        server_sock_final();
    }
	public FinalServer(String l)throws Exception {
       setLalana(lalana);
	   receive_client=sock_final_client();
    }



    public static void main(String[] args) throws Exception{
        new FinalServer();
    }

    public void receive(DataInputStream str){
		try {
			DataInputStream in = str;
			int lim=in.readInt();
			String titre_one=in.readUTF();
			String path="D:\\MR NAINA\\Socket\\final_file\\"+titre_one;
			File file=new File(path);
			FileOutputStream out = new FileOutputStream(file); //hanoratra
			
			int taille=lim*3;
			byte buffer[] = new byte[taille];
			in.read(buffer);
			out.write(buffer,0,taille);  
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	


    public void server_sock_final(){
		int port = 200;
		int connected = 0;
		try (ServerSocket serverSocke = new ServerSocket(port)) {
			System.out.println("port : "+port);
			
			while( true ){
				connected++;
				Socket s = serverSocke.accept();
				System.out.println("connected : " + connected);
				DataInputStream obj = new DataInputStream(s.getInputStream());
				receive(obj); //Atao anaty paath ilay obj azo avy any amny client
				s.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }


	public Socket sock_final_client() throws Exception{
		int port = 100;
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
	
	public void send_to_client(String lalana) throws Exception{
	    try{	

			OutputStream out = this.getReceive_client().getOutputStream();
			DataOutputStream o=new DataOutputStream(out);
			File file = new File(lalana);
			FileInputStream input = new FileInputStream(file);
			byte buffer[] = new byte[(int) file.length()];
			int n;
			if( file.length() == 0 ){
				return;
			} 
		    o.writeUTF(this.getLalana());
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