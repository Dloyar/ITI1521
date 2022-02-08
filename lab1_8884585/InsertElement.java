/*
Student name: Rayold RAKOTONOMENJANAHARY  
Student number: 8884585 
Course code: ITI1121
Lab section: A-2 

Question 3.3 Lab1:Créez une méthode qui permet d’ajouter un élément a une position spécifique d’un tableau. 
Cette méthode doit prendre trois paramètres : un tableau, une position et un nombre à insérer.
 Utilisez la méthode main pour imprimer le tableau avant et après l’insertion.
*/
public class InsertElement{
	public static void main(String[]args){
		int[] array; 
		array = new int[]{1,5,4,7,9,6};
		System.out.println("Array before insertion:");
		for (int i = 0; i < array.length;i++){
			System.out.println(array[i]);
		}
		int[] arrayNew;
		arrayNew = insertIntoArray(array, 3, 15);
		
		System.out.println("Array after insertion:");
		for (int i = 0; i < arrayNew.length;i++){
			System.out.println(arrayNew[i]);
		}
	}	
	public static int[] insertIntoArray(int[] beforeArray, int position, int value){
		
		int [] afterArray;
		
		afterArray = new int[beforeArray.length + 1 ];
		
		for(int i = 0; i < position; i++){
			afterArray[i]= beforeArray[i];
		}
		
		afterArray[position] = value;
	
		
		for(int i = position + 1; i <= beforeArray.length; i++){
			afterArray[i]= beforeArray[i-1];
		}
		return 	afterArray;
	}
}