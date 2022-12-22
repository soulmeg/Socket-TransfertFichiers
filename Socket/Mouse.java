package listener;
import affichage.*;
import client.*;
import serveur.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class Mouse implements MouseListener{
     
    MyPanel p;
    Send sender;
    Server server;
    ClientSocket client;

    public Server getServer() {
        return server;
    }
    public void setServer(Server server) {
        this.server = server;
    }
 
    public MyPanel getP(){
        return p;
    }
    public void setP(MyPanel p) {
        this.p = p;
    }
   public Send getSender() {
       return sender;
   }
   public void setSender(Send sender) {
       this.sender = sender;
    }
    
    public void setClient(ClientSocket cl){
        client = cl;
    }
    public ClientSocket getClient(){
        return this.client; 
    }
    
    
    public Mouse(MyPanel p,Send s) {
        setP(p);
        setSender(s);
    }

    public Mouse() {
    }

    public Mouse(Send sender) {
        setSender(sender);
    }


    public Mouse(Server sr){
        setServer(sr);
    }

    public void mouseClicked(MouseEvent e){
        if((JButton)e.getSource() == getP().getBtn()[0]){
            JFileChooser choose = new JFileChooser(
				FileSystemView.getFileSystemView().getHomeDirectory()
			);
			int res = choose.showOpenDialog(null);
			if (res == JFileChooser.APPROVE_OPTION) {
				File file = choose.getSelectedFile();
                String foo=file.getAbsolutePath();
                String bar=foo.replace("\\","\\\\");
				getSender().setChemin(bar);
                getSender().setNameFile(file.getName());
                getP().getLabel().setForeground(Color.red);
                getP().getLabel().setText("choosen file "+ getSender().getChemin() +" ");
			}	
        }

        if((JButton)e.getSource() == getP().getBtn()[1]){
            try {
                if(getSender().getChemin() != null){
                    getSender().setNameFile(getSender().getNameFile()); 
                    getClient().setFileName(getSender().getNameFile());
                    Server ss=new Server(getSender().getNameFile());
                    Serveur1 ss1=new Serveur1(getSender().getNameFile());
                    Serveur2 ss2=new Serveur2(getSender().getNameFile());
                    Serveur3 ss3=new Serveur3(getSender().getNameFile());
                    ss.setLalana(getSender().getNameFile());
                    this.getClient().send(getSender().getChemin());
                    ss.send_cut_file(getSender().getChemin());
                    String part1="Part_1_"+getSender().getNameFile();
                    String part2="Part_2_"+getSender().getNameFile();
                    String part3="Part_3_"+getSender().getNameFile();
                    String p1="D:\\MR NAINA\\Socket\\file1\\"+part1;
                    String p2="D:\\MR NAINA\\Socket\\file2\\"+part2;
                    String p3="D:\\MR NAINA\\Socket\\file3\\"+part3;
                    ss.send_restituate_file(p1,p2,p3);
                    new Server_frame("1",part1,10,20);
                    new Server_frame("2",part2,520,20);
                    new Server_frame("3",part3,1030,20);

                    JFileChooser chooser = new JFileChooser("D:\\MR NAINA\\Socket\\final_file");                
                    int res = chooser.showOpenDialog(null);
                    if (res == JFileChooser.APPROVE_OPTION) {
                        File fichier = chooser.getSelectedFile();
                        FinalServer f=new FinalServer(fichier.getName());
                        f.setLalana(fichier.getName());
                        f.send_to_client(fichier.getAbsolutePath());
                        getP().getBtn()[0].setVisible(false);
                        getP().getBtn()[1].setVisible(false);
                        getP().getLabel().setForeground(Color.red);
                        getP().getLabel().setText("SUCCES DOWNLOAD");
                    }	
            }
        
                
            } catch (Exception em) {
                em.printStackTrace();
                
            }
        }
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
        
    }
    
}