package com.mycompany.app.main;

import entorno.*;
import com.mycompany.app.enums.Orientation;
import com.mycompany.app.object.*;

public class Game extends InterfaceJuego {
   
    private Tank tank;
	//private Image fondo = Herramientas.cargarImagen("imagen/fondo.jpg");
    private Draftsman dibujador;
    private GraphicMap mapa;
	private ListStructures estructuras;
	private TankController tControl;
     
	public Game() 
	{
		this.mapa = new GraphicMap(new Size(1000, 600), new Size(20, 20));
		this.dibujador = new Draftsman(this, mapa, "Battle-Ungs");
		this.estructuras = new ListStructures(mapa, 35); // cantidad de tipos de estructuras -- num * 3 
		this.tank = new Tank(Orientation.UP,new Coordinate(400,400),new Size(40,40));
		this.tControl = new TankController(tank);
	}
	
    public void tick() 
    {
    	    	
    	this.dibujador.dibujarMarco(mapa); 

    	/*for (ObjetoGrafico e:estructuras.getLista()) 
    	{
			this.dibujador.dibujarEstructura(e);
		}*/
    	
    	this.dibujador.dibujarTank(tank);
    	this.tControl.ControlTank(dibujador.getEntorno());
    	this.tControl.control_bullet(dibujador.getEntorno());
    }



}
