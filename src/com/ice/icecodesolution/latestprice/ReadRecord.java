package com.ice.icecodesolution.latestprice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadRecord {
	
	public void readFile(){
		/*
		 * Assumption file is csv file comma-separated
		 * Using FileInputStream per line would be loaded in Memory
		 * This Solution will iterate through all lines, this will allow
		 * Reading line and will not keep reference of it in Memory
		 * Tested this solution with 2 Million records. 
		 * File Size 300 MB
		 * 1. Attached is Heap Dump
		 * 2. Attached is Visual VM usage of memory, hence show program 
		 * is efficient
		 * Further we can run the program using Performance Tuning Parameter 
		 * to Manage the Memory according to file size and Host we are running
		 * like Eden Space, Survivor Space Ratio, Heap Min/Max, Type of Garbage
		 * Collector.
		 * It depends on requirement we can use Parellel or CMS Garbage Collector.
		 */
		FileInputStream inputStream = null;
		Scanner scan = null;
		String path = "C:/Users/spandya/workspace/LatestPrice.csv";
		try {
			inputStream = new FileInputStream(path);
			scan = new Scanner(inputStream, "UTF-8");
			while(scan.hasNext()){
				String line = scan.nextLine();
				String firstWord = line.split(",")[0];
				String latestPrice = line.substring(line.lastIndexOf(",")+1);
				System.out.println(firstWord+":"+latestPrice);
			}
			if(scan.ioException() != null){
				try {
					throw scan.ioException();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(scan != null){
				scan.close();
			}
		}
	}

}
