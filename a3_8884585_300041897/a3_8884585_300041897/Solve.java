/**
 *cette classe represente les methode pour solver le jeu
 *@author Rayold Rakotonomenjanahary
 *@author Sydroy Rakotonomenjanahary
 * 
 */
public class Solve{
  private static Cube a= new Cube(new Color[]{Color.BLUE, Color.GREEN, Color.WHITE, Color.GREEN, Color.BLUE, Color.RED});
  private static Cube b= new Cube(new Color[]{Color.WHITE, Color.GREEN, Color.BLUE, Color.WHITE, Color.RED, Color.RED});
  private static Cube c= new Cube(new Color[]{Color.GREEN, Color.WHITE, Color.RED, Color.BLUE, Color.RED, Color.RED});
  private static Cube d= new Cube(new Color[]{Color.BLUE, Color.RED, Color.GREEN, Color.GREEN, Color.WHITE, Color.WHITE});
  
 
 /**
 *Methode generateAndTest
 *@return une file contenant toutes les solutions possibles
 */
 public static Queue <Solution> generateAndTest(){
 LinkedQueue<Solution> validSolutionsQueue = new LinkedQueue<Solution>();
    
    Cube[] cubeTower = new Cube[]{a, b, c, d};
    Solution solution = new Solution(cubeTower);
    solution.resetNumberOfCalls();
    
   
    for (int i = 0; i < 24; i++) {
      
      cubeTower[0].next();
      
      for (int j = 0; j < 24; j++) {
        
        cubeTower[1].next();
        
        if (j == 23) {
          cubeTower[1].reset();
        }
        
        for (int k = 0; k < 24; k++) {
          
          cubeTower[2].next();
          
          if (k == 23) {
            
            cubeTower[2].reset();
          }
          
          for (int l = 0; l < 24; l++) {
            
            cubeTower[3].next();
            
            if (solution.isValid() == true) {
              validSolutionsQueue.enqueue(solution);
            }
            if (l == 23) {
              cubeTower[3].reset();
            } 
            
          }
          
        }
        
      }
        
    }
    
    
    
       
    System.out.println("Number of calls of method isValid() : "+solution.getNumberOfCalls()+"");
    return validSolutionsQueue; 
    
  }
 /**
 *Methode generateAndTest
 *@return une file contenant toutes les solutions valides
 */
 public static Queue<Solution> breadthFirstSearch (){
   return null;
 }
 
 /**
 *Main method pour exécuter le jeu
 */
 public static void main(String[] args){
  long start, stop;
  
  System.out.println("generateAndTest:");
  start = System.currentTimeMillis();
  generateAndTest();
  
  stop = System.currentTimeMillis();
  System.out.println("Elapsed time: " + (stop - start) + " milliseconds");
  
  System.out.println("breadthFirstSearch: ");
  start = System.currentTimeMillis();
  
  breadthFirstSearch();
  
  stop = System.currentTimeMillis();
  System.out.println("Elapsed time: "+(stop - start) + " milliseconds");
  
 }

}