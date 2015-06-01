package sort;

public abstract class Sort {

	//ランダムに作成されたデータ
	int [] values;

	public Sort(int [] values) {
		copy(values);
	}

	public Sort() {
	}

	public void updateData(int [] values) {
		this.values = values;
	}

	/**
	 * ソートの実装を記述する
	 * return : 計算時間
	 */
	public abstract long calc();

	/**
	 * データのコピーを行う
	 */
	public void copy(int [] values) {
		int size = values.length;
		this.values = new int [size];
		for (int i = 0; i < size; i++) {
			this.values[i] = values[i];
		}
	}

	/**
	 * ソートされているか確認する場合にのみ用いる
	 */
	public void printValues() {
		System.out.print("Data : ");
		for (int val : this.values) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	public void swap(int i, int j) {
		int temp = values[i];
		values[i] = values[j];
		values[j] = temp;
	}
}
