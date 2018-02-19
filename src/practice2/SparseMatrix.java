package practice2;

public class SparseMatrix {
	public static int[] value;
	public static int[] rowPtr;
	public static int[] colInd;
	public SparseMatrix(int[] value, int[] rowPtr, int[] colInd) {
		this.value = value;
		this.rowPtr = rowPtr;
		this.colInd = colInd;
	}
	public static int[][] matrixA(){
		int[][] A = new int[5][5];
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				A[i][j] = 0;
		int m = 1;
		int n = 1;
		while(n <= value.length) {
			while(n > rowPtr[m]) 
				m++;
			A[m - 1][colInd[n - 1]] = value[n - 1];
			n++;
		}
		return A;
	}
	public static int retrieveElement(int m, int n) {
		return matrixA()[m][n];
	}
	public static void output() {
		System.out.println("The matrix is: " );
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(matrixA()[i][j] + " ");
				if(j == 4)
					System.out.println("");
			}
		}
		System.out.println("A[0][0] is: " + retrieveElement(0, 0));
	}
}
