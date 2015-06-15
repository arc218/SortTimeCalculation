package sort;

public class HeapSort extends BaseSort {

	@Override
	public long sort() {
		long start = System.nanoTime();

		int size = values.length;
		//printValues();
		for (int i = (size - 2) / 2; i >= 0; i--) {
			downHeap(i, size - 1);
		}

		for (int i = size - 1; i > 0; i--) {
			swap(0, i);
			//printValues();
			downHeap(0, i - 1);
		}
		long end = System.nanoTime();
		return end - start;
	}

	private void downHeap(int k, int r) {
		int j, v;
		v = values[k];
		while (true) {
			j = 2 * k + 1;
			if (j > r) {
				break;
			}
			if (j != r) {
				if (values[j + 1] > values[j]) {
					j += 1;
				}
			}
			if (v >= values[j]) {
				break;
			}
			values[k] = values[j];
			k = j;
		}
		values[k] = v;
	}

}
