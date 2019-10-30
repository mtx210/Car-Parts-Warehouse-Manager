package Controller;

import View.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {

    public Controller(){

        new View_Startup(this);
    }

    /*
    //<editor-fold desc="Main listeners">

        //main panel

        class MainMainPartsListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                view_main.CL.show(view_main.mainPanel,"parts");
            }
        }

        class MainMainWarehousesListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                view_main.CL.show(view_main.mainPanel,"warehouse");
            }
        }

        class MainMainCustomersListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                view_main.CL.show(view_main.mainPanel,"customers");
            }
        }

        class MainMainOrdersListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                view_main.CL.show(view_main.mainPanel,"orders");
            }
        }

        class MainMainSettingsListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                view_main.CL.show(view_main.mainPanel,"settings");
            }
        }

        class MainMainExitListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(view_main,"Are you sure you want to close the program?");
                if(a==JOptionPane.YES_OPTION){
                    view_main.dispose();
                }
            }
        }

        //parts panel

        class MainPartsUpdateListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<ArrayList<String>> parts = model.selector("select * from parts;");

                String data[][] = model.fill(parts,parts.size());
                String column[]={"ID","LOCALIZATION","CATALOG NUMBER","PRICE","SHIPPING PRICE","YEAR","MAKE","MODEL","BODYTYPE","NAME","COLOR CODE"};
                view_main.tParts = new JTable(data,column);
                view_main.tParts.setBounds(30,40,200,300);
                view_main.spParts = new JScrollPane(view_main.tParts);
                view_main.spParts.setBounds(10,60,1260,640);
                view_main.pParts.add(view_main.spParts);
            }
        }

        class MainPartsAddListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.view_addPart = new View_addPart();
                model.view_addPart = Controller.view_addPart;
                Controller.view_addPart.addNewPartApply(new addPartApplyListener());
                Controller.view_addPart.addNewPartCancel(new addPartCancelListener());

            }
        }

        class MainPartsDeleteListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.view_delPart = new View_delPart();
                model.view_delPart = Controller.view_delPart;
                Controller.view_delPart.addDelPartDelete(new delPartApplyListener());
                Controller.view_delPart.addDelPartCancel(new delPartCancelListener());
            }
        }

        class MainPartsEditListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }

        class MainPartsBackListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                view_main.CL.show(view_main.mainPanel,"main");
            }
        }

        //warehouse panel

        class MainWarehouseBackListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                view_main.CL.show(view_main.mainPanel,"main");
            }
        }

        class MainWarehouseInfoListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(view_main,"Database organization is as follows:\n" +
                        "<shelf letter>,<row number>,<column number>\n\n"+
                        "Example: \n2008 BMW E60 left front door location:\n"+
                        "B 3 3");
            }
        }

        //settings panel



    //</editor-fold>

    //<editor-fold desc="Add Part listeners">
        class addPartApplyListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                model.insertPart(Integer.parseInt(view_addPart.id_loc.getText()),
                        view_addPart.catalogNr.getText(),
                        Integer.parseInt(view_addPart.price.getText()),
                        Integer.parseInt(view_addPart.sPrice.getText()),
                        Integer.parseInt(view_addPart.year.getText()),
                        view_addPart.make.getText(),
                        view_addPart.model.getText(),
                        view_addPart.body.getText(),
                        view_addPart.name.getText(),
                        view_addPart.color.getText());

                JOptionPane.showMessageDialog(view_addPart,"Part added successfully!");
                view_addPart.dispose();

                //<editor-fold desc="Updating part list">
                ArrayList<ArrayList<String>> parts = model.selector("select * from parts;");

                String data[][] = model.fill(parts,parts.size());
                String column[]={"ID","LOCALIZATION","CATALOG NUMBER","PRICE","SHIPPING PRICE","YEAR","MAKE","MODEL","BODYTYPE","NAME","COLOR CODE"};
                view_main.tParts = new JTable(data,column);
                view_main.tParts.setBounds(30,40,200,300);
                view_main.spParts = new JScrollPane(view_main.tParts);
                view_main.spParts.setBounds(10,60,1260,640);
                view_main.pParts.add(view_main.spParts);
                //</editor-fold>
            }
        }

        class addPartCancelListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(view_addPart,"Discard changes?");
                if(a==JOptionPane.YES_OPTION){
                    view_addPart.dispose();
                }
            }
        }
    //</editor-fold>

    //<editor-fold desc="Delete Part listeners">
        class delPartApplyListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {

                int a = JOptionPane.showConfirmDialog(view_addPart,"Confirm deletion");
                if(a==JOptionPane.YES_OPTION){
                    model.deletePart(Integer.parseInt(view_delPart.tfId.getText()));
                    JOptionPane.showMessageDialog(view_addPart,"Part deleted successfully!");
                    view_delPart.dispose();
                }

                //<editor-fold desc="Updating part list">
                ArrayList<ArrayList<String>> parts = model.selector("select * from parts;");

                String data[][] = model.fill(parts,parts.size());
                String column[]={"ID","LOCALIZATION","CATALOG NUMBER","PRICE","SHIPPING PRICE","YEAR","MAKE","MODEL","BODYTYPE","NAME","COLOR CODE"};
                view_main.tParts = new JTable(data,column);
                view_main.tParts.setBounds(30,40,200,300);
                view_main.spParts = new JScrollPane(view_main.tParts);
                view_main.spParts.setBounds(10,60,1260,640);
                view_main.pParts.add(view_main.spParts);
                //</editor-fold>
            }
        }

        class delPartCancelListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(view_addPart,"Discard changes?");
                if(a==JOptionPane.YES_OPTION){
                    view_delPart.dispose();
                }
            }
        }
    //</editor-fold>

    */
}