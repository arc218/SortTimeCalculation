package sort;

public interface Sort {

	/**
	 * ソートの実装を記述する
	 * return : 計算時間
	 */
	public long calc();

	/**
	 * データのコピーを行う
	 */
	public default int [] copy(int [] values) {
		int size = values.length;
		int [] copy = new int [size];
		for (int i = 0; i < size; i++) {
			copy[i] = values[i];
		}
		return copy;
	}

	/**
	 * ソートされているか確認する場合にのみ用いる
	 */
	public default void printValues(int [] values) {
		for (int val : values) {
			System.out.println(val);
		}
	}
}
