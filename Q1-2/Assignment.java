/**
 *Question 1.2
 * The class  <b>Assignment</b> is used to
 * test our LinearRegression class. It uses the
 * provided class <b>Display</b> to show the results
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
     * In this second method, we will select a line at random.
     * 	1) we select a line y = ax + b, with a randomly selected
     * between -100 and +100 and b randomly selected between 
     * -250 and +250
     * 	2) we add 500 samples randomly selected on the line
     * between -100 and +300. For each sample we add a "noise" 
     * randomly selected between -1000 and +1000 (that is, for
     * each randomly selected x, we add the sample (x, ax+b+noise).
     * where "noise" is randomly selected between -1000 and 1000
     *  3) We create an instance of Display
     *  4) we iterate gradient descent (find a number of iterations,
     * a number of updates to the instance of Display, and a 
     * step alpha that seems to work
     */
	private static void randomLine(){

		// your code goes there
		
		LinearRegression linearRegression;
		linearRegression = new LinearRegression(500);
		
		Display graph; 
		graph = new Display(linearRegression);
		
		double a,b,noise,x,alpha;
		alpha=generator.nextDouble()*1;
		a=generator.nextDouble()*200-100;
		b=generator.nextDouble()*500-250;
		graph.setTarget(a,b);
		
		for(int i = 0; i< 500;i++){
			
			x =generator.nextDouble()*400-100;
			noise = generator.nextDouble()*2000-1000;
			linearRegression.addSample(x,a*x+b+noise);
			
		}	
			
		for(int i=0;i <40;i ++){
			
			System.out.println(linearRegression.currentHypothesis());
			System.out.println("Current cost:" + linearRegression.currentCost());
			System.out.println("Aiming for:" + a + "+" + b +"x_1");
			graph.update();
			linearRegression.gradientDescent(0.000000004,100);
			
		} 

	}


	public static void main(String[] args) {

	    StudentInfo.display();

		System.out.println("randomLine");
		randomLine();

	}

}