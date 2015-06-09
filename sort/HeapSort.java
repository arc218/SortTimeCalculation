package sort;

public class HeapSort extends BaseSort {

	@Override
	public long sort() {
		long start = System.nanoTime();
		int right = values.length - 1;
		int left = 0;
		sort(right, left);
		long end = System.nanoTime();
		return end - start;
	}

	private void sort(int right, int left) {
		if (right <= left) {
			return;
		}
		int pivot = values[right];
		int sakai = divide(right, left, pivot);
		sort(sakai - 1, left);
		sort(right, sakai);
	}

	private int divide(int right, int left, int pivot) {
		int r = right;
		int l = left - 1;
		while (true) {
			r -= 1;
			while (values[r] >= pivot) {
				if (r > left) {
					r--;
				} else {
					break;
				}
			}
			l++;
			while (values[l] <= pivot) {
				if (l < right) {
					l++;
				} else {
					break;
				}
			}
			if (l >= r) {
				swap(l, right);
				return l;
			}
			swap(l, r);
		}
	}
}
