/****************************************************************
 * This Class implements a Dictionary Data Structure.
 * Used to keep track of the letters in the text and their values.
 * Keeps track of frequency.
 ****************************************************************/
public class Dictionary {
	
		private Pair letterArray[]; 	
		private int capacity;
		private int cardinality;
	
		
		public Dictionary(int count) {
		
			letterArray = new Pair[count];
			capacity = count;
			cardinality = 0;
		}
		
		
		public void add(char k) {
		
			//Checks if the letter Array is at capacity and doubles the capacity if true.		
			if (cardinality == capacity) {
			
				Pair newArray[] = new Pair[capacity * 2];
				
				
				for(int i = 0; i < cardinality; i++) {
				
					newArray[i] = letterArray[i];
				}
				letterArray = newArray;
				capacity = 2 * capacity;
			}
			
			//Checks if the word is already in the array and increases the value if true.
			Pair p = find(k);
			if (p != null) {
			
				p.incValue();
			}
			//If it's not in the array it adds the word in the proper place in the array.
			else {
			
				letterArray[cardinality] = new Pair(k,1);
				cardinality++;	
			}	
		}
		
	
		//Method to find a char in the array
		public Pair find(char k)
		{
			for(int i  = 0; i < cardinality; i++)
			{
				
				if(letterArray[i].getKey() == k)
				{	
					
					return  letterArray[i];
				}
			}	
			return null;
		}
		

		public Pair[] getArray()
		{
			return letterArray;
		}
		
		public int getCard(){
			return cardinality;
		}
	
	
}
