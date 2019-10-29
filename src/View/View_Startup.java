package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class View_Startup extends JFrame {

    //Components name tutorial: <lower case letter for component type> + <Uppercase component's panel> + <component's name and function>

    //<editor-fold desc="Class fields">
        public JPanel mainPanel;
        public CardLayout CL;

    //main window
        JPanel pMain;

        JLabel lStartup;
        JButton bMainLogin, bMainRegister, bMainExit;

    //login window
        JPanel pLogin;

        JLabel lLoginUser,lLoginPassword;
        public JTextField tfLoginUser;
        public JPasswordField pfLoginPassword;
        JButton bLoginLogin,bLoginBack;

    //register window
        JPanel pRegister;

        JLabel lRegisterName,lRegisterSurname,lRegisterLogin,lRegisterPassword,lRegisterConfPassword;
        public JTextField tfRegisterName;
        public JTextField tfRegisterSurname;
        public JTextField tfRegisterLogin;
        public JPasswordField pfRegisterPassword,pfRegisterConfPassword;
        JButton bRegisterRegister,bRegisterBack;
    //</editor-fold>


    public View_Startup(){

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
            pMain.add(bMainLogin);

            bMainRegister = new JButton("Register");
            bMainRegister.setBounds(270,240,100,50);
            pMain.add(bMainRegister);

            bMainExit = new JButton("Exit");
            bMainExit.setBounds(270,300,100,50);
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
            pLogin.add(bLoginLogin);

            bLoginBack = new JButton("Back");
            bLoginBack.setBounds(530,300,100,50);
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
            pRegister.add(bRegisterRegister);

            bRegisterBack = new JButton("Back");
            bRegisterBack.setBounds(530,300,100,50);
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

            if(settings.getProperty("Theme").equals("2")){
                pMain.setBackground(Color.gray);
                bMainLogin.setBackground(Color.darkGray);
                bMainLogin.setForeground(Color.white);
                bMainRegister.setBackground(Color.darkGray);
                bMainRegister.setForeground(Color.white);
                bMainExit.setBackground(Color.darkGray);
                bMainExit.setForeground(Color.white);

                pLogin.setBackground(Color.gray);
                bLoginLogin.setBackground(Color.darkGray);
                bLoginLogin.setForeground(Color.white);
                bLoginBack.setBackground(Color.darkGray);
                bLoginBack.setForeground(Color.white);

                pRegister.setBackground(Color.gray);
                bRegisterRegister.setBackground(Color.darkGray);
                bRegisterRegister.setForeground(Color.white);
                bRegisterBack.setBackground(Color.darkGray);
                bRegisterBack.setForeground(Color.white);
            }
            if(settings.getProperty("Language").equals("Polski")){
                bMainLogin.setText("Zalouj sie");
                bMainRegister.setText("Zarejestruj sie");
                bMainExit.setText("Wyjdz");
                bLoginLogin.setText("Zaloguj");
                bLoginBack.setText("Wstecz");
                bRegisterRegister.setText("Zarejestruj");
                bRegisterBack.setText("Wstecz");
                lLoginUser.setText("Uzytkownik");
                lLoginPassword.setText("Haslo");
                lRegisterName.setText("Imie:");
                lRegisterSurname.setText("Nazwisko:");
                lRegisterPassword.setText("Haslo:");
                lRegisterConfPassword.setText("Potw. haslo:");
            }

            this.add(mainPanel);
            this.setUndecorated(true);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.setVisible(true);
            bMainLogin.requestFocus();
        //</editor-fold>
    }

    //<editor-fold desc="//Main listeners">
        public void addStartupMainLogin(ActionListener listener){
            bMainLogin.addActionListener(listener);
        }

        public void addStartupMainRegister(ActionListener listener){
            bMainRegister.addActionListener(listener);
        }

        public void addStartupMainExit(ActionListener listener){
            bMainExit.addActionListener(listener);
        }
    //</editor-fold>

    //<editor-fold desc="//Login listeners">
        public void addStartupLoginLogin(ActionListener listener){
            bLoginLogin.addActionListener(listener);
        }

        public void addStartupLoginBack(ActionListener listener){
            bLoginBack.addActionListener(listener);
        }
    //</editor-fold>

    //<editor-fold desc="//Register listeners">
        public void addStartupRegisterRegister(ActionListener listener){
            bRegisterRegister.addActionListener(listener);
        }

        public void addStartupRegisterBack(ActionListener listener){
            bRegisterBack.addActionListener(listener);
        }
    //</editor-fold>
}