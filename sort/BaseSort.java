package sort;

public abstract class BaseSort {

	protected int[] values;

	public BaseSort(int[] values) {
		copy(values);
	}

	public BaseSort() {
	}

	public void updateData(int[] values) {
		this.values = values;
	}

	/**
	 * ソートを行う
	 */
	public abstract long sort();

	/**
	 * 配列をコピーする
	 */
	protected void copy(int[] values) {
		int size = values.length;
		this.values = new int [size];
		for (int i = 0; i < size; i++) {
			this.values[i] = values[i];
		}
	}

	/**
	 * 配列の出力
	 */
	public void printValues() {
		System.out.print("Data : ");
		for (int val : this.values) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	/**
	 * 配列の要素の交換
	 */
	protected void swap(int i, int j) {
		int temp = values[i];
		values[i] = values[j];
		values[j] = temp;
	}
}
