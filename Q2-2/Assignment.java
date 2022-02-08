/**
 *Question2.2
 * The class  <b>Assignment</b> is used to
 * test our LinearRegression class. 
 *
 * @author Rayold Rakotonomenjanahary(rrako090@uottawa.ca)
 * @author Sydroy Rakotonomenjanahary(srako102@uottawa.ca)
 */

public class Assignment {


	/** 
     * Random generator 
     */
	private static java.util.Random generator = new java.util.Random();

    /** 
     * In this first method, we are simply using sample points that are
     * on a straight plane. We will use the plane z= x + 2x.
     * In his method, 
     * 	1) we create an instance of LinearRegression.
     * 	2) we add 2,000 samples from the plane z= x + 2x as follows:
     * 		add the sample [(i, 2i), 5i] for 0<=i<=999
     * 		add the sample [(2i, i), 4i] for 0<=i<=999
     *  3) we iterate gradient descent 10,000, printing out the
     * current hypothesis and the current cost every 1,000 
     * iterations, using a step alpha of 0.000000003
     */
    private static void setPlane(){

		// your code goes there

	}

	/** 
     * In this second method, we will select a plane at random.
     * 	1) we select a line z = ax + by + c, with a, b and c 
     * randomly selected between -100 and +100 
     * 	2) we add 5000 samples randomly selected on the plane
     * with x and y both randomly selected between 50 and 4000. 
     * For each sample we add a "noise" 
     * randomly selected between -20 and +20 (that is, for
     * each randomly selected x and y we add the sample 
     *[ (x,y), ax+by+c+noise).
     * where "noise" is randomly selected between -20 and 20
     *  4) we iterate gradient descent (find a number of iterations,
     * and a step alpha that seems to work, regularly printing
     * the target,  the current hypothesis and the current cost)
     */

	private static void randomPlane(){

		// your code goes there
		double a,b,c,x,y,noise;
		a = generator.nextDouble()*200-100;
		b = generator.nextDouble()*200-100;
		c = generator.nextDouble()*200-100;
		LinearRegression linearRegression;
		linearRegression = new LinearRegression(2,5000);
		for (int i=0; i<5000;i++){
			noise = generator.nextDouble()*40-20;
			x = generator.nextDouble()*350+50;
			y = generator.nextDouble()*350+50;
			double[]array={x,y};
			linearRegression.addSample(array,a*x+b*y+c+noise);
			
		}
		for(int i=0;i <40;i ++){
			System.out.println(linearRegression.currentHypothesis());
			System.out.println("Current cost:" + linearRegression.currentCost());
			System.out.println("Aiming for:" + a +"x"+ "+" + b +"y"+"+"+c);
			linearRegression.gradientDescent(0.000000004,100);
		}

	}


	public static void main(String[] args) {

		StudentInfo.display();

		System.out.println("randomPlane");
		randomPlane();



	}

}