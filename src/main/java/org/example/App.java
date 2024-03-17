package org.example;

import java.sql.*;
import java.sql.Date;

public class App {

    public static void main(String[] args) {

        System.out.println("Start coding the stage!");

        try {
            Connection cdb = Connectdb.getInstance();
            App.selectjoin(cdb);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public static void populate_tablec(Connection cdb) {

        try {
            for (int i = 1001; i <= 2000; i++) {
                System.out.println(i);
                String sql = " insert into table_c (idc,name)"
                        + " values (?, ?)";

                PreparedStatement preparedStmt = cdb.prepareStatement(sql);
                preparedStmt.setInt(1, i);
                preparedStmt.setString(2, "name" + Integer.toString(i));
                preparedStmt.execute();

            }
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
    }

    public static void populate_tableb(Connection cdb) {

        try {
            for (int i = 0; i <= 1000; i++) {
                System.out.println(i);
                String sql = " insert into table_b (idb,name,birthday,age,cfk)"
                        + " values (?, ?, ?, ?, ?)";

                PreparedStatement preparedStmt = cdb.prepareStatement(sql);
                preparedStmt.setInt(1, i);
                preparedStmt.setString(2, "name" + Integer.toString(i));
                preparedStmt.setDate(3, null);
                preparedStmt.setInt(4, i);
                preparedStmt.setInt(5, i);

                preparedStmt.execute();

            }
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
    }

    public static void populate_tablea(Connection cdb) {

        Date tdate = new Date(1);

        try {
            for (int i = 0; i <= 1000; i++) {
                System.out.println(i);
                String sql = " insert into table_a (ida,name,birthday,age,bfk)"
                        + " values (?, ?, ?, ?, ?)";

                PreparedStatement preparedStmt = cdb.prepareStatement(sql);
                preparedStmt.setInt(1, i);
                preparedStmt.setString(2, "name" + Integer.toString(i));
                preparedStmt.setDate(3, tdate);
                preparedStmt.setInt(4, i);
                preparedStmt.setInt(5, i);

                preparedStmt.execute();

            }
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
    }

    public static void selectjoin(Connection cdb) {
        try {
            long startTime = System.currentTimeMillis();

            String sql = "SELECT table_a.ida , table_a.name , table_a.birthday ,b.idb,b.name FROM table_a INNER JOIN table_b b ON table_a.bfk = b.idb;";

            Statement st = cdb.createStatement();
            ResultSet rs = st.executeQuery(sql);

            long endTime = System.currentTimeMillis();
            System.out.println("Execution Time: " + (endTime - startTime) + " ms");

            // while (rs.next()) {
            // System.out.println(rs.getString(1));
            // System.out.println(rs.getString(2));
            // System.out.println(rs.getString(3));
            // System.out.println(rs.getString(4));
            // System.out.println(rs.getString(5));

            // }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

    }

}
