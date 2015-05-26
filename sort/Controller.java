package sort;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Controller {

	static PrintWriter pw;

	public static void main(String [] args) {
		//ソート対象のサイズを指定
		int size = 100000;

		//対象データを作成
		int [] values = createData(size);

		//出力ファイルのパスを指定(任意に変更)
		String path = "/Users/hiroki/Desktop/test.csv";

		initWriter(path);

		Sort bubbleSort = new BubbleSort(values);
		doSort(bubbleSort);

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
	private static void doSort(Sort sort) {
		long time = sort.calc();
		writeValue(Long.toString(time));
	}

	/**
	 * 結果をファイルに書き込む
	 */
	private static void writeValue(String time) {
		System.out.println(time);
		pw.println(time);//バッファに書かれる
		pw.flush();//ファイルに書き込みを行う
	}

}
