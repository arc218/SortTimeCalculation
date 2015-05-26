package sort;

public class BubbleSort extends Sort {

	/**
	 * 配列をコピーする
	 */
	public BubbleSort(int [] values) {
		super(values);
	}

	@Override
	public long calc() {
		long start = System.currentTimeMillis();
		int size = values.length;
		for (int i = 0; i < size - 1; i++) {
			for (int j = size - 1; j > i; j--) {
				if (values[j] < values[j - 1]) {
					int temp = values[j];
					values[j] = values[j - 1];
					values[j - 1] = temp;
				}
			}
		}
		long end = System.currentTimeMillis();
		return end - start;
	}

}
