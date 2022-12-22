package affichage;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class MyFrame extends JFrame {
    MyPanel p=new MyPanel();
  
    public MyPanel getP() {
        return p;
    }
    public void setP(MyPanel p) {
        this.p = p;
    }
    public MyFrame(MyPanel panel){
        setP(panel);
    }
    public MyFrame() {
            add(getP());
         //   add(getPp());
            setBounds(500, 300, 400, 300);
            setTitle("File transfer");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500,200);
         //   setVisible(true);
    }

    
    
}