package org.example;

import java.sql.*;;

public class Connectdb {

    private static Connectdb instance;

    private Connection cdb = null;

    public Connectdb() {

    }

    private Connection connect() {
        try {

            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql:stage";
            String name = "postgres";
            String password = "4033";

            Connection db = DriverManager.getConnection(url, name, password);

            return db;

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;

    }

    public Connection getConnection() {
        return cdb;
    }

    public static Connection getInstance() throws SQLException {
        if (instance != null && !instance.getConnection().isClosed()) {
            return instance.cdb;
        } else {
            instance = new Connectdb();
            return instance.connect();
        }
    }

    public void createtbales() throws SQLException {

        Statement s = cdb.createStatement();

        s.execute("Create Table table_c" +
                "(idc int NOT NULL PRIMARY KEY," +
                "name varchar(255))");

        s.execute("Create Table table_b" +
                "(idb int NOT NULL PRIMARY KEY," +
                "name varchar(255)," +
                "birthday Date," +
                "age int," +
                "cfk int ," +
                "CONSTRAINT forg_cfk FOREIGN KEY (cfk) REFERENCES table_c(idc))");

        s.execute("Create Table table_a" +
                "(ida int NOT NULL PRIMARY KEY," +
                "name varchar(255)," +
                "birthday Date," +
                "age int," +
                "bfk int ," +
                "CONSTRAINT forg_bfk FOREIGN KEY (bfk) REFERENCES table_b(idb))");
    }

}
