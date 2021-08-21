package view;

import controller.ControladorRequerimientosReto4;
import model.vo.LiderPorNombre;
import model.vo.LiderPorSalario;
import model.vo.ProyectosPorTipo;

import java.awt.*;
import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class VistaRequerimientosReto4 extends JFrame{
    
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    private JPanel contentPane;
    private static JTextArea areaDeTexto;
    private static JTable  tabla;

    public VistaRequerimientosReto4(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450,200,800,600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel etiqueta = new JLabel("Solucion Reto 5 - Ciclo 2");
        etiqueta.setBounds(180,10,400,50);
        etiqueta.setFont(new Font("MV Boli",Font.PLAIN,32));
        contentPane.add(etiqueta);
        JLabel etiqueta2 = new JLabel("Frank Alejandro Polania");
        etiqueta2.setBounds(270,50,400,50);
        etiqueta2.setFont(new Font("MV Boli",Font.PLAIN,20));
        contentPane.add(etiqueta2);


        
        JScrollPane barra = new JScrollPane(tabla);
        barra.setBounds(50,100,700,400);
        contentPane.add(barra);
        
        
        

        areaDeTexto = new JTextArea();
        areaDeTexto.setBounds(0,0,500,500);
        barra.setViewportView(areaDeTexto);
        
//************BOTON 1 ************/
        JButton btnconsulta1 = new JButton("Consulta 1");
        btnconsulta1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                requerimiento1();
            }
        });
        btnconsulta1.setBounds(50,500,120,30);
        contentPane.add(btnconsulta1);
//************BOTON 2 ************/
        JButton btnconsulta2 = new JButton("Consulta 2");
        btnconsulta2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                requerimiento2();
            }
        });
        btnconsulta2.setBounds(330,500,120,30);
        contentPane.add(btnconsulta2);
//************BOTON 3 ************/
        JButton btnconsulta3 = new JButton("Consulta 3");
        btnconsulta3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                requerimiento3();
            }
        });
        btnconsulta3.setBounds(630,500,120,30);
        contentPane.add(btnconsulta3);

        

    }


    //// ****************REQUERIMIENTO 1 LIDERES POR SALARIO ******************
    public static void requerimiento1(){ //lider por salario
    //System.out.println("*** Lideres por Salario ***");
        
        try{
        ArrayList<LiderPorSalario> RankingLideresPorSalario = controlador.consultarLideresPorSalario();
       
        
      
        String salida = "*** lider por salario ***\n\nNombre\tPrimer Apellido\tID del Lider\tSalario\n\n";

        for(LiderPorSalario liderporsalario : RankingLideresPorSalario){
            salida += liderporsalario.getNombre() + "\t";
            salida += liderporsalario.getApellido()+ "\t";
            salida += liderporsalario.getIdLider()+ "\t";
            salida += liderporsalario.getSalario()+ "\n";
        }
        areaDeTexto.setText(salida);
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
    }

    public static void requerimiento2(){   // Proyectos  por tipo  
        String salida = "*** Proyectos por Tipo ***\nID Proyecto\tConstructora\t\tCiudad\tEstrato\n\n";
        try{
            ArrayList<ProyectosPorTipo> RankingProyectosPorTipo = controlador.consultarProyectosPorTipos();
            for(ProyectosPorTipo proyectosportipo : RankingProyectosPorTipo){
                
                salida += proyectosportipo.getIdProyecto() + "\t";
                if(proyectosportipo.getConstructora().equals("Pegaso")) {salida += proyectosportipo.getConstructora() + "\t\t";}else{salida += proyectosportipo.getConstructora() + "\t";}
                salida += proyectosportipo.getciudad() + "\t";
                salida += proyectosportipo.getEstrato() + "\n";
        }
        areaDeTexto.setText(salida);

        }catch(SQLException e){
            System.err.println(e);
        }
    }

    public static void requerimiento3(){ // Lider por nombre

        String salida="*** Lideres por Nombre ***\nID lider\tNombre\tApellido\n\n";
        try{
            ArrayList<LiderPorNombre> RankingLiderPorNombres = controlador.consultarLideresPorNombres();
            for(LiderPorNombre liderespornombre : RankingLiderPorNombres){
                
                salida +=liderespornombre.getIdLider()+"\t";
                salida +=liderespornombre.getNombre()+"\t";
                salida +=liderespornombre.getApellido()+"\n";

        }
        areaDeTexto.setText(salida);
        }catch(SQLException e){
            System.err.println(e);
        }
    }

}
