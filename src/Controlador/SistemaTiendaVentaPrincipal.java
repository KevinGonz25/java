package Controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import Lib.BaseDatos;
import Lib.ConexionBD;
import Vista.PantallaCarga;

public class SistemaTiendaVentaPrincipal {

	public static void main(String[] args) 
	{
		
		
		
		
		PantallaCarga entrada = new PantallaCarga();
		entrada.setVisible(true);
        try
        {
            for(int i=0; i <=100; i++)
            {
                Thread.sleep(40);
                entrada.Myprogress.setValue(i);
                entrada.Percentage.setText(Integer.toString(i)+"%");
            }
        } catch (Exception e)
        {
            System.out.println("Error al entrar");
        }
        new CSesion();
        entrada.dispose();
		
		
		
	}

}
