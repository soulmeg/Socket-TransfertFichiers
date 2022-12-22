package affichage;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Server_frame extends JFrame {
    int xx;
    int yy;
    JLabel [] label =new JLabel [2];


    public JLabel [] getLabel() {
        return label;
    }

    public void setLabel(JLabel [] label) {
        this.label = label;
    }
    public int getXX() {
        return xx;
    }

    public void setXX(int label) {
        this.xx = label;
    }
    public int getYY() {
        return yy;
    }

    public void setYY(int label) {
        this.yy = label;
    }


    public Server_frame(String titre_serveur,String file_choisi,int x,int y) {
            label[0]=new JLabel("SERVEUR "+ titre_serveur);
            label[1]=new JLabel("FILE : "+ file_choisi);
            setXX(x);
            setYY(y);
            add(label[1]);
            // add(label[0]);
            setBounds(getXX(), getYY(), 100, 50);
            setTitle("SERVEUR "+titre_serveur);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(300,100);
            setVisible(true);
    }

    
    
}