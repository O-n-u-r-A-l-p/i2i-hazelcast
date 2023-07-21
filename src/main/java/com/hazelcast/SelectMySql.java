package com.hazelcast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectMySql {

	public static void main(String[] args) {

		try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test", "root", "12345");
            Statement stmt = con.createStatement();
            
            int number;
            long start = System.nanoTime();
            for(int i = 0; i < 20000; i++){
                ResultSet rs = stmt.executeQuery("SELECT num FROM NUMBERS");
                rs.next();
                number = rs.getInt("num");
                System.out.println(number);
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
