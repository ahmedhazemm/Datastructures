package eg.edu.alexu.csd.datastructure.hangman.cs18015030;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception
    {
        hangman test = new hangman() ;
        Scanner myObj = new Scanner(System.in); 
        
        String[] words = test.scanDictionary()  ;
        test.setDictionary(words);
        
        String randomSecretWord = test.selectRandomSecretWord();
        System.out.println(randomSecretWord);
        
        System.out.println("Enter number of max wrong guesses: ");
        int max = myObj.nextInt(); 
        test.setMaxWrongGuesses(max);
        
        char c;
        
		do
        {
        	System.out.println("Enter the expected letter: ");
            c = myObj.next().charAt(0);
            
        	test.guess(c);
        	
        } while ( (test.getFailedAttepmts() < max) && !(test.getWinFlag()) );
       
    }
}
