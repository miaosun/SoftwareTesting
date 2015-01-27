import java.text.DecimalFormat;
import java.util.ArrayList;


public class Simulation {

	public static void main(String[] args) {

		ArrayList<Producer> producers = new ArrayList<Producer>();
		ArrayList<Consumer> consumers = new ArrayList<Consumer>();
		ArrayList<Product> products = new ArrayList<Product>();

		boolean change_wage = false;  //false: consumer's wage remain constant; true: increase by a small random value (<5%)
		
		for(int i=0; i<100; i++)
		{
			consumers.add(new Consumer(change_wage));
		}

		for(int i=0; i<15; i++)
		{
			producers.add(new Producer());
		}

		for(int i=0; i<5; i++)
		{
			products.add(new Product());
		}
		
		for(int i=0; i<1; i++) // cycles
		{
			System.out.println("     Cycle: " + i);
			for(int j=0; j<consumers.size(); j++)
			{
				System.out.println("Consumer " + j + ": " + new DecimalFormat("#.00").format(consumers.get(j).getCash()));
				consumers.get(j).start(producers, products);
			}
		}

	}

}
