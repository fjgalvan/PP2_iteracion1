package app.modelo;

import java.awt.Color;

import app.object.Coordinate;
import app.object.Size;

public abstract class ObjetoGrafico {
	
	protected Coordinate coordinate;
	protected Size size;
	protected Color color;
	
	public ObjetoGrafico()
	{

	}
	//public abstract void dibujar(Entorno ent);

	//public abstract void dibujar(Entorno ent, Coordenada c);
	
	


	public Color getColor() {
		return color;
	}

	public Coordinate getCoordenada() 
	{
		return coordinate;
	}

	public void setCoordenada(Coordinate coordenada) 
	{
		this.coordinate = coordenada;
	}

	public Size getSize() 
	{
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}