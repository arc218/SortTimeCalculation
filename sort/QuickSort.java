package sort;

public class QuickSort extends BaseSort {

	@Override
	public long sort() {
		long start = System.nanoTime();
		sort(0, values.length - 1, values);
		long end = System.nanoTime();
		return end - start;
	}

	private void sort(int left, int right, int [] values) {
		if (right <= left) {
			return;
		}
		int sakai = divide(left, right, values);
		sort(left, sakai - 1, values);
		sort(sakai, right, values);
	}

	private int divide(int left, int right, int [] values) {
		int r = right;
		int l = left;
		int pivot = values[(right + left) / 2];
		while (l <= r) {

			while (values[r] > pivot) {
				if (r > left) {
					r--;
				} else {
					break;
				}
			}

			while (values[l] < pivot) {
				if (l < right) {
					l++;
				} else {
					break;
				}
			}
			if (l <= r) {
				swap(l, r);
				l++;
				r--;
			}
		}
		return l;
	}
}
