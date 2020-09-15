package 구현;
import java.util.*;
public class 방금그곡 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("CDEFGAC", new String[] {"12:00,12:06,HELLO,CDEFGA"}));
	}
    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        int max = 0;
        Arrays.sort(musicinfos, Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int start1=Integer.valueOf(s1.split(",")[0]);
                int end1=Integer.valueOf(s1.split(",")[1]);
                int start2=Integer.valueOf(s2.split(",")[0]);
                int end2=Integer.valueOf(s2.split(",")[1]);
                if (start1 < start2) {
                    return -1;
                } else if(start1 == start2) {
                    if (end1 < end2) {
                        return -1;
                    } else if(end1 == end2) {
                        return 0;
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                };
            };
        });
        for (int i = 0; i < musicinfos.length; i++) {
			String[] curInfo=musicinfos[i].split(",");
			String start = curInfo[0];
			String startHour = start.split(":")[0];
			String startMin = start.split(":")[1];
			
			String end = curInfo[1];
			String endHour = end.split(":")[0];
			String endMin = end.split(":")[1];
			int diffHour = 60 * (Integer.valueOf(endHour) - Integer.valueOf(startHour));
			int diffMin = (diffHour + Integer.valueOf(endMin)) - Integer.valueOf(startMin);
			System.out.println(diffMin);
			
			String name = curInfo[2];
			String sound = curInfo[3];
			ArrayList<String> musicOrigin = new ArrayList<String>();
			for (int j = 0; j < sound.length(); j++) {
				char curChar = sound.charAt(j);
				if (!isAlphabet(curChar) && j != 0) {
					musicOrigin.set(musicOrigin.size()-1, musicOrigin.get(musicOrigin.size()-1) + String.valueOf(curChar));
				} else {
					musicOrigin.add(String.valueOf(curChar));
				}
				
			}
			ArrayList<String> musicSound = new ArrayList<String>();
			for (int j = 0; j < m.length(); j++) {
				char curChar = m.charAt(j);
				System.out.println("curChar" + curChar);
				if (!isAlphabet(curChar) && j != 0) {
					musicSound.set(musicSound.size()-1, musicSound.get(musicSound.size()-1) + String.valueOf(curChar));
				} else {
					musicSound.add(String.valueOf(curChar));
				}
				
			}
			
			for (int j = 0; j < musicOrigin.size(); j++) {
				System.out.print(musicOrigin.get(j)+ " origin");
			}
			
			System.out.println();
			int j2 = 0;
			int count = 0;
			
			for (int j = 0; j < musicSound.size(); j++) {
				if (j2 >= musicOrigin.size()) {
					j2 = 0;
				}
				if (count == diffMin) {
					System.out.println("AA");
					break;
				};
				String hear=musicSound.get(j);
				String orig=musicOrigin.get(j2);
				System.out.println(hear +" : sound : " +musicSound.size() );
				if (!hear.equals(orig)) {
					j--;
					j2++;
					count++;
					continue;
				}
				if ( j == musicSound.size() -1) {
					if (diffMin > max) {
						max = diffMin;
						answer = name;
					}
				}
				j2++;
				count++;
				
			}
			
			
			
		}
        if (answer.equals("")) return "`(None)`";
        return answer;
    }
    public static boolean isAlphabet(char s) {
    	if ('A' <= s && 'Z' >= s) {
    		return true;
    	}
    	return false;
    }
}
