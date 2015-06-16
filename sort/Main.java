package sort;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Main {

	static private PrintWriter pw;

	public static void main(String [] args) {
		//size
		final int size = 100000;

		//repeat count
		final int count = 100;

		//System.out.println();
		//Defines a path
		String path = "./Data/test.csv";

		initWriter(path);

		doAllSort(count, size);

		//		HeapSort sort = new HeapSort();
		//		sort.updateData(new int [] {1, 9, 8, 3, 4, 6, 4, 9, 2});
		//		sort.sort();

		pw.close();

		System.out.println("the process is terminated");
	}

	/**
	 * Inits writer
	 */
	private static void initWriter(String path) {
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
		} catch (IOException e) {
			System.out.println("Path is wrong");
		}
	}

	/**
	 * Creates Data
	 */
	private static int [] createData(int size) {
		int [] values = new int [size];

		Random random = new Random();

		for (int i = 0; i < values.length; i++) {
			values[i] = random.nextInt(10000);
		}
		return values;
	}

	/**
	 * Performs a sort and Prints a result
	 */
	private static void doSort(BaseSort sort, int count, int size) {
		pw.print(sort.getClass().getSimpleName() + ",");
		long time = 0l;
		for (int i = 0; i < count; i++) {
			sort.updateData(createData(size));
			time = sort.sort();
			writeValue(Long.toString(time));
		}
		pw.println();
	}

	/**
	 * Performs all sorts
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
	 * Prints a result
	 */
	private static void writeValue(String time) {
		//System.out.println(time);
		pw.print(time + ",");
		pw.flush();
	}

}
