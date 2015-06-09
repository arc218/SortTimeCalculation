package sort;

public class GnomeSort extends BaseSort {

	@Override
	public long sort() {
		long start = System.nanoTime();
		int size = values.length;
		int i = 1;
		while (i < size) {
			if (values[i - 1] <= values[i]) {
				i++;
			} else {
				swap(i, i - 1);
				i--;
				if (i == 0) {
					i += 2;
				}
			}
		}
		long end = System.nanoTime();
		return end - start;
	}

}
