package com.mycompany.app.object;

import java.util.Random;

import entorno.Entorno;
import com.mycompaany.app.enums.Orientation;

@SuppressWarnings("unused")
public class TankController {
	private Tank tank;
	
	
	public TankController(Tank tank){
		this.tank = tank;
	}
	
	public void ControlUp()
	{
		tank.moverseArriba();
	}
	public void ControlDown()
	{
		tank.moverseAbajo();
	}
	public void ControlRigth()
	{
		tank.moverseDerecha();
	}
	public void ControlLeft()
	{
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
		if(ent.estaPresionada(ent.TECLA_CTRL))
			this.tank.disparar();
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
		for(int i=0;i<5;i++)
		{
			this.ControlCpu(dir);
		}
		tank.disparar();
	}
}
