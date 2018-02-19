package practice1;

public class Main {
	public static double sol = 2.3504;
	public static double hk = 2.0;
	public static void main(String[] args) {
		double rec = hk * func(-1);
		double trap = hk * (0.5 * func(-1) + 0.5 * func(1));
		double mid = hk * func(0);
		double simp = hk * (1 / 6 * func(-1) + 4 / 6 * func(0) + 1 / 6 * func(1));
		double gaussian2 = hk * (0.5 * (func(0) - 1 / (2 * Math.sqrt(3)) * hk) + 0.5 * (func(0) + 1 / (2 * Math.sqrt(3)) * hk));
		System.out.println("Rectangle approximation is: " + rec + ", error is: " + ((rec - sol) / sol));
		System.out.println("Trapezoid approximation is" + trap + ", error is: " + ((trap - sol) / sol));
		System.out.println("Midpoint approximation is" + mid + ", error is: " + ((mid - sol) / sol));
		System.out.println("Simpson approximation is" + simp + ", error is: " + ((simp - sol) / sol));
		System.out.println("2-point Gaussian approximation is" + gaussian2 + ", error is: " + ((gaussian2 - sol) / sol));
		
	}
	public static double func(double x) {
		return Math.pow(Math.E, x);
	}
}
