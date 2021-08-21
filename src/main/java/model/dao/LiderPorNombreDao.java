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
import model.vo.LiderPorNombre;

public class LiderPorNombreDao {
   
    public ArrayList<LiderPorNombre> rankingLiderPorNombre() throws SQLException {
        ArrayList<LiderPorNombre> respuesta = new ArrayList<LiderPorNombre>();
        Connection conexion = JDBCUtilities.getConnection();

        try{
                String Consulta = "select ID_lider,Nombre,Primer_Apellido from Lider l where l.Primer_Apellido like('%z') order by Nombre ASC ";

                PreparedStatement statement = conexion.prepareStatement(Consulta);
                ResultSet resultSet = statement.executeQuery();

                while(resultSet.next()){
                    LiderPorNombre liderPorNombre= new LiderPorNombre();
                    liderPorNombre.setIdLider(resultSet.getInt("ID_Lider"));
                    liderPorNombre.setNombre(resultSet.getString("Nombre"));
                    liderPorNombre.setApellido(resultSet.getString("Primer_Apellido"));
                    respuesta.add(liderPorNombre);
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
