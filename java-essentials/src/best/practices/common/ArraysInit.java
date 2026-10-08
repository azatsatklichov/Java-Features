package best.practices.common;

public class ArraysInit {
    public static void main(String[] args) {
        int x = 9;

        //
        int[] dots = {6, x, 8};
        // dots = {4,5}; //you can not re-initialize this direct construct {}
        dots = new int[]{6, x, 8}; // BUT this is OK

        int[] dotsz = new int[]{6, x, 8};
        // dotsz = {4,5,66};//you can not re-initialize this direct construct {}

        int[] dotss;
        // dotss = { 6, x, 8 }; // Array constants can only be used in initializers
        // dots = {4,5}; //// Array constants can only be used in initializers

        // Constructing and Initializing an Anonymous Array
        int[] dots2; // can be possible to initialize in new line
        dots2 = new int[]{6, 8};

        // like matlab approaches
        int[][] scores = {{5, 2, 4, 7}, {9, 2}, {3, 4}};
        // or
        scores = new int[][]{{23, 232}, {232}};

        int[][][] arr3d = {{{1, 2}, {0, -3, 12}}, {{11, 21, 2, 21, 2}}};

        int count = 0;
        for (; ; ) {// ;true;
            System.out.print("s ");
            if (count++ == 50) {
                break;
            }
        }
    }

}


class ArrayUtil {

    public static void print2DArray(int[][] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            int[] js = myArray[i];
            if (js != null) {
                for (int j = 0; j < js.length; j++) {
                    int arr = js[j];
                    System.out.print(arr + " ");
                }
            }
            System.out.println();

        }
    }

    public static void print2DMatrix(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            int[] arr1D = grid[r];
            if (arr1D != null) {
                for (int c = 0; c < arr1D.length; c++)
                    System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }
    }

    public static void fill2DArray(int[][] myArray, int defaultValue,
                                   int diagValue) {
        for (int i = 0; i < myArray.length; i++) {
            int[] js = myArray[i];
            if (js != null) {
                for (int j = 0; j < js.length; j++) {
                    if (i == j)
                        myArray[i][j] = diagValue;
                    else
                        myArray[i][j] = defaultValue;
                }
            }
        }
    }

}