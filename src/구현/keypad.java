package 구현;

public class keypad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String main = "left";
		System.out.println(solution(arr, main));
	}
	int[][] keypad = {{1,2,3},{4,5,6},{7,8,9},{10,0,12}};
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        Position left = new Position(3,0);
        Position right = new Position(3,2);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
			int cur = numbers[i];
			System.out.println("CUR l : " + left.i + " cur r : " + right.i);
			if (cur == 1 || cur == 4 || cur == 7) {
				s.append("L");
				if (cur == 1) {
					left.i = 0;
				} else if (cur == 4) {
					left.i = 1;
				} else {
					left.i = 2;
				}

				left.j = 0;
			} else if (cur == 3 || cur == 6 || cur == 9) {
				s.append("R");
				if (cur == 3) {
					right.i = 0;
				} else if (cur == 6) {
					right.i = 1;
				} else {
					right.i = 2;
				}
				right.j = 2;
			} else {
				s.append(check(left,right,hand, cur));
			}
		}
        
        return s.toString();
    }
    public static String check(Position left, Position right, String hand, int cur) {
    	int level;
    	if (cur == 2) {
    		level = 0;
    	} else if (cur == 5) {
    		level = 1;
    	} else if (cur == 8) {
    		level = 2;
    	} else {
    		level = 3;
    	}

		
    	if (Math.abs(left.i - level) + Math.abs(left.j - 1) < Math.abs(level - right.i)  + Math.abs(right.j - 1)) {
    		left.i = level;
			left.j = 1;
    		return "L";
    	} else if (Math.abs(left.i - level) + Math.abs(left.j - 1) > Math.abs(level - right.i)+ + Math.abs(right.j - 1)) {
			right.i = level;
			right.j = 1;
    		return "R";
    	} else {
    		if (hand.equals("left")) {
    			left.i = level;
    			left.j = 1;
    			return "L";
    		} else {
    			right.i = level;
    			right.j = 1;
    			return "R";
    		}
    	}
    }
    
}
class Position{
	int i;
	int j;
public Position(int i, int j) {
	this.i = i;
	this.j = j;
}
}
