package sort;

public class OddEvenSort extends Sort {

	public OddEvenSort(int [] values) {
		super(values);
	}

	@Override
	public long calc() {
		long start = System.currentTimeMillis();
		int size = values.length;
		int flag = 1;
		while (flag == 1) {
			flag = 0;
			for (int i = 0; i < size - 1; i += 2) {
				if (values[i] > values[i + 1]) {
					swap(i, i + 1);
					flag = 1;
				}
			}

			for (int i = 1; i < size - 1; i += 2) {
				if (values[i] > values[i + 1]) {
					swap(i, i + 1);
					flag = 1;
				}
			}
		}
		long end = System.currentTimeMillis();
		return end - start;
	}

}