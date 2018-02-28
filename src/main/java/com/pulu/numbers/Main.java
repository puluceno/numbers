package com.pulu.numbers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

	private static List<int[]> results = new ArrayList<>();
	private static String path = System.getProperty("user.home") + File.separator + "Desktop" + File.separator
			+ "numbers.txt";

	public static void main(String[] args) throws IOException {
		Long b = new Date().getTime();
		int[] numbers = new int[60];

		for (int i = 1; i <= 60; i++) {
			numbers[i - 1] = i;
		}

		combinations(numbers, 6, 0, new int[6]);
		System.out.println(results.size());
		for (int[] i : results) {
			for (int j : i) {
				System.out.println(j);
			}
			
		}
		System.out.println("*******" + (new Date().getTime() - b));
	}

	static void combinations(int[] arr, int len, int startPosition, int[] result) {
		if (len == 0) {
			int first = 0;
			int second = 0;
			int third = 0;
			int forth = 0;
			int fifth = 0;
			int sixth = 0;
			for (int i = 0; i < result.length; i++) {
				if (result[i] > 10 && result[i] <= 20)
					second++;
				else if (result[i] > 20 && result[i] <= 30)
					third++;
				else if (result[i] > 30 && result[i] <= 40)
					forth++;
				else if (result[i] > 40 && result[i] <= 50)
					fifth++;
				else if (result[i] > 50 && result[i] <= 60)
					sixth++;
				else
					first++;

			}
			if (!(first > 3 || second > 3 || third > 3 || forth > 3 || fifth > 3 || sixth > 3))
				results.add(result);
			return;
		}
		for (int i = startPosition; i <= arr.length - len; i++) {
			result[result.length - len] = arr[i];
			combinations(arr, len - 1, i + 1, result);
		}
	}

}
