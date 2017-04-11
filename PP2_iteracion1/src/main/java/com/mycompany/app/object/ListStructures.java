package com.mycompany.app.object;

import java.util.*;
import com.mycompany.app.estructura.*;
import com.mycompany.app.modelo.ObjetoGrafico;
import com.mycompany.app.modelo.objeto.Tamaño;

public class ListStructures 
{
	private int lenght;
	private List<ObjetoGrafico> estructuras;
	private boolean listaLenghtValidate;
	
	public ListStructures(GraphicMap map, int length)
	{
		this.setLenght(length);
		this.estructuras = new ArrayList<ObjetoGrafico>();
		this.inicializarLista(map);
	}
	
	private void inicializarLista(GraphicMap mapa) 
	{
		if(listaLenghtValidate)
		{
			for(int i=0;i<lenght;i++)
			{
				this.estructuras.add((ObjetoGrafico)new EstructuraAcero());
				this.estructuras.add((ObjetoGrafico)new EstructuraAgua());
				this.estructuras.add((ObjetoGrafico)new EstructuraLadrillo());
			}
		}
		for(ObjetoGrafico o : estructuras)
		{
			Random ale = new Random();
			List<Coordinate> lista = mapa.listaCoordenadas();
			int pos = ale.nextInt(lista.size());
			Coordinate azar = mapa.getCoordenada(pos);
//			System.out.println(azar);
			//Coordinate azar = new Coordinate(20, 20);
			o.setCoordenada(azar);
			o.setTamaño(new Tamaño(40,40));
			lista.remove(pos);
		}
	}

	public int getLenght() 
	{
		return lenght;
	}

	public void setLenght(int lenght) 
	{
		this.lenght = lenght;
		this.listaLenghtValidate = lenght>0 && lenght<50;
	}

	public List<ObjetoGrafico> getLista() {
		return estructuras;
	}
		
}
