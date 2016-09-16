/*********************************************
 * This class implements a Tree data Structure 
 * which includes traversal
 ********************************************/
public class Node {
	
	public Node leftPointer;
	private Node rightPointer;
	
	private char letter;
	private int frequency;
	
	public Node(char k, int v) {
		leftPointer = null;
		rightPointer = null;
		
		letter = k;
		frequency = v;
	}
	
	public Node(int freq, Node left, Node right){
		frequency = freq;
		leftPointer = left;
		rightPointer = right;	
	}
	
	public char getLetter() {
		return letter;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	//Traversal of the tree in prefix recursively
	public void prefixTraversal(Node inNode, StringBuffer s) {
		
		if (inNode != null) {
			
			if (Character.isLetter(inNode.getLetter())) {
				System.out.println(inNode.getLetter() + " " + inNode.getFrequency() + " Encode: " + s);
			}
	
			s.append('0');
			prefixTraversal(inNode.leftPointer , s);
			s.deleteCharAt(s.length()-1);
			
			s.append('1');
			prefixTraversal(inNode.rightPointer, s); 
			s.deleteCharAt(s.length() - 1);
	
		}
	}

}
