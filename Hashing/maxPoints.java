import java.util.*;

public class maxPoints {
	public int maxpoints(ArrayList<Integer> a, ArrayList<Integer> b) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    int counter = 0;
	    
		for (int i = 0; i < a.size() - 1; i++) {
			for (int j = 1; j < a.size(); j++) {
			    if (a.get(i) - b.get(j) == 0 && b.get(i) - b.get(j) == 0) {
			        if (map.containsKey(1)) {
			            map.put(1, map.get(1) + 1);    
			        } else {
			            map.put(1, 1);
			        }
			        continue;
			    }
			    
			    if (a.get(i) - b.get(j) == 0) {
			        if (map.containsKey(0)) {
			            map.put(0, map.get(0) + 1);
			        } else {
			            map.put(0, 1);
			        }
			        continue;
			    }
			    
			    if (b.get(i) - b.get(j) == 0) {
			        counter++;
			        continue;
			    }
			    
				int k = (b.get(i) - b.get(j))/(a.get(i) - b.get(j));
				if (map.containsKey(k)) {
					map.put(k, map.get(k)+1);
				} else {
					map.put(k, 1);
				}
			}
		}
		
		int max = 0;
		for (int count:map.values()) {
			max = Math.max(0, count);
		}
		return Math.max(max, counter);
	}
	
	public void main (String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		a.add(0);
		a.add(1);
		a.add(-1);
		b.add(0);
		b.add(1);
		b.add(-1);
		int result = maxpoints(a, b);
		System.out.println(result);
	}
}
