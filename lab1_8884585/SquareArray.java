/*
Student name: Rayold RAKOTONOMENJANAHARY  
Student number: 8884585 
Course code: ITI1121
Lab section: A-2 

Question 3.1 Lab1:Ce programme crée un tableau où chaque élément contiendra la valeur du carré de 
son index de 0 jusqu’au nombre fourni en paramètre et retourner ce tableau. 
Cette méthode doit être appelée à partir de la méthode main afin de 
recevoir les carrés de 0 à 12 et d'en imprimer les valeurs. 
*/
public class SquareArray{
	public static void main(String[] args){
		int[] array = createArray(13);
		for (int i = 0; i < array.length;i++){
			System.out.println("The square of " + i + " is: " + array[i]);		
		}
	}
	public static int[] createArray(int size){
		int [] array;
		array = new int [size];
		for (int i = 0; i < array.length;i++){
			array[i] = i*i;
		}
		return array;
	}		
}