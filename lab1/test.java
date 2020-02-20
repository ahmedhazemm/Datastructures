package lab1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test {

	@Test
	void test1() {
		
		calculator obj = new calculator() ;
		assertEquals(7,obj.add(3, 4));
	}
	@Test
	void test2() {
		
		calculator obj = new calculator() ;
		assertEquals(-7,obj.add(-2, -5));
	}
	@Test
	void test3() {
		
		calculator obj = new calculator() ;
		assertEquals(0,obj.add(0, 0));
	}
	@Test
	void test4() {
		
		calculator obj = new calculator() ;
		assertEquals(2,obj.divide(8, 4));
	}
	@Test
	void test5() {
		
		calculator obj = new calculator() ;
		assertEquals(0,obj.divide(0, 4));
	}
	@Test
	void test6() {
		
		calculator obj = new calculator() ;
		float t = (float)5/3 ;
		assertEquals(t,obj.divide(10,6));
	}
	@Test
	void test7() {
		try {
		calculator obj = new calculator() ;
		obj.divide(15,0);
		}
		catch (Exception e)
		{
		    System.out.println("Something went wrong (You cannot divide by zero)");
		}
	}
	
}
