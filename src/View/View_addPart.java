package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View_addPart extends JFrame {

    //<editor-fold desc="Class fields">
        public JTextField id_loc,catalogNr,price,sPrice,year,make,model,body,name,color;
        JLabel Lid_loc,LcatalogNr,Lprice,LsPrice,Lyear,Lmake,Lmodel,Lbody,Lname,Lcolor;
        JButton apply,abort;
    //</editor-fold>


    public View_addPart(){

        //<editor-fold desc="//window">
            this.setSize(500,500);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
            this.setLayout(null);
        //</editor-fold>

        ////
        Lid_loc = new JLabel("Location:");
        Lid_loc.setBounds(10,10,100,20);
        this.add(Lid_loc);

        id_loc = new JTextField();
        id_loc.setBounds(120,10,200,20);
        this.add(id_loc);
        ////
        LcatalogNr = new JLabel("Part number:");
        LcatalogNr.setBounds(10,40,100,20);
        this.add(LcatalogNr);

        catalogNr = new JTextField();
        catalogNr.setBounds(120,40,200,20);
        this.add(catalogNr);
        ////
        Lprice = new JLabel("Price:");
        Lprice.setBounds(10,70,100,20);
        this.add(Lprice);

        price = new JTextField();
        price.setBounds(120,70,200,20);
        this.add(price);
        ////
        LsPrice = new JLabel("Shipping price:");
        LsPrice.setBounds(10,100,100,20);
        this.add(LsPrice);

        sPrice = new JTextField();
        sPrice.setBounds(120,100,200,20);
        this.add(sPrice);
        ////
        Lyear = new JLabel("Production year:");
        Lyear.setBounds(10,130,100,20);
        this.add(Lyear);

        year = new JTextField();
        year.setBounds(120,130,200,20);
        this.add(year);
        ////
        Lmake = new JLabel("Make:");
        Lmake.setBounds(10,160,100,20);
        this.add(Lmake);

        make = new JTextField();
        make.setBounds(120,160,200,20);
        this.add(make);
        ////
        Lmodel = new JLabel("Model:");
        Lmodel.setBounds(10,190,100,20);
        this.add(Lmodel);

        model = new JTextField();
        model.setBounds(120,190,200,20);
        this.add(model);
        ////
        Lbody = new JLabel("Bodytype:");
        Lbody.setBounds(10,220,100,20);
        this.add(Lbody);

        body = new JTextField();
        body.setBounds(120,220,200,20);
        this.add(body);
        ////
        Lname = new JLabel("Name:");
        Lname.setBounds(10,250,100,20);
        this.add(Lname);

        name = new JTextField();
        name.setBounds(120,250,200,20);
        this.add(name);
        ////
        Lcolor = new JLabel("Color:");
        Lcolor.setBounds(10,280,100,20);
        this.add(Lcolor);

        color = new JTextField();
        color.setBounds(120,280,200,20);
        this.add(color);

        //buttons
        apply = new JButton("Add");
        apply.setBounds(10,310,100,50);
        this.add(apply);

        abort = new JButton("Cancel");
        abort.setBounds(120,310,100,50);
        this.add(abort);

        //<editor-fold desc="//finishing window">
            this.setVisible(true);
            id_loc.requestFocus();
        //</editor-fold>
    }

    public void addNewPartApply(ActionListener listener){
        apply.addActionListener(listener);
    }

    public void addNewPartCancel(ActionListener listener){
        abort.addActionListener(listener);
    }
}