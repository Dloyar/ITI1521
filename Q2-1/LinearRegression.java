/**
 *Question2.1
 * The class  <b>LinearRegression</b> implements gradient
 * descent for multiple variables
 *
 * @author Rayold Rakotonomenjanahary(rrako090@uottawa.ca)
 * @author Sydroy Rakotonomenjanahary(srako102@uottawa.ca)
 */

public class LinearRegression{


	/** 
     * Number of features (usually "n" in litterature) 
     */
	private int nbreOfFeatures;

	/** 
     * Number of samples (usually "m" in litterature) 
     */
	private int nbreOfSamples;


	/** 
     * the nbreOfFeatures X nbreOfSamples Matrix of samples
     */
	private double[][] samplesMatrix;

	/** 
     * the nbreOfSamples Matrix of samples target values
     */
	private double[] samplesValues;

	/** 
     * the nbreOfFeatures Matrix theta of current hypthesis function
     */
	private double[] theta;


	/** 
     * number of samples received so far
     */
	private int currentNbreOfSamples;

	/** 
     * a place holder for theta during descent calculation
     */
	private double[] tempTheta;


	/** 
     * counts how many iterations have been performed
     */
	private int iteration;
	
	/** 
     * Object's contructor. The constructor initializes the instance
     * variables. The starting hypthesis is theta[i]=0.0 for all i
     * 
     * @param n the number of features that we will have
     * @param m the number of samples that we will have
	 *
     */
 	public LinearRegression(int n, int m){

		// your code goes there
		nbreOfSamples = m;
		nbreOfFeatures = n;
		samplesMatrix = new double[nbreOfFeatures][nbreOfSamples];
		samplesValues = new double[nbreOfSamples];
		theta = new double [nbreOfSamples];
		currentNbreOfSamples = 0; 
		tempTheta = new double[nbreOfSamples];
		
		iteration = 0; 

	}

	/** 
     * Add a new sample to samplesMatrix and samplesValues
     * 
     * @param x the vectors of samples
     * @param y the coresponding expected value
     *
	 */
	public void addSample(double[] x, double y){

		// your code goes there
		samplesMatrix[0][currentNbreOfSamples]=x[0];
		samplesMatrix[1][currentNbreOfSamples]=x[1];
		samplesValues[currentNbreOfSamples]=y;
		currentNbreOfSamples ++;

	}

	/** 
     * Returns the current hypothesis for the value of the input
     * @param x the input vector for which we want the current hypothesis
     * 
	 * @return h(x)
	 */

	private double hypothesis(double[] x){
		double hypothesis = 0.0;
		x = new double [nbreOfSamples];
		for (int i=0; i<nbreOfSamples;i++){
			hypothesis += theta[i]*x[i];
		}
		//your code goes there
		
		return hypothesis;
	}

	/** 
     * Returns a string representation of hypthesis function
     * 
	 * @return the string "theta0 x_0 + theta1 x_1 + .. thetan x_n"
	 */

	public String currentHypothesis(){

		// your code goes there
		String output = "Current Hypothesis: " + theta[0]+ " + " + theta[1]+"x_1" + " + " + theta[2]+"x_2";
		return output;
	}

	/** 
     * Returns the current cost
     * 
	 * @return the current value of the cost function
	 */

	public double currentCost(){
		double sumCost = 0.0;
		double []x = new double [nbreOfSamples];
		
		// your code goes there
		for (int i = 0; i< nbreOfSamples;i++){
			sumCost += (hypothesis(samplesMatrix[0])-samplesValues[i])*(hypothesis(samplesMatrix[0])-samplesValues[i]);
		}
		return sumCost/nbreOfSamples;
	}

	/** 
     * runs several iterations of the gradient descent algorithm
     * 
     * @param alpha the learning rate
     *
     * @param numberOfSteps how many iteration of the algorithm to run
     */

	public void gradientDescent(double alpha, int numberOfSteps) {

		double []x = new double [nbreOfSamples];
		for(int index = 0; index<numberOfSteps;index++ ){ 
			double sum = 0;
			for(int i= 0; i<nbreOfSamples; i++){
				tempTheta [i]= 0.0;
				sum += (hypothesis(samplesMatrix[0])-samplesValues[i])*samplesValues[i];
				tempTheta [i] += sum; 
			}
			
		}
		for(int i= 0; i<nbreOfSamples; i++){
			theta[i] +=(-alpha)*2*(tempTheta[i])/nbreOfSamples;
		}
			iteration++;

	}


	/** 
     * Getter for theta
     *
	 * @return theta
	 */

	public double[] getTheta(){

		// your code goes there
		return theta;

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