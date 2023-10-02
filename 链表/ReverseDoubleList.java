package 链表;

import 链表.ReverseList.Node;

public class ReverseDoubleList {

	public static class DoubleNode{
		public DoubleNode next;
		public DoubleNode last;
		public int value;
		
		public DoubleNode(int value) {
			this.value=value;
			
		}
		
	}
	
	
	public static DoubleNode reverseDoubleLinkedList(DoubleNode head) {
		
		DoubleNode next=null;
		DoubleNode pre=null;
		
		while(head!=null) {
			next=head.next;
			head.next=pre;
			head.last=next;
			pre=head;
			head=next;
			
		}
		return pre;
	}
	
	
	 public static DoubleNode reverseList(DoubleNode head) {

	      if(head==null||head.next==null){
	          return head;
	      }

	      DoubleNode last=reverseList(head.next);
	      head.next.next=head;
	      head.next.last=head.next.next;
	     
	      head.last=head.next;
	      head.next=null;
	      return last;

	    }
	
	
	public static void printLinkedList(DoubleNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a sample linked list
        DoubleNode head = new DoubleNode(1);
        head.next = new DoubleNode(2);
        head.last=null;
        head.next.next = new DoubleNode(3);
        head.next.last=head;
        head.next.next.next = new DoubleNode(4);
        head.next.next.last=head.last;

        System.out.println("Original Linked List:");
        printLinkedList(head);

        // Reverse the linked list
        head = reverseList(head);

        System.out.println("Reversed Linked List:");
        printLinkedList(head);
    }
	
	
	
}
