package com.laioffer.classone;
import java.util.ArrayList;

public class pascalTriangle {
	public static void main (String args[]) {
		pascalTriangle sll = new pascalTriangle();
		sll.run();
	}
	public void run() {
		int numRows = 3;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();  
		result = generate(numRows);
		ArrayList<Integer> a = result.get(2);
		System.out.println(a);
	}
	
	public ArrayList<ArrayList<Integer>> generate( int numRows){
		ArrayList<Integer> preRow = new ArrayList<Integer>();
		ArrayList<Integer> curRow = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		curRow.add(1);
		result.add(0,curRow);
		//printArr(curRow);
		preRow = curRow;
		
		for (int i = 2; i <= numRows; i++) {
			curRow = new ArrayList<Integer>();
			for (int j = 0; j < i; j++) {
				if (j == 0 || j == i - 1) {
					curRow.add(j, 1);
				}else{
					curRow.add(j, preRow.get(j) + preRow.get(j-1));
				}	
			}
			//printArr(curRow);
			result.add(i-1, curRow);
			preRow = curRow;	
		}
		return result;
	}
	
	public void printArr(ArrayList<Integer> Arr) {
		for (int i = 0; i < Arr.size(); i++) {
			System.out.print(Arr.get(i)+ " ");
		}
		System.out.println();
		return;
	}
}
