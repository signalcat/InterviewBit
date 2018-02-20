import java.util.*;

public class SteppingNumbers {
	public static ArrayList<Integer> stepnum(int A, int B) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < 10; i++) {
			res.addAll(generateStepnum(A, B, i, set));
		}
		Collections.sort(res);
		return res;
	}
	
	public static ArrayList<Integer> generateStepnum(int low, int high, int singleStepNum, HashSet<Integer> set) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		//set.add(singleStepNum);
		q.add(singleStepNum);
		while (!q.isEmpty()) {
			int curVal = q.poll();
			if(!set.contains(curVal)) {
				set.add(curVal);
				System.out.println("Set add" + curVal);
				if (curVal >= low && curVal <= high) {
					res.add(curVal);
					System.out.println("Storing" + curVal);
				} 
			} else {
				continue;
			}
			if (curVal > high) {
				System.out.println("Break! Current Value is: " + curVal);
				return res;
			}
			int lastDigit = curVal % 10;
			int nextStepNumA = curVal * 10 + (lastDigit + 1);
			int nextStepNumB = curVal * 10 + (lastDigit - 1);
			if (lastDigit == 0) {
				q.add(nextStepNumA);
				System.out.println("Encounter 0, Add to q " + nextStepNumA);
			} else if (lastDigit == 9) {
				q.add(nextStepNumB);
				System.out.println("Encounter 9, Add to q " + nextStepNumB);
			} else {
				System.out.println("Add to q" + nextStepNumB + " and " + nextStepNumA);
				q.add(nextStepNumB);
				q.add(nextStepNumA);
			
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> res = stepnum(10, 20); 
		res = stepnum(0,21);
		for (int i = 0; i < res.size(); i++) {
			System.out.println("Step number: " + res.get(i));
		}
		return;
	}
}
