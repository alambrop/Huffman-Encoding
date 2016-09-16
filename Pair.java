/********************************************************
 * This class defines a pair that maps a key to its value.
 *******************************************************/
public class Pair {
	
	private char k;
	private int v;
	
	public Pair(char kVal, int vVal) {
		k = kVal;
		v = vVal;
	}
	
	public char getKey() {
		return k;
	}
	
	public int getValue() {
		return v;
	}
	
	public void incValue() {
		v++;
	}
}
