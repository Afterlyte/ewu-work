package lab11.cscd211reversestring;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedListToReverseStringTests {
	LinkedList list;
	
	@Before
	public void setUp() throws Exception {
		list = new LinkedList();
	}

	@After
	public void tearDown() throws Exception {
	}

	//toReverseString tests
	@Test
	public void testToReverseStringEmptyList() {
		try{
			assertEquals("", list.toReverseString());
		}
		catch(Exception e){
			fail("Exception occurred in testtoReverseStringEmptyList: " + e.getMessage());
		}
	}
	
	@Test
	public void testToReverseString1Item() {
		try{
			list.addFirst("single item");
			assertEquals("single item\r\n", list.toReverseString());
		}
		catch(Exception e){
			fail("Exception occurred in testToReverseString1Item: " + e.getMessage());
		}
	}
	
	@Test
	public void testToReverseString2Items() {
		try{
			list.addFirst("second");
			list.addFirst("first");
			assertEquals("second\r\nfirst\r\n", list.toReverseString());
		}
		catch(Exception e){
			fail("Exception occurred in testToReverseString2Items: " + e.getMessage());
		}
	}
	
	@Test
	public void testToReverseString10Items() {
		try{
			list.addFirst("10");
			list.addFirst("9");
			list.addFirst("8");
			list.addFirst("7");
			list.addFirst("6");
			list.addFirst("5");
			list.addFirst("4");
			list.addFirst("3");
			list.addFirst("2");
			list.addFirst("1");
			assertEquals("10\r\n9\r\n8\r\n7\r\n6\r\n5\r\n4\r\n3\r\n2\r\n1\r\n", list.toReverseString());
		}
		catch(Exception e){
			fail("Exception occurred in testToReverseString10Items: " + e.getMessage());
		}
	}



}
