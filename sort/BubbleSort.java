package sort;

public class BubbleSort extends BaseSort {

	@Override
	public long sort() {
		long start = System.nanoTime();
		int size = values.length;
		for (int i = 0; i < size - 1; i++) {
			for (int j = size - 1; j > i; j--) {
				if (values[j] < values[j - 1]) {
					swap(j, j - 1);
				}
			}
		}
		long end = System.nanoTime();
		return end - start;
	}

}
