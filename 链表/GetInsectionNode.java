package 链表;

/**
 * 160. 相交链表
 * @author kylec
 *
 */

public class GetInsectionNode {

	
	
	
	 public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        if(headA==null||headB==null){
	            return null;
	        }

	        ListNode p1=headA,p2=headB;

	        while(p1!=p2){
	            p1=p1==null?headB:p1.next;
	            p2=p2==null?headA:p2.next;
	        }

	        return p1;
	    }
}
