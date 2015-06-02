package sort;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Controller {

	static private PrintWriter pw;

	public static void main(String [] args) {
		//ソート対象のサイズを指定
		final int size = 10000;

		//反復回数
		final int count = 100;

		//出力ファイルのパスを指定(変更可能)
		String path = "./result.csv";

		initWriter(path);

		doSort(new OddEvenSort(), count, size);

		doSort(new ShakerSort(), count, size);

		doSort(new CombSort(), count, size);

		doSort(new BubbleSort(), count, size);

		//writerの解放(必ず最後に行う)
		pw.close();
	}

	/**
	 * writerを初期化
	 */
	private static void initWriter(String path) {
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 指定されたサイズのデータを作成
	 */
	private static int [] createData(int size) {
		int [] values = new int [size];

		Random random = new Random();

		for (int i = 0; i < values.length; i++) {
			//０から引数-1までの値をとる
			values[i] = random.nextInt(10000);
		}
		return values;
	}

	/**
	 * 与えられたソートを実行して、結果を出力する
	 */
	private static void doSort(BaseSort sort) {
		pw.print(sort.getClass());
		long time = sort.calc();
		writeValue(Long.toString(time));
		pw.println();
	}

	/**
	 * 与えられたソートを実行して、結果を出力する
	 */
	private static void doSort(BaseSort sort, int count, int size) {
		pw.print(sort.getClass().getSimpleName());
		long time = 0l;
		for (int i = 0; i < count; i++) {
			sort.updateData(createData(size));
			time = sort.calc();
			writeValue(Long.toString(time));
		}
		pw.println();
	}

	/**
	 * 結果をファイルに書き込む
	 */
	private static void writeValue(String time) {
		System.out.println(time);
		pw.print(time + ",");//バッファに書かれる
		pw.flush();//ファイルに書き込みを行う
	}

}
