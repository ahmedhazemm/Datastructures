package eg.edu.alexu.csd.datastructure.stack.cs;
import java.util.*;

public class stackUI 
{	
	static myStack s = new myStack () ;
	
	public static void main(String[] args) 
	{	
		System.out.println( "Choose number of operation :\n" + "1: Push\n" + "2: Pop\n" + "3: Peek\n" + "4: Get size\n" + "5: Check if empty\n"+ "6: Print Stack\n" + "7: Clear Stack");
		Scanner scan ;
		
		do
		{
			scan = new Scanner (System.in) ;
		}
		while ( !scan.hasNextInt() );
		
		switch (scan.nextInt())
		{
		case 1 :
			do{scan = new Scanner (System.in) ;}
			while ( !scan.hasNextInt() );
			s.push(scan.nextInt());
			break;
		case 2 :
			System.out.println(s.pop());
			break;
		case 3 :
			System.out.println(s.peek());
			break;
		case 4 :
			System.out.println(s.size());
			break;
		case 5 :
			System.out.println("Empty : "+ s.isEmpty());
			break;
		case 6 :
			s.print();
			break;
		case 7 :
			s.clear();
			break;
		default :
			main(args);
		}
		
		main(args);
	}
}