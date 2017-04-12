package com.mycompany.app.object;

import static org.junit.Assert.*;


import org.junit.Test;
import com.mycompany.app.enums.Orientation;
import com.mycompany.app.object.Coordinate;
import com.mycompany.app.object.Size;
import com.mycompany.app.object.Tank;
import com.mycompany.app.object.TankController;

public class TestTankController {

	
	/**moverse*/
	@Test
	public void testMoversePorIzquierda() {
		Orientation orientation = Orientation.LEFT;
		Coordinate coordinate = new Coordinate(400, 400);
		Size size = new Size(40, 40);
		Tank tank = new Tank(orientation, coordinate, size);
		TankController tankC = new TankController(tank);
		tankC.ControlLeft();
		assertNotEquals(400.0,tank.getCoordinate().getX());
	}
	
	@Test
	public void testMoversePorDerecha() {
		Orientation orientation = Orientation.RIGTH;
		Coordinate coordinate = new Coordinate(400, 400);
		Size size = new Size(40, 40);
		Tank tank = new Tank(orientation, coordinate, size);
		TankController tankC = new TankController(tank);
		tankC.ControlRigth();
		assertNotEquals(400.0,tank.getCoordinate().getX());
	}
	
	@Test
	public void testMoversePorAbajo() {
		Orientation orientation = Orientation.DOWN;
		Coordinate coordinate = new Coordinate(400, 400);
		Size size = new Size(40, 40);
		Tank tank = new Tank(orientation, coordinate, size);
		TankController tankC = new TankController(tank);
		tankC.ControlDown();
		assertNotEquals(400.0,tank.getCoordinate().getY());
	}
	
	@Test
	public void testMoversePorArriba() {
		Orientation orientation = Orientation.UP;
		Coordinate coordinate = new Coordinate(400, 400);
		Size size = new Size(40, 40);
		Tank tank = new Tank(orientation, coordinate, size);
		TankController tankC = new TankController(tank);
		tankC.ControlUp();
		assertNotEquals(400.0,tank.getCoordinate().getY());
	}
	
	/**disparar*/
	@Test
	public void testDisparar() {
		Orientation orientation = Orientation.LEFT;
		Coordinate coordinate = new Coordinate(400, 400);
		Size size = new Size(40, 40);
		Tank tank = new Tank(orientation, coordinate, size);
		TankController tankC = new TankController(tank);
		tankC.getTank().disparar();
		assertNotEquals(null,tankC.getTank().getBullet());
	}

}
