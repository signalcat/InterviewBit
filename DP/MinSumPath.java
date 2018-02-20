import java.util.*;
public class MinSumPath {
	static int memo[][];
    static int vals[][];
    
    public static int minPathSum(ArrayList<ArrayList<Integer>> A) {
        int rows = A.size();
        int clms = A.get(0).size(); 
        memo = new int[rows][clms];
        vals = new int[rows][clms];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < clms; c++) {
                vals[r][c] = A.get(r).get(c);
                //System.out.print(vals[r][c]);
            }
            //System.out.println();
        }
        helper(rows - 1, clms - 1);
        printGrid(memo);
        return helper(rows - 1, clms - 1);
    }
    
    public static int helper(int r, int c) {
    	if (memo[r][c] != 0)
    	   return memo[r][c];
    	
        if (r == 0 && c == 0) {
        	memo[r][c] = vals[r][c];
        	return memo[r][c];
        }
        if (r == 0) {
        	memo[r][c] = vals[r][c] + helper(r, c-1);
        	return memo[r][c];
        }
        
        if (c == 0) {
        	memo[r][c] = vals[r][c] + helper(r-1, c);  	
        	return memo[r][c];
        }
        
        memo[r][c] = vals[r][c] + Math.min(helper(r-1, c)
            , helper(r, c-1));
        return memo[r][c];
    }
    
    public static void main(String[] args) {
    	ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
//    	A.add(new ArrayList<Integer>(Arrays.asList(29, 16, 28, 10, 98)));
//    	A.add(new ArrayList<Integer>(Arrays.asList(11, 12, 95, 6, 67)));
//    	A.add(new ArrayList<Integer>(Arrays.asList(9, 31, 53, 42, 49)));
//    	A.add(new ArrayList<Integer>(Arrays.asList(46, 66, 50, 60, 43)));
//    	A.add(new ArrayList<Integer>(Arrays.asList(0, 36, 87, 91, 59)));
//    	A.add(new ArrayList<Integer>(Arrays.asList(71, 60, 37, 83, 89)));
//    	A.add(new ArrayList<Integer>(Arrays.asList(95, 8, 67, 26, 92)));
//    	A.add(new ArrayList<Integer>(Arrays.asList(58, 46, 81, 12, 15)));
//    	A.add(new ArrayList<Integer>(Arrays.asList(90, 9, 42, 28, 86)));
//    	A.add(new ArrayList<Integer>(Arrays.asList(51, 25, 23, 36, 49)));
    	A.add(new ArrayList<Integer>());
    	A.get(0).add(0);
    	int minSum = minPathSum(A);
    	System.out.println(minSum);
    }
    
    public static void printGrid(ArrayList<ArrayList<Integer>> A) {
    	for (int i = 0; i < A.size(); i++) {
    		for (int j = 0; j < A.get(0).size(); j++) {
    			System.out.print(A.get(i).get(j));
    		}
    		System.out.println();
    	}
    }
    
    public static void printGrid(int[][] A) {
    	System.out.println("Printing Grid:");
    	for (int i = 0; i < A.length; i++) {
    		for (int j = 0; j < A[0].length; j++) {
    			System.out.print(A[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
   }
