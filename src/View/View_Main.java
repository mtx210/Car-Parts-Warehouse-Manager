package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class View_Main extends JFrame {

    //Components name tutorial: <lower case letter for component type> + <Uppercase component's panel> + <component's name and function>

    //<editor-fold desc="Class fields">
        public JPanel mainPanel;
        public CardLayout CL;

    //main window
        JPanel pMain;

        ImageIcon iBG;
        JLabel lMainStartup,lBg;
        JButton bMainParts,bMainWarehouse,bMainCustomers,bMainOrders,bMainSettings,bMainExit;

    //parts window
        public JPanel pParts;

        public JTable tParts;
        public JScrollPane spParts;
        JButton bPartsUpdate,bPartsAdd,bPartsDelete,bPartsEdit,bPartsBack;

    //warehouse window
        JPanel pWarehouse;

        JLabel lBgWarehouse;
        ImageIcon iBGWarehouse;
        JButton bWarehouseInfo,bWarehouseBack;

    //customers window
        JPanel pCustomers;



    //orders window
        JPanel pOrders;



    //settings window
        JPanel pSettings;


    //</editor-fold>


    public View_Main() {

        //<editor-fold desc="mi">
        Properties settings = new Properties();
        try {
            FileInputStream in = new FileInputStream("settings.properties");
            settings.load(in);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //</editor-fold>

        //<editor-fold desc="//window">
            this.setSize(1280,720);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        //</editor-fold>

        //<editor-fold desc="//setting Main Panel">
            pMain = new JPanel();
            pMain.setLayout(null);

            iBG = new ImageIcon("imgs/mainMenu.jpg");

            lMainStartup = new JLabel("Virtual Warehouse v1.0 by M&M Inc.",SwingConstants.CENTER);
            lMainStartup.setFont(new Font("Serif",Font.BOLD,30));
            lMainStartup.setForeground(Color.ORANGE);
            lMainStartup.setBounds(240,10,800,100);
            pMain.add(lMainStartup);

            bMainParts = new JButton("Parts");
            bMainParts.setBounds(10,350,100,50);
            pMain.add(bMainParts);

            bMainWarehouse = new JButton("Warehouse");
            bMainWarehouse.setBounds(10,410,100,50);
            pMain.add(bMainWarehouse);

            bMainCustomers = new JButton("Customers");
            bMainCustomers.setBounds(10,470,100,50);
            pMain.add(bMainCustomers);

            bMainOrders = new JButton("Orders");
            bMainOrders.setBounds(10,530,100,50);
            pMain.add(bMainOrders);

            bMainSettings = new JButton("Settings");
            bMainSettings.setBounds(10,590,100,50);
            pMain.add(bMainSettings);

            bMainExit = new JButton("Exit");
            bMainExit.setBounds(10,650,100,50);
            pMain.add(bMainExit);


        //</editor-fold>

        //<editor-fold desc="//setting Parts Panel">
            pParts = new JPanel();
            pParts.setLayout(null);


            bPartsUpdate = new JButton();
            ImageIcon iUpdate = new ImageIcon("imgs/update.png");
            bPartsUpdate.setIcon(iUpdate);
            bPartsUpdate.setBounds(1040,10,50,50);
            bPartsUpdate.setBorderPainted(false);
            pParts.add(bPartsUpdate);

            bPartsAdd = new JButton();
            ImageIcon iAdd = new ImageIcon("imgs/add.png");
            bPartsAdd.setIcon(iAdd);
            bPartsAdd.setBounds(1110,10,50,50);
            bPartsAdd.setBorderPainted(false);
            pParts.add(bPartsAdd);

            bPartsDelete = new JButton();
            ImageIcon iDelete = new ImageIcon("imgs/delete.png");
            bPartsDelete.setIcon(iDelete);
            bPartsDelete.setBounds(1165,10,50,50);
            bPartsDelete.setBorderPainted(false);
            pParts.add(bPartsDelete);

            bPartsEdit = new JButton();
            ImageIcon iEdit = new ImageIcon("imgs/edit.png");
            bPartsEdit.setIcon(iEdit);
            bPartsEdit.setBounds(1220,10,50,50);
            bPartsEdit.setBorderPainted(false);
            pParts.add(bPartsEdit);

            bPartsBack = new JButton();
            ImageIcon iBack = new ImageIcon("imgs/back.png");
            bPartsBack.setIcon(iBack);
            bPartsBack.setBounds(10,10,50,50);
            bPartsBack.setBorderPainted(false);
            pParts.add(bPartsBack);

            String data[][]={ {"-","-","-","-","-","-","-","-","-","-","-"}};
            String column[]={"ID","LOCALIZATION","CATALOG NUMBER","PRICE","SHIPPING PRICE","YEAR","MAKE","MODEL","BODYTYPE","NAME","COLOR CODE"};
            tParts = new JTable(data,column);
            tParts.setBounds(30,40,200,300);
            spParts = new JScrollPane(tParts);
            spParts.setBounds(10,60,1260,640);
            pParts.add(spParts);
        //</editor-fold>

        //<editor-fold desc="//setting Warehouse Panel">
            pWarehouse = new JPanel();
            pWarehouse.setLayout(null);

            iBGWarehouse = new ImageIcon("imgs/warehouse.png");

            bWarehouseInfo = new JButton();
            ImageIcon iWInfo = new ImageIcon("imgs/info.png");
            bWarehouseInfo.setIcon(iWInfo);
            bWarehouseInfo.setBounds(70,10,50,50);
            bWarehouseInfo.setBorderPainted(false);
            pWarehouse.add(bWarehouseInfo);

            bWarehouseBack = new JButton();
            ImageIcon iWBack = new ImageIcon("imgs/back.png");
            bWarehouseBack.setIcon(iWBack);
            bWarehouseBack.setBounds(10,10,50,50);
            bWarehouseBack.setBorderPainted(false);
            pWarehouse.add(bWarehouseBack);

            lBgWarehouse = new JLabel(iBGWarehouse);
            lBgWarehouse.setBounds(0,0,1280,720);
            pWarehouse.add(lBgWarehouse);
        //</editor-fold>

        //<editor-fold desc="//setting Customers Panel">
            pCustomers = new JPanel();
            pCustomers.setLayout(null);


        //</editor-fold>

        //<editor-fold desc="//setting Orders Panel">
            pOrders = new JPanel();
            pOrders.setLayout(null);


        //</editor-fold>

        //<editor-fold desc="//setting Settings Panel">
            pSettings = new JPanel();
            pSettings.setLayout(null);


        //</editor-fold>

        //<editor-fold desc="//setting CardLayout">
            mainPanel = new JPanel();
            CL = new CardLayout();
            mainPanel.setLayout(CL);
            mainPanel.add(pMain,"main");
            mainPanel.add(pParts,"parts");
            mainPanel.add(pWarehouse,"warehouse");
            mainPanel.add(pCustomers,"customers");
            mainPanel.add(pOrders,"orders");
            mainPanel.add(pSettings,"settings");
            CL.show(mainPanel,"main");
        //</editor-fold>

        //<editor-fold desc="//finishing window">
        //<editor-fold desc="niaa">
        if(settings.getProperty("Theme").equals("2")){
                bMainParts.setBackground(Color.darkGray);
                bMainWarehouse.setBackground(Color.darkGray);
                bMainCustomers.setBackground(Color.darkGray);
                bMainOrders.setBackground(Color.darkGray);
                bMainSettings.setBackground(Color.darkGray);
                bMainExit.setBackground(Color.darkGray);
                bMainParts.setForeground(Color.white);
                bMainWarehouse.setForeground(Color.white);
                bMainCustomers.setForeground(Color.white);
                bMainOrders.setForeground(Color.white);
                bMainSettings.setForeground(Color.white);
                bMainExit.setForeground(Color.white);

                ImageIcon dark = new ImageIcon("imgs/Dark/warehouseDark.png");
                lBgWarehouse.setIcon(dark);

                ImageIcon iWInfo2 = new ImageIcon("imgs/Dark/info.png");
                bWarehouseInfo.setIcon(iWInfo2);
                ImageIcon iWBack2 = new ImageIcon("imgs/Dark/back.png");
                bWarehouseBack.setIcon(iWBack2);

                pParts.setBackground(Color.gray);
                ImageIcon iUpdate2 = new ImageIcon("imgs/Dark/update.png");
                bPartsUpdate.setIcon(iUpdate2);
                ImageIcon iAdd2 = new ImageIcon("imgs/Dark/add.png");
                bPartsAdd.setIcon(iAdd2);
                ImageIcon iDelete2 = new ImageIcon("imgs/Dark/delete.png");
                bPartsDelete.setIcon(iDelete2);
                ImageIcon iEdit2 = new ImageIcon("imgs/Dark/edit.png");
                bPartsEdit.setIcon(iEdit2);
                ImageIcon iBack2 = new ImageIcon("imgs/Dark/back.png");
                bPartsBack.setIcon(iBack2);
            }
        //</editor-fold>

            lBg = new JLabel(iBG);
            lBg.setBounds(0,0,1280,720);
            pMain.add(lBg);

            this.add(mainPanel);
            this.setUndecorated(true);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.setVisible(true);
            bMainParts.requestFocus();
        //</editor-fold>
    }

    public static void main(String[] args){
        new View_Main();
    }

    //<editor-fold desc="//Main listeners">
        public void addMainMainParts(ActionListener listener){
            bMainParts.addActionListener(listener);
        }

        public void addMainMainWarehouse(ActionListener listener){
            bMainWarehouse.addActionListener(listener);
        }

        public void addMainMainCustomers(ActionListener listener){
            bMainCustomers.addActionListener(listener);
        }

        public void addMainMainOrders(ActionListener listener){
            bMainOrders.addActionListener(listener);
        }

        public void addMainMainSettings(ActionListener listener){
            bMainSettings.addActionListener(listener);
        }

        public void addMainMainExit(ActionListener listener){
            bMainExit.addActionListener(listener);
        }

    //</editor-fold>

    //<editor-fold desc="//Parts listeners">
        public void addMainPartsUpdate(ActionListener listener){
            bPartsUpdate.addActionListener(listener);
        }

        public void addMainPartsAdd(ActionListener listener){
            bPartsAdd.addActionListener(listener);
        }

        public void addMainPartsDelete(ActionListener listener){
            bPartsDelete.addActionListener(listener);
        }

        public void addMainPartsEdit(ActionListener listener){
            bPartsEdit.addActionListener(listener);
        }

        public void addMainPartsBack(ActionListener listener){
            bPartsBack.addActionListener(listener);
        }
    //</editor-fold>

    //<editor-fold desc="//Warehouse listeners">
        public void addMainWarehouseBack(ActionListener listener){
            bWarehouseBack.addActionListener(listener);
        }

        public void addMainWarehouseInfo(ActionListener listener){
            bWarehouseInfo.addActionListener(listener);
        }
    //</editor-fold>

    //<editor-fold desc="//Customers listeners">
        //public void addStartupMainLogin(ActionListener listener){
            //.addActionListener(listener);
        //}


    //</editor-fold>

    //<editor-fold desc="//Orders listeners">
        //public void addStartupMainLogin(ActionListener listener){
            //.addActionListener(listener);
        //}


    //</editor-fold>

    //<editor-fold desc="//Settings listeners">
        //public void addStartupMainLogin(ActionListener listener){
            //.addActionListener(listener);
        //}


    //</editor-fold>
}