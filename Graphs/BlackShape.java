import java.util.*;

//Answer := 0
//Loop i = 1 to N :
//    Loop j = 1 to M:
//          IF MATRIX at i, j equal to 'X' and not visited:
//                 BFS/DFS to mark the connected area as visited
//                 update Answer
//    EndLoop
//EndLoop
//
//return Answer

public class BlackShape {
	public static void dfs(char[][] arr, int r, int c) {
		int nr = arr.length;
	    int nc = arr[0].length;

	    if (r < 0 || c < 0 || r >= nr || c >= nc || arr[r][c] != 'X') {
	      return;
	    }
	    arr[r][c] = 'F';
	    
	    
		dfs(arr, r-1, c);
		dfs(arr, r+1, c);
		dfs(arr, r, c-1);
		dfs(arr, r, c+1);
	}
	
    public static int black(ArrayList<String> A) {
    	int num = 0;
    	int r = A.size();
    	int c = A.get(0).length();
    	
    	if (A == null || A.size() == 0) {
    	      return 0;
    	}
    	
    	char[][] arr = new char[r][c];
        for(int i = 0; i < r; i++) {
        	 arr[i]= A.get(i).toCharArray();
        	 System.out.println(arr[i]);
        }
        System.out.println();
        
    	for (int i = 0; i < A.size(); i++) {
    		for (int j = 0; j < A.get(0).length(); j++) {
    			if (arr[i][j] == 'X') {
    				num++;
    				dfs(arr, i, j);
    				print(arr);
    			}
    		}
    	}
    	return num;
    }
    
    public static void print(char[][] arr) {
    	for (int i = 0; i < arr.length; i++) {
        	for (int j = 0; j < arr[i].length; j++) {
        		System.out.print(arr[i][j]);
        	}
        	System.out.println();	
        }
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	ArrayList<String> A = new ArrayList<String>();
    	A.add("OOOXOOO");
    	A.add("OOXXOXO");
    	A.add("OXOOOXO");
    	black(A);
    	System.out.println(black(A));
    	return;
    }
    
}
