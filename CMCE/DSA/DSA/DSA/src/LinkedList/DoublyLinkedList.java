package LinkedList;

//2. DOUBLY LINKED LIST


class DoublyLinkedList {
 private class Node {
     int data;
     Node prev;
     Node next;
     
     Node(int val) {
         data = val;
         prev = null;
         next = null;
     }
 }
 
 private Node head;
 
 public DoublyLinkedList() {
     head = null;
 }
 
 // Add First - O(1)
 public void addFirst(int val) {
     Node newNode = new Node(val);
     if (head == null) {
         head = newNode;
     } else {
         newNode.next = head;
         head.prev = newNode;
         head = newNode;
     }
     System.out.println("Added " + val + " at beginning");
 }
 
 // Add Last - O(n)
 public void addLast(int val) {
     Node newNode = new Node(val);
     if (head == null) {
         head = newNode;
     } else {
         Node trav = head;
         while (trav.next != null) {
             trav = trav.next;
         }
         trav.next = newNode;
         newNode.prev = trav;
     }
     System.out.println("Added " + val + " at end");
 }
 
 // Delete First - O(1)
 public void deleteFirst() {
     if (head == null) {
         System.out.println("List is empty");
         return;
     }
     Node temp = head;
     head = head.next;
     if (head != null) {
         head.prev = null;
     }
     System.out.println("Deleted first node with value: " + temp.data);
 }
 
 // Delete at Position - O(n)
 public void deleteAtPos(int pos) {
     if (head == null || pos == 1) {
         deleteFirst();
         return;
     }
     
     Node trav = head;
     for (int i = 1; i < pos; i++) {
         if (trav == null) {
             System.out.println("Position out of bounds");
             return;
         }
         trav = trav.next;
     }
     
     if (trav == null) {
         System.out.println("Position out of bounds");
         return;
     }
     
     // Remove trav node
     if (trav.prev != null) {
         trav.prev.next = trav.next;
     }
     if (trav.next != null) {
         trav.next.prev = trav.prev;
     }
     System.out.println("Deleted node at position " + pos + " with value: " + trav.data);
 }
 
 // Display forward
 public void display() {
     if (head == null) {
         System.out.println("List is empty");
         return;
     }
     System.out.print("Doubly Linked List (forward): ");
     Node trav = head;
     while (trav != null) {
         System.out.print(trav.data + " <-> ");
         trav = trav.next;
     }
     System.out.println("null");
 }
 
 // Display backward
 public void displayReverse() {
     if (head == null) {
         System.out.println("List is empty");
         return;
     }
     Node trav = head;
     while (trav.next != null) {
         trav = trav.next;
     }
     System.out.print("Doubly Linked List (backward): ");
     while (trav != null) {
         System.out.print(trav.data + " <-> ");
         trav = trav.prev;
     }
     System.out.println("null");
 }
 
 public static void main(String[] args) {
     System.out.println("\n===== DOUBLY LINKED LIST DEMO =====");
     DoublyLinkedList dlist = new DoublyLinkedList();
     
     dlist.addFirst(30);
     dlist.addFirst(20);
     dlist.addFirst(10);
     dlist.display();
     
     dlist.addLast(40);
     dlist.addLast(50);
     dlist.display();
     
     dlist.displayReverse();
     
     dlist.deleteFirst();
     dlist.display();
     
     dlist.deleteAtPos(2);
     dlist.display();
 }
}