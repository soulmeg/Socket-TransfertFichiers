package serveur;
import listener.*;
import affichage.*;
import java.io.*;
import java.net.*;
import client.*;
public class Server{
	Socket serv;
	String lalana;
	Socket finalServeur;
	Socket serveur1;
	Socket serveur2;
	Socket serveur3;

	public Socket getServeur1() {
		return serveur1;
	}
	public Socket getServeur2() {
		return serveur2;
	}
	public Socket getServeur3() {
		return serveur3;
	}
	public String getLalana() {
		return lalana;
	}
	public void setLalana(String lalana) {
		this.lalana = lalana;
	}
	public Socket getServ() {
		return serv;
	}
	public void setServ(Socket serv) {
		this.serv = serv;
	}
	public Socket getFinalServeur() {
		return finalServeur;
	}
	public void setFinalServeur(Socket finalServeur) {
		this.finalServeur = finalServeur;
	}
	
	public Server() throws Exception{
		Server_sock();
		
	}
	public Server(String l) throws Exception{
		setLalana(l);
		serveur1=sock_server1();
		serveur2=sock_server2();
		serveur3=sock_server3();
		finalServeur=final_sock();
	}


	public static void main(String[] args) throws Exception {
		new Server();
	
	}

	public void receive(DataInputStream str){
		try {
			DataInputStream in = str;
			String ts=in.readUTF();
			String path="D:\\MR NAINA\\Socket\\file\\"+ts;
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



	public void Server_sock(){
		int port = 5001;
		int connected = 0;
		//	ClientSocket cs=new clientSocket();
		try (ServerSocket serverSocke = new ServerSocket(port)) {
			System.out.println("port : "+port);
			// Socket clientSocket = serverSocke.accept();         
			
			while( true ){
				Socket s = serverSocke.accept();
				connected++;
				//String lalanaa="D:\\Socket\\file\\handrana.pdf";
				System.out.println("connected : " + connected);
				// ObjectInputStream obj = new ObjectInputStream(s.getInputStream());
				DataInputStream obj = new DataInputStream(s.getInputStream());
				receive(obj);
				obj.close();
				s.close();
				serverSocke.close();	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}



	public Socket sock_server1() throws Exception{
		int port = 4001;
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


	public Socket sock_server2() throws Exception{
		int port = 4002;
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
	

	public Socket sock_server3() throws Exception{
		int port = 4003;
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


	public void send_cut_file(String path) throws Exception{
		OutputStream out1=this.getServeur1().getOutputStream();
		OutputStream out2=this.getServeur2().getOutputStream();
		OutputStream out3=this.getServeur3().getOutputStream();
		DataOutputStream data1=new DataOutputStream(out1);
		DataOutputStream data2=new DataOutputStream(out2);
		DataOutputStream data3=new DataOutputStream(out3);
	
		File file = new File(path);
		FileInputStream input = new FileInputStream(file);
		int file_length=(int) file.length();
		int one=((int) file.length())/3;

		data1.writeInt(one);
		data2.writeInt(one);			
		data3.writeInt(file_length-(one*2));
		
		byte buffer1[] = new byte[one];
		byte buffer2[] = new byte[one];
		byte buffer3[] = new byte[file_length-(2*one)];
		byte buff[][]=new byte[3][];
		buff[0]=buffer1;
		buff[1]=buffer2;
		buff[2]=buffer3;
		if( file.length() == 0 ){
			return;
		} 
		data1.writeUTF(this.getLalana());
		data2.writeUTF(this.getLalana());
		data3.writeUTF(this.getLalana());

		byte buf[]= new byte[file_length];
		input.read(buf);
		int ex=0;
		int lim=one;
		for (int k = 0; k < buff.length; k++) {

		
			int j=0;
			for (int i = ex; ex < lim; i++) {
				buff[k][j]=buf[i];
				ex++;
				j++;
			}

			if(k == buff.length-2){
				lim=file_length;
			}
			else {
				lim=one*2;
			}
		}

		data1.write(buffer1);
		data2.write(buffer2);
		data3.write(buffer3);
		data1.flush();
		data2.flush();
		data3.flush();
		out1.flush();
		out2.flush();
		out3.flush();
		input.close();

	}

	public void send_restituate_file(String path1,String path2,String path3) throws Exception{
			
		OutputStream out = this.getFinalServeur().getOutputStream();
		DataOutputStream o=new DataOutputStream(out);
		File file1 = new File(path1);
		File file2 = new File(path2);
		File file3 = new File(path3);
		FileInputStream input1 = new FileInputStream(file1); //le zavatra ho alefa 
		FileInputStream input2 = new FileInputStream(file2); //le zavatra ho alefa 
		FileInputStream input3 = new FileInputStream(file3); //le zavatra ho alefa 
		int file_length1 =(int) file1.length();
		int file_length2 =(int) file2.length();
		int file_length3 =(int) file3.length();
		int taille=file_length1+file_length2+file_length3;
		o.writeInt(taille);
		byte buffer1[] = new byte[file_length1];
		byte buffer2[] = new byte[file_length2];
		byte buffer3[] = new byte[file_length3];
		int n1;
		int n2;
		int n3;
		o.writeUTF(this.getLalana());
		while ((n1 = input1.read(buffer1))!=-1) {
			o.write(buffer1,0,n1);  
		}
		while ((n2 = input2.read(buffer2))!=-1) {
			o.write(buffer2,0,n2);  
		}
		while ((n3 = input3.read(buffer3))!=-1) {
			o.write(buffer3,0,n3);  
		}
		
		o.flush();
		out.flush();
		input1.close();
		input2.close();
		input3.close();
	}


	
}
