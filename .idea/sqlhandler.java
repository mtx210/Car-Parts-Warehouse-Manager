import java.sql.*;
import java.util.ArrayList;

public class sqlhandler {


    public static void main(String[] args){


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

    static public ArrayList<ArrayList<String>> selector(String query){
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

    public void inserter(int loc, String catNum, int price, int sPrice, int year, String make, String model, String bodytype, String name, String color){
        try{
            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:55555/katalogCzesci","root","");
            Statement st = dbConnection.createStatement();

            String query = "INSERT INTO parts (id_loc,catalogNumber,price,shippingPrice,year,make,model,bodytype,name,color) "+
                    "VALUES ("+loc+","+catNum+","+price+","+sPrice+","+year+","+make+","+model+","+bodytype+","+name+","+color+");";

            ResultSet rs = st.executeQuery(query);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleter(){

    }
}