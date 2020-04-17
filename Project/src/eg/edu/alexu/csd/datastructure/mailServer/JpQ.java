package eg.edu.alexu.csd.datastructure.mailServer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JpQ {

	@Test
	void test() 
	{
		pQ myq = new pQ () ;
		myq.insert(3, 3);myq.insert(2, 2);myq.insert(5, 5);myq.insert(4, 4);myq.insert(1, 1);
		
		assertEquals(false,myq.isEmpty());
		assertEquals(5,myq.size());
		
		assertEquals(1,myq.removeMin());
		assertEquals(2,myq.removeMin());
		assertEquals(3,myq.min());
		assertEquals(3,myq.size());
		
		myq.removeMin();myq.removeMin();myq.removeMin();
		assertEquals(true,myq.isEmpty());
		
		assertThrows(RuntimeException.class, () -> myq.removeMin());
		assertThrows(RuntimeException.class, () -> myq.min());
	}

}
