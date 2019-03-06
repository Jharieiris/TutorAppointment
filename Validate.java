/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbean;

/**
 *
 * @author jhari
 */
import java.sql.*;
public class Validate {
    static public Connection con;
    public static void connect() throws ClassNotFoundException {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("After for name");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tutorappointment?useSSL=false","root","root");
            System.out.println("After driver");
        }
        catch (Exception e) {}
        
    }
    
    public static boolean checkUser (int UVI_id, String UVI_password) throws ClassNotFoundException, SQLException{
        boolean st= false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("After for name");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tutorappointment?useSSL=false","root","root");
            System.out.println("After driver");
            System.out.println("After driver");
            PreparedStatement ps= con.prepareStatement("select * from student_info WHERE UVI_ID= ? and password = ?");
            System.out.println("After driver"+ UVI_id + UVI_password);
           ps.setInt(1, 10);
          ps.setString(2, "hello");
            ResultSet rs = ps.executeQuery();
            System.out.println("After executequery");
            if (rs.next()){
             System.out.println("After no next execute");
            st= true;
            }
            else{
                System.out.println(" NO");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
           
        }
        return st;
    }
}
