package 해쉬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Clss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Clss().solution("Muzi", new String[] {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"}
));
	}

    public int solution(String word, String[] pages) {
        int answer = 0;
        Page[] arr = new Page[pages.length];
        word = word.toLowerCase();
        HashMap<String, Page> hm = new HashMap<>();
        for (int i = 0; i < pages.length; i++) {
        	pages[i] = pages[i].toLowerCase();
        	Page cur = new Page();
			cur.basic = pages[i].split(word).length-1;
			cur.url = pages[i].split("<meta property=\"og:url\" content=\"")[1].split("\"")[0];
			hm.put(cur.url, cur);
			cur.link = pages[i].split("<a href=\"");
			System.out.println(cur.link.length + " " + cur.basic);
			for (int j = 1; j < cur.link.length; j++) {
				cur.link[j] = cur.link[j].split("\"")[0];
			}
			cur.index = i;
			
			arr[i] = cur;
		}
        for (int i = 0; i < arr.length; i++) {
			String[] link = arr[i].link;
			float linkNum = ((float)arr[i].basic / ((float)arr[i].link.length-1));
			for (int j = 0; j < link.length; j++) {
				if (hm.containsKey(link[j])) {
					hm.get(link[j]).sum += linkNum;
				}
			}
		}
        
        for (int i = 0; i < arr.length; i++) {
        	arr[i].sum += arr[i].basic;
        	System.out.println(arr[i].sum + " " + arr[i].index);
		}
        Arrays.sort(arr, new Comparator<Page>() {
        	@Override
        	public int compare(Page o1, Page o2) {
        		// TODO Auto-generated method stub
        		if (o1.sum < o2.sum) {
        			return 1;
        		} else if (o1.sum > o2.sum) {
        			return -1;
        		} else {
        			if (o1.index < o2.index) return 1;
        			else if (o1.index > o2.index) return -1;
        			else return 0;
        		}

        	}
        });
        return arr[0].index;
    }
    public static int getWord(String html) {
    	
    }
    class Page {
    	int index;
        int basic;
        String[] link;
        int ref;
        String url;
        float sum = 0;
        public Page() {
			// TODO Auto-generated constructor stub
		}
    }
}
