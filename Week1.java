class Week1 {
	// a
	static int doubleOf(int x) {
		return (x * 2);
	}
	
	// b
	static int squareOf(int x) {
		return (x * x);
	}
	
	// c
	static int difference(int x, int y) {
		return (x - y);
	}
	
	// d
	static double percentage(int n, int total) {
		return (total / n * 100);
	}
	
	// e
	static double average(int x, int y) {
		return ((x + y) / 2);
	}
	
	// f
	static int round(double x) {
		return ((int)(x + 0.5));
	}
	
	// g
	static boolean isNegative(int n) {
		if (n < 0)
			return (true);
		return (false);
	}
	
	// h
	static boolean isImpar(int x) {
		if (x % 2 == 0)
			return (true);
		return (false);
	}
	
	// i
	static boolean isPar(int x) {
		if (x % 2 == 0)
			return (false);
		return (true);
	}
	
	// j
	static boolean isSmaller(int x, int y) {
		if (x < y)
			return (true);
		return (false);
	}
	
	// k
	static boolean isDigit(int x) {
		if (x >= 0 && x <= 9)
			return (true);
		return (false);
	}
	
	// l
	static boolean isIncluded(int x, int y, int z) {
		if (x > y && x < z)
			return (true);
		return (false);
	}
	
	// m
	static boolean isExcluded(int x, int y, int z)
	{
		if (!(x > y && x < z))
			return (true);
		return (false);
	}
	
	// n
	static boolean isMultiPar(int x, int y)
	{
		if (x % y == 0 && x % 2 == 0)
			return (true);
		return (false);
	}

	// o
	static boolean isNegaPar(int x)
	{
		if (x < 0 && x % 2 == 0)
			return (true);
		return (false);
	}
	
	// p
	static boolean isExeclusiveDis(boolean x, boolean y)
	{
		if (x != y)
			return (true);
		return (false);
	}
	
	// q
	static boolean isLowerVowel(char x)
	{
		if (x >= 'a' && x <= 'z')
			return (true);
		return (false);
	}

	// main
	public static void main(String[] args) {
        System.out.printf("%d", doubleOf(4));
    }
}