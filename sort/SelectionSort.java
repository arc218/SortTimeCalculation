package sort;

public class SelectionSort extends BaseSort {

	@Override
	public long sort() {
		long start = System.nanoTime();
		int size = values.length;
		for (int i = 0; i < size; i++) {
			int min = i;
			for (int j = i + 1; j < size; j++) {
				if (values[min] > values[j]) {
					min = j;
				}
			}
			if (min != i) {
				swap(i, min);
			}
		}
		long end = System.nanoTime();
		return end - start;
	}
}
