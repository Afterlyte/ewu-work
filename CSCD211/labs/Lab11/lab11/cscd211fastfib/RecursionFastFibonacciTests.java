package lab11.cscd211fastfib;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecursionFastFibonacciTests {

	@Test
	public void testFastFibonacci0() {
		try{
			long result = CSCD211FastFib.fastFibonacci(0);
			assertEquals(0, result);
		}
		catch(Exception e){
			fail("Exception occurred in testFastFibonacci0: " + e.getMessage());
		}
		
	}
	
	@Test
	public void testFastFibonacci1() {
		try{
			long result = CSCD211FastFib.fastFibonacci(1);
			assertEquals(1, result);
		}
		catch(Exception e){
			fail("Exception occurred in testFastFibonacci1: " + e.getMessage());
		}
		
	}
	
	@Test
	public void testFastFibonacci2() {
		try{
			long result = CSCD211FastFib.fastFibonacci(2);
			assertEquals(1, result);
		}
		catch(Exception e){
			fail("Exception occurred in testFastFibonacci2: " + e.getMessage());
		}
		
	}
	
	@Test
	public void testFastFibonacci3() {
		try{
			long result = CSCD211FastFib.fastFibonacci(3);
			assertEquals(2, result);
		}
		catch(Exception e){
			fail("Exception occurred in testFastFibonacci3: " + e.getMessage());
		}
		
	}
	
	@Test
	public void testFastFibonacci4() {
		try{
			long result = CSCD211FastFib.fastFibonacci(4);
			assertEquals(3, result);
		}
		catch(Exception e){
			fail("Exception occurred in testFastFibonacci4: " + e.getMessage());
		}
		
	}
	
	@Test
	public void testFastFibonacci5() {
		try{
			long result = CSCD211FastFib.fastFibonacci(5);
			assertEquals(5, result);
		}
		catch(Exception e){
			fail("Exception occurred in testFastFibonacci5: " + e.getMessage());
		}
		
	}
	
	@Test
	public void testFastFibonacci10() {
		try{
			long result = CSCD211FastFib.fastFibonacci(10);
			assertEquals(55, result);
		}
		catch(Exception e){
			fail("Exception occurred in testFastFibonacci10: " + e.getMessage());
		}
		
	}
	
	@Test
	public void testFastFibonacci40() {
		try{
			long result = CSCD211FastFib.fastFibonacci(40);
			assertEquals(102334155, result);
		}
		catch(Exception e){
			fail("Exception occurred in testFastFibonacci40: " + e.getMessage());
		}
		
	}



}
