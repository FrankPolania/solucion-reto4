package model.vo;

public class LiderPorNombre {
private int idLider;
private String Nombre;
private String Apellido;

public LiderPorNombre(){}
public LiderPorNombre(int idLider,String Nombre,String Apellido){
    this.idLider=idLider;
    this.Nombre = Nombre;
    this.Apellido = Apellido;
}

public void setIdLider(int idLider){this.idLider=idLider;}
public void setNombre(String  Nombre){this.Nombre= Nombre;}
public void setApellido(String Apellido){this.Apellido= Apellido;}

public int getIdLider(){return this.idLider;}
public String getNombre(){return this.Nombre;}
public String getApellido(){return this.Apellido;}
    
}
