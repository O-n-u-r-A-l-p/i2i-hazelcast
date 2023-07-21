package com.hazelcast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;

public class InsertMySql {

	public static void main(String[] args) {
		
		try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test", "root", "12345");
            Statement stmt = con.createStatement();
            
            Random rand = new Random();
            long start = System.nanoTime();
            for(int i = 0; i < 100000; i++){
                stmt.executeUpdate("INSERT INTO NUMBERS(num) VALUES("+rand.nextInt(100000)+")");
            }
            
            CalculateTime time = new CalculateTime();
            time.calculateTime(start);
        }
		
        catch(Exception e)
        {
            System.out.println(e);
        }
	}
}
