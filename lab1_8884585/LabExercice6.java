/*
Student name: Rayold RAKOTONOMENJANAHARY  
Student number: 8884585 
Course code: ITI1121
Lab section: A-2 

Question 6 Lab1: ce code permert de stocker 10 notes et de calculer la moyenne, la médiane, le nombre d'étudiants qui ont passé le cours
et le nombre d'étudiants qui l'ont raté
*/
import java.util.*;
import java.util.Scanner;
public class LabExercice6 {
	public static void main(String[] args) {
		
  	    double[] score;
		score = new double[10];
		
		Scanner keyb = new Scanner(System.in);
		for(int i= 0; i< score.length; i++){
			System.out.print("Enter score " + (i+1) + ":");
			score[i] = keyb.nextDouble();
			System.out.println("");
		}
		calculateAverage(score);
		calculateMedian(score);
		calculateNumberFailed(score);
		calculateNumberPassed(score);
	}
	
	public static void calculateAverage(double[] notes) {
	    double average = 0; 
		for(int i= 0; i< notes.length; i++){
			average += notes[i];
		}
		average = average/notes.length;
		System.out.println("the average is:" + average);
	}
	
	public static void calculateMedian(double[] notes) {
		Arrays.sort(notes);
		double median;
		if (notes.length % 2 == 0){
			median = ((double)notes[notes.length/2] + (double)notes[notes.length/2-1])/2;
		}
		else{
			median = (double)notes[notes.length/2];
		}
		System.out.println("the median is:" + median);
	}
	
	public static void calculateNumberFailed(double[] notes) {
		int failed = 0;
		for(int i= 0; i< notes.length; i++){
			if (notes[i] < 50.0){
				failed ++;
			}
		}
		if (failed == 0){
			System.out.println("No one failed the course");
		}
		else if(failed > 0){
			System.out.println("the number of students who failed the course is:" + failed);
		}
		
	}
	
	public static void calculateNumberPassed(double[] notes) {
	    int passed = 0;
		for(int i= 0; i< notes.length; i++){
			if (notes[i] >= 50.0){
				passed ++;
			}
		}
		if (passed == 0){
			System.out.println("No one passed the course");
		}
		else if(passed > 0){
			System.out.println("the number of students who passed the course is:" + passed);
		}
	}

}