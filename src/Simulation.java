import java.text.DecimalFormat;
import java.util.ArrayList;


public class Simulation {

	public static void main(String[] args) {

		ArrayList<Producer> producers = new ArrayList<Producer>();
		ArrayList<Consumer> consumers = new ArrayList<Consumer>();
		ArrayList<Product> products = new ArrayList<Product>();

		boolean change_wage = false;  //false: consumer's wage remain constant; true: increase by a small random value (<5%)
		
		/*
		 *  Initialize all consumers
		 */
		for(int i=0; i<1000; i++)
		{
			consumers.add(new Consumer(change_wage));
		}

		/*
		 *  Initialize all producers
		 */
		for(int i=0; i<15; i++)
		{
			producers.add(new Producer());
		}

		/*
		 *  Initialize all products
		 */
		for(int i=0; i<5; i++)
		{
			products.add(new Product());
		}
		
		/*
		 *  Cycles
		 */
		for(int i=0; i<10; i++) 
		{
			System.out.println("********************** Cycle: " + i + " **************************");
			
			/*
			 *  Transactions of orders between consumers and producers
			 */
			for(int j=0; j<consumers.size(); j++)    // consumer
			{
				//System.out.println("Consumer " + j + ": " + new DecimalFormat("#.00").format(consumers.get(j).getCash()));
				consumers.get(j).start(producers, products);
				consumers.get(j).updateCash();
			}
			
			/*
			 *  Required output
			 */
			for(int j=0; j<producers.size(); j++)
			{
				System.out.println("   **************** Producer " + producers.get(j).getId() + " ****************");
				System.out.println("      Number of orders in execution: " + producers.get(j).getNExecutionOrders());
				System.out.println("      Number of completed orders: " + producers.get(j).getNCompletedOrders());
				
				ArrayList<Factory> factories = producers.get(j).getFactories();
				System.out.println("      Number of factories: " + factories.size());
				System.out.println("      Number of completed orders per factory:");
				for(int k=0; k<factories.size(); k++)
				{
					System.out.println("         Factory " + k + ": " + factories.get(k).getNCompletedOrders());
				}
				System.out.println("      Cash available: " + new DecimalFormat("#.00").format(producers.get(j).getCash()));
				System.out.println("   *********************************************");
				System.out.println();
				
				// update order status, update cash
				producers.get(j).updateData(i);
			}
			System.out.println("   Consumers' average cash: " + new DecimalFormat("#.00").format(Utils.averageConsumerCash(consumers)));
			System.out.println("**********************************************************");
			System.out.println();
		}
	}

}
