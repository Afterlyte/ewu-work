// Author: Ian Kaiserman

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Main driver class
public class TopoSort {
	
	// Reads and processes a line sent to it by the Scanner
	private static LinkedList lineRead(String line) {
		String[] vertex = line.split(":");
		LinkedList v = new LinkedList();
		v.addLast(Integer.parseInt(vertex[0]));
		if(vertex.length > 1) {
			String[] neighbors = vertex[1].split(",");
			for(int i = 0; i < neighbors.length; i++) {
				v.addLast(Integer.parseInt(neighbors[i]));
			}
		}
		return v;
	}
	
	// Read and processes the file input in the command line argument
	private static LinkedList[] fileRead(String[] args) {
		File input = new File(args[0]);
		Scanner scan = null;
		try {
			scan = new Scanner(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int vertices = 0;
		while(scan.hasNextLine()) {
			vertices++;
			scan.nextLine();
		}
		scan.close();
		LinkedList[] graph = new LinkedList[vertices];
		try {
			scan = new Scanner(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scan.hasNextLine()) {
			LinkedList l = lineRead(scan.nextLine().trim());
			graph[(int) l.getFirst()] = l;
		}
		scan.close();
		return graph;
	}
	
	// Main driver function
	public static void main(String[] args) {
		LinkedList[] graph = fileRead(args);
		Graph g = new Graph(graph);
		g.topographical_sort();
		LinkedList dfs = g.getTopoSort();
		System.out.println(dfs.toString());
	}

}
