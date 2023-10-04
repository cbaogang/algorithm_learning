package 链表;

import 链表.SortList.ListNode;

public class DeleteDuplicates {

	
	// 删除排序链表中的重复元素 II
	 public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	 
	 
	 public ListNode deleteDuplicates(ListNode head) {

	       ListNode dummy=new ListNode(-100);
	       dummy.next=head;
	       ListNode pre=dummy;
	       ListNode cur=dummy.next;
	   

	        while(cur!=null&&cur.next!=null){

	            if(cur.val==cur.next.val){
	            int val=cur.val;
	            while(cur!=null&&cur.val==val){
	                cur=cur.next;
	            }
	            pre.next=cur;
	            }else{
	                pre=cur;
	                cur=cur.next;
	            }
	        
	        }
	        return dummy.next;
	    }
}
