/**
 *Question1.2
 * The class  <b>LinearRegression</b> implements gradient
 * descent with 1 variable.
 *
 * @author Rayold Rakotonomenjanahary(rrako090@uottawa.ca)
 * @author Sydroy Rakotonomenjanahary(srako102@uottawa.ca)
 */

public class LinearRegression {


	/** 
     * Number of samples (usually "m" in litterature) 
     */
	private int nbreOfSamples;


	/** 
     * the sample vector
     */
	private double[] samples;

	/** 
     * the samples target values
     */
	private double[] samplesValues;

	/** 
     * the current hypthesis function: theta0 + theta1 x
     */
	private double theta0, theta1;


	/** 
     * used to ensure that the object is ready
     */
	private int currentNbreOfSamples;



	/** 
     * counts how many iterations have been performed
     */
	private int iteration;


	/** 
     * Object's contructor. The constructor initializes the instance
     * variables. The starting hypthesis is y = 0;
     * 
     * 
     * @param m the number of samples that we will have
	 *
     */
 	public LinearRegression(int m){

 		// your code goes there
		this.nbreOfSamples = m;
		this.theta0 =0.0; 
		this.theta1= 0.0;
		this.samples = new double[this.nbreOfSamples];
		this.samplesValues = new double[this.nbreOfSamples];
		currentNbreOfSamples = 0; 
		this.iteration = 0;

	}

	/** 
     * Adds a new sample to sample and to samplesValues. This
     * method must be iteratively called with all the samples
     * before the gradient descent can be started
     * 
     * @param x the new sample
     * @param y the corresponding expected value
     *
	 */
	public void addSample(double x, double y){

		// your code goes there
		samples[currentNbreOfSamples] = x;
		samplesValues[currentNbreOfSamples] = y;
		currentNbreOfSamples ++;
	}

	/** 
     * Returns the current hypothesis for the value of the input
     * @param x the input for which we want the current hypothesis
     * 
	 * @return theta0 + theta1 x
	 */
	private double hypothesis(double x){
		// your code goes there
		double a = this.theta0 + this.theta1*(x);
		return a;
	}

	/** 
     * Returns a string representation of hypthesis function
     * 
	 * @return the string "theta0 + theta1 x"
	 */
	public String currentHypothesis(){

		// your code goes there
		String hypothesis = "Current hypothesis:" + getTheta0()+ "+" + getTheta1()+"x";
		return hypothesis;
	}

	/** 
     * Returns the current cost
     * 
	 * @return the current value of the cost function
	 */
	public double currentCost(){
		// your code goes there
		double temp = 0.0; 
		for (int i= 0; i< this.nbreOfSamples; i++){
			temp += (hypothesis(samples[i])-samplesValues[i])*(hypothesis(samples[i])-samplesValues[i]);
		}
		return temp/nbreOfSamples;
	}

	/** 
     * runs several iterations of the gradient descent algorithm
     * 
     * @param alpha the learning rate
     *
     * @param numberOfSteps how many iteration of the algorithm to run
     */
	public void gradientDescent(double alpha, int numberOfSteps) {


		// your code goes there
		for(int i=0; i < numberOfSteps; i++){
			double tempTeta0 = 0.0;
			double tempTeta1 = 0.0;
	
		for (int j= 0; j< nbreOfSamples; j++){
			tempTeta0 += (hypothesis(samples[j])-samplesValues[j]);
			tempTeta1 += ((hypothesis(samples[j])-samplesValues[j])*samplesValues[j]);
		}
		
		theta0 -=(alpha*(2)*(tempTeta0))/nbreOfSamples;
		theta1 -=(alpha*(2)*(tempTeta1))/nbreOfSamples;
		iteration ++;
		}
		
	}



	/** 
     * Getter for theta0
     *
	 * @return theta0
	 */

	public double getTheta0(){
		// your code goes there
		return theta0;
	}

	/** 
     * Getter for theta1
     *
	 * @return theta1
	 */

	public double getTheta1(){
		// your code goes there
		return theta1;
	}

	/** 
     * Getter for samples
     *
	 * @return samples
	 */

	public double[] getSamples(){
		// your code goes there
		return samples;
	}

	/** 
     * Getter for getSamplesValues
     *
	 * @return getSamplesValues
	 */

	public double[] getSamplesValues(){
		// your code goes there
		return samplesValues;
	}

	/** 
     * Getter for iteration
     *
	 * @return iteration
	 */

	public int getIteration(){
		// your code goes there
		return iteration;
	}
}