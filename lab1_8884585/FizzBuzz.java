/*
Student name: Rayold RAKOTONOMENJANAHARY  
Student number: 8884585 
Course code: ITI1121
Lab section: A-2 

Question 2 Lab1: Ce programme parcours les nombres 1 a 30,
 si le nombre est divisible par 3 imprimer le numéro plus « Fizz »,
 si divisible par 5 imprimer le numéro plus « Buzz », 
 si le nombre est divisible par 15 imprimez le numéro plus « FizzBuzz »
*/  

public class FizzBuzz{
	public static void main(String[] args){
		for(int i = 1; i <= 30; i++){
			if (i%15 == 0){
				System.out.println(i+" FizzBuzz");
			} else if(i%5 == 0){
				System.out.println(i+" Buzz");
			} else if(i%3 == 0){
				System.out.println(i+" Fizz");
			}
		}
		int i = 1;
		while(i <= 30){
			if (i%15 == 0){
				System.out.println(i+" FizzBuzz");
			} else if(i%5 == 0){
				System.out.println(i+" Buzz");
			} else if(i%3 == 0){
				System.out.println(i+" Fizz");
			}
			i++;
		}
	}
	
}