import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BombTest {
	
	@Test
	public void testWind() {
		Bomb bomb = new Bomb(0, 0, 0, 0, null, 0, 45, 10);
		assertEquals(45, bomb.getWindDirection(), 0.000001);
		assertEquals(10, bomb.getWindSpeed(), 0.000001);
	}
	
	@Test
	public void testRelease() {
		Bomb bomb = new Bomb(100, 200, 300, 10, null, 0, 0, 0);
		assertEquals(100, bomb.getReleaseCoordinates().getX(), 0.000001);
		assertEquals(200, bomb.getReleaseCoordinates().getY(), 0.000001);
		assertEquals(300, bomb.getReleaseAltitude(), 0.000001);
		assertEquals(10, bomb.getDescentSpeed(), 0.000001);
	}
	
	@Test
	public void testError() {
		Bomb bomb1 = new Bomb(0, 0, 0, 0, Bomb.E_ErrorType.NONE, 10, 0, 0);
		Bomb bomb2 = new Bomb(0, 0, 0, 0, Bomb.E_ErrorType.UNIFORM, 10, 0, 0);
		Bomb bomb3 = new Bomb(0, 0, 0, 0, Bomb.E_ErrorType.GAUSSIAN, 10, 0, 0);
		assertEquals(Bomb.E_ErrorType.NONE, bomb1.getErrorType());
		assertEquals(10, bomb1.getErrorRange(), 0.000001);
		assertEquals(Bomb.E_ErrorType.UNIFORM, bomb2.getErrorType());
		assertEquals(10, bomb2.getErrorRange(), 0.000001);
		assertEquals(Bomb.E_ErrorType.GAUSSIAN, bomb3.getErrorType());
		assertEquals(10, bomb3.getErrorRange(), 0.000001);
	}

}
