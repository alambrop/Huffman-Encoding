import java.util.*;
import java.io.*;
import java.util.LinkedList;
/***************************************************************************************
 * @author Andrew Lambropoulos
 * This project Implements Huffman's Encoding on an input file of text. 
 * The goal of Huffman's encoding is to calculate the frequencies of letters in the text.
 ***************************************************************************************/
public class Main {
	
	public static void main (String [] args) throws IOException {
		
		
		String fileName = "text.txt";
		Scanner inputFile = new Scanner(new File(fileName));
		
		Dictionary dict = new Dictionary(10);
		Pair letterArray[];
		
		//creates a linked list of nodes.
		LinkedList <Node> RemainingNodes = new LinkedList<Node>();
		
		String inputText;
		char letter;
		
		Node newNode = null;
		Node firstMin;
		Node secondMin;
		Node temp;
		
		
		
		/************************************************
		 * Reads file and adds letters to the dictionary.
		 ************************************************/
		while (inputFile.hasNext()) {
			inputText = inputFile.next().toLowerCase();
			
			for (int i = 0; i < inputText.length(); i++) {
				letter = inputText.charAt(i);
				dict.add(letter);
				
			}
		}	
		inputFile.close();
		
		
		/*********************************************************************
		 * creates Nodes out of the letters in the dictionary with frequencies.
 		 *********************************************************************/
		letterArray = dict.getArray();
		for (int i = 0; i < dict.getCard(); i++) {
			
			newNode = new Node(letterArray[i].getKey(), letterArray[i].getValue());
			RemainingNodes.add(newNode);
		
		}
		
		
		/***************************************************************************
		 * Finds the two least frequent letters in order in which they were inserted.
		 **************************************************************************/
		while(RemainingNodes.size()!= 1) {
			
			firstMin = RemainingNodes.get(0);
			secondMin = RemainingNodes.get(1);
			
			for (int i = 2; i < RemainingNodes.size(); i++) {
				
				if (RemainingNodes.get(i).getFrequency() < firstMin.getFrequency()) {
					temp = firstMin;
					firstMin = RemainingNodes.get(i);
					if(secondMin.getFrequency() >= temp.getFrequency()){
						secondMin = temp;
					}	
				}
				
				else if (RemainingNodes.get(i).getFrequency() < secondMin.getFrequency()) 
					secondMin = RemainingNodes.get(i);
			}
			
			//Creates a new node with no letter but a frequency of the first and second minimum combined.
			newNode = new Node(firstMin.getFrequency() + secondMin.getFrequency(), firstMin, secondMin);
			
			//Deletes the two minimum nodes from linked list and adds the new one. 
			RemainingNodes.remove(firstMin);
			RemainingNodes.remove(secondMin);
			RemainingNodes.add(newNode);
		}
		
		//prints out the letter along with its frequency and the code. 
		newNode.prefixTraversal(newNode, new StringBuffer());
	}
}
