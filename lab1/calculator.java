package lab1;

public class calculator implements ICalculator   {
	
	public int add(int x, int y) {
		
		return x+y;
	}

	public float divide(int x, int y) {
		
		if (y==0)
			throw new RuntimeException() ;
		
		return (float)x/y;
	}
	
}
