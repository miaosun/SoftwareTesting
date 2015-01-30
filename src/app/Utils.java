package app;
import java.util.ArrayList;
import java.util.Random;


public class Utils {
	
	protected static Random random = new Random();
	public static double doubleInRange(double min, double max) {
	  return random.nextDouble() * (max-min) + min;
	}
	
	public static int intInRange(int min, int max) {
		return random.nextInt((max - min) + 1) + min;
	}
	
	public static double averageConsumerCash(ArrayList<Consumer> consumers) {
		double res = 0.0;
		for(Consumer consumer : consumers)
		{
			res += consumer.getCash();
		}
		return res / consumers.size();
	}
}
