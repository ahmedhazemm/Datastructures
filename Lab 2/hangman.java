package eg.edu.alexu.csd.datastructure.hangman.cs18015030;
import eg.edu.alexu.csd.datastructure.hangman.cs18015030.IHangman;
import java.io.*;  
import java.util.Random;

public class hangman implements IHangman {
	
	public String[] dictionary;
	private String randomSecretWord ;
	char entry;
	public int maxWrongGuesses, failedAttempts = 0 ;
	boolean[] chosen = new boolean[26];
	String word ;
	boolean winFlag=false;

	public boolean validate(String s) {
        for (char c : s.toCharArray()) {
            if (!(Character.isLetter(c))) {
                return false;
            }
        }
        return true;
    }
	
	public String[] scanDictionary() throws Exception {

        int i = 0;
        String currentLine;
        
        try {
        	FileReader fr=new FileReader("C:\\Users\\ADMIN\\Desktop\\Eclipse-Workspace\\Lab2\\bin\\eg\\edu\\alexu\\csd\\datastructure\\hangman\\cs18015030\\words.txt");
            BufferedReader br = new BufferedReader(fr);
            while ((currentLine = br.readLine()) != null) {
                if(validate(currentLine))
                    i++;
            }
            if (i==0) throw new Exception();
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] words = new String[i];
        i = 0;
        try {
            FileReader fr = new FileReader("C:\\Users\\ADMIN\\Desktop\\Eclipse-Workspace\\Lab2\\bin\\eg\\edu\\alexu\\csd\\datastructure\\hangman\\cs18015030\\words.txt");
            BufferedReader br = new BufferedReader(fr);
            while ((currentLine = br.readLine()) != null) {
                if(validate(currentLine)) {
                    words[i] = currentLine;
                    i++;
                }
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
	
	@Override
	public void setDictionary(String[] words) {
		dictionary=words;
	}

	@Override
	public String selectRandomSecretWord() {
		Random r=new Random();
        int randomNumber=r.nextInt(dictionary.length);
        randomSecretWord=dictionary[randomNumber];
        word = randomSecretWord;
        word = word.replaceAll(".", "-");
		return randomSecretWord;
	}

	@Override
	public String guess(Character c) throws Exception {

		if (!Character.isLetter(c)) {
            System.out.println("Invalid");
            System.out.println(word);
            return word;
        }
		
		c = Character.toLowerCase(c);
		
		int index = c - 'a';
		
        if (chosen[index]) {
            System.out.println("Already chosen!");
            System.out.println(word);
            return word;
        } else {
            chosen[index] = true;
        }
        
        char[] temp;
        boolean failed = true;
        for (int i = 0; i < randomSecretWord.length(); i++) {
            if (c == randomSecretWord.charAt(i)) {
                temp = word.toCharArray();
                temp[i] = c;
                word = String.copyValueOf(temp);
                failed = false;
            }
        }
        
        if (failed) {
            failedAttempts++;
        }
        
        if (failedAttempts == maxWrongGuesses) {
            System.out.println("You Lost!");
            return null;
        } else if (word.compareToIgnoreCase(randomSecretWord)==0){
            System.out.println("You Won!");
            winFlag=true;
            System.out.println(word);
            return null;
        }else
        {
        	System.out.println(word);
        	return word;
        }
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		if (max == null) {
            maxWrongGuesses = 1;
        }else {
            maxWrongGuesses = max;
        }		
	}
	
	public int getFailedAttepmts() {
        return failedAttempts;
    }

	public boolean getWinFlag() {
        return winFlag;
    }
	
}

