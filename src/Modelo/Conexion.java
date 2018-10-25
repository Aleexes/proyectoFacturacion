package Modelo;
import java.sql.*;

public class Conexion {
    
    public Conexion(){
        
    }
    
    public Connection getConexion(){
        Connection con = null;
        try{
            
            Class.forName("com.mysql.jdbc.Driver"); //CARGO EL DRIVER A LA API DE JDBC
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/facturaciondb", "root", "Root123"); //OBTENGO LA CONEXION
            System.out.println("conexion establecida!");
            if (con != null) {
                //System.out.println("Base de datos disponible...");
            }
            
        }catch(SQLException ex){
            System.out.println(ex);
        }catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
    
}
