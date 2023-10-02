package 链表;

import 链表.ReverseList.Node;

public class RecursionReverse {
	
	

	public static class Node{
		
		public int value;
		public Node next;
		
		public Node(int value) {
			this.value=value;
		}
	}
	
	
	
	
	 public static Node reverseList(Node head) {

	      if(head==null||head.next==null){
	          return head;
	      }

	      Node last=reverseList(head.next);
	      head.next.next=head;
	      head.next=null;
	      return last;

	    }
	 
	 
	
	 public static Node successor=null; 
	 public static Node reverseN(Node head,int n) {
		 if(n==1) {
			 successor=head.next;
			 return head; 
		 }
		 
		 Node last=reverseN(head.next,n-1);
		 head.next.next=head;
		 head.next=successor;
		 
		 return last;
	 }
	 
	 
	public static Node reverseBetween(Node head,int m,int n) {
		// base case
		if(m==1) {
			return reverseN(head,n);
		}
		
		head.next=reverseBetween(head.next,m-1,n-1);
		return head;
		
	}
	
	public static void printLinkedList(Node head) {
       while (head != null) {
           System.out.print(head.value + " ");
           head = head.next;
       }
       System.out.println();
   }

   public static void main(String[] args) {
       // Create a sample linked list
       Node head = new Node(1);
       head.next = new Node(2);
       head.next.next = new Node(3);
       head.next.next.next = new Node(4);
       head.next.next.next.next = new Node(5);

       System.out.println("Original Linked List:");
       printLinkedList(head);

       // Reverse the linked list
       head = reverseList(head);

       System.out.println("Reversed Linked List:");
       printLinkedList(head);
       
       head = reverseN(head,3);
       
       
       System.out.println("Reversed Linked List:");
       printLinkedList(head);
   }
	
	
	
}
