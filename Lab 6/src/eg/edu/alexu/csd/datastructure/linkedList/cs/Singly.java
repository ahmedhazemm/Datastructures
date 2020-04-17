package eg.edu.alexu.csd.datastructure.linkedList.cs;

/**
* This class implements the (ILinkedList) interface
* its methods are : add ,  get , set , clear , isEmpty , remove , size , sublist , contains , print , valid
* and it has two instance variables : listCount (number of the elements in the singly linked list) and header (which is the header (sentinel) node)
*/
public class Singly implements ILinkedList{
	
	/**
	* This class is for the node of the Singly linked list
	* and it has two instance variables : data (which is the data contained in the node) and next (which is the next node following the specified one)
	*/
	private class Node {
		Object data ;
		Node next ;
	}
	
	int listCount;
	Node header ;
	
	//constructor
	public Singly ()
	{
		header = new Node() ;
		header.next=null;
		this.listCount=0;
	}
	
	@Override
	public void add(int index, Object element)  {
		if ( valid(index-1) || index==1 )
		{
			Node added = new Node () ;
			added.data=element;
			Node i = header;
			for (int j=1 ; j<index ;i=i.next) j++;
			added.next= i.next;
			i.next = added ;
			listCount++;		
		}
		else
			throw new RuntimeException ("ERROR : Invalid Index") ;
	}

	@Override
	public void add(Object element) {
		
		Node added = new Node () ;
		added.data=element;
		added.next=null;
		Node i= header ;
		for (; i.next!=null ;i=i.next);
		i.next=added;
		listCount++;	
	}

	@Override
	public Object get(int index) {
		if (valid(index))
		{
			Node i = header;
			for (int j=1; j<=index ;i=i.next) j++;
			return i.data;		
		}
		else
			throw new RuntimeException ("ERROR : Invalid Index") ;
	}

	@Override
	public void set(int index, Object element) {
		if (valid(index))
		{
			Node i = header;
			for (int j=1; j<=index ;i=i.next) j++;
			i.data=element;
		}
		else 
			throw new RuntimeException ("ERROR : Invalid Index") ;
	}

	@Override
	public void clear() {
		header.next=null;
		listCount=0;	
	}

	@Override
	public boolean isEmpty() {
		boolean empty = true ;
		if ( listCount > 0)
			empty=false;
		return empty;
	}

	@Override
	public void remove(int index) {
		if (valid(index))
		{
			Node i = header;
			for (int j=1; j<index ;i=i.next) j++;
			Node t =i.next;
			i.next=t.next;
			listCount--;	
		}
		else 
			throw new RuntimeException ("ERROR : Invalid Index") ;
	}

	@Override
	public int size() {
		return listCount;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		if (valid(fromIndex) && valid(toIndex))
		{
			Node i = header;
			for (int j=1 ; j<=fromIndex ;i=i.next) j++;
			
			Singly subList = new Singly ();
			
			for (int j=fromIndex ;j<=toIndex ; j++) 
			{
				subList.add(i.data);
				i=i.next;
			}
		
			return subList;
		}
		else 
			throw new RuntimeException ("ERROR : Invalid Index") ;
	}

	@Override
	public boolean contains(Object o) {
		boolean found = false ;
		Node i = header;
		for (; i!=null ;i=i.next)
		{
			if (i.data == o)
			{
				found = true ;
				break;
			}
		} 
		return found;
	}
	
	/**
	* Takes a Singly list and Print it
	* @param list
	* Singly list
	*/
	public void print (Singly list) {
		if (listCount != 0) 
		{
			Node i = header.next;
			for (; i!=null ;i=i.next)
				System.out.println(i.data);
		}
	}
	
	/**
	* Checks whether the index chosen is valid (exist in the list) or not
	* @param index
	* index that will be checked
	*/
	public boolean valid(int index) {
		boolean valid = false;
		if (index >0 && index <= listCount)
			valid=true;
		return valid;
	}

}
