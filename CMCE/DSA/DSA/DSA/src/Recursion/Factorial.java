package Recursion;

// 1. FACTORIAL USING RECURSION
//Time Complexity: O(n)

class Factorial {
 // Iterative approach - O(n)
 public static int factorialIterative(int num) {
     int result = 1;
     for (int i = 1; i <= num; i++) {
         result = result * i;
     }
     return result;
 }
 
 // Recursive approach - O(n)
 public static int factorialRecursive(int num) {
     if (num <= 1) return 1;
     return num * factorialRecursive(num - 1);
 }
 
 public static void main(String[] args) {
     System.out.println("\n===== FACTORIAL DEMO =====");
     int num = 5;
     
     System.out.println("Factorial of " + num + " (iterative): " + factorialIterative(num));
     System.out.println("Factorial of " + num + " (recursive): " + factorialRecursive(num));
     
     num = 7;
     System.out.println("Factorial of " + num + " (iterative): " + factorialIterative(num));
     System.out.println("Factorial of " + num + " (recursive): " + factorialRecursive(num));
 }
}