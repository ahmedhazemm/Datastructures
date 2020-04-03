package eg.edu.alexu.csd.datastructure.stack.cs;
import eg.edu.alexu.csd.datastructure.linkedList.cs.*;
import java.lang.Math; 

/**
* This class implements the (IExpressionEvaluator) interface
* its methods are : infixToPostfix ,  evaluate , validInfix
*/
public class expEval implements IExpressionEvaluator {

	@Override
	public String infixToPostfix(String expression) {
		expression=expression.replaceAll(" ", "");
		//using dummy zero to handle negative numbers
		for(int i=0; i<expression.length();i++)
		{
			 if (expression.charAt(i)=='-' && Character.isLetterOrDigit(expression.charAt(i+1)) && (i==0 || expression.charAt(i-1)=='+' || expression.charAt(i-1)=='-' || expression.charAt(i-1)=='*' || expression.charAt(i-1)=='/'))
			 {
				String neg = new String ("-");//(Character.toString(expression.charAt(i)))
				int j=i+1;
				while ( j < expression.length() && Character.isLetterOrDigit(expression.charAt(j))) 
				{
					neg+=expression.charAt(j);
					j++;
				}
				expression=expression.replaceAll(neg,"(0-" +neg.substring(1,neg.length()) + ")");
			}
		}
		
		myStack op = new myStack();
		String post = new String () ;
		for(int i=0; i<expression.length();i++)
		{
			if ( Character.isLetterOrDigit( expression.charAt(i) ) )
				post+=expression.charAt(i);
			else if ( expression.charAt(i)=='(' )
				op.push( expression.charAt(i) );
			else if ( expression.charAt(i)==')' )
			{
				while ( (char) op.peek() != '(' ) 
					post = post + " " + op.pop() + " " ;
				op.pop() ;
			}
			else 
			{
				if ( op.isEmpty() )
				{
					post+=" ";
					op.push( expression.charAt(i) );
				}
				else
				{
					if ( expression.charAt(i)=='+' || expression.charAt(i)=='-' )
					{
						boolean flag = false ;
						while ( !op.isEmpty() )
						{
							if ( (char) op.peek()!='(' ) 
							{
								post = post + " " + op.pop() + " " ;
								flag = true ;
							}
							else 
								break ;
						}
						if ( !flag ) post+=" ";
					}
					else 
					{
						boolean flag = false ;
						while ( !op.isEmpty() )
						{
							if ( (char) op.peek()=='*' || (char) op.peek()=='/' )
							{
								post = post + " " + op.pop() + " " ;
								flag = true ;
							}
							else 
								break ;
						}
						if ( !flag ) post+=" ";
					}
					op.push( expression.charAt(i) );
				}
			}
		}
		//then pop all operations
		while ( !op.isEmpty() ) post = post + " " + op.pop() + " " ;
		
		return post.replaceAll("  ", " ") ;
	}

	@Override
	public int evaluate(String expression) {
		myStack s = new myStack () ;
		
		for (int i=0 ;i<expression.length() ;i++)
		{
			if ( Character.isDigit(expression.charAt(i)) )
			{
				int j=0;
				float input=0;
				do {
						input = (float) (input * Math.pow(10, 1) + ( (int)expression.charAt(i+j)-48 ))  ;
						j++;
					}
				while ( expression.charAt(i+j) !=' ' );
				i+=j;
				s.push(input);
			}
			
			if ( !Character.isDigit(expression.charAt(i)) && expression.charAt(i)!=' ' )
			{
				switch ( expression.charAt(i) ) 
				{
				case '+' :
					s.push( (float) s.pop() + (float) s.pop() );
					break;
				case '-' :
					s.push( -1*(float)  s.pop() + (float) s.pop() );
					break;
				case '*' :
					s.push( (float) s.pop() * (float) s.pop() );
					break;
				case '/' :
					if ( (float) s.peek() == 0 ) throw new RuntimeException ("Division by zero") ;
					s.push( 1  /( (float) s.pop() / (float) s.pop() ) );
					break;
				}
			}
		}
				
		return (int) (float) s.peek() ;
	}

	/**
	* Takes a symbolic/numeric infix expression as input and check its validity
	* @param s
	* infix expression
	* @return true if valid and false if not
	*/
	public boolean validInfix (String s)
	{
		for (int i=0 ;i<s.length() ;i++)
		{
			if (!Character.isLetterOrDigit(s.charAt(i))&& s.charAt(i)!='+'&& s.charAt(i)!='-'&& s.charAt(i)!='*'&& s.charAt(i)!='/'&& s.charAt(i)!='('&& s.charAt(i)!=')'&& s.charAt(i)!=' ')
				return false;
			if (i!=s.length()-1&&((Character.isLetterOrDigit(s.charAt(i))&&Character.isLetterOrDigit(s.charAt(i+1)))&&!(Character.isDigit(s.charAt(i))&&Character.isDigit(s.charAt(i+1)))))
				return false;
		}
		
		myStack par = new myStack( );
		for (int i=0 ;i<s.length() ;i++)
		{
			if ( s.charAt(i) == '(')
				par.push(s.charAt(i));
			else if ( s.charAt(i) == ')' )
			{
				if (par.isEmpty())
					return false;
				else par.pop();
			}
		}
		if ( !par.isEmpty() ) return false ;
		
		Singly infix = new Singly () ;
		for (int i=0 ;i<s.length() ;i++)
			if ( s.charAt(i) != '(' && s.charAt(i) != ')' && s.charAt(i) != ' ' )
				infix.add(s.charAt(i));
		
		for (int i=1 ;i<=infix.size() ;i++)
		{
			if ( !Character.isLetterOrDigit( (char)infix.get(i) ) )	
			{
				if ( i==infix.size() ) 
					return false ;
				if ( !Character.isLetterOrDigit((char)infix.get(i+1)) ) 
				{
					if ( (char)infix.get(i+1) !='-' )
						return false ;
					if ( i<infix.size()-1&&(char)infix.get(i+2)=='-' )
						return false ;
				}
				if ( (char)infix.get(i) !='-' )
				{
					if ( i==1 ) 
						return false ;
					if ( !Character.isLetterOrDigit((char)infix.get(i-1)) )
						return false;
				}
			}
		}
		
	return true ;	
	}
}
