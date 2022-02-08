/*
Student name: Rayold RAKOTONOMENJANAHARY  
Student number: 8884585 
Course code: ITI1121
Lab section: A-2 

Question 3.2 Lab1: Ce code calcule la moyenne des 10 nombres fournis dans un tableau 
*/  
public class AverageDemo{
	public static void main(String[] args){
		double [] valuesArray;
		valuesArray = new double []{100.0,34.0,72.0,56.0,82.0,67.0,94.0};
		System.out.println("The average is: " + calculateAverage(valuesArray));
	}
	public static double calculateAverage(double[] values){
		double result = 0.0;
		for(int i = 0; i < values.length;i++){
			result += values[i];
		}
		result = result/values.length;
		return result; 
	}
}