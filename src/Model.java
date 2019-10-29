import View.View_Main;
import View.View_Startup;
import View.View_addPart;
import View.View_delPart;

import java.sql.*;
import java.util.ArrayList;

public class Model {

    //<editor-fold desc="Class fields">
    View_Startup view_startup;
    View_Main view_main;
    View_addPart view_addPart;
    View_delPart view_delPart;
    //</editor-fold>

    public Model(View_Startup view) {

        this.view_startup = view;
    }

    public boolean authenticateLogin(String login, String password){

        boolean authentication = false;
        ArrayList<ArrayList<String>> data = selector("select * from users;");

        for(int i=0 ; i<data.size() ; i++) {
            if (data.get(i).get(1).equals(login) && data.get(i).get(2).equals(password)) {
                authentication = true;
            }
        }

        return authentication;
    }

    public void register(String login, String password, String name, String surname){

        try{
            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:55555/katalogCzesci","root","");
            Statement st = dbConnection.createStatement();

            String query = "INSERT INTO users (login,password,name,surname) " +
                           "VALUES (\'"+login+"\',\'"+password+"\',\'"+name+"\',\'"+surname+"\');";

            st.executeUpdate(query);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ArrayList<String>> selector(String query){
        ArrayList<ArrayList<String>> returnValue = new ArrayList<>();

        try{
            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:55555/katalogCzesci","root","");
            Statement st = dbConnection.createStatement();

            ResultSet rs = st.executeQuery(query);

            ResultSetMetaData metadata = rs.getMetaData();
            int colNum = metadata.getColumnCount();

            while(rs.next()){
                ArrayList<String> row = new ArrayList<>(colNum);
                int i=1;
                while(i <= colNum){
                    row.add(rs.getString(i++));
                }
                returnValue.add(row);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            return returnValue;
        }
    }

    public void insertPart(int loc, String catNum, int price, int sPrice, int year, String make, String model, String bodytype, String name, String color){
        try{
            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:55555/katalogCzesci","root","");
            Statement st = dbConnection.createStatement();

            String query = "INSERT INTO parts (id_loc,catalogNumber,price,shippingPrice,year,make,model,bodytype,name,color) "+
                    "VALUES ("+loc+",\'"+catNum+"\',"+price+","+sPrice+","+year+",\'"+make+"\',\'"+model+"\',\'"+bodytype+"\',\'"+name+"\',\'"+color+"\');";

            st.executeUpdate(query);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePart(int id){
        try{
            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:55555/katalogCzesci","root","");
            Statement st = dbConnection.createStatement();

            String query = "DELETE FROM parts WHERE id_part="+id;

            st.executeUpdate(query);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public String[][] fill(ArrayList<ArrayList<String>> data,int size){

        String[][] result = new String[size][11];

        for(int i=0 ; i<data.size() ; i++){
            for(int j=0 ; j<data.get(i).size() ; j++){
                result[i][j] = data.get(i).get(j);
            }
        }

        return result;
    }
}
