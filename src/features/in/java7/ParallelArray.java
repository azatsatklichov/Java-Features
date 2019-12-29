package features.in.java7;

import java.util.concurrent.ForkJoinPool;
import static Ops.*; 
public class ParallelArray {
	
	public static void main(String[] args) {

		ForkJoinPool fj = new ForkJoinPool(10); 
		Order[] data = ... 
		ParallelArray<Order> orders = new ParallelArray(fj, data); 

		//ParallelArray 


		// Filter 
		Ops.Predicate<Order> isLate = new Ops.Predicate<Order>() { 
		  public boolean op(Order o) { 
		     return o.due() < new Date(); 
		   } 
		}; 

		// Map 
		Ops.Predicate<Order> daysOverdue = 
		  new Ops.ObjectToInt<Order>() { 
		     public int op(Order o) { 
		       return daysOverdue(o.due()); 
		     } 
		}; 
		
			SummaryStatistics<Integer> summary = 
			   orders.withFilter(isLate) 
			            .withMapping(daysOverdue) 
			            .summary(); 

			System.out.println(“overdue: “ + summary.size()); 
			System.out.println(“avg by: “ + summary.average()); 


	}

}
