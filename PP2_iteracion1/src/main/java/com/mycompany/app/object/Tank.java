package com.mycompany.app.object;

import com.mycompany.app.enums.Orientation;

import com.mycompany.app.enums.TankShot;
import com.mycompany.app.util.Util;

public class Tank {
	private Orientation orientation;
	private TankShot tankShot;
	private Coordinate coordinate;
	private Size size;
	private Bullet bullet;
	private double velocidadDeMovimiento = 2;
	
	public Tank(Orientation orientation, Coordinate coordinate,	Size size){
		this.orientation = orientation;
		this.coordinate = coordinate;
		this.size = size;
	}

	//dependiendo del estado en que se encuentre se gira
	//le paso una nueva orientacion que reemplaza a la anterior, y cuando lo dibuje girara el tanque
	public void girar(Orientation orientation)
	{
		this.setOrientation(orientation);
	}
	
	//dependiendo del estado en que se encuentre se mueve
	public void moverseArriba()
	{
		if(getOrientation().equals(Orientation.UP))
			this.coordinate.setY(this.coordinate.getY()+5);
		this.girar(Orientation.UP);			
	}
	public void moverseAbajo()
	{
		if(getOrientation().equals(Orientation.DOWN))
			this.coordinate.setY(this.coordinate.getY()-5);
		this.girar(Orientation.DOWN);			
	}
	public void moverseDerecha()
	{
		if(getOrientation().equals(Orientation.RIGTH))
			this.coordinate.setX(this.coordinate.getX()+5);
		this.girar(Orientation.RIGTH);			
	}
	public void moverseIzquierda()
	{
		if(getOrientation().equals(Orientation.LEFT))
			this.coordinate.setX(this.coordinate.getX()-5);
		this.girar(Orientation.LEFT);			
	}
	
	public void disparar(){
		if(tankShot.equals(TankShot.NO_EXISTS)){
			bullet = new Bullet(orientation, 
					new Coordinate(this.coordinate.getX(),this.coordinate.getY()),
					new Size(10, 10));
			tankShot = TankShot.EXISTS;
		}
	}
	
	//dependiendo del estado en que se encuentre se mueve en esa posicion
	public void moverse(){
		//controlar que no choque con las estructuras o el limite del mapa
		if(!Util.estaEnElLimiteDeTablero(orientation, coordinate)){
			Util.moverse(orientation, coordinate, velocidadDeMovimiento);
		}
	}
	public double getAngulo() {
		if(this.orientation.equals(Orientation.UP)){
			return Math.PI*1.5;
		}if(this.orientation.equals(Orientation.DOWN)){
			return Math.PI/2;
		}if(this.orientation.equals(Orientation.LEFT)){
			return Math.PI;
		}if(this.orientation.equals(Orientation.RIGTH)){
			return 0;
		}
	return 0;
	}
	
	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public TankShot getTankBullet() {
		return tankShot;
	}

	public void setTankBullet(TankShot tankShot) {
		this.tankShot = tankShot;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Bullet getBullet() {
		return bullet;
	}

	public void setBullet(Bullet bullet) {
		this.bullet = bullet;
	}
}
