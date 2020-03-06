package eg.edu.alexu.csd.datastructure.iceHockey.cs;

import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;

public class playersFinder implements  IPlayersFinder {
	
	boolean pixels[][] = new boolean[50][50];
	int squareNum =0,counter =0 ,playersCount=0 ,index=0;
	Point[] players = new Point [50];
	int maxR=-1,maxC=-1,minR=51,minC=51;
	
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		
		if (photo==null) {
			return  null;
		}
		 
		char c=(char)(team+'0');
		for (int y=0 ; y<photo.length ;y++)
		{
			for (int x=0 ;x<photo[0].length() ;x++)
			{
				if ( photo[y].charAt(x) == c )
				{
					pixels [x][y] = true;
					squareNum++;
				}
			}
		}
	
		if (squareNum == 0 || squareNum*4<threshold) {
			return  null;
		}
		
		for (int i=0 ; i<50 ;i++)
		{
			for (int j=0 ;j<50 ;j++)
			{
				check (i,j);
				if (counter*4 >= threshold )
				{
					playersCount++;
					players [index] = new Point (minR+maxR+1 , minC+maxC+1) ;
					index++;
				}
				counter=0;
				maxR=-1;
				maxC=-1;
				minR=51;
				minC=51;
			}
		}
		
		Point[] playersCopy = new Point [playersCount];
		
		for (int i=0 ;i<playersCount ;i++)
		{
			playersCopy[i]=players[i];
		}
	
		Arrays.sort(playersCopy, new Comparator<Point>()
		{
		    public int compare(Point a, Point b) {
		        int xComp = Integer.compare(a.x, b.x);
		        if(xComp == 0) {
					return Integer.compare(a.y, b.y);
				} else {
					return xComp;
				}
		    }
		} );	
			
		return playersCopy;
	}
	
	
	public void check(int row , int col) 
	{
		if ( row>=0 && row<50 && col>=0 && col<50 && pixels [row][col] )
		{
		if(row<minR) {
			minR=row;
		}
		if(row>maxR) {
			maxR=row;
		}
		if(col<minC) {
			minC=col;
		}
		if(col>maxC) {
			maxC=col;
		}
		counter++;
		pixels [row][col] = false ;
		check(row ,col+1);
		check(row+1 ,col);
		check(row-1 ,col);
		check(row ,col-1);
		}
	}
	
}
