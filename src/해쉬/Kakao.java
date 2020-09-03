package 해쉬;
import java.util.*;
public class Kakao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kakao a = new Kakao();
		a.solution(new int[][] {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}});
	}
	static int index;
    public int[][] solution(int[][] nodeinfo) {
        Node[] arr = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
			arr[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1);
		}
        Arrays.sort(arr, new Comparator<Node>() {
        	@Override
        	public int compare(Node o1, Node o2) {
        		if (o1.y < o2.y) {
        			return 1;
        		} else if (o1.y > o2.y) {
        			return -1;
        		} else {
        			if (o1.x < o2.x) {
            			return 1;
            		} else if (o1.x > o2.x){
            			return -1;
            		} else {
            			return 0;
            		}
        		}
        	}
        });
        for (int i = 1; i < arr.length; i++) {
        	insert(arr[0],arr[i]);
		}
        index = 0;
        int[] postArr = post(arr[0], new int[arr.length]);
        index = 0;
        int[] preArr = pre(arr[0], new int[arr.length]);
        
        
        int[][] answer = new int[2][arr.length];
        answer[0]= preArr;
        answer[1] = postArr;
        
        return answer;
    }
   
    public static Node insert(Node root, Node cur) {
    	if (root == null) {
    		return cur;
    	}
    	if (cur.x < root.x) {
    		root.left = insert(root.left, cur);
    	} else {
    		root.right = insert(root.right, cur);
    	}
    	return root;
    }
    public static int[] post(Node root, int[] arr) {
    	if (root == null) {
    		return null;
    	}
    	post(root.left, arr);
    	post(root.right, arr);
    	arr[index++] = root.index;
    	return arr;
    }
    public static int[] pre(Node root, int[] arr) {
    	if (root == null) {
    		return null;
    	}
    	arr[index++] = root.index;
    	pre(root.left, arr);
    	pre(root.right, arr);
    	return arr;
    }
	class Node {
		int x;
		int y;
		int index;
		Node left;
		Node right;
		public Node(int x, int y, int index) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
			this.index = index;
		}
	}
}
