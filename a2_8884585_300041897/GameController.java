import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.*;


/**
 * The class <b>GameController</b> is the controller of the game. It is a listener
 * of the view, and has a method <b>play</b> which computes the next
 * step of the game, and  updates model and view.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
  * @author Rayold Rakotonomenjanahary(rrako090@uottawa.ca)
 * @author Sydroy Rakotonomenjanahary(srako102@uottawa.ca)
 */


public class GameController implements ActionListener {

    // ADD YOUR INSTANCE VARIABLES HERE
		private GameModel gameModel;
		private GameView gameView;

    /**
     * Constructor used for initializing the controller. It creates the game's view 
     * and the game's model instances
     * 
     * @param width
     *            the width of the board on which the game will be played
     * @param height
     *            the height of the board on which the game will be played
     * @param numberOfMines
     *            the number of mines hidden in the board
     */
    public GameController(int width, int height, int numberOfMines) {

    // ADD YOU CODE HERE
		gameModel = new GameModel(width,height,numberOfMines);
		gameView = new GameView(gameModel,this);

    }


    /**
     * Callback used when the user clicks a button (reset or quit)
     *
     * @param e
     *            the ActionEvent
     */

    public void actionPerformed(ActionEvent e) {
        
    // ADD YOU CODE HERE
		if(e.getActionCommand().equals("Reset")) {
			reset();
			gameView.update();
		}
		if(e.getActionCommand().equals("Quit")) {
			System.exit(0);
		}
		if(e.getActionCommand().equals(gameModel.getHeigth()+" "+gameModel.getWidth())) {
			play(gameModel.getHeigth(),gameModel.getWidth());
			gameView.update();
		}
			
    }

    /**
     * resets the game
     */
    private void reset(){

	// ADD YOU CODE HERE
		gameModel.reset();

    }

    /**
     * <b>play</b> is the method called when the user clicks on a square.
     * If that square is not already clicked, then it applies the logic
     * of the game to uncover that square, and possibly end the game if
     * that square was mined, or possibly uncover some other squares. 
     * It then checks if the game
     * is finished, and if so, congratulates the player, showing the number of
     * moves, and gives to options: start a new game, or exit
     * @param width
     *            the selected column
     * @param heigth
     *            the selected line
     */
    private void play(int width, int heigth){

    // ADD YOU CODE HERE
		if(gameModel.hasBeenClicked(heigth,width)==false){
			gameModel.click(heigth,width);
			 
			 
			if (gameModel.isCovered(heigth,width)) {
				gameModel.step();
			}
			
			gameModel.uncover(heigth,width);

			if (gameModel.isBlank(width,heigth)) {
				clearZone(gameModel.get(width,heigth));
			}
			
		}
		 if (gameModel.isFinished() == true) {
			gameView.update();
			gameModel.uncoverAll();
			gameView.update();
		 }
	
    }

   /**
     * <b>clearZone</b> is the method that computes which new dots should be ``uncovered'' 
     * when a new square with no mine in its neighborood has been selected
     * @param initialDot
     *      the DotInfo object corresponding to the selected DotButton that
     * had zero neighbouring mines
     */
    private void clearZone(DotInfo initialDot) {
		int top = 0, x=-1 , y=-1;
		DotInfo d, n;
		GenericArrayStack e;
		d = new DotInfo(x,y);
		e =new GenericArrayStack(top);
		e.push(initialDot);
		while (!e.isEmpty() == true){
			d = (DotInfo)e.peek();
			e.pop();
			for (int i= (d.getX()-1) ; i<=(d.getX()+1) ; i++){
				for (int j=(d.getY()-1)  ; j<=(d.getY()+1) ; j++){
					gameModel.uncover(i,j);
					n = new DotInfo(i,j);
					if (!gameModel.isMined(i,j) == true ){
						e.push(n);
					}
				}
			}		
		}

    }



}
