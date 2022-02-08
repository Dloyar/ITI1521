import java.util.Random;

/**
 * The class <b>GameModel</b> holds the model, the state of the systems. 
 * It stores the following information:
 * - the state of all the ``dots'' on the board (mined or not, clicked
 * or not, number of neighbooring mines...)
 * - the size of the board
 * - the number of steps since the last reset
 *
 * The model provides all of this informations to the other classes trough 
 *  appropriate Getters. 
 * The controller can also update the model through Setters.
 * Finally, the model is also in charge of initializing the game
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
  * @author Rayold Rakotonomenjanahary(rrako090@uottawa.ca)
 * @author Sydroy Rakotonomenjanahary(srako102@uottawa.ca)
 */
public class GameModel {


     // ADD YOUR INSTANCE VARIABLES HERE
	 private java.util.Random generator;
	 private int heigthOfGame;
	 private DotInfo[][] model;
	 private int numberOfMines;
	 private int numberOfSteps;
	 private int numberUncovered;
	 private int widthOfGame;

    /**
     * Constructor to initialize the model to a given size of board.
     * 
     * @param width
     *            the width of the board
     * 
     * @param heigth
     *            the heigth of the board
     * 
     * @param numberOfMines
     *            the number of mines to hide in the board
     */
    public GameModel(int width, int heigth, int numberOfMines) {
        
    // ADD YOU CODE HERE
		generator = new Random();
		heigthOfGame = heigth;
		widthOfGame = width;
		model = new DotInfo[heigthOfGame][widthOfGame];
		this.numberOfMines = numberOfMines;
		
		reset();//appeler cette méthode pour créer les cases et positionnés les mines
		
		
    }


 
    /**
     * Resets the model to (re)start a game. The previous game (if there is one)
     * is cleared up . 
     */
    public void reset(){

        
    // ADD YOU CODE HERE
		this.widthOfGame = widthOfGame;
		this.heigthOfGame = heigthOfGame;
		this.numberOfMines = numberOfMines;
		model = new DotInfo[heigthOfGame][widthOfGame];
		numberOfSteps = 0;
		numberUncovered = 0;
		
		//créer les cases
		for (int i = 0; i < heigthOfGame; i++) {
			for (int j = 0; j < widthOfGame; j++) {
				model[i][j] = new DotInfo(i,j);
			}
		}
		
		//placer les mines dans leurs emplacement respective
		
		int index = 0;//pour compter le nombre de mine placer 
		while (index < numberOfMines){
			
			int i = generator.nextInt(heigthOfGame);
			int j = generator.nextInt(widthOfGame);
			if(isMined(i,j) == false){//si il y a pas de mine dans la case
				model[i][j].setMined();
				index ++;
			}
		}
		
		//boucle pour compter le nombre de mines autour d'une case[i][j]
		for (int i = 0; i <heigthOfGame; i++) {
			for(int j = 0; j<widthOfGame;j++){
				int temp = 0; //pour tenir temporairement le nombre de mines autour d'une case 
				
				if ((i-1)>=0 && (j-1)>=0){//verifie l'existence d'une case en haut à gauche de la case[i][j]
					if(isMined(i-1,j-1)){
						temp++;
					}
				}
				
				if((i-1)>=0 && j>=0){//verifie l'existence d'une case en haut au centre de la case[i][j]
					if(isMined(i-1,j)){
						temp++;
					}
					
				} 
				
				if ((i-1)>=0 && (j+1)<widthOfGame){//verifie l'existence d'une case en haut à droite de la case[i][j]
					if(isMined(i-1,j+1)){
						temp++;
					}
				}
				
				if (i>=0 && (j-1)>=0){//verifie l'existence d'une case à gauche de la case[i][j]
					if(isMined(i,j-1)){
						temp++;
					}
				}
				
				if (i>=0 && (j+1)<widthOfGame){//verifie l'existence d'une case à droite de la case[i][j]
					if(isMined(i,j+1)){
						temp++;
					}
				}
				
				if (i+1<heigthOfGame && (j-1)>=0){//verifie l'existence d'une case en bas à gauche de la case[i][j]
					if(isMined(i+1,j-1)){
						temp++;
					}
				}
				
				if (i+1<heigthOfGame && j>=0){//verifie l'existence d'une case en bas au centre de la case[i][j]
					if(isMined(i+1,j)){
						temp++;
					}
				}
				
				if (i+1<heigthOfGame && j+1<widthOfGame){//verifie l'existence d'une case en bas à droite de la case[i][j]
					if(isMined(i+1,j+1)){
						temp++;
					}
				}
				model[i][j].setNeighbooringMines(temp);//ajouter le nombre de mine autour de la case[i][j]
			}
		}
		
		

    }


    /**
     * Getter method for the heigth of the game
     * 
     * @return the value of the attribute heigthOfGame
     */   
    public int getHeigth(){
        
    // ADD YOU CODE HERE
		return heigthOfGame;

    }

    /**
     * Getter method for the width of the game
     * 
     * @return the value of the attribute widthOfGame
     */   
    public int getWidth(){
        
    // ADD YOU CODE HERE
		return widthOfGame;

    }



    /**
     * returns true if the dot at location (i,j) is mined, false otherwise
    * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the status of the dot at location (i,j)
     */   
    public boolean isMined(int i, int j){
        
    // ADD YOU CODE HERE
		return model[i][j].isMined();

    }

    /**
     * returns true if the dot  at location (i,j) has 
     * been clicked, false otherwise
     * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the status of the dot at location (i,j)
     */   
    public boolean hasBeenClicked(int i, int j){
        
    // ADD YOU CODE HERE
		return model[i][j].hasBeenClicked();
    }

  /**
     * returns true if the dot  at location (i,j) has zero mined 
     * neighboor, false otherwise
     * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the status of the dot at location (i,j)
     */   
    public boolean isBlank(int i, int j){
        
    // ADD YOU CODE HERE
		boolean blank = false;//pour verifier si la case est vide ou pas
		if(getNeighbooringMines(i,j)==0 && isMined(i,j)==false){
			blank = true;
		}
		return  blank;
    }
    /**
     * returns true if the dot is covered, false otherwise
    * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the status of the dot at location (i,j)
     */   
    public boolean isCovered(int i, int j){
        
    // ADD YOU CODE HERE
		return model[i][j].isCovered();

    }

    /**
     * returns the number of neighbooring mines os the dot  
     * at location (i,j)
     *
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the number of neighbooring mines at location (i,j)
     */   
    public int getNeighbooringMines(int i, int j){
        
    // ADD YOU CODE HERE
		return model[i][j].getNeighbooringMines();

    }


    /**
     * Sets the status of the dot at location (i,j) to uncovered
     * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     */   
    public void uncover(int i, int j){
        
    // ADD YOU CODE HERE
		model[i][j].uncover();
		numberUncovered++;
    }

    /**
     * Sets the status of the dot at location (i,j) to clicked
     * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     */   
    public void click(int i, int j){
        
    // ADD YOU CODE HERE
		model[i][j].click();
    }
     /**
     * Uncover all remaining covered dot
     */   
    public void uncoverAll(){
        
    // ADD YOU CODE HERE
		for (int i = 0; i < heigthOfGame; i++) {
			for (int j = 0; j < widthOfGame; j++) {
				if(isCovered(i,j)){
					uncover(i,j);
				}
			}
		}
    }

 

    /**
     * Getter method for the current number of steps
     * 
     * @return the current number of steps
     */   
    public int getNumberOfSteps(){
        
    // ADD YOU CODE HERE
		return numberOfSteps;
    }

  

    /**
     * Getter method for the model's dotInfo reference
     * at location (i,j)
     *
      * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     *
     * @return model[i][j]
     */   
    public DotInfo get(int i, int j) {
        
    // ADD YOU CODE HERE
		return model[i][j];
    }


   /**
     * The metod <b>step</b> updates the number of steps. It must be called 
     * once the model has been updated after the payer selected a new square.
     */
     public void step(){
        
    // ADD YOU CODE HERE
		numberOfSteps++;
    }
 
   /**
     * The metod <b>isFinished</b> returns true iff the game is finished, that
     * is, all the nonmined dots are uncovered.
     *
     * @return true if the game is finished, false otherwise
     */
    public boolean isFinished(){
        
    // ADD YOU CODE HERE
		return numberUncovered == heigthOfGame*widthOfGame;
    }


   /**
     * Builds a String representation of the model
     *
     * @return String representation of the model
     */
    public String toString(){
        
    // ADD YOU CODE HERE
	String game = "heigthOfGame: "+heigthOfGame+"\n widthOfGame: " + widthOfGame
						+ "\n numberOfMines: "+ numberOfMines + " \n numberOfSteps:"
						+ numberOfSteps + "\n numberUncovered: " + numberUncovered;
		return game;//retourne toutes les informations sur model

    }
}
