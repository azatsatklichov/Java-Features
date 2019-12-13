package tasks.algorithmic.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;




/*
 * also noce questions like
 * 
 * 1. Linkedlist (add remove first or last element, or intechaging ,... is expensive ..)
 */
public class PTest { 

	public static void main(String[] args) {
		System.out.println("Test");
		Integer[] numbers = {3, 5,1, 3, 2, 3,3 }; 
		List<Integer> linkList = new LinkedList<>(Arrays.asList(numbers));
		for (Iterator iterator = linkList.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			if(integer == 3)
			iterator.remove();
			
		}
		
		System.out.println(linkList);
		 
	}

	static void  countPairs(int array_count, int[] arr, int diff) {
		 
 
	}

	 
}
