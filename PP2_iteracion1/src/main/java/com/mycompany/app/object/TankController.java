package com.mycompany.app.object;

import java.awt.Color;
import java.util.Random;

import entorno.Entorno;
import entorno.Herramientas;
import com.mycompany.app.enums.Orientation;
import com.mycompany.app.enums.TankShot;
import sonido.Sonido;
import com.mycompany.app.util.Util;

@SuppressWarnings("unused")
public class TankController {
	private Tank tank;
	
	
	public TankController(Tank tank){
		this.tank = tank;
	}
	
	public void ControlUp()
	{
		if(tank.getCoordinate().getY() >= 25)
		tank.moverseArriba();
	}
	public void ControlDown()
	{
		if(tank.getCoordinate().getY() <= 547)
		tank.moverseAbajo();
	}
	public void ControlRigth()
	{
		if(tank.getCoordinate().getX() <= 946 )
		tank.moverseDerecha();
	}
	public void ControlLeft()
	{
		if(tank.getCoordinate().getX() >= 25)
		tank.moverseIzquierda();
	}
	
	public void ControlTank(Entorno ent)
	{
		if(ent.estaPresionada(ent.TECLA_ARRIBA))
			ControlUp();
		if(ent.estaPresionada(ent.TECLA_ABAJO))
			ControlDown();
		if(ent.estaPresionada(ent.TECLA_DERECHA))
			ControlRigth();
		if(ent.estaPresionada(ent.TECLA_IZQUIERDA))
			ControlLeft();		
		if(ent.estaPresionada(ent.TECLA_ENTER)){
			Sonido.TanqueDisparo.stop();
			Sonido.TanqueDisparo.play();
			this.tank.disparar();
		}
	}
	
	private void ControlCpu(Orientation direction)
	{
		if(direction.equals(Orientation.UP))
			ControlUp();
		if(direction.equals(Orientation.DOWN))
			ControlDown();
		if(direction.equals(Orientation.RIGTH))
			ControlRigth();
		if(direction.equals(Orientation.LEFT))
			ControlLeft();
	}
	private Orientation genDirection()
	{		
		    int pick = new Random().nextInt(Orientation.values().length);
		    return Orientation.values()[pick];
	}
	public void ai()
	{
		Orientation dir = this.genDirection();
		for(int i=0;i<1;i++)
		{
			this.ControlCpu(dir);
		}
		//tank.disparar();
	}
	public void control_bullet(Entorno entorno){
		if(this.tank.getTankBullet().equals(TankShot.EXISTS)){
			this.tank.getBullet().avanzarBullet();
			/*entorno.dibujarCirculo(this.tank.getBullet().getCoordinate().getX(), 
					this.tank.getBullet().getCoordinate().getY(), 10, Color.gray);*/
			entorno.dibujarImagen(Herramientas.cargarImagen("imagen/bala.png"), this.tank.getBullet().getCoordinate().getX(), 
					this.tank.getBullet().getCoordinate().getY(), 0);
			if(this.tank.getBullet().colisionBullet()){
				this.tank.setTankBullet(TankShot.NO_EXISTS);
				this.tank.setBullet(null);
			}
		}
	}

	public Tank getTank() {
		return tank;
	}

	public void setTank(Tank tank) {
		this.tank = tank;
	}
}
