package com.Program;

import java.util.Scanner;

public class SortNames {

	public static void main(String[] args) {
		

		int num;
		String temp;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the numbers of names you want to store ");
		num=sc.nextInt();
		
		String names[]=new String[num];
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter all the the names you want to store ");
		for(int i=0;i<num;i++) {
			names[i]=sc.nextLine();
		}
		//compare i and i+1 element 
		for(int i=0;i<num;i++) {
			for(int j=i+1;j<num;j++) {
				if(names[i].compareTo(names[j])>0) {
					temp=names[i];
					names[i]=names[j];
					names[j]=temp;
				}
			}
		}
		for(String name:names) {
			System.out.println("Sorted Array : ");
			System.out.println(name);
		}
		// TODO Auto-generated method stub

	}

}
