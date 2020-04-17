package eg.edu.alexu.csd.datastructure.queue;

public class arrQ implements IArrayBased {
	
	int f,r,n;
	Object [] arr;
	public arrQ ( int num )
	{
		n=num+1;
		f=0;
		r=0; 
		arr = new Object[n]  ;
	}
	
	public void enqueue(Object item)
	{
		if ( size() == n-1 ) throw new RuntimeException ("Full Queue") ;
		arr [r] = item ;
		r= (r+1) % n;
	}
	public Object dequeue()
	{
		if ( isEmpty() ) throw new RuntimeException ("Empty Queue") ;
		Object temp = arr [f] ;
		arr [f] = null ;
		f= (f+1) % n ;
		return temp ;
	}
	public boolean isEmpty()
	{
		return f==r ;
	}
	public int size()
	{
		return (n-f+r) % n ;
	}
	public Object front()
	{
		if ( isEmpty() ) throw new RuntimeException ("Empty Queue") ;
		return arr[f] ;
	}

}
