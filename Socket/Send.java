package client;
import listener.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.net.*;
import java.nio.file.Path;
import java.io.File;
import javax.swing.JFileChooser;

import client.*;
import java.util.*;
public class Send {
	String chemin;
	String nameFile;
	Socket serv;

	public String getChemin() {
		return chemin;
	}
	public void setChemin(String chemin) {
		this.chemin = chemin;
	}
	public String getNameFile() {
		return nameFile;
	}
	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}
	public Socket getServ() {
		return serv;
	}
	public void setServ(Socket serv) {
		this.serv = serv;
	}
	
	public Send() {
		
	}



	

	
	
}
