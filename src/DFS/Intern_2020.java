package DFS;

public class Intern_2020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Intern_2020().solution("50*6-3*2"));
	}
	static long answer;
	static long sum;
    public long solution(String expression) {
        answer = 0;
        sum = 0;
        String[][] arr = {{"*", "+", "-"},{"*", "-", "+"},{"+", "*", "-"},{"+", "-", "*"},{"-", "+", "*"},{"-", "*", "+"}};
        for (int i = 0; i < arr.length; i++) {
			answer = Math.max(Math.abs(find(arr[i], 0, expression)), answer);;
		}
        
        return answer;
    }
    public static long find(String[] arr, int index, String expression) {
		long s= 0;
		if (index >= arr.length) return Long.parseLong(expression);
		if (!expression.contains(arr[index])) {
			try {
				s = Long.parseLong(expression);
				return s;
			} catch (Exception e) {
				return find(arr, index+1, expression);
			}
		}else {
			String[] split = expression.split("\\"+arr[index]);
			long temp = 0;
			for (int i = 0; i < split.length; i++) {
				if (arr[index].equals("*") ) {
					temp = (i == 0) ? find(arr, index+1, split[i]) : temp * find(arr, index+1, split[i]);
					
				} else if(arr[index].equals("+")) {
					temp = (i == 0) ? find(arr, index+1, split[i]) : temp + find(arr, index+1, split[i]);
					
				}else {
					temp = (i == 0) ? find(arr, index+1, split[i]) : temp - find(arr, index+1, split[i]);
				}
			}
			return temp;
		}
    }
}
