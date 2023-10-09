public class Week2 {
	// a
	static int max(int a, int b) {
		if (a >= b)
			return (a);
		return (b);
	}

	// b
	static boolean isMulti(int x, int y) {
		int	i;
	
		i = 0;
		while (i * y <= x ) {
			if (i * y == x)
				return (true);
			i++;
		}
		return (false);
	}

	// c
	static int abs(int x) {
		if (x < 0)
			return (-x);
		return (x);
	}

	// d
	static int irs(int x) {
		if (x < 10000)
			return (1);
		else if (x >= 1000 && x < 25500)
			return (2);
		else if (x >= 25500 && x < 48500)
			return (3);
		else
			return (4);
	}

	// e
	static char nextLetter(char letter) {
		if (letter >= 'a' && letter < 'z')
			letter += 1;
		else
			letter = 'a';
		return (letter);
	}

	// f
	static int firstDig(int x) {
		while (x >= 9)
			x /= 10;
		return (x);

		/*
		if (x >= 9) {
			res =  res / 10;
			return (firstDig(res));
		}
		else
			return (res);
		*/
	}
	
	// g
	static int wholeDiv(int x, int y) {
		int div;
	
		div = 0;
		while (y * div < x) {
			div++;
		}
		return (div);
	}

	// h
	static int powerOfTwo(int x) {
		int	i;
		int res;
	
		i = 1;
		res = 2;
		while (i <= x)
			res *= 2;
		return (res);
	}

	// i
	static int sumNaturalsUpTo(int x) {
		int result;
		int i;
	
		i = 0;
		result = 0;
		while (i < x) {
			result += i;
			i++;
		}
		return (result);
	}

	// j
	static int sumEvenNumbersBetween(int x, int y) {
		int result;
		int i;
	
		i = x;
		result = 0;
		while (i < y) {
			if (i % 2 == 0) {
				result += i;
			}
			i++;
		}
		return (result);
	}

	// Extra
	// k
	static int nFibonacci(int x) {
		int	i;
		int	prev;
		int result;
		int	tmp;
	
		i = 2;
		prev = 0;
		result = 1;
		if (x == 1)
			return (1);
		else {
			while (i <= x) {
				tmp = result;
				result += prev;
				prev = tmp;
				i++;
			}
		}
		return (result);
	}

	// l
	static int gcd(int x, int y) {
		int result;
	
		if (x >= y)
			result = x;
		else
			result = y;
		while (result > 0) {
			if (x % result == 0 && y % result == 0)
				return (result);
			result--;
		}
		return (result);
	}
	
	// main
	public static void main(String[] args) {
        System.out.printf("Index 7 in Fibonnaci = %d;%n", nFibonacci(7));
		System.out.printf("First Digit of (378) = %d;", firstDig(378));
    }
}