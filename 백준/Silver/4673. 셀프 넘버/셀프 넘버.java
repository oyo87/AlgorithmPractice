public class Main {

	public static boolean[] d(int i, boolean[] arr) {
		int sum = i;
		while (i != 0) {
			sum += i % 10;
			i /= 10;
		}
		if (sum < 10000) {
			arr[sum] = true;
		} 
		
		return arr;
	}

	public static void main(String[] args) {
		boolean[] arr = new boolean[10000];

		for (int i = 1; i < 10000; i++) {
			arr = d(i, arr);
		}
		for (int i = 1; i < 10000; i++) {
			if (arr[i] == false)
				System.out.println(i);
		}
	}
}
