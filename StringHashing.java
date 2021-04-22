import java.math.BigInteger;
import java.util.*;
 class RabinKarp {
	static int MAXN = 100000 + 5;
	static int p = 31;
	static int m = (int)1e9 + 9;
	static long[] powers = new long[MAXN]; //powers[i] = p^i % m
	static int primeInv = 838709685;
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		int Q = sc.nextInt();
		while(Q-- > 0) {
			String B = sc.nextLine();
			if(B.length() == 0)
				B = sc.nextLine();
			System.out.println(rabinKarp(A, B));
		}
	}
 
	//Number of occcurrences of B in A.
	public static int rabinKarp(String A, String B) {
		int N = A.length();
		int M = B.length();
		powers[0] = 1; 
		for(int i = 1; i <= M - 1; i++) {
			powers[i] = (powers[i - 1] * p) % m;
		}
 
		//Calculating hash for first M sized window
		long hashA = 0, hashB = 0;
		for(int i = 0; i < M; i++) {
			hashA = (hashA  + value(A.charAt(i)) * powers[i]) % m;
			hashB = (hashB + value(B.charAt(i)) * powers[i]) % m;
		}
 
		int count = 0;
		for(int i = 0; i <= N - M; i++) {
			if(hashA == hashB) count++;
			if(i < N - M) {
				hashA = (hashA - value(A.charAt(i)) + m) * primeInv % m;
				hashA = (hashA + value(A.charAt(i + M)) * powers[M - 1]) % m;
			}
		}
 
		return count;
	}
 
	private static int value(char ch) {
		return (int)ch;
	}
}