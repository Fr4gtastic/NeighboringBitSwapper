import java.util.Random;

public class NeighboringBitSwapper {
	
	private static int swapTwoBits(int number, int firstBitPosition, int secondBitPosition) {

		int bit1 = (number >> firstBitPosition) & 1;
		int bit2 = (number >> secondBitPosition) & 1;

		if(bit1 == bit2) {
			return number;
		}
		
		int mask = (1 << firstBitPosition) | (1 << secondBitPosition);

		// printout for debugging purposes
		//System.out.println(Integer.toBinaryString(number ^ mask));
		return number ^ mask;
	}
	
	public static int swapPairsOfBits(Integer number) {

	    int length = Integer.toBinaryString(number).length();

		for(int i = 0; i < length; i += 2) {
            // printout for debugging purposes
		    //System.out.println(i);
			number = swapTwoBits(number, i, i + 1);
		}
		
		return number;
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		int exampleValue = rand.nextInt(100);

		System.out.println(exampleValue);
		System.out.println(Integer.toBinaryString(exampleValue));
		System.out.println(Integer.toBinaryString(swapPairsOfBits(exampleValue)));
	}
}