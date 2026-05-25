package Sorting;

//5. MERGE SORT
//Time Complexity: O(n log n)


class MergeSort {
 public static void mergeSort(int[] arr, int left, int right) {
     if (left >= right) return;
     
     int mid = (left + right) / 2;
     
     // Sort left and right parts
     mergeSort(arr, left, mid);
     mergeSort(arr, mid + 1, right);
     
     // Merge two sorted partitions
     int cnt = right - left + 1;
     int[] temp = new int[cnt];
     
     int i = left, j = mid + 1, k = 0;
     
     while (i <= mid && j <= right) {
         if (arr[i] < arr[j]) {
             temp[k++] = arr[i++];
         } else {
             temp[k++] = arr[j++];
         }
     }
     
     while (i <= mid) temp[k++] = arr[i++];
     while (j <= right) temp[k++] = arr[j++];
     
     // Copy back to original array
     for (k = 0; k < cnt; k++) {
         arr[left + k] = temp[k];
     }
 }
 
 public static void main(String[] args) {
     System.out.println("\n===== MERGE SORT DEMO =====");
     int[] arr = {12, 11, 13, 5, 6, 7};
     System.out.print("Original array: ");
     for (int num : arr) System.out.print(num + " ");
     
     mergeSort(arr, 0, arr.length - 1);
     System.out.print("\nSorted array:   ");
     for (int num : arr) System.out.print(num + " ");
     System.out.println();
 }
}
