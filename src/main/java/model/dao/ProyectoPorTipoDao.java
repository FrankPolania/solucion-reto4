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

import model.vo.ProyectosPorTipo;

public class ProyectoPorTipoDao { ////////////////////////////////// ************************
    
    public ArrayList<ProyectosPorTipo> rankingProyectosPorTipo() throws SQLException {
        ArrayList<ProyectosPorTipo> respuesta = new ArrayList<ProyectosPorTipo>();
        Connection conexion = JDBCUtilities.getConnection();

        try{
                String Consulta = "select p.ID_Proyecto, p.Constructora, p.Ciudad, t.Estrato as Estrato  from Proyecto p  join Tipo t on p.ID_Tipo = t.ID_Tipo where p.ciudad='Cartagena' ORDER BY Estrato";

                PreparedStatement statement = conexion.prepareStatement(Consulta);
                ResultSet resultSet = statement.executeQuery();

                while(resultSet.next()){
                    ProyectosPorTipo proyectosPorTipo= new ProyectosPorTipo();
                    proyectosPorTipo.SetIdProyecto(resultSet.getInt("ID_proyecto"));
                    proyectosPorTipo.SetCostructora(resultSet.getString("Constructora"));
                    proyectosPorTipo.SetCiudad(resultSet.getString("Ciudad"));
                    proyectosPorTipo.SetEstrato(resultSet.getInt("estrato"));
                    respuesta.add(proyectosPorTipo);
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
