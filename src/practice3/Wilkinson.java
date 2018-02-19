package practice3;
import practice2.SparseMatrix;;

public class Wilkinson {
	public static int[] value = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	public static int[] rowPtr = {0, 3, 6, 9, 10, 12};
	public static int[] colInd = {0, 1, 4, 0 ,1, 2, 1, 2, 4, 3, 0, 4};
	public static SparseMatrix matrix = new SparseMatrix(value, rowPtr, colInd);
	public static int[][] A = SparseMatrix.matrixA();
	public static int[] x = {5, 4, 3, 2, 1};
	public static int[] rowCompressed(){
		int[] res = {0, 0, 0, 0, 0};
		int m = 1;
		for(int i = 1; i <= 12; i++) {
			while(i > rowPtr[m])
				m++;
			res[m - 1] += value[i - 1] * x[colInd[i - 1]];
		}
		
		return res;
	}
	public static int[] fullMatrix() {
		int[] res = {0, 0, 0, 0, 0};
		for(int m = 0; m < 5; m++) {
			for(int n = 0; n < 5; n++) {
				res[m] += A[m][n] * x[n];
			}
		}
		return res;
	}
	public static boolean isCorrect() {
		for(int i = 0; i < 5; i++) {
			if(Wilkinson.rowCompressed()[i] != Wilkinson.fullMatrix()[i])
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println("The result of using row-compressed storage is:");
		for(int i = 0; i < 5; i++)
			System.out.println(rowCompressed()[i]);
		System.out.println("The result of using full-martix representation is:");
		for(int i = 0; i < 5; i++)
			System.out.println(fullMatrix()[i]);
		if(isCorrect())
			System.out.println("Two methods have same result. According to Wilkinson Principle, both of the methods are correct.");
		else
			System.out.println("Two methods have different result. At least one of them is wrong");
	}
}
