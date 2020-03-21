package eg.edu.alexu.csd.datastructure.linkedList.cs;

public class test {

	public static void main(String[] args)
	{
		Psolver obj = new Psolver ();
		int poly1[][] = { { 1, 7}, { 2, 9} };	
		int poly2[][] = { { 2, -15}, { 3, -14} };	
		
		obj.setPolynomial('A',poly1);
		obj.setPolynomial('B',poly2);
		
		
		//list=obj.polyA;
		//list.print(list);
		//obj.clearPolynomial('A');
		
		obj.setPolynomial('R', obj.multiply('A', 'B') );
		
		
		
		
		System.out.print(obj.print('R'));
		//System.out.print(obj.print('B'));
		
		

	}
}
