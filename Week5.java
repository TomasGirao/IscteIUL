class Week5 {
	// A
	static char[] create(char c, int n) {
		char[] array = new char[n];
		for (int i = 0; i < n; i++) {
			array[i] = c;
		}
		return (array);
	}
	// B
	static void fill(char c, char[] v) {
		for (int i = 0; i < v.length; i++)
			v[i] = c;
	}
	// C
	
}
