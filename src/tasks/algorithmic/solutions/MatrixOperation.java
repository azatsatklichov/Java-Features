package tasks.algorithmic.solutions;



// import java.util.Locale;
// import java.util.Scanner;
// import java.util.Arrays;
import java.util.*;



public class MatrixOperation{


 public static void  just_an_example() {  
     // A method about converting 2D matrix (with some NaN elemnts )
     //into 1D sequence
     
     
        int[] p = new int[10];
        int[] p1=new int[12]; 
        int counter=0; 
        int [][] D = {{-3, 4, 7, 9}, {1, -2, 3}, {-5, 6}, {-3}};
       System.out.print(" Dimension of Matrix D : D("+D.length+","+D[0].length+")");
       System.out.print("\n-------------------------------------");             
       System.out.print("\n \t\t  Matrix D \n");  
       System.out.print("-------------------------------------\n");             
        
       for (int i=0; i<D.length; i++)
        { 
          for (int j=0; j<D.length-i; j++){
              System.out.print("\t" + D[i][j]); p[counter]=D[i][j]; counter++;
            } 
          System.out.print("\n"); 
        } 
      
       System.out.print("\n Obtained sequence from matrix D has a dimension : p(" +p.length+")");
       System.out.println("\nBefore sorting: p= " + Arrays.toString(p));
       Arrays.sort(p); // Sorting in ascending form-from smallest to biggest
       System.out.println("After sorting: p= " + Arrays.toString(p));
       Arrays.fill(p, 4, 7,  -10);  
       Arrays.sort(p, 2, 5);
    
       
       StringBuffer b = new StringBuffer(" =p :niaga detros dna degnahc stnemelE\n");
       System.out.println(b.reverse()+ Arrays.toString(p));
              
       System.arraycopy(p, 0, p1, 0, p.length);  Arrays.sort(p1);
       System.out.println("p1= "+Arrays.toString(p1));
       
       String[] st = {"a", "b", "ab", "c", "ca", "d"};
       List list = Arrays.asList(st);
       System.out.println("original list = " + list);
       Collections.swap(list, 2, 5);
       System.out.println("after swapping two elements = " + list);
       Collections.rotate(list, 3); 
       System.out.println("3 places rotated to right = " + list);
       Collections.rotate(list, -2);
       System.out.println("2 place rotated to left = " + list);
       Collections.rotate(list.subList(1, 4), 1);
       System.out.println("sub list is rotated 1 place to right = " + list);
       Collections.sort(list);
       System.out.println("sorted in natural form  = " + list);      
       Collections.shuffle(list);
       System.out.println("randomly listed = " + list);   
    }
    
    // method for reading the elements of a matrix
    public  void readElms(int[][] x){
        Scanner sc = new Scanner(System.in);   
        sc.useLocale(Locale.US); 
      for (int i=0; i<x.length; i++) {
         for (int j=0; j<x[0].length; j++){
           System.out.println("[" + i +","+ j + "]=");
           x[i][j]=sc.nextInt();   
           // or we can use the readInt() method from RaedInt class
         }
       }      
    }     
    
     // method for printing out the elemnts of a matrix    
    public  void printElms(int[][] x){
      for (int i=0; i<x.length; i++) {
         for (int j=0; j<x[0].length; j++){
        System.out.print("\t" + x[i][j]); 
       } 
        System.out.print("\n");
     }  
    } 
    
    // method for finding the product of two matrices
    public  void productOf2Matrices(int[][] x, int[][] y, int[][] z){
       int sum=0;
      for (int i=0; i<x.length; i++){
        for (int j=0; j<y[0].length; j++) {
                 for (int l=0; l<x[0].length; l++)
                 sum=sum+x[i][l]*y[l][j];
                 z[i][j]=sum; sum=0;                           
              }
            }
            printElms(z);
        }
    
      static double average(int[] values) {
          
      if (values == null || values.length == 0)
      throw new IllegalArgumentException(); 
//     if (values == null)
//         throw new IllegalArgumentException();
//     else
//         if (values.length == 0)
//             throw new IllegalArgumentException();
        else {
            double sum = 0.0;
            for (int i = 0; i < values.length; i++)
                sum += values[i];



           return sum / values.length;
        }
    }
    
//          if (values == null | values.length == 0)
//          throw new IllegalArgumentException();
    // ** Unfortunately, this code is not correct. Even if values is null, this code will still attempt to access 
    // ** its length field because the normal boolean operators always evaluate both operands. --FALSE
    // ** We can correct the example code by using the conditional-OR (||) operator:

//       if (values == null || values.length == 0)
//       throw new IllegalArgumentException();

/**
 * Searches the array A for the integer N.  If N is not in the array,
 * then -1 is returned.  If N is in the array, then return value is
 * the first integer i that satisfies A[i] == N.
 */
static int find(int[] A, int N) {
      
   for (int index = 0; index < A.length; index++) {
      if ( A[index] == N ) 
         return index;  // N has been found at this index!
   }
   
   // If we get this far, then N has not been found
   // anywhere in the array.  Return a value of -1.
   
   return -1;
   
}

/**
 * Searches the array A for the integer N.
 * Precondition:  A must be sorted into increasing order.
 * Postcondition: If N is in the array, then the return value, i,
 *    satisfies A[i] == N.  If N is not in the array, then the
 *    return value is -1.
 */
static int binarySearch(int[] A, int N) {
      
    int lowestPossibleLoc = 0;
    int highestPossibleLoc = A.length - 1;
    
    while (highestPossibleLoc >= lowestPossibleLoc) {
       int middle = (lowestPossibleLoc + highestPossibleLoc) / 2;
       if (A[middle] == N) {
                 // N has been found at this index!
          return middle;
       }
       else if (A[middle] > N) {
                 // eliminate locations >= middle
          highestPossibleLoc = middle - 1;
       }
       else {
                 // eliminate locations <= middle
          lowestPossibleLoc = middle + 1;   
       }
    }
    
    // At this point, highestPossibleLoc < LowestPossibleLoc,
    // which means that N is known to be not in the array.  Return
    // a -1 to indicate that N could not be found in the array.
 
    return -1;
  
}
    

/*
 * Precondition:  itemsInArray is the number of items that are
 *    stored in A.  These items must be in increasing order
 *    (A[0] <= A[1] <= ... <= A[itemsInArray-1]).
 *    The array size is at least one greater than itemsInArray.
 * Postcondition:  The number of items has increased by one,
 *    newItem has been added to the array, and all the items
 *    in the array are still in increasing order.
 * Note:  To complete the process of inserting an item in the
 *    array, the variable that counts the number of items
 *    in the array must be incremented, after calling this
 *    subroutine.
 */
static void insert(int[] A, int itemsInArray, int newItem) {
      
   int loc = itemsInArray - 1;  // Start at the end of the array.
   
   /* Move items bigger than newItem up one space;
      Stop when a smaller item is encountered or when the
      beginning of the array (loc == 0) is reached. */
   
   while (loc >= 0 && A[loc] > newItem) {
      A[loc + 1] = A[loc];  // Bump item from A[loc] up to loc+1.
      loc = loc - 1;        // Go on to next location.
   }
   
   A[loc + 1] = newItem;  // Put newItem in last vacated space.

}


static void insertionSort(int[] A) {
      // Sort the array A into increasing order.
      
   int itemsSorted; // Number of items that have been sorted so far.

   for (itemsSorted = 1; itemsSorted < A.length; itemsSorted++) {
         // Assume that items A[0], A[1], ... A[itemsSorted-1] 
         // have already been sorted.  Insert A[itemsSorted]
         // into the sorted part of the list.
         
      int temp = A[itemsSorted];  // The item to be inserted.
      int loc = itemsSorted - 1;  // Start at end of list.
      
      while (loc >= 0 && A[loc] > temp) {
         A[loc + 1] = A[loc]; // Bump item from A[loc] up to loc+1.
         loc = loc - 1;       // Go on to next location.
      }
      
      A[loc + 1] = temp; // Put temp in last vacated space.
   }
}



// Another typical sorting method uses the idea of finding the biggest item in the
// list and moving it to the end -- which is where it belongs if the list is to be in 
// increasing order. Once the biggest item is in its correct location, you can then apply the same 
// idea to the remaining items. That is, find the next-biggest item, and move it
//  into the next-to-last space, and so forth. This algorithm is called selection sort. 
//  It's easy to write:
// SELECTION SORT 

static void selectionSort(int[] A) {
      // Sort A into increasing order, using selection sort
      
   for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {
         // Find the largest item among A[0], A[1], ...,
         // A[lastPlace], and move it into position lastPlace 
         // by swapping it with the number that is currently 
         // in position lastPlace.
         
      int maxLoc = 0;  // Location of largest item seen so far.
      
      for (int j = 1; j <= lastPlace; j++) {
         if (A[j] > A[maxLoc]) {
               // Since A[j] is bigger than the maximum we've seen
               // so far, j is the new location of the maximum value
               // we've seen so far.
            maxLoc = j;  
         }
      }
      
      int temp = A[maxLoc];  // Swap largest item with A[lastPlace].
      A[maxLoc] = A[lastPlace];
      A[lastPlace] = temp;
      
   }  // end of for loop
   
}
   public static void main(String[] args) {
   //    System.out.println("See the relation between a Matrix and a Vector:\n ");
   //    just_an_example(); 
       
       MatrixOperation matrix=new MatrixOperation();
        
    // matrices can be given in initialized form such a row vector form
    //     int[][] A={{-1, 3, -2}, {3, 5, 4},  {0, 6, 4},  {-2, 0, -1}}; 
    //  int B[][]=new int [n][k];
    //     int[][] B={{0, 3, -2, 0, 4}, {5, 0, 1, -1, 3},  {0, 2, -2, -3, -1}}; 
         
     // int  m=4, n=4, k=4; // --- for square matrices 
    // for A(m,n), B(n,k) matrices I will give the following ranges just for practicals 
     int m=3, n=2, k=3;
     int[][] A=new int[m][n];
     System.out.println("\nPlease enter the elements of matrix A: ");
     matrix.readElms(A); 
        
     int[][] B=new int[n][k];System.out.println("\nPlease enter the elements of matrix B: ");
     matrix.readElms(B); 
         
     System.out.print("\n-------------------------------------");             
     System.out.print("\n \t\t  Matrix A \n");  
     System.out.print("-------------------------------------\n");             
     matrix.printElms(A);       
      
     System.out.print("\n-------------------------------------");             
     System.out.print("\n \t\t  Matrix B \n");  
     System.out.print("-------------------------------------\n");   
     matrix.printElms(B);
      
      System.out.print("\n \n Now, we will find the matrix C which is the product of A*B ");
      int C[][]=new int [m][k];
      System.out.print("\n Dimension of Matrix C will be : C("+C.length+","+C[0].length+")");
      System.out.print("\n-------------------------------------");             
      System.out.print("\n \t\t  Matrix C=A*B \n");  
      System.out.print("-------------------------------------\n");  
      matrix.productOf2Matrices(A,B,C);  
      
      // Multiplying the matrices, another option
      //      int sum=0;
      //       for (int i=0; i<m; i++)
      //         for (int j=0; j<k; j++)
      //               {
          //                  for (int l=0; l<n; l++)
          //                  sum=sum+A[i][l]*B[l][j];
          //                  C[i][j]=sum; sum=0;                           
          //   }  
    }
 }
