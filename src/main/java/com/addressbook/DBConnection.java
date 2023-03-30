package com.addressbook;

import javax.xml.transform.Result;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnection {
Connection con;
PreparedStatement pstmt;
ResultSet rs;
String input;
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
DBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book_service", "root", "password");
            System.out.println("connection established........");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void display() throws Exception {
        pstmt = con.prepareStatement("SELECT * FROM address_book;");
        rs = pstmt.executeQuery();

        while (rs.next()){
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)
                    +" "+rs.getString(4)+"  "+rs.getString(5)
                    +"  "+rs.getString(6)+"  "+rs.getString(7)
                    +"  "+rs.getString(8)+"  "+rs.getString(9)
                    +"  "+rs.getString(10));
        }

    }
    public void countDetailDB() throws Exception {
        System.out.println("Enter the name of city");
        input = br.readLine();
        pstmt = con.prepareStatement("SELECT COUNT(*) FROM address_book WHERE city = ?");
        pstmt.setString(1,input);
        rs = pstmt.executeQuery();
        while (rs.next())
            System.out.println(rs.getInt(1));

    }
    public void addDB() throws Exception {
        ContactPerson contacts = new ContactPerson();
        pstmt = con.prepareStatement("INSERT INTO address_book(firstname,lastname,address,city,state,zip,phone,email,type) " +
                "VALUES (?,?,?,?,?,?,?,?,?)");
        pstmt.setString(1,contacts.getFirstName());
        pstmt.setString(2,contacts.getLastName());
        pstmt.setString(3,contacts.getAddress());
        pstmt.setString(4,contacts.getCity());
        pstmt.setString(5,contacts.getState());
        pstmt.setString(6,contacts.getZip());
        pstmt.setString(7,contacts.getPhoneNumber());
        pstmt.setString(8,contacts.getEmail());
        pstmt.setString(9,contacts.getType());
        pstmt.executeUpdate();

    }

    public void close() throws Exception{
    con.close();
    }

}
