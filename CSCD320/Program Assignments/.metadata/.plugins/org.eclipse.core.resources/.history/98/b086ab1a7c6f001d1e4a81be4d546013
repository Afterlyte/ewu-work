// Author: Ian Kaiserman

// Graph object for storing various information and functions for graph representation
public class Graph {
	private LinkedList[] adj;
	private LinkedList topoSort;
	private int time;
	private enum Color {
		WHITE,
		GRAY,
		BLACK
	};
	private Color[] colors;
	private int[][] timestamps;
	private int[] parents;
	
	// Constructor for Graph object (takes Linked List array)
	Graph(LinkedList[] adj) {
		this.adj = adj;
		this.timestamps = new int[adj.length][2];
		this.parents = new int[adj.length];
		this.colors = new Color[adj.length];
	}
	
	// Driver function for topological_sort, creates DFS order for every node in graph
	public void topographical_sort() {
		this.topoSort = new LinkedList();
		for(int i = 0; i < this.adj.length; i++) {
			this.colors[i] = Color.WHITE;
			this.parents[i] = -1;
		}
		this.time = 0;
		for(int j = 0; j < this.adj.length; j++) {
			if(colors[j] == Color.WHITE) this.graph_DFS(adj[j]);
		}
	}

	// Creates DFS order for given vertex using Linked List adjacency set
	private void graph_DFS(LinkedList s) {
		int x = (int) s.getFirst();
		//this.dfs.addFirst(s.getFirst());
		this.time++;
		this.timestamps[x][0] = this.time;
		this.colors[x] = Color.GRAY;
		for(int i = 1; i < s.getSize(); i++) {
			if(this.colors[(int) s.getAtIndex(i)] == Color.WHITE) {
				this.parents[(int) s.getAtIndex(i)] = x;
				graph_DFS(adj[(int) s.getAtIndex(i)]);
			}
		}
		this.time++;
		this.timestamps[x][1] = time;
		this.colors[x] = Color.BLACK;
		this.topoSort.addFirst(s.getFirst());
	}
	
	// Returns the topological order of the graph stored in a Linked List
	public LinkedList getTopoSort() {
		return this.topoSort;
	}
}
