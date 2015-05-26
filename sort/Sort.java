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
	public void printValues(int [] values) {
		for (int val : values) {
			System.out.println(val);
		}
	}
}
