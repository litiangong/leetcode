import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDict {

	public static void main(String[] args) {
		  System.out.println(new AlienDict().alienOrder(new String[]{"wrt","wrf","er","ett","rftt"}));
	}
	
	public String alienOrder(String[] words) {
		if(words == null || words.length == 0)
			return "";
		if(words.length == 1){
			return words[0];
		}
		Map<Character, Integer> degrees = new HashMap<>();
		Map<Character, Set<Character>> map = new HashMap<>();
		for(int i = 0;i<words.length;i++){
			for(int j = 0;j<words[i].length();j++){
				degrees.put(words[i].charAt(j), 0);
				map.put(words[i].charAt(j), new HashSet<Character>());
			}
		}
		
		for(int i = 1;i<words.length;i++){
			String a = words[i-1];
			String b = words[i];
			
			for(int x = 0;x<Math.min(a.length(), b.length());x++){
				if(a.charAt(x) != b.charAt(x)){
					map.get(a.charAt(x)).add(b.charAt(x));
					degrees.put(b.charAt(x), degrees.get(b.charAt(x)) + 1);
					break;
				}
			}
		}
		return topoloysort(map, degrees);
    }

	private String topoloysort(Map<Character, Set<Character>> map, Map<Character, Integer> degrees) {
		
		Queue<Character> queue = new LinkedList<>();
		for(Character c : map.keySet()){
			if(degrees.get(c) == 0){
				queue.add(c);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()){
			
			char c = queue.poll();
			sb.append(c);
			Set<Character> neighbours = map.get(c);
			for(Character s : neighbours){
				degrees.put(s, degrees.get(s)-1);
				if(degrees.get(s) == 0){
					queue.add(s);
				}
			}
			map.remove(c);
			
		}
		
		if(map.isEmpty())
			return sb.toString();
		
		return "";
	}
	
}
