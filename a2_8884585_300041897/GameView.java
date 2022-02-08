import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * The class <b>GameView</b> provides the current view of the entire Game. It extends
 * <b>JFrame</b> and lays out a matrix of <b>DotButton</b> (the actual game) and 
 * two instances of JButton. The action listener for the buttons is the controller.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
  * @author Rayold Rakotonomenjanahary(rrako090@uottawa.ca)
 * @author Sydroy Rakotonomenjanahary(srako102@uottawa.ca)
 */

public class GameView extends JFrame {
	 private DotButton[][] board;
	 private GameModel gameModel;
	 private javax.swing.JLabel nbreOfStepsLabel;
	 

    /**
     * Constructor used for initializing the Frame
     * 
     * @param gameModel
     *            the model of the game (already initialized)
     * @param gameController
     *            the controller
     */

    public GameView(GameModel gameModel, GameController gameController) {
        
		this.gameModel = gameModel;
		board = new DotButton[gameModel.getHeigth()][gameModel.getWidth()];
		
		setTitle("Minesweeper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//creaion du panel pour les cases 
		JPanel myPanelDot = new JPanel();
		myPanelDot = new JPanel();
		myPanelDot.setBackground(Color.WHITE);
		myPanelDot.setLayout(new GridLayout(gameModel.getHeigth(),gameModel.getWidth()));
		add(myPanelDot);
		
		//creation du panel pour les bouton reset et quit
		JPanel myPanel = new JPanel();
		myPanel.setBackground(Color.WHITE);
		add(myPanel, BorderLayout.SOUTH);
		
		//creaion du nbreOfStepsLabel
		nbreOfStepsLabel = new JLabel("Number of steps: " + gameModel.getNumberOfSteps());
		myPanel.add(nbreOfStepsLabel);
		
		//bouton reset
		JButton resetButton = new JButton("Reset");
		resetButton.setBackground(Color.WHITE);
		myPanel.add(resetButton);
		resetButton.addActionListener(gameController);
		
		//bouton quit
		JButton quitButton = new JButton("Quit");
		quitButton.setBackground(Color.WHITE);
		myPanel.add(quitButton);
		quitButton.addActionListener(gameController);
		for (int i = 0; i< gameModel.getHeigth();i++){
			for (int j = 0; j<gameModel.getWidth();j++){
				board[i][j]= new DotButton(j,i,getIcon(i,j));
				board[i][j].setActionCommand(i+""+j);

				myPanelDot.add(board[i][j]);
			}
		}
		
		pack();
	
		setVisible(true);
		

    }

    /**
     * update the status of the board's DotButton instances based 
     * on the current game model, then redraws the view
     */

    public void update(){
		for (int i = 0; i< gameModel.getHeigth();i++){
			for (int j = 0; j<gameModel.getWidth();j++){
				board[i][j]= new DotButton(j,i,getIcon(i,j));
				board[i][j].setIconNumber(getIcon(i,j));
				nbreOfStepsLabel.setText("Number of steps: " + gameModel.getNumberOfSteps());
			}
		}
		
    }

    /**
     * returns the icon value that must be used for a given dot 
     * in the game
     * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the icon to use for the dot at location (i,j)
     */   
    private int getIcon(int i, int j){
        
    // ADD YOU CODE HERE
	//zero neighboring
	if(gameModel.isBlank(i,j)==true && gameModel.isCovered(i,j) == false){
		return board[i][j].ZERO_NEIGHBOURS;
	} 
	
	//one neighboring
	else if(gameModel.getNeighbooringMines(i,j)== 1 && gameModel.isMined(i,j) == false && gameModel.isCovered(i,j) == false){
		return board[i][j].ONE_NEIGHBOURS;
	}
	
	//two neighboring
	else if(gameModel.getNeighbooringMines(i,j)== 2 && gameModel.isMined(i,j) == false && gameModel.isCovered(i,j) == false){
		return board[i][j].TWO_NEIGHBOURS;
	}
	
	//three neighboring
	else if(gameModel.getNeighbooringMines(i,j)== 3 && gameModel.isMined(i,j) == false && gameModel.isCovered(i,j) == false){
		return  board[i][j].THREE_NEIGHBOURS;
	}
	
	//four
	else if(gameModel.getNeighbooringMines(i,j)== 4 && gameModel.isMined(i,j) == false && gameModel.isCovered(i,j) == false){
		return  board[i][j].FOUR_NEIGHBOURS;
	}
	
	//five neighboring
	else if(gameModel.getNeighbooringMines(i,j)== 5 && gameModel.isMined(i,j) == false && gameModel.isCovered(i,j) == false){
		return board[i][j].FIVE_NEIGHBOURS;
	}
	
	//six neighboring
	else if(gameModel.getNeighbooringMines(i,j)== 6 && gameModel.isMined(i,j) == false && gameModel.isCovered(i,j) == false){
		return  board[i][j].SIX_NEIGHBOURS;
	}
	
	//seven neighboring
	else if(gameModel.getNeighbooringMines(i,j)== 7 && gameModel.isMined(i,j) == false && gameModel.isCovered(i,j) == false){
		return  board[i][j].SEVEN_NEIGHBOURS;
	}
	
	//eight neighboring
	else if(gameModel.getNeighbooringMines(i,j)== 8 && gameModel.isMined(i,j) == false && gameModel.isCovered(i,j) == false){
		return  board[i][j].EIGHT_NEIGHBOURS;
	}
	
	//
	else if( gameModel.isMined(i,j) == true && gameModel.isCovered(i,j) == false){
		return  board[i][j].MINED;
	}
	else if(gameModel.hasBeenClicked(i,j)==true && gameModel.isMined(i,j) == true && gameModel.isCovered(i,j) == false){
		return  board[i][j].CLICKED_MINE;
	}
	else if(gameModel.isCovered(i,j) == true && gameModel.hasBeenClicked(i,j) == false){
		return  board[i][j].COVERED;
	}

	return  board[i][j].FLAGGED;

    }

}
