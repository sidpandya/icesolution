package com.ice.icecodesolution.Anagram;

import java.util.Scanner;

public class AnagramProgram {
	/*
	 * User can provide input it will output the anagram words.
	 */
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a Block of Text: ");
		String anagramStr = reader.nextLine();
		int len = anagramStr.length();
		AnagramProgram anagram = new AnagramProgram();
		anagram.permutation(anagramStr, 0, len-1);
	}
	
	private void permutation(String anagramStr, int startIndex, int endIndex){
		if(startIndex == endIndex){
			System.out.println(anagramStr);
		}			
		else{
			for(int i = startIndex; i <= endIndex; i++){
				anagramStr = swapping(anagramStr, startIndex, i);
				permutation(anagramStr, startIndex+1, endIndex);
				anagramStr = swapping(anagramStr, startIndex, i);
			}
		}
	}
	
	public String swapping(String str, int j, int k){
		char stage;
		char[] charArr = str.toCharArray();
		stage = charArr[j];
		charArr[j] = charArr[k];
		charArr[k] = stage;
		return String.valueOf(charArr);
	}
}
