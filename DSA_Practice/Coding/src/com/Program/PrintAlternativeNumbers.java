package com.Program;

import java.util.Scanner;

public class PrintAlternativeNumbers {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of an array");
		int size=sc.nextInt();
		
		int[] arr=new int[size];
		
		
		System.out.println("Enter "+size+" element ");
		for(int i=0;i<size;i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int num:arr) {
			System.out.println(num);
		}
		
		System.out.println("Alternative number starting from index 0");
		for(int i=0;i<size;i+=2) {
			System.out.println(i);
		}
		System.out.println("Alternative number starting from index 1");
		for(int i=1;i<size;i+=2) {
			System.out.println(i);
		}

	}

}
