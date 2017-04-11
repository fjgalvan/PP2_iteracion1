package com.mycompany.app.estructura;

import java.awt.Color;

import entorno.Entorno;
import com.mycompany.app.modelo.Bala;
import com.mycompany.app.modelo.Casilla;

//abstracto
public interface Estructura {
	
	public void colisionBala(Bala bala, Casilla casilla);
	public void destruir(Casilla casilla);
	public void dibujar(Entorno unEntorno, Casilla casilla);
	
}
