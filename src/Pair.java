import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Pair {

	public static void main(String[] args) {
		Map<Integer, String> m = new HashMap<Integer, String>();

		int[] a = { 1, 2, 1, 2, 4, 5, 6, 6, 6, 5, 4 ,7,8};

		System.out.println(m.toString());
		System.out.println(Arrays.toString(a));

		for (int i : a) {
			if (a.length > 1) {
				int temp = a[0];
				a = removeTheElement(a, 0);

				a = p(a, temp, m);
			}
		}

		System.out.println(m.toString());
		System.out.println(Arrays.toString(a));
	}

	private static int[] p(int[] a, int n, Map r) {

		boolean contains = IntStream.of(a).anyMatch(x -> x == n);
		if (contains) {
			int idx = indexOfFirstOne(a, n);
			int[] a_new = removeTheElement(a, idx);

			r.put(n, "");

			return a_new;
		}

		return a;
	}

	private static int indexOfFirstOne(int arr[], int n) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == n) {
				return i;
			}
		}

		return -1;
	}

	private static int[] removeTheElement(int[] arr, int index) {

		if (arr == null || index < 0 || index >= arr.length) {

			return arr;
		}

		int[] anotherArray = new int[arr.length - 1];

		for (int i = 0, k = 0; i < arr.length; i++) {
			if (i == index) {
				continue;
			}
			anotherArray[k++] = arr[i];
		}

		return anotherArray;
	}

}
