package com.mycompany.app.object;

import java.awt.Color;

import entorno.*;
import com.mycompany.app.modelo.ObjetoGrafico;

public class Draftsman {
	private Entorno entorno;

	public Draftsman(InterfaceJuego i, GraphicMap gm, String title)
	{
		this.dibujarEscenario(i,gm,title);
	}
	
	public void dibujarEscenario(InterfaceJuego i, GraphicMap gm, String title)
	{
		this.entorno = new Entorno(i, title, (int)gm.getSizeMap().getAncho(), (int)gm.getSizeMap().getAlto());
	}
	
	public void dibujarMarco(GraphicMap gm)
	{
		Color color = Color.GRAY;
		// linea de arriba y de lado izquierdo
		this.entorno.dibujarRectangulo(10, 10, gm.getSizeMarco().getAncho(), gm.getSizeMap().getAlto()*2, 0, color);
		this.entorno.dibujarRectangulo(10, 10, gm.getSizeMap().getAncho()*2, gm.getSizeMarco().getAlto(), 0, color);
		// linea de abajo y lado derecho
		this.entorno.dibujarRectangulo(gm.getSizeMap().getAncho(), 0, gm.getSizeMarco().getAncho(), gm.getSizeMap().getAlto()*2+20, 0, color);
		this.entorno.dibujarRectangulo(10, gm.getSizeMap().getAlto(), gm.getSizeMap().getAncho()*2, gm.getSizeMarco().getAlto(), 0, color);
	}
	
	public void dibujarImagen(String rutaImagen, Coordinate coordinate){
		this.entorno.dibujarImagen(Herramientas.cargarImagen(rutaImagen), coordinate.getX(), coordinate.getY(), 0);
	}
	
	public void dibujarImagen(String rutaImagen, Coordinate coordinate, double angulo){
		this.entorno.dibujarImagen(Herramientas.cargarImagen(rutaImagen), coordinate.getX(), coordinate.getY(), angulo);
	}
	
	public void dibujarRectangulo(Coordinate coordinate, Size size, double angulo, Color color){
		this.entorno.dibujarRectangulo(coordinate.getX(), coordinate.getY(), size.getAncho(), 
				size.getAlto(), angulo, color);
	}
	
	public void dibujarCirculo(Coordinate coordinate, double diametro, Color color){
		this.entorno.dibujarCirculo(coordinate.getX(), coordinate.getY(), diametro, color);
	}
	
	public void dibujarEstructura(ObjetoGrafico e)
	{
		this.entorno.dibujarRectangulo(e.getCoordenada().getX()+(e.getTamaño().getAncho()/2),e.getCoordenada().getY()+e.getTamaño().getAlto()/2, e.getTamaño().getAncho(), e.getTamaño().getAlto(), 0, e.getColor());
	}
}
