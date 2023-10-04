package 链表;

import java.util.Stack;

public class IsPalindromeList {

	
	 public class ListNode {
		      int val;
		      ListNode next;
		     ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	 
	  public boolean isPalindrome(ListNode head) {

	        if(head==null){
	            return true;
	        }

	        ListNode firstHalfEnd=endOfFirstHalf(head);
	        ListNode secondHalfStart=reverseList(firstHalfEnd.next);

	        ListNode p1=head;
	        ListNode p2=secondHalfStart;
	        boolean result = true;
	        while(result&&p2!=null){
	            if(p1.val!=p2.val){
	                result=false;
	                break;
	            }

	            p1=p1.next;
	            p2=p2.next;
	        }

	        firstHalfEnd.next=reverseList(secondHalfStart);
	        return result;

	    }



	    public ListNode endOfFirstHalf(ListNode head){
	        if(head==null||head.next==null||head.next.next==null){
	            return head;
	        }

	        ListNode fast=head;
	        ListNode slow=head;

	        while(fast.next!=null&&fast.next.next!=null){
	            fast=fast.next.next;
	            slow=slow.next;
	        }

	        return slow;

	    }

	    public ListNode reverseList(ListNode head){
	        ListNode pre=null;
	   

	        while(head!=null){
	            ListNode temp=head.next;
	            head.next=pre;
	            pre=head;
	            head=temp;
	        }

	        return pre;

	    }
	    
	    
	    public  boolean isPalindrome2(ListNode head) {
			Stack<ListNode> stack = new Stack<ListNode>();
			ListNode cur = head;
			while (cur != null) {
				stack.push(cur);
				cur = cur.next;
			}
			while (head != null) {
				if (head.val != stack.pop().val) {
					return false;
				}
				head = head.next;
			}
			return true;
		}
}
