package sort;

public abstract class BaseSort {

	protected int [] values;

	public BaseSort(int [] values) {
		copy(values);
	}

	public BaseSort() {
	}

	public void updateData(int [] values) {
		this.values = values;
	}

	/**
	 * Performs sort
	 * return : calculation time
	 */
	public abstract long sort();

	/**
	 * Copys a data
	 */
	protected void copy(int [] values) {
		int size = values.length;
		this.values = new int [size];
		for (int i = 0; i < size; i++) {
			this.values[i] = values[i];
		}
	}

	/**
	 * Prints a data
	 */
	public void printValues() {
		System.out.print("Data : ");
		for (int val : this.values) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	/**
	 * Swapping
	 */
	protected void swap(int i, int j) {
		int temp = values[i];
		values[i] = values[j];
		values[j] = temp;
	}
}
