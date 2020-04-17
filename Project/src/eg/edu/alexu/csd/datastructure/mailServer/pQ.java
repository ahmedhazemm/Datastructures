package eg.edu.alexu.csd.datastructure.mailServer;
import eg.edu.alexu.csd.datastructure.linkedList.cs.*;

public class pQ implements IPriorityQueue {

	Singly items = new Singly () ;
	Singly keys = new Singly () ;
	
	@Override
	public void insert(Object item, int key) {
		for ( int i=1 ; i<=keys.size()+1 ; i++)
		{
			if ( i==keys.size()+1 || key >= (int) keys.get(i) )
			{
				keys.add(i, key);
				items.add(i, item);
				break;
			}
		}
		
	}

	@Override
	public Object removeMin() {
		if ( isEmpty() ) throw new RuntimeException ("Empty Queue") ;
		Object temp = items.get(items.size()) ;
		items.remove(items.size());
		keys.remove(keys.size());
		return temp;
	}

	@Override
	public Object min() {
		if ( isEmpty() ) throw new RuntimeException ("Empty Queue") ;
		return items.get(items.size());
	}

	@Override
	public boolean isEmpty() {
		return items.isEmpty();
	}

	@Override
	public int size() {
		return items.size();
	}
	
	public void print () {
		items.print(items);
	}
	
	public void clear () {
		items.clear();
	}

}
