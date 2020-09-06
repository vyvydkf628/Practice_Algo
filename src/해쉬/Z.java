package 해쉬;
import java.util.*;
public class Z {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Z a = new Z();
		int[] ans = a.solution(new String[] {"A","B","D","D","D","C","A","B","D"});
		System.out.println(ans[0] + " " +ans[1]);
	}
    public static int[] solution(String[] gems) {
        HashMap<String, Integer> hs = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < gems.length; i++) {
			if (set.contains(gems[i])) {
			} else {
				set.add(gems[i]);
			}
		}
        int i = -1;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int minI = 0;
        int minJ = 0;
        int size = set.size();
        int count = 0;
        if (size == gems.length) return new int[] {1, gems.length};
        while (i < gems.length && j < gems.length) {
        	while (hs.size() != size) {
    			i++;
        		if (!hs.containsKey(gems[i])) {
    				hs.put(gems[i], 1);
        		}else {
        			hs.put(gems[i], hs.get(gems[i])+1);
        		}
    			
        		if (hs.size() == size) {
    				min = i - j;
        			minI = i+1;
        			minJ = j+1;
    			}
        	}
    		int jCount = hs.get(gems[j]);
    		if (hs.size() >= size && jCount >= 2) {
        		hs.put(gems[j], jCount-1);
    			j++;
    			if (i-j < min) {
    				min = i - j;
        			minI = i+1;
        			minJ = j+1;
    			}
    		} else {
    			hs.put(gems[i], hs.get(gems[i])+1);
        		i++;
    		}
        }
        if (hs.get(gems[j]) == 2) {
        	j++;
			if ((--i)-j < min ) {
				min = i - j;
    			minI = i+1;
    			minJ = j+1;
			}
        }
        if (min == Integer.MAX_VALUE) return new int[] {1, gems.length};
        return new int[] {minJ, minI};
    }
}
