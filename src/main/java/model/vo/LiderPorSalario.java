package model.vo;

public class LiderPorSalario {
    //Su codigo
    private String Nombre;
    private String Apellido;
    private int IdLider;
    private int Salario;

    public LiderPorSalario(){}
    
    public LiderPorSalario(String Nombre,String Apellido, int IdLider,int Salario){
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.IdLider = IdLider;
        this.Salario = Salario;
    }

/// setters
    public void SetNombre(String Nombre){this.Nombre = Nombre;}
    public void setApellido(String Apellido){this.Apellido = Apellido;}
    public void setIdLider(int IdLider){this.IdLider = IdLider;}
    public void setSalario(int Salario){this.Salario = Salario;}

/// Getters
    public String getNombre(){return this.Nombre;}
    public String getApellido(){return this.Apellido;}
    public int getIdLider(){return this.IdLider;}
    public int getSalario(){return this.Salario;}

    
}
