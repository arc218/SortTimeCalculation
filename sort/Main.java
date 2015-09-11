package sort;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringJoiner;

public class Main {

	static private PrintWriter pw;

	public static void main(String[] args) {
		//size
		final int size = 15000;

		//repeat count
		final int count = 100;

		//Defines a path
		String path = "./Data/result.csv";

		initWriter(path);

		System.out.println("ソート開始");

		doAllSort(count, size);

		System.out.println("ソート終了");

		pw.close();

		System.out.println("the process is terminated");
	}

	protected static void swap(int i, int j, double[] values) {
		double temp = values[i];
		values[i] = values[j];
		values[j] = temp;
	}

	/**
	 * Writerの初期化
	 */
	private static void initWriter(String path) {
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
		} catch (IOException e) {
			System.out.println("Path is wrong");
		}
	}

	/**
	 * データを作成する
	 */
	private static int[] createData(int size) {
		int[] values = new int [size];

		long seed = System.currentTimeMillis();

		Random random = new Random(seed);

		for (int i = 0; i < values.length; i++) {
			values[i] = random.nextInt(size);
		}
		return values;
	}

	/**
	 * ソートを実行して結果を出力する
	 */
	private static void doSort(BaseSort sort, int count, int size) {
		StringJoiner joiner = new StringJoiner(",");
		joiner.add(sort.getClass().getSimpleName());
		long time = 0l;
		for (int i = 0; i < count; i++) {
			sort.updateData(createData(size));
			time = sort.sort();
			joiner.add(Long.toString(time));
		}
		writeValue(joiner.toString());
		pw.println();
	}

	/**
	 * すべてのソートを実行する
	 */
	private static void doAllSort(int count, int size) {
		doSort(new OddEvenSort(), count, size);
		doSort(new ShakerSort(), count, size);
		doSort(new CombSort(), count, size);
		doSort(new BubbleSort(), count, size);
		doSort(new GnomeSort(), count, size);
		doSort(new HeapSort(), count, size);
		doSort(new QuickSort(), count, size);
		doSort(new SelectionSort(), count, size);
		doSort(new ShellSort(), count, size);
		doSort(new InsertionSort(), count, size);
		doSort(new MergeSort(), count, size);
	}

	/**
	 * 結果をcsvに出力する
	 */
	private static void writeValue(String time) {
		//System.out.println(time);
		pw.print(time);
		pw.flush();
	}

}
