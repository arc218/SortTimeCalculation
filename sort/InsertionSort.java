package sort;

public class InsertionSort extends BaseSort {

	@Override
	public long sort() {
		long start = System.nanoTime();
		int size = values.length;
		for (int i = 0; i < size; i++) {
			int ins = values[i];
			for (int j = i; j >= 0; j--) {
				if ((j > 0) && (values[j - 1] > ins)) {
					values[j] = values[j - 1];
				} else {
					values[j] = ins;
					break;
				}
			}
		}
		long end = System.nanoTime();
		return end - start;
	}
}
