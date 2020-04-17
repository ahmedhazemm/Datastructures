package eg.edu.alexu.csd.datastructure.queue;
import eg.edu.alexu.csd.datastructure.linkedList.cs.*;

public class listQ implements ILinkedBased {
	
	Singly list = new Singly () ;
	
	public void enqueue(Object item)
	{
		list.add(item);
	}
	public Object dequeue()
	{
		if ( list.size() == 0 ) throw new RuntimeException ("Empty Queue") ;
		Object temp = list.get(1);
		list.remove(1);
		return temp ;
	}
	public boolean isEmpty()
	{
		return list.isEmpty() ;
	}
	public int size()
	{
		return list.size() ;
	}
	public Object front()
	{
		return list.get(1) ;
	}
	public void clear () 
	{
		list.clear();
	}
	public void print () 
	{
		list.print(list);
	}

}
