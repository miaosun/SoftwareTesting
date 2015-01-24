import java.util.Random;


public class Utils {
	
	protected static Random random = new Random();
	public static double doubleInRange(double min, double max) {
	  return random.nextDouble() * (max-min) + min;
	}
	
	public static int intInRange(int min, int max) {
		return random.nextInt((max - min) + 1) + min;
	}
}
