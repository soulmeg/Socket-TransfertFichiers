package affichage;
import listener.*;
import java.lang.reflect.Constructor;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MyPanel extends JPanel{
    JLabel lab=new JLabel("Welcomee !!");
    JLabel label=new JLabel("choosen file");
    JButton [] btn =new JButton[2];

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JButton[] getBtn() {
        return btn;
    }

    public void setBtn(JButton[] btn) {
        this.btn = btn;
    }

    public MyPanel() {
        try {
           // MyFrame f=new MyFrame(this);
            // GridLayout layout = new GridLayout(0,2);
            // this.setLayout(layout);
            lab.setFont(new Font("tahoma",Font.ROMAN_BASELINE,15));
            getLabel().setFont(new Font("tahoma",Font.ROMAN_BASELINE,15));
            getBtn()[0]=new JButton("Choose file");
            getBtn()[0].setBounds(10, 20, 20, 20);
            getBtn()[1]=new JButton("Envoyer");
            // getBtn()[0].addMouseListener(new Mouse(this));
            // getBtn()[1].addMouseListener(new Mouse(this));
            add(lab);
            add(btn[0]);
            add(getLabel());
            add(btn[1]);
          
            
        } catch (Exception e) {

            // TODO: handle exception
        }
       
    }




    
}