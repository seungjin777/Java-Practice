package ex07;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class HashMapEx {
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		hm.put("aa", 10);
		hm.put("bb", 20);
		hm.put("cc", 30);
		hm.put("dd", 40);
		hm.put("ee", 50);
		
		System.out.println("Map Size : " + hm.size());
		
		Set<String> keys = hm.keySet();
		Iterator<String> it = keys.iterator();
		
		while(it.hasNext()) {
			String name = it.next();
			int score = hm.get(name);
			System.out.println(name + " : " + score);
		}
	}
}
