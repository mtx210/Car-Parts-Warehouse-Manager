import View.View_Startup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

    static Process databaseProcess;

    public static void main(String[] args) {

        try{ databaseProcess = Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd database && mysql_start.cmd\""); }catch (Exception e){}

        //<editor-fold desc="Settings">
        File file = new File("settings.properties");
        if(file.exists()){} else{
            Properties settings = new Properties();
            settings.setProperty("Theme","1");
            settings.setProperty("Language","English");

            FileOutputStream out = null;
            try {
                out = new FileOutputStream("settings.properties");
                settings.store(out,null);
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //</editor-fold>

        View_Startup view = new View_Startup();
        Model model = new Model(view);
        Controller controller = new Controller(view,model);
    }
}