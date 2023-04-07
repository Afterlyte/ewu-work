// Author: Ian Kaiserman

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Main driver class
public class Dijkstra {
	
	// Reads and processes a line sent to it by the Scanner
	private static LinkedList lineRead(String line) {
		String[] vertex = line.split(":");
		LinkedList v = new LinkedList();
		v.addLast(new int[] {Integer.parseInt(vertex[0]), 0});
		if(vertex.length > 1) {
			String[] neighbors = vertex[1].split(";");
			for(int i = 0; i < neighbors.length; i++) {
				String[] node = neighbors[i].split(",");
				v.addLast(new int[] {Integer.parseInt(node[0]), Integer.parseInt(node[1])});
			}
		}
		return v;
	}
	
	// Read and processes the file input in the command line argument
	private static LinkedList[] fileRead(String file) {
		File input = new File(file);
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
			graph[l.getFirst()[0]] = l;
		}
		scan.close();
		return graph;
	}
	
	// Main driver function
	public static void main(String[] args) {
		if(args.length != 2) {
			throw new IllegalArgumentException("Not enough command line arguemnts");
		}
		LinkedList[] graph = fileRead(args[0]);
		Graph g = new Graph(graph);
		g.dijkstra(Integer.parseInt(args[1]));
		g.printPath(Integer.parseInt(args[1]));
	}

}
