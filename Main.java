import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		//T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			long x = fs.nextLong();
			Pair min = new Pair(Long.MAX_VALUE, Long.MAX_VALUE);
			for (long num = 1; num <= Math.sqrt(x); num++) {
				if (x % num == 0) {
					long fact1 = num;
					long fact2 = x / num;
					if (getLcm(fact1, fact2) == x) {
						if (Math.max(fact1, fact2) < Math.max(min.first, min.second)) {
							min = new Pair(fact1, fact2);
						}
					}
				}
			}
			out.println(min);
		}
		out.close();
	}
	
	static class Pair {
		long first, second;
		
		Pair(long first, long second) {
			this.first = first;
			this.second = second;
		}
		
		@Override
		public String toString() {
			return first + " " + second;
		}
	}
	
	static long getLcm(long a, long b) {
		return (a * b) / getGcd(a, b);
	}
	
	static long getGcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return getGcd(b, a % b);
	}
	
	static final Random rnd = new Random();
	
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
