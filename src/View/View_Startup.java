package View;

import Controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class View_Startup extends JFrame implements ActionListener {

    //Components name tutorial: <lower case letter for component type> + <Uppercase component's panel> + <component's name and function>

    //<editor-fold desc="Class fields">
    Controller controller;
    private JPanel mainPanel;
    private CardLayout CL;

    //main window
    private JPanel pMain;
    private JLabel lStartup;
    private JButton bMainLogin, bMainRegister, bMainExit;

    //login window
    private JPanel pLogin;
    private JLabel lLoginUser,lLoginPassword;
    private JTextField tfLoginUser;
    private JPasswordField pfLoginPassword;
    private JButton bLoginLogin,bLoginBack;

    //register window
    private JPanel pRegister;
    private JLabel lRegisterName,lRegisterSurname,lRegisterLogin,lRegisterPassword,lRegisterConfPassword;
    private JTextField tfRegisterName, tfRegisterSurname, tfRegisterLogin;
    private JPasswordField pfRegisterPassword,pfRegisterConfPassword;
    private JButton bRegisterRegister,bRegisterBack;
    //</editor-fold>

    public View_Startup(Controller controller){

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

        this.controller = controller;

        //<editor-fold desc="//window">
        this.setSize(640,360);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        //</editor-fold>

        //<editor-fold desc="//setting Main panel">
        pMain = new JPanel();
        pMain.setLayout(null);

        lStartup = new JLabel("Virtual Warehouse v1.0 by M&M Inc.",SwingConstants.CENTER);
        lStartup.setFont(new Font("Serif",Font.BOLD,15));
        lStartup.setForeground(Color.orange);
        lStartup.setBounds(170,10,300,50);
        pMain.add(lStartup);

        bMainLogin = new JButton("Login");
        bMainLogin.setBounds(270,180,100,50);
        bMainLogin.addActionListener(this);
        pMain.add(bMainLogin);

        bMainRegister = new JButton("Register");
        bMainRegister.setBounds(270,240,100,50);
        bMainRegister.addActionListener(this);
        pMain.add(bMainRegister);

        bMainExit = new JButton("Exit");
        bMainExit.setBounds(270,300,100,50);
        bMainExit.addActionListener(this);
        pMain.add(bMainExit);
        //</editor-fold>

        //<editor-fold desc="//setting Login Panel">
        pLogin = new JPanel();
        pLogin.setLayout(null);

        lLoginUser = new JLabel("User",SwingConstants.CENTER);
        lLoginUser.setBounds(270,10,100,20);
        pLogin.add(lLoginUser);

        tfLoginUser = new JTextField();
        tfLoginUser.setBounds(220,40,200,20);
        tfLoginUser.setText("admin");
        pLogin.add(tfLoginUser);

        lLoginPassword = new JLabel("Password",SwingConstants.CENTER);
        lLoginPassword.setBounds(270,70,100,20);
        pLogin.add(lLoginPassword);

        pfLoginPassword = new JPasswordField();
        pfLoginPassword.setBounds(220,100,200,20);
        pLogin.add(pfLoginPassword);

        bLoginLogin = new JButton("Login");
        bLoginLogin.setBounds(10,300,100,50);
        bLoginLogin.addActionListener(this);
        pLogin.add(bLoginLogin);

        bLoginBack = new JButton("Back");
        bLoginBack.setBounds(530,300,100,50);
        bLoginBack.addActionListener(this);
        pLogin.add(bLoginBack);
        //</editor-fold>

        //<editor-fold desc="//setting Register Panel">
        pRegister = new JPanel();
        pRegister.setLayout(null);

        lRegisterName = new JLabel("Name:");
        lRegisterName.setBounds(10,10,150,20);
        pRegister.add(lRegisterName);

        tfRegisterName = new JTextField();
        tfRegisterName.setBounds(120,10,200,20);
        pRegister.add(tfRegisterName);

        lRegisterSurname = new JLabel("Surname:");
        lRegisterSurname.setBounds(10,40,150,20);
        pRegister.add(lRegisterSurname);

        tfRegisterSurname = new JTextField();
        tfRegisterSurname.setBounds(120,40,200,20);
        pRegister.add(tfRegisterSurname);

        lRegisterLogin = new JLabel("Login:");
        lRegisterLogin.setBounds(10,70,150,20);
        pRegister.add(lRegisterLogin);

        tfRegisterLogin = new JTextField();
        tfRegisterLogin.setBounds(120,70,200,20);
        pRegister.add(tfRegisterLogin);

        lRegisterPassword = new JLabel("Password:");
        lRegisterPassword.setBounds(10,100,150,20);
        pRegister.add(lRegisterPassword);

        pfRegisterPassword = new JPasswordField();
        pfRegisterPassword.setBounds(120,100,200,20);
        pRegister.add(pfRegisterPassword);

        lRegisterConfPassword = new JLabel("Confirm password:");
        lRegisterConfPassword.setBounds(10,130,150,20);
        pRegister.add(lRegisterConfPassword);

        pfRegisterConfPassword = new JPasswordField();
        pfRegisterConfPassword.setBounds(120,130,200,20);
        pRegister.add(pfRegisterConfPassword);

        bRegisterRegister = new JButton("Register");
        bRegisterRegister.setBounds(10,300,100,50);
        bRegisterRegister.addActionListener(this);
        pRegister.add(bRegisterRegister);

        bRegisterBack = new JButton("Back");
        bRegisterBack.setBounds(530,300,100,50);
        bRegisterBack.addActionListener(this);
        pRegister.add(bRegisterBack);
        //</editor-fold>

        //<editor-fold desc="//setting CardLayout">
        mainPanel = new JPanel();
        CL = new CardLayout();
        mainPanel.setLayout(CL);
        mainPanel.add(pMain,"startup");
        mainPanel.add(pLogin,"login");
        mainPanel.add(pRegister,"register");
        CL.show(mainPanel,"startup");
        //</editor-fold>

        //<editor-fold desc="//finishing window">
        this.add(mainPanel);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        bMainLogin.requestFocus();
        //</editor-fold>
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == bMainLogin){
            CL.show(mainPanel,"login");
            tfLoginUser.requestFocus();
        } else if(source == bMainRegister){
            CL.show(mainPanel,"register");
            tfRegisterName.requestFocus();
        } else if(source == bMainExit){
            int a = JOptionPane.showConfirmDialog(this,"Are you sure you want to close the program?");
            if(a==JOptionPane.YES_OPTION){
                this.dispose();
            }
        } else if(source == bLoginLogin){
            boolean access = false;
            //access=model.authenticateLogin(view_startup.tfLoginUser.getText(),String.valueOf(view_startup.pfLoginPassword.getPassword()));
            if(access == true){
                //nibba
            } else{
                tfLoginUser.setText("");
                pfLoginPassword.setText("");
                tfLoginUser.requestFocus();
                JOptionPane.showMessageDialog(this,"Invalid login or password!");
            }
        } else if(source == bLoginBack){
            CL.show(mainPanel,"startup");
        } else if(source == bRegisterRegister){
            if(String.valueOf(pfRegisterPassword.getPassword()).equals(String.valueOf(pfRegisterConfPassword.getPassword()))){
                //model.register(view_startup.tfRegisterLogin.getText(),String.valueOf(view_startup.pfRegisterPassword.getPassword()),view_startup.tfRegisterName.getText(),view_startup.tfRegisterSurname.getText());
                CL.show(this.mainPanel,"startup");
                JOptionPane.showMessageDialog(this,"Account created successfully!");

            } else{
                JOptionPane.showMessageDialog(this,"Passwords do not match!");
            }
        } else if(source == bRegisterBack){
            CL.show(mainPanel,"startup");
        }
    }
}