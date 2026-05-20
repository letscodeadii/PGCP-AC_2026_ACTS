package com.Program;

public class NegativeElement {

	private static void display(int[] newArr) {
		for (int i : newArr) {
			System.out.println(i);
		}

	}
	private static void rearrange(int[] arr, int[] newArr) {

		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				newArr[j] = arr[i];
				j++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				newArr[j] = arr[i];
				j++;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { -1, -20, 30, 40, 50, -8 };
		int[] newArr = new int[arr.length];
		rearrange(arr, newArr);
		display(newArr);

	}
}
