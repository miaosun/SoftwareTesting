import java.util.ArrayList;


public class Producer {
	ArrayList<Factory> factories;
	double cash;
	
	double[] margins;
	int threshold;
	
	public Producer() {
		double percentage = Utils.doubleInRange(-0.1, 0.1);
		
		cash = 10000 * (1+percentage);
	}
	
	public boolean bankrupted() {
		if(cash <= 0)
			return true;
		else
			return false;
	}
	
	public void setMargins() {
		for(int i=0; i<5; i++)
		{
			margins[i] = Utils.doubleInRange(1.2, 1.5);
		}
	}

	public double getMargin(int p) {
		if(p<0 || p>4)
			throw new IndexOutOfBoundsException("Index out of range");
		
		return margins[p];
	}
}
