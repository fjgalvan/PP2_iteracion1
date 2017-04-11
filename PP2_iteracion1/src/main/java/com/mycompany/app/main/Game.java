package com.mycompany.app.main;

import entorno.*;

import com.mycompany.app.modelo.ObjetoGrafico;
import com.mycompany.app.object.*;

public class Game extends InterfaceJuego {
   
    //private Tanque tanque;
	//private Image fondo = Herramientas.cargarImagen("imagen/fondo.jpg");
    //private Bala bala;
    private Draftsman dibujador;
    private GraphicMap mapa;
	private ListStructures estructuras;
     
	
	public Game() 
	{
		this.mapa = new GraphicMap(new Size(1000, 600), new Size(20, 20));
		this.dibujador = new Draftsman(this, mapa, "Battle-Ungs");
		this.estructuras = new ListStructures(mapa, 35); // cantidad de tipos de estructuras -- num * 3 
		//this.tanque = new Tanque(400, 400, 0);
	}
	
    public void tick() 
    {
    	this.dibujador.dibujarMarco(mapa); 

    	for (ObjetoGrafico e:estructuras.getLista()) 
    	{
			this.dibujador.dibujarEstructura(e);
		}
    }



}
