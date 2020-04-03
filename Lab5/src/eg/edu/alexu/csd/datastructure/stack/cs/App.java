package eg.edu.alexu.csd.datastructure.stack.cs;
import java.util.*;

public class App {
	
	public static void main(String[] args)
	{
		expEval obj = new expEval ();
		System.out.println( "Enter the infix expression : ");
		Scanner scan ;
		scan = new Scanner (System.in) ;
		String exp = scan.nextLine() ;
		
		if ( obj.validInfix(exp) )
			System.out.println( "Postfix notation : " + obj.infixToPostfix(exp) );
		else
		{
			System.out.println("ERROR : Invalid Expression ");
			System.exit(1);
		}
		
		exp = obj.infixToPostfix(exp) ;
		
		//substitution
		for (int i=0 ;i<exp.length() ;i++)
		{
			if ( Character.isLetter( exp.charAt(i) ) )
			{
				do {
					System.out.println("Enter the value of " + exp.charAt(i) + " :");
					scan = new Scanner (System.in) ;
				}while ( !scan.hasNextInt() ) ;
				
				String input = String.valueOf(scan.nextInt()) ;
				exp=exp.replaceAll( Character.toString(exp.charAt(i)) , input ) ;	
			}
		}
		System.out.println( "Value : " + obj.evaluate(exp) ); 
	}
}
