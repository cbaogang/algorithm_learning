package 链表;

import 链表.DeleteGivenValue.Node;

public class LinkedListMid {

	
	public static class Node{
		
		public int val;
		public Node next;
		
		public Node(int val) {
			this.val=val;
		}
	}
	
	
	// 偶数返回第二个中点
	
	 public static Node middleOrDownNode(Node head) {

	        if(head==null||head.next==null){
	            return head;
	        }

	        Node slow=head;
	        Node fast=head;


	        while(fast!=null && fast.next!=null){
	            slow=slow.next;
	            fast=fast.next.next;
	        }

	        return slow;

	    }
	 
	 
	// 偶数返回第一个中点
	 public static Node middleOrUpNode(Node head) {
		 if(head==null||head.next==null||head.next.next==null) {
			 return head;
		 }
		 Node slow=head;
		 Node fast=head;
		 
		 while(fast.next!=null&&fast.next.next!=null) {
			 slow=slow.next;
			 fast=fast.next.next;
		 }
		 
		 return slow;
	 }
	 
	 
		public static void printLinkedList(Node node) {
	        while (node != null) {
	            System.out.print(node.val + " ");
	            node = node.next;
	        }
	        System.out.println();
	    }
	 
		public static void main(String[] args) {
			Node test = null;
			test = new Node(0);
			test.next = new Node(1);
			test.next.next = new Node(2);
			test.next.next.next = new Node(3);
			test.next.next.next.next = new Node(4);
			test.next.next.next.next.next = new Node(5);
			test.next.next.next.next.next.next = new Node(6);
			test.next.next.next.next.next.next.next = new Node(7);
			//test.next.next.next.next.next.next.next.next = new Node(8);

			Node ans = middleOrUpNode(test);

		    System.out.println("偶数返回第一个中点:");
		    printLinkedList(ans);
		    
			Node ans2 = middleOrDownNode(test);

		    System.out.println("偶数返回第二个中点:");
		    printLinkedList(ans2);

		}

	
}
