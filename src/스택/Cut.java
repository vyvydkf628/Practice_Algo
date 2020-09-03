package 스택;
import java.util.*;
public class Cut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] arr = s.toCharArray();
		Stack<Character> st = new Stack<>();
		int level = 0;
		int sum = 0;
		int stack = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == '(' && arr[i+1] == ')') {
				sum += level;
				i++;
				continue;
			}
			if (arr[i] == '(') {
				level++;
			} else {
				level--;
				sum++;
			}
		}
		if (arr[arr.length-1] == ')' && arr[arr.length -2] != '(') {
			sum++;
		}
		// 마지막char 값 체
		System.out.println(sum);
	}

}
