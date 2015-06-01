package sort;

public class ShakerSort extends Sort {

	public ShakerSort(int [] values) {
		super(values);
	}

	@Override
	public long calc() {
		long start = System.currentTimeMillis();
		int size = values.length;
		int top = 0;
		int bottom = size - 1;

		while (true) {
			int last;
			last = top;
			for (int i = top; i < bottom; i++) {
				if (values[i] > values[i + 1]) {
					int temp = values[i];
					values[i] = values[i + 1];
					values[i + 1] = temp;
					last = i;
				}
			}
			bottom = last;
			if (top == bottom) {
				break;
			}
			last = bottom;
			for (int i = bottom; i > top; i--) {
				if (values[i] < values[i - 1]) {
					swap(i, i - 1);
					last = i;
				}
			}
			top = last;
			if (top == bottom) {
				break;
			}
		}
		long end = System.currentTimeMillis();
		return end - start;
	}

}
