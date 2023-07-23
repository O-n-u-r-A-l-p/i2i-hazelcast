package com.hazelcast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;

public class InsertMySql {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test", "root", "12345");
            Statement stmt = con.createStatement();

            int dataSize20k = 20000;
            Random rand = new Random();
            long start20k = System.currentTimeMillis();
            for (int i = 0; i < dataSize20k; i++) {
                stmt.executeUpdate("INSERT INTO NUMBERS(num) VALUES(" + rand.nextInt(100000) + ")");
            }
            long end20k = System.currentTimeMillis();
            long elapsedTime20k = end20k - start20k;
            System.out.println("Time taken for inserting 20000 random numbers with MySQL: " + elapsedTime20k + " ms");

            int dataSize100k = 100000;
            long start100k = System.currentTimeMillis();
            for (int i = 0; i < dataSize100k; i++) {
                stmt.executeUpdate("INSERT INTO NUMBERS(num) VALUES(" + rand.nextInt(100000) + ")");
            }
            long end100k = System.currentTimeMillis();
            long elapsedTime100k = end100k - start100k;
            System.out.println("Time taken for inserting 100000 random numbers with MySQL: " + elapsedTime100k + " ms");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
