package practice2;

public class Main {
	public static void main(String[] arg) {
		int[] value = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int[] rowPtr = {0, 3, 6, 9, 10, 12};
		int[] colInd = {0, 1, 4, 0 ,1, 2, 1, 2, 4, 3, 0, 4};
		SparseMatrix matrixA = new SparseMatrix(value, rowPtr, colInd);
		matrixA.output();
	}
}
