package com.mycompany.app.estructura;

import java.awt.Color;


import entorno.Entorno;
import com.mycompany.app.modelo.Bala;
import com.mycompany.app.modelo.Casilla;
import com.mycompany.app.modelo.ObjetoGrafico;
import com.mycompany.app.modelo.objeto.Coordenada;

//SE COMENTARON TODOS LOS @Override
public class EstructuraAcero extends ObjetoGrafico implements Estructura{

	
	public EstructuraAcero()
	{
		//this.imagen = new Imagen("agua.png");
		//System.out.println("me construi, estructura acero ");
		this.color = Color.ORANGE;
	}
	
	public void colisionBala()
	{

	}

	//@Override
	public void colisionBala(Bala bala, Casilla casilla) 
	{
		//bala.destruir();
		
	}

	
	//@Override
	public void destruir(Casilla casilla) 
	{
		casilla.liberarCasilla();
		
	}

	//@Override
	public void dibujar(Entorno unEntorno, Casilla casilla) {
		//unEntorno.dibujarRectangulo(casilla.x, casilla.y, 20, 20, 0, Color.GRAY);
		
	}

	//@Override
	public void dibujar(Entorno ent, Coordenada c) {
		// TODO Auto-generated method stub
		ent.dibujarRectangulo(c.getX(), c.getY(), 20, 20, 0, Color.GREEN);
	}
}
