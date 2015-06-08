package sort;

public class CombSort extends BaseSort {

	@Override
	public long sort() {
		long start = System.currentTimeMillis();
		int size = values.length;
		int h = size * 10 / 13;
		while (true) {
			int swaps = 0;
			for (int i = 0; i + h < size; ++i) {
				if (values[i] > values[i + h]) {
					swap(i, i + h);
					++swaps;
				}
			}

			if (h == 1) {
				if (swaps == 0) {
					break;
				}
			} else {
				h = h * 10 / 13;
			}
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
}
