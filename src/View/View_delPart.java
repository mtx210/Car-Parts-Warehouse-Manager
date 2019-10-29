package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View_delPart extends JFrame {

    //<editor-fold desc="Class fields">
        public JTextField tfId;
        JLabel Lid;
        JButton delete,abort;
    //</editor-fold>


    public View_delPart(){

        //<editor-fold desc="//window">
            this.setSize(500,500);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
            this.setLayout(null);
        //</editor-fold>

        Lid = new JLabel("Part ID:");
        Lid.setBounds(10,10,100,20);
        this.add(Lid);

        tfId = new JTextField();
        tfId.setBounds(120,10,200,20);
        this.add(tfId);

        delete = new JButton("Delete");
        delete.setBounds(10,50,100,50);
        this.add(delete);

        abort = new JButton("Cancel");
        abort.setBounds(120,50,100,50);
        this.add(abort);

        //<editor-fold desc="//finishing window">
            this.setVisible(true);
            tfId.requestFocus();
        //</editor-fold>
    }

    public void addDelPartDelete(ActionListener listener){
        delete.addActionListener(listener);
    }

    public void addDelPartCancel(ActionListener listener){
        abort.addActionListener(listener);
    }
}