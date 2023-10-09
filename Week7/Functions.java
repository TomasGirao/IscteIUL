import Math;
import java.util.Random;

class Functions {
	static int randMax(int x){
		Random rand = new Random();
		return rand.nextInt(x);
	}
	static int constrain(int n, int min, int max){
		if (n < min)
			return min;
		else if (n > max)
			return max;
		return n;
	}
	static boolean randBool(){
		Random rand = new Random();
		return rand.nextBoolean();
	}
	static boolean[] boardBool(){
		boolean[]
	}
}
