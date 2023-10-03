package 链表;

import 链表.ReverseList.Node;

public class DeleteGivenValue {

	public static class Node{
		
		public int val;
		public Node next;
		
		public Node(int val) {
			this.val=val;
		}
	}
	
	
	public Node removeElements(Node head, int val) {


        Node dummyHead=new Node(0);
        dummyHead.next=head;
        Node pre=dummyHead;
        Node cur=dummyHead.next;


        while(cur!=null){
            if(cur.val==val){
                pre.next=cur.next;
            }else{
                pre=cur;
            }
            cur=cur.next;
        }
        return dummyHead.next;
    }
}
