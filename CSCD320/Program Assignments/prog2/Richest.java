// Author: Ian Kaiserman

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Richest {

	static int[] list = new int[10001];
	static int heapSize;
	static int i;
	
	static void buildMinHeap() {
		heapSize = list.length - 1;
		for(int i = (int) Math.floor(list.length/2); i >= 1; i--) minHeapify(i);
	}
	
	static void minHeapify(int i) {
		if(i*2+1 <= heapSize) {
			if(list[i] < list[i*2] && list[i] < list[i*2+1]) {
				return;
			}
			else if(list[i*2] < list[i*2+1]) {
				int temp = list[i];
				list[i] = list[i*2];
				list[i*2] = temp;
				minHeapify(i*2);
			}
			else {
				int temp = list[i];
				list[i] = list[i*2+1];
				list[i*2+1] = temp;
				minHeapify(i*2+1);
			}
		}
		else if(i*2 <= heapSize) {
			if(list[i*2] < list[i]) {
				int temp = list[i];
				list[i] = list[i*2];
				list[i*2] = temp;
				minHeapify(i*2);
			}
		}
		else {
			return;
		}
		
	}
	
	static void checkLarger(int fileInt) {
		if(fileInt > list[1]) {
			list[1] = fileInt;
			minHeapify(1);
		}
	}
	
	static void heapSort() {
		buildMinHeap();
		for(int j = list.length - 1; j >= 2; j--) {
			int temp = list[1];
			list[1] = list[j];
			list[j] = temp;
			heapSize--;
			minHeapify(1);
		}
	}
	
	static void writeHeap(String file) throws IOException {
		BufferedWriter output = null;
		output = new BufferedWriter(new FileWriter(file));
		for(int j = 1; j < list.length; j++) {
			output.write(Integer.toString(list[j]));
			output.newLine();
		}
		output.flush();
		output.close();
	}
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		Scanner fscan = null;
		try {
			fscan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(i = 1; i < list.length && fscan.hasNextInt(); i++) {
			list[i] = fscan.nextInt();
		}
		buildMinHeap();
		while(fscan.hasNextInt()) {
			checkLarger(fscan.nextInt());
		}
		heapSort();
		writeHeap("richest.output");
	}

}