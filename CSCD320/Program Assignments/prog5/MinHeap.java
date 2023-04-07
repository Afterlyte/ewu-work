
public class MinHeap {
	private int[][] minHeap;
	private int heapSize;
	
	public MinHeap(int n) {
		this.minHeap = new int[n][2];
		this.heapSize = 0;
	}
	
	public void insertKey(int[] key) {
		int i = this.heapSize + 1;
		this.minHeap[i] = key;
		this.heapSize++;
		while(i != 1 && this.minHeap[i][1] < this.minHeap[i/2][1]) {
			int[] temp = this.minHeap[i];
			this.minHeap[i] = this.minHeap[i/2];
			this.minHeap[i/2] = temp;
			i/=2;
		}
	}

	public int getHeapSize() {
		return this.heapSize;
	}

	public int[] extractMin() {
		if(heapSize == 1) {
			this.heapSize--;
			return this.minHeap[1];
		}
		else {
			int[] root = this.minHeap[1];
			this.minHeap[1] = this.minHeap[this.heapSize];
			this.heapSize--;
			this.minHeapify(1);
			return root;
		}
	}

	private void minHeapify(int i) {
		int smallest = i;
		if(i*2 < this.heapSize && this.minHeap[i*2][1] < this.minHeap[smallest][1]) {
			smallest = i*2;
		}
		if(i*2+1 < this.heapSize && this.minHeap[i*2+1][1] < this.minHeap[smallest][1]) {
			smallest = i*2+1;
		}
		if(smallest != i) {
			int[] temp = this.minHeap[i];
			this.minHeap[i] = this.minHeap[smallest];
			this.minHeap[smallest] = temp;
			this.minHeapify(smallest);
		}
	}
	
	public void decreaseKey(int key, int val) {
		for(int[] i : this.minHeap) {
			if(i[0] == key) {
				i[1] = val;
			}
		}
		while(key != 1 && this.minHeap[key][1] < this.minHeap[key/2][1]) {
			int[] temp = this.minHeap[key];
			this.minHeap[key] = this.minHeap[key/2];
			this.minHeap[key/2] = temp;
			key/=2;
		}
	}
}
