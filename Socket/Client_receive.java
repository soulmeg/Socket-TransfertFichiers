package client;
import listener.*;
import affichage.*;
import java.io.*;
import java.net.*;
import client.*;
public class Client_receive{

    public Client_receive()throws Exception {
        client_sock_final();
    }

    public static void main(String[] args) throws Exception{
        new Client_receive();
    }

    public void receive(DataInputStream str){
		try {
			DataInputStream in = str;
            String titre_one=in.readUTF();
			String path="D:\\MR NAINA\\Socket\\DOWNLOAD FILE\\"+titre_one;
			File file=new File(path);
			FileOutputStream out = new FileOutputStream(file); //hanoratra
            byte buffer[] = new byte[1024];
			int n;
			while ((n=in.read(buffer))!=-1) {
				out.write(buffer,0,n);  
			}
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	


    public void client_sock_final(){
		int port = 100;
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


	
	
    
}