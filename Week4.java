//import java.util.random;

public class Week4 {
	// a
	static int[] naturals(int n) {
		int[] array;
		int i;
		array = new int[n];
		i = 1;
		while(i <= n) {
			array[i -1] = i;
			i++;
		}
		return (array);
	}

	// b
	static int sum(int[] v) {
		int result;

		result = 0;

		for (int i : v)
			result += i;
		return (result);
	}

	// c
	static int[] randomDigits(int n) {
		int array[] = new int[n];
		for (int i = 0; i < n; i++) {
			double rd = Math.random();
			int	nb = (int) (rd * 10);
			array[i] = nb;
		}
		return (array);
	}

	// d
	static double mean(double n[]) {
		double result = 0;
		double size = 0;
		for (double i : n) {
			result += i;
			size++;
		}
		return (result / size);
	}

	// e
	static int[] copyn(int[] v, int lenght) {
		int array_copy[] = new int[lenght];
		int i = 0;
		for (int n : v) {
			array_copy[i] = n;
			i++;
		}
		while (i < lenght) {
			array_copy[i] = 0;
			i++;
		}
		return (array_copy);
	}

	// f
	static int[] copy(int[] v) {
		int size = v.length;
		int array_copy[] = new int[size];
		int i = 0;
		for (int a : v) {
			array_copy[i] = a;
			i++;
		}
		return (array_copy);
	}

	// g
	static boolean exists(int n, int[] v) {
		for (int i : v) {
			if (i == n)
				return (true);
		}
		return (false);
	}

	// h
	static int count(int n, int[] v) {
		int counter = 0;
		for (int i : v) {
			if (i == n) {
				counter++;
			}
		}
		return (counter);
	}

	// i
	static int max(int[] v) {
		int nb = 0;
		for (int i : v) {
			if (i > nb)
				nb = i;
		}
		return (nb);
	}

	// j
	static int[] subArray(int min, int max, int[] v) {
		int i = 0;
		int size = max - min + 1;
		if (min < 0 || max > v.length || size < 0) {
			int array_error[] = {0};
			return (array_error);
		}
		int array_copy[] = new int[size];
		while (i + min <= max) {
			array_copy[i] = v[i + min];
			i++;
		}
		return (array_copy);
	}

	// k
	static int[] firstHalf(int[] v, boolean includeMiddle) {
		int size = v.length;
		int array_copy[];
		if (size % 2 == 0 || !includeMiddle) {
			size = size / 2;
			array_copy = new int[size];
			for (int i = 0; i <= size / 2; i++)
				array_copy[i] = v[i];
		}
		else {
			size = size / 2 + 1;
			array_copy = new int[size];
			for (int i = 0; i <= size / 2; i++)
					array_copy[i] = v[i];
		}
		return (array_copy);
	}

	// main
	public static void main(String[] args) {
		// a
		int[] array = naturals(5);
		System.out.print("(A) Result: ");
		for(int i : array)
			System.out.printf("%d, ", i);
		System.out.printf("%n");

		// b
		int	arrayb[] = {1, 3, 5};
		System.out.printf("(B) Result: %d%n", sum(arrayb));

		// c
		array = randomDigits(5);
		System.out.print("(C) Result: ");
		for (int i : array)
			System.out.printf("%d, ", i);
		System.out.printf("%n");

		// d
		double arrayd[] = {13, 14, 16, 15};
		System.out.printf("(D) Result: %.1f%n", mean(arrayd));

		// e
		int arraye[] = {1, 2, 3};
		System.out.print("(E) Result: ");
		for (int i : copyn(arraye, 6))
			System.out.printf("%d, ", i);
		System.out.printf("%n");

		// f
		int arrayf[] = {3, 4, 1};
		System.out.print("(F) Result: ");
		for (int i : copy(arrayf))
			System.out.printf("%d, ", i);
		System.out.printf("%n");

		// g
		int arrayg[] = {1, 5, 2};
		System.out.printf("(G) Result: %b%n", exists(5, arrayg));

		// h
		int arrayh[] = {1, 3, 4, 5, 3};
		System.out.printf("(H) Result: %d%n", count(3, arrayh));

		// i
		int arrayi[] = {5, 1, 6, 9, 3};
		System.out.printf("(I) Result: %d%n", max(arrayi));

		// j
		int arrayj[] = {3, 5, 6, 7, 8, 9};
		System.out.print("(J) Result: ");
		for (int i : subArray(2, 4, arrayj))
			System.out.printf("%d, ", i);
		System.out.printf("%n");

		// k
		int arrayk[] = {1, 2, 3, 4, 5};
		System.out.print("(K) Result: ");
		for (int i : firstHalf(arrayk, false))
			System.out.printf("%d, ", i);
		System.out.printf("%n");
	}
}
