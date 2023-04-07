package lab11.cscd211gcd;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecursionGCDTests {

	//gcd tests
	@Test
	public void testGcd1and1() {
		try{
			int result = CSCD211GCD.gcd(1, 1);
			assertEquals(1, result);
		}
		catch(Exception e){
			fail("Exception occurred in testGcd1and1: " + e.getMessage());
		}
		
	}
	
	@Test
	public void testGcd1and2() {
		try{
			int result = CSCD211GCD.gcd(1, 2);
			assertEquals(1, result);
		}
		catch(Exception e){
			fail("Exception occurred in testGcd1and2: " + e.getMessage());
		}
		
	}
	
	@Test
	public void testGcd2and1() {
		try{
			int result = CSCD211GCD.gcd(2, 1);
			assertEquals(1, result);
		}
		catch(Exception e){
			fail("Exception occurred in testGcd2and1: " + e.getMessage());
		}
		
	}
	
	@Test
	public void testGcd2and3() {
		try{
			int result = CSCD211GCD.gcd(2, 3);
			assertEquals(1, result);
		}
		catch(Exception e){
			fail("Exception occurred in testGcd2and3: " + e.getMessage());
		}
		
	}
	
	@Test
	public void testGcd2and4() {
		try{
			int result = CSCD211GCD.gcd(2, 4);
			assertEquals(2, result);
		}
		catch(Exception e){
			fail("Exception occurred in testGcd2and4: " + e.getMessage());
		}
		
	}
	
	@Test
	public void testGcd2and1000() {
		try{
			int result = CSCD211GCD.gcd(2, 1000);
			assertEquals(2, result);
		}
		catch(Exception e){
			fail("Exception occurred in testGcd2and1000: " + e.getMessage());
		}
		
	}
	
	@Test
	public void testGcd3and1000() {
		try{
			int result = CSCD211GCD.gcd(3, 1000);
			assertEquals(1, result);
		}
		catch(Exception e){
			fail("Exception occurred in testGcd3and1000: " + e.getMessage());
		}
		
	}
	
	@Test
	public void testGcd1000and3() {
		try{
			int result = CSCD211GCD.gcd(1000, 3);
			assertEquals(1, result);
		}
		catch(Exception e){
			fail("Exception occurred in testGcd1000and3: " + e.getMessage());
		}
		
	}
	
	@Test
	public void testGcd1000and600() {
		try{
			int result = CSCD211GCD.gcd(1000, 600);
			assertEquals(200, result);
		}
		catch(Exception e){
			fail("Exception occurred in testGcd1000and600: " + e.getMessage());
		}
		
	}
	
	@Test
	public void testGcd1001and991() {
		try{
			int result = CSCD211GCD.gcd(1001, 991);
			assertEquals(1, result);
		}
		catch(Exception e){
			fail("Exception occurred in testGcd1001and991: " + e.getMessage());
		}
		
	}
	
	@Test
	public void testGcd1002and992() {
		try{
			int result = CSCD211GCD.gcd(1002, 992);
			assertEquals(2, result);
		}
		catch(Exception e){
			fail("Exception occurred in testGcd1002and992: " + e.getMessage());
		}
		
	}
	

}
