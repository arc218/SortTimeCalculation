package sort;

public class ShellSort extends BaseSort {

	@Override
	public long sort() {
		long start = System.nanoTime();
		int size = values.length;

		for (int gap = size / 2; gap > 0; gap /= 2) {
			for (int h = 0; h < gap; h++) {
				for (int i = h + gap; i < size; i += gap) {
					int temp = values[i];
					int j;
					for (j = i - gap; j >= h; j -= gap) {
						if (values[j] < temp) {
							break;
						}
						values[j + gap] = values[j];
					}
					values[j + gap] = temp;
				}
			}
		}
		long end = System.nanoTime();
		return end - start;
	}
}
