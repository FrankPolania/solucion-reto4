package controller;

//Estructuras de datos (colecciones)
import java.util.ArrayList;

//Modelos (acceso y objetos contenedores)
import model.dao.LiderPorSalarioDao;
import model.dao.LiderPorNombreDao;
import model.dao.ProyectoPorTipoDao;
import model.vo.LiderPorSalario;
import model.vo.LiderPorNombre;
import model.vo.ProyectosPorTipo;
//import model.vo.Requerimiento_3;


//Librerías para bases de datos
import java.sql.SQLException;

public class ControladorRequerimientosReto4 {       
    //Su codigo
    
    public ControladorRequerimientosReto4(){
        //Su codigo

    }

    public ArrayList<LiderPorSalario> consultarLideresPorSalario() throws SQLException {
        LiderPorSalarioDao respuesta = new LiderPorSalarioDao();
        return respuesta.rankingLiderPorSalario();
    } 
    
    public ArrayList<ProyectosPorTipo> consultarProyectosPorTipos() throws SQLException {
       ProyectoPorTipoDao respuesta = new ProyectoPorTipoDao();
        return respuesta.rankingProyectosPorTipo();
    }

    public ArrayList<LiderPorNombre> consultarLideresPorNombres() throws SQLException {
        LiderPorNombreDao respuesta = new LiderPorNombreDao();
        return respuesta.rankingLiderPorNombre();
    }

}
