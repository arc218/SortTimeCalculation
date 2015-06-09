package sort;

public class MergeSort extends BaseSort {

	@Override
	public long sort() {
		long start = System.nanoTime();
		mergeSort(values);
		long end = System.nanoTime();
		return end - start;
	}

	private void mergeSort(int [] values) {
		int size = values.length;
		if (size > 1) {
			int m = size / 2;
			int n = size - m;
			int [] a1 = new int [m];
			int [] a2 = new int [n];
			for (int i = 0; i < m; i++) {
				a1[i] = values[i];
			}
			for (int i = 0; i < n; i++) {
				a2[i] = values[m + i];
			}
			mergeSort(a1);
			mergeSort(a2);
			merge(a1, a2, values);
		}
	}

	private void merge(int [] a1, int [] a2, int [] values) {
		for (int i = 0, j = 0; i < a1.length || j < a2.length;) {
			if (j >= a2.length || (i < a1.length && a1[i] < a2[j])) {
				values[i + j] = a1[i];
				i++;
			} else {
				values[i + j] = a2[j];
				j++;
			}
		}
	}
}
