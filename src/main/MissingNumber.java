package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class MissingNumber {

	public static void main(String[] args) {
		int[] A = new int[]{1, 3, 6, 4, 1, 2};
		int[] B = new int[]{1, 2, 3};
		int[] C = new int[]{-1, -3};

		
		solution1(A);
		solution1(B);
		solution1(C);
		
		solution2(A);
		solution2(B);
		solution2(C);
        
    }

    public static int solution1(int[] A) {
    	Arrays.sort(A);
        
        int result = 1;
        int maxInt = A[A.length-1];
        List<Integer> notFounded = new ArrayList<Integer>();
        
        List<Integer> listIntegerOfA = Arrays.stream(A).boxed().collect(Collectors.toList());
        
        for (int i=1; i <= maxInt+1; i++) {
        	
			if (!listIntegerOfA.contains(new Integer(i))) {
        		notFounded.add(i);
        	}
        	
		}
        
        if(notFounded.size() > 0) {
        	
        	if(notFounded.get(0) == maxInt+1) {
        		result = notFounded.get(notFounded.size()-1);
        	} else {
        		result = notFounded.get(notFounded.size()-2);
        	}
        	
        }
        
        System.out.println(result);
        return result;
    }
    
    public static int solution2(int[] A) {
    	HashSet<Integer> nums = new HashSet<Integer>();
    	
    	for(int i = 1; i<= A.length+1; i++) {
    		nums.add(i);
    	}
    	
    	for(int a : A) {
    		nums.remove((new Integer(a)));
    	}
    	
    	int result = nums.iterator().next();
    	System.out.println(nums.toString());
    	System.out.println(result);
    	return result;
    	
    }

}
