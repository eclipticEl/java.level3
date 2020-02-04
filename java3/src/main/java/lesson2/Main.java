package lesson2;

import java.sql.*;
import java.text.Format;

public class Main {
    private static Connection conn;


    public static boolean connect() throws SQLException {

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:testDB.db");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return  true;
    }

    public static void disconnect(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet execDMLQuery(String queryStr, String[] params){

        try (PreparedStatement ps = conn.prepareStatement(queryStr)) {
            if (params != null){
                for (int i = 0; i <params.length ; i++) {
                   if (params[i].matches("[+-]?\\d+")) {
                      ps.setInt(i+1, Integer.parseInt(params[i]));
                   }
                   else  if (params[i].matches("[+-]?\\d+\\.\\d+")){
                       ps.setDouble(i+1, Double.parseDouble(params[i]));
                   }
                   else {
                       ps.setString(i+1,params[i]);
                   }
                }
            }

            ResultSet rs = null;
            if (queryStr.toUpperCase().contains("SELECT")) {
                rs = ps.executeQuery();
// блок вывода работает здесь, при возвращении в main rs уже пуст ... как сделать правильно?
                ResultSetMetaData rsmd = rs.getMetaData();

                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.print(rsmd.getColumnName(i) + "\t ");
                }
                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= 3; i++) {
                        System.out.print(rs.getString(i) + "\t ");
                    }
                    System.out.println();
                }


            }
            else {
                ps.executeUpdate();
            }

            return rs;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void execDDLTableQuery(String tableName, ColumnAttribute[] columns, String manipulationType){
        StringBuilder strquery = new StringBuilder();
        if (manipulationType.toUpperCase().equals("CREATE")){
            if (columns.length==0){
                System.out.println("В таблице должен быть хотя бы один столбец");
                return;
            }
            else{
                strquery.append("CREATE TABLE ");
                strquery.append(tableName).append("(");
                for (int i = 0; i < columns.length; i++) {
                    strquery.append(columns[i].getName()).append(" ").append(columns[i].getType()).append(" ").append(columns[i].getAddOptions()).append(",\n");
                }
                strquery.delete(strquery.length()-2, strquery.length());
                strquery.append(");");

            }

        }
        else if (manipulationType.toUpperCase().equals("DROP")){
            strquery.append("DROP TABLE ").append(tableName);
        }
        else{
            System.out.println("Неизвестный тип операции");
            return;
        }

        try (Statement ps = conn.createStatement()){
            ps.execute(strquery.toString());
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        try {
            connect();
            String[] insValues = new String[2];
            insValues[1]= "Audi";
            for (int i = 3; i < 10; i++) {
                insValues[0]= "A"+i;
                execDMLQuery("INSERT INTO product(name, label) VALUES(?,?)", insValues);
            }
            insValues[1]= "BMW";
            for (int i = 1; i < 7; i++) {
                insValues[0]= "X"+i;
                execDMLQuery("INSERT INTO product(name, label) VALUES(?,?)", insValues);
            }

            String[] updValues = {"Q3" , "Audi","A9"};
            execDMLQuery("UPDATE product SET name = ? WHERE  label=? AND name=?", updValues);


            String[] delValues = {"Audi"};
            execDMLQuery("DELETE FROM product WHERE  label=?", delValues);

            String[] vals = {"BMW"};
            ResultSet  rs =execDMLQuery("SELECT * FROM product WHERE  label=?",vals);
/* здесь брок вывода не работает, к этому времени  rs.open = false. Срабатывает только внутри execDMLQuery. Подскажите Как правильно возвращать ResultSet, чтобы он бы с данными,
            ResultSetMetaData rsmd = rs.getMetaData();

            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.print(rsmd.getColumnName(i) + "\t ");
            }
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= 3; i++) {
                    System.out.print(rs.getString(i) + "\t ");
                }
                System.out.println();
            }
*/
            ColumnAttribute[] cols = new ColumnAttribute[3];
            cols[0] = new ColumnAttribute("id", "INTEGER", "PRIMARY KEY AUTOINCREMENT");
            cols[1] = new ColumnAttribute( "product_id", "INTEGER", "REFERENCES product (id)");
            cols[2] = new ColumnAttribute("year", "INTEGER", "NOT NULL");
            execDDLTableQuery("catalog", cols,"CREATE");
//            execDDLTableQuery("catalog", cols,"DROP");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

    }
}
