/**
*
*Une Solution est une structure de données afin de sauvegarder des cubes. C’est une solution partielle au probleme «instant
insanity». C’est une représentation pour une tour de n cubes, où n 2 [1, 2, 3, 4].
*@author Rayold Rakotonomenjanahary
*@author Sydroy Rakotonomenjanahary
*
*/
public class Solution{
 private Cube[] initCube;//pour sauvegarder la valeur initial des cubes
 private Cube[] cube;//cube utiliser dans les tests
 private int countValid;//pour compter le nombre d'appel à la méthode isValid()
 
 /**
 *Constructor
 *@param cubes 
 *    un tableau contenant des cubes
 */
 public Solution(Cube[] cubes){
  
  initCube = new Cube[cubes.length];
  cube = new Cube[initCube.length];
  
  for(int i=0; i< cubes.length; i++){
   initCube[i] = cubes[i].copy();
  } 
  
  for(int i=0; i< cube.length; i++){
   this.cube[i] = initCube[i].copy();
  } 
  
  countValid =0;
 }
 
 
 /**
 *Constructor
 *
 *@param other
 *@param c
 *
 */
 public Solution(Solution other, Cube c){
  if (c == null){
   throw new NullPointerException("the parameter Cube point a null value");
  }
  
  initCube = new Cube[other.cube.length+1];
  cube = new Cube[initCube.length];
  
  for(int i=0; i< other.cube.length; i++){
   initCube[i] = other.cube[i].copy();
  } 
  
  initCube[other.cube.length]= c; 
  
  for(int i=0; i< cube.length; i++){
   this.cube[i] = initCube[i].copy();
  } 
  
  countValid =0;
 }
 
 /**
 *Getter method for the number of the cube in the solution 
 *@return the size of the solution
 */
 public int size(){
  return cube.length;
 }
 
 /**
 *Getter method a cube in solution
 *@param pos
 *@return the cube at the position pos in the solution
 */
 public Cube getCube(int pos){
  return cube[pos];
 }
 
 /**
 *method that check if a solution is valid or not
 *@return boolean true if isValid, otherwise false 
 */
 public boolean isValid(){
  for(int i=0; i<cube.length; i++){
   for(int j=0; j<cube.length; j++){
    if(i != j){
     if(cube[i].getFront() == cube[j].getFront()){//check if the front of the tower is valid 
      System.out.println(1);
      return false;
     }
     
     if(cube[i].getBack() == cube[j].getBack()){//check if the back of the tower is valid
      System.out.println(2);
      return false;
     }
     if(cube[i].getLeft() == cube[j].getLeft()){//check if the left side of the tower is valid
      System.out.println(1);
      return false;
     }
     if(cube[i].getRight() == cube[j].getRight()){//check if the right side of the tower is valid
      System.out.println(1);
      return false;
     }
    }
   }
  }
  countValid ++;
  System.out.println(countValid);
  return true;
  
  
 }
 /**
 *method that check if a solution is valid or not
 *@param next
 *@return boolean true if isValid, otherwise false 
 */
 public boolean isValid(Cube next){
  System.out.println(next);
  for(int i=0; i<cube.length; i++){
   for(int j=0; j<cube.length; j++){
    if(i != j){
     if( (cube[i].getFront() == cube[j].getFront()) || (cube[i].getFront() == next.getFront())){//check if the front of the tower is valid 
      return false;
     }
     if(cube[i].getBack() == cube[j].getBack() || cube[i].getBack() == next.getBack()){//check if the back of the tower is valid
      return false;
     }
     if(cube[i].getLeft() == cube[j].getLeft() || cube[i].getLeft() == next.getLeft()){//check if the left side of the tower is valid
      return false;
     }
     if(cube[i].getRight() == cube[j].getRight() || cube[i].getRight() == next.getRight()){//check if the right side of the tower is valid
      return false;
     }
    }
   }
  }
  return true;
 }
  /**
     * Builds a String representation of the solution
     *
     * @return String representation of the solution
     */
 public String toString(){
  String str = "";
  for (int i=0; i<cube.length; i++){
   str += cube[i] + "\n";
  }
  
  return str;
 }
 
 /**
 *
 *Getter to the Number of calls of isValid() 
 *@return countValid
 */
 public int getNumberOfCalls(){
  return countValid;
 } 
 
 /**
 *Setter of countValid
 */
 public void resetNumberOfCalls(){
  countValid = 0;
 }
 
}