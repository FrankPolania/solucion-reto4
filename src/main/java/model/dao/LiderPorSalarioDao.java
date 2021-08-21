package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.LiderPorSalario;

public class LiderPorSalarioDao {
    
    public ArrayList<LiderPorSalario> rankingLiderPorSalario() throws SQLException {
        ArrayList<LiderPorSalario> respuesta = new ArrayList<LiderPorSalario>();
        Connection conexion = JDBCUtilities.getConnection();

        try{
                String Consulta = "SELECT Id_Lider, Nombre,Primer_Apellido, salario FROM Lider WHERE salario <= 500000 ORDER BY salario";

                PreparedStatement statement = conexion.prepareStatement(Consulta);
                ResultSet resultSet = statement.executeQuery();

                while(resultSet.next()){
                    LiderPorSalario liderPorSalario= new LiderPorSalario();
                    liderPorSalario.SetNombre(resultSet.getString("Nombre"));
                    liderPorSalario.setApellido(resultSet.getString("Primer_apellido"));
                    liderPorSalario.setIdLider(resultSet.getInt("Id_Lider"));
                    liderPorSalario.setSalario(resultSet.getInt("Salario"));
                    respuesta.add(liderPorSalario);
                }
                resultSet.close();
                statement.close();

        }catch(SQLException e){
            System.err.println("error consultando los lideres por salario:" + e);
        }finally{
            
        }

       

        return respuesta;
        // Su código
    }
    
}
