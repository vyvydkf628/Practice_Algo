package 구현;
import java.util.*;
public class Koo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((int)'A');
		int[] arr = solution("TOBEORNOTTOBEORTOBEORNOT");
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
    public static int[] solution(String msg) {
    	ArrayList<String> arr= new ArrayList<>();
    	for (int i = 0; i < 26; i++) {
			arr.add("");
		}
    	ArrayList<Integer> answer = new ArrayList<Integer>();
    	char[] msgArr = msg.toCharArray();
    	for (int i = 0; i < msgArr.length; i++) {
			char cur = msgArr[i];
			if (arr.get(cur-65).equals("")) {
				arr.set(cur-65, Character.toString(cur));
			}
			StringBuilder str = new StringBuilder();
			int prev = 0;
			for (int j = i; j < msgArr.length; j++) {
				str.append(msgArr[j]);
				boolean flag = false;
				int index = 0;
				for (int j2 = 0; j2 < arr.size(); j2++) {
					String indexed = arr.get(j2);
					if (str.toString().equals(indexed)) {
						flag = true;
						index = j2;
						break;
					};
				}
				if (!flag) {
					if (str.length() == 1) {
						
					}else {
						arr.add(str.toString());
					}
					i = j-1;
					break;
				}else {
					prev = index+1;
					
				}
				if (j == msgArr.length-1) {
					i = j+1;
					break;
				}
			}
			answer.add(prev);
		}
        return answer.stream().mapToInt(i->i).toArray();
    }
}
