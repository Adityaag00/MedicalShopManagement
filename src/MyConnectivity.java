import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

   public class MyConnectivity {
        public static Connection con= null;
    
        public static Connection getSQLConnection(){
            try{
                Class.forName("java.sql.Driver");
                System.out.println("Class successfully found");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CLASSXIIIP","root","tiger");
                System.out.println("jdbc successfully registered");
            }
            catch(ClassNotFoundException e){
                JOptionPane.showMessageDialog(null,"Class not Found ");
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Sql Exception"+e.getMessage());

            }
            return con;
        }
    
    }
