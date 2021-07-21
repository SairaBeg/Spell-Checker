package Assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class SpellCheck {

	public static void main(String[] args) {
	
//User enters a dictionary file
		try {

			
			System.out.println("Please enter a Dictionary file: ");
			Scanner in = new Scanner(System.in);
			
			
			String dictionaryFile = in.nextLine();
			Scanner in1 = new Scanner(new File(dictionaryFile));
			
			//Debugging line
			//Scanner in1 = new Scanner(new File("/Users/Saira/Desktop/Eclipse Workspace 2021/340 Data Structures and Algorithms/src/Assignment4/words.txt"));
			
			
//put each word in the file into a BinaryTree
BinaryT<String> tree = new BinaryT<String>();			
			while (in1.hasNextLine()) {
				String line = in1.nextLine();		
				tree.insert(line);
			}
//print height of the dictionary BinaryTree			
		System.out.println("Loaded the words into a tree with height = "+ tree.height());	
		

//ask user for a string of words			
			Scanner in3 = new Scanner(System.in);
			String input = null;
			while (input != "END") {
System.out.println("Enter a string: ");
			 input = in3.nextLine();
			 
//If "END" is entered, program is ended
			 if (input.equals("END") ) {
				 System.out.println("Program Ended.");
					break;
			}
			 
//Split the input into words
			 String[] inputParts = input.split(" ");
			 
//Check if the words are in the BinaryTree
		for (int i=0; i<inputParts.length; i++) {
			if(tree.search(inputParts[i])== null) {
				System.out.println(inputParts[i]+ " is spelled wrong!");
			}
			
		}

			 
			 
			}
//If file is not found, print an error
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found.");
		}

	}


	
}
