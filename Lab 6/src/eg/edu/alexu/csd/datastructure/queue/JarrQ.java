package eg.edu.alexu.csd.datastructure.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JarrQ {

	@Test
	void test() 
	{
		arrQ myq = new arrQ ( 5 );
		myq.enqueue(1);myq.enqueue(2);myq.enqueue(3);myq.enqueue(4);myq.enqueue(5);
		
		assertThrows(RuntimeException.class, () -> myq.enqueue(6));
		assertEquals(5,myq.size());
		assertEquals(1,myq.dequeue());
		assertEquals(4,myq.size());
		assertEquals(2,myq.front());
		assertEquals(4,myq.size());
		assertEquals(false,myq.isEmpty());
		
		myq.dequeue();myq.dequeue();myq.dequeue();myq.dequeue();
		
		assertEquals(0,myq.size());
		assertEquals(true,myq.isEmpty());
		assertThrows(RuntimeException.class, () -> myq.dequeue());
	}

}
