package 链表;

public class ReverseList {

	
	public static class Node{
		
		public int value;
		public Node next;
		
		public Node(int value) {
			this.value=value;
		}
	}
	
	public static Node reverseLinkedList(Node head) {
		Node pre=null;
		Node next=null;
		
		while(head!=null) {
			next=head.next;
			head.next=pre;
			pre=head;
			head=next;
		}
		
		return pre;
		
	}
	
	
	   public static Node reverseBetween(Node head, int left, int right) {

	        if(head==null) return head;

	        Node dummyHead=new Node(0);

	        dummyHead.next=head;
	        Node pre=dummyHead;
	        Node cur=dummyHead.next;

	        for(int i=0;i<left-1;i++){
	            pre=pre.next;
	            cur=cur.next;
	        }

	        for(int i=0;i<right-left;i++){
	            Node temp=cur.next;

	            cur.next=cur.next.next;
	            // 头插法每次都必须把元素插到一个固定的元素后面，对本题而言，cur是在循环中要不断改变的，pre才是我们一开始就确定的固定不变的点，pre后面的元素就是需要倒置的，所以每次插入必须要插在pre后面
	            temp.next=pre.next;
	            pre.next=temp;
	        }

	        return dummyHead.next;

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
       
    	
    	Node head=new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        
        
        
     
        
        System.out.println("Original Linked List:");
        printLinkedList(head);

        // Reverse the linked list
        head = reverseLinkedList(head);

        System.out.println("Reversed Linked List:");
        printLinkedList(head);
        
        
        // Reverse the linked list
        head = reverseBetween(head,2,5);

        System.out.println("Reversed Linked List:");
        printLinkedList(head);
        
    }
	
	
}
