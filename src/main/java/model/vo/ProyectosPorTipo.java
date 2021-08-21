package model.vo;

public class ProyectosPorTipo {
    private int idProyecto;
    private String constructora;
    private String ciudad;
    private int estrato;
    
    public ProyectosPorTipo(){}
    public ProyectosPorTipo(int idProyecto,String constructora,String ciudad,int estrato){
        this.idProyecto=idProyecto;
        this.constructora=constructora;
        this.ciudad=ciudad;
        this.estrato=estrato;
    }


    /// setters
    public void SetIdProyecto(int idProyecto){this.idProyecto = idProyecto;}
    public void SetCostructora(String constructora){this.constructora = constructora;}
    public void SetCiudad(String ciudad){this.ciudad = ciudad;}
    public void SetEstrato(int estrato){this.estrato = estrato;}


/// Getters
public int getIdProyecto(){return this.idProyecto;}
public String getConstructora(){return this.constructora;}
public String getciudad(){return this.ciudad;}
public int  getEstrato(){return this.estrato;}
}
