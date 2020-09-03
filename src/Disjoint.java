
public class Disjoint {
	static int[] parent;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		parent = new int[] {1,2,3,4,5,6,7,8,9};
		
	}
	public void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			x = parent[y];
		}
	}
	public int find(int x) {
		
		if (x == parent[x]) {
			return x;
		}
		return find(parent[x]);
	}

}
