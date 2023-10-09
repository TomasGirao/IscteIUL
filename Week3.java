

public class Week3 {
	// a
	static int divisors(int n) {
		int	divisors;
		int tmp;

		tmp = n;
		divisors = 0;
		while (tmp > 0) {
			if (n % tmp == 0)
				divisors++;
			tmp--;
		}
		return (divisors);
	}

	// b
	static int sumDivisors(int n) {
		int	divisors;
		int tmp;

		tmp = n - 1;
		divisors = 0;
		while (tmp > 0) {
			if (n % tmp == 0)
				divisors += tmp;
			tmp--;
		}
		return (divisors);
	}

	// c
	static int perfectNumbersUpTo(int n) {
		int	i;
		int	div;
		int tmp;
		int result;

		i = 1;
		div = 0;
		tmp = 1;
		result = 0;
		while (i <= n) {
			while (tmp < i) {
				if (i % tmp == 0)
					div += tmp;
				tmp++;
			}
			if (div == i)
				result++;
			div = 0;
			tmp = 1;
			i++;
		}
		return (result);
	}

	// d
	static boolean isPrime(int n) {
		int	div;

		div = 2;
		while (div < n) {
			if (n % div == 0)
				return (false);
			div++;
		}
		return (true);
	}

	// e
	static int sumPrimesSmallerThan(int n) {
		int i;
		int	result;

		result = 0;
		i = 2;
		while (i <= n) {
			if (isPrime(i))
				result += i;
			i++;
		}
		return (result);
	}

	// f
	static int countPrimesUpTo(int n) {
		int i;
		int	primes;

		i = 2;
		primes = 0;
		while (i <= n) {
			if (isPrime(i))
				primes ++;
			i++;
		}
		return (primes);
	}

	// g
	static boolean existsPrimeBetween(int n, int p) {
		int	i;

		i = n + 1;
		while (i < p) {
			if (isPrime(i))
				return (true);
			i++;
		}
		return (false);
	}

	// h
	static int fibonacci(int n) {
		if (n == 1)
			return (1);
		else if (n > 0)
			return (fibonacci(n - 1) + fibonacci(n - 2));
		return (0);
	}

	// i
	static int factorial(int n) {
		if (n <= 0)
			return (1);
		return (n * factorial(n - 1));
	}

	// j
	static int gcd(int x, int y) {
		if (y == 0)
			return (x);
		return (gcd(y, x % y));
	}

	// Extra
	// k
	static int largerDifferenceBetweenPrimes(int n) {
		int i;
		int prime;
		int tmp;

		i = 1;
		prime = 0;
		tmp = 0;
		while (i <= n) {
			if (isPrime(i)) {
				if (i - prime > prime - tmp) {
					tmp = prime;
					prime = i;
				}
			}
			i++;
		}
		return (prime - tmp);
	}

	// Debugging
	// main
	public static void main(String[] args) {
		System.out.printf("(A)Result = %d%n", divisors(8));
		System.out.printf("(B)Result = %d%n", sumDivisors(6));
		System.out.printf("(C)Result = %d%n", perfectNumbersUpTo(30));
		System.out.printf("(D)Result = %b%n", isPrime(6));
		System.out.printf("(E)Result = %d%n", sumPrimesSmallerThan(8));
		System.out.printf("(F)Result = %d%n", countPrimesUpTo(10));
		System.out.printf("(G)Result = %b%n", existsPrimeBetween(5, 9));
		System.out.printf("(H)Result = %d%n", fibonacci(4));
		System.out.printf("(I)Result = %d%n", factorial(5));
		System.out.printf("(J)Result = %d%n", gcd(30, 25));
		System.out.printf("(K)Result = %d%n", largerDifferenceBetweenPrimes(11));
	}
}
