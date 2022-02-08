/**
 *cette classe represente un cube
 *@author Rayold Rakotonomenjanahary
 *@author Sydroy Rakotonomenjanahary
 * 
 */
public class Cube{
 //creation des 6 faces.
 private Color up, front, right, back, left, down;
 private Color[] initFaces; 
 private int counter;
 
 /**
  * ce constructeur
  * initialise ce cube à l aide des couleurs specifiees dans le tableau.
  *  
  * @param faces Couleur de chaque face cube
  */
 public Cube(Color [] faces){
  initFaces = new Color[faces.length];
 
  for(int i=0;i<initFaces.length;i++){
   initFaces[i] = faces[i]; 
  }
  reset();
 }
 
 /**
  * ce constructeur 
  * cree un cube par la methode du copie en profondeur
  * 
  * @param other Le cube a copier
  */
 public Cube(Cube other){
  up = other.up;
  front = other.front;
  right = other.right;
  back  = other.back;
  left = other.left;
  down = other.down;
  
  initFaces = new Color[6];
  initFaces[0] = up;
  initFaces[1] = front;
  initFaces[2] = right;
  initFaces [3] = back;
  initFaces[4] = left;
  initFaces[5] = down;
  counter = 0;   
 }
 
 /**
  * c'est un getter utiliser pour recevoir la valeur 
  * de la variable up
  *
  * @return Color Cela retourne la couleur de la face haut du cube
  */
 public Color getUp(){
  return up;
  
  /**
  * c'est un getter utiliser pour recevoir la valeur 
  * de la variable front
  *
  * @return Color Cela retourne la couleur de la face a l avant du cube
  */
 }public Color getFront(){
  return front;
  
  /**
  * c'est un getter utiliser pour recevoir la valeur 
  * de la variable right
  *
  * @return Color Cela retourne la couleur de la face  droite du cube
  */
 }public Color getRight(){
  return right;
  
   /**
  * c'est un getter utiliser pour recevoir la valeur 
  * de la variable back
  *
  * @return Color Cela retourne la couleur de la face a l arriere du cube
  */
 }public Color getBack(){
  return back;
  
   /**
  * c'est un getter utiliser pour recevoir la valeur 
  * de la variable left
  *
  * @return Color Cela retourne la couleur de la face gauche du cube
  */
 }public Color getLeft(){
  return left;
  
   /**
  * c'est un getter utiliser pour recevoir la valeur 
  * de la variable down
  *
  * @return Color Cela retourne la couleur de la face au bas du cube
  */
 }public Color getDown(){
  return down;
 }
 
 /**
  * c'est une methode
  * qui retourne une chaîne de caractères représentant l’état de l’objet
  * 
  * @return String Cela retourne la liste de chaque face selon leur position 
  * sous format tableau
  */
 public String toString(){
  String str = "["+ up +","+ front+"," + right+","+ back+","+ left+","+ down+"]";
  return str;
 }
 
 /**
  *cette methode verifie si le prochain appel a la methode next sera un succes
  * 
  * @return boolean Retourne true ou false
  */
 public boolean hasNext(){
  if (counter<24){
   return true;
  }
  return false;
 }
 
 /**
  *cette methode permet de changer l orientation du cube a chaque appel
  * 
  * @throws IllegalStateException
  */
 public void next(){
  Color [] faces = new Color[6];
  faces[0]=up;
  faces[1]=front;
  faces[2]=right;
  faces[3]=back;
  faces[4]=left;
  faces[5]=down;
  
  //identity
  if(counter == 0){
   up = faces[0];
   front = faces[1];
   right = faces[2];
   back = faces [3];
   left = faces[4];
   down = faces[5];
  }
  
  //rigthRoll
  else if(counter==4 || counter==8 || counter == 20){
   up = faces[4];
   right = faces[0];
   down = faces[2];
   left = faces[5];
  }
  
  //leftRoll
  else if(counter==12 || counter==16){
   up = faces[2];
   right = faces[5];
   left = faces[0];
   down = faces[4];
  }
  
  //rotate
  else{
   front = faces[4];
   right = faces[1];
   back = faces[2];
   left = faces[3];
  }
  
  
  if (counter >= 24){
   throw new IllegalStateException("This orientation of the cube has been already visited");
  }
  counter ++;
  
 }
 
 /**
  * cette methode remet le cube dans sa position initiale
  * et a reinitialiser le compteur (counter) a 0
  *
  */
 public void reset(){
  up = initFaces[0];
  front = initFaces[1];
  right = initFaces[2];
  back = initFaces [3];
  left = initFaces[4];
  down = initFaces[5];
  counter = 0;
  
 } 
 
 /**
  * cette methode retourne une copie profonde d'un cube
  * 
  * @return Cube La copie du Cube 
  */
 public Cube copy(){
  
  Cube copyObject = new Cube(initFaces);
  return copyObject;
 }
 
}