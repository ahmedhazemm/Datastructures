package eg.edu.alexu.csd.datastructure.stack.cs;
import eg.edu.alexu.csd.datastructure.linkedList.cs.*;

/**
* This class implements the (IStack) interface
* its methods are : pop ,  peek , push , isEmpty , size , print , clear
* and it has one instance variable : list (the singly linked list which is used in the implementation of the stack)
*/
public class myStack implements IStack {
	
	Singly list = new Singly () ;

	@Override
	public Object pop() {
		
		if ( list.size() > 0 )
		{
			Object x = list.get(1);
			list.remove(1);
			return x;
		}
		else 
			throw new NullPointerException("Empty Stack"); 
	}

	@Override
	public Object peek() {
		
		if ( list.size() > 0 )
			return list.get(1);
		else 
			throw new NullPointerException("Empty Stack"); 
	}

	@Override
	public void push(Object element) {
		
		list.add(1,element);
	}

	@Override
	public boolean isEmpty() {
		
		return list.isEmpty();
	}

	@Override
	public int size() {
		
		return list.size();
	}
	
	/**
	* Print the Stack
	*/
	public void print () {
		
		list.print(list);
	}
	
	/**
	* Clear the Stack
	*/
	public void clear () {
		
		list.clear();
	}
}
