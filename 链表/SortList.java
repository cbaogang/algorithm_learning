package 链表;

import 链表.IsPalindromeList.ListNode;


/**
 * 21. 合并两个有序链表
 * 148. 排序链表
 * @author kylec
 *
 */

public class SortList {

	
	 public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	
	
	 public static ListNode sortListRecursive(ListNode head) {
		 if(head==null||head.next==null) {
			 return head;
		 }
		 	
		 return sortList(head);
	 }
	 
	 public static ListNode sortListNoRecursive(ListNode head) {
		 if(head==null||head.next==null) {
			 return head;
		 }
		 	
		 int length=getLength(head);
		 ListNode dummyHead=new ListNode(0);
		 dummyHead.next=head;
		 
		 
		 int mergeSize=1;
		 
		 while(mergeSize<length) {
			 ListNode pre=dummyHead;
			 
			 ListNode cur=dummyHead.next;
			 
			 while(cur!=null) {
				 
				 ListNode h1=cur;
				 ListNode h2=split(h1,mergeSize);
				 cur=split(h2,mergeSize);
				 
				 ListNode temp=merge(h1,h2);
				 pre.next=temp;
				 
				 while(pre.next!=null) {
					 pre=pre.next;
				 } 
			 }
			  
			 
			 mergeSize*=2;
			 
		 }
		 
		 return dummyHead.next;
		 
	 }
	 
	 
	 public static ListNode sortList(ListNode head) {
		 if(head==null||head.next==null) {
			 return head;
		 }	 
		
		 ListNode midNode=middleNode(head);
		 ListNode rightHead=midNode.next;
		 midNode.next=null;
		 
		 ListNode left=sortList(head);
		 ListNode right=sortList(rightHead);
		 return merge(left,right);
		 
	 }
	 
	 
	 public static ListNode split(ListNode head,int step) {
		 if(head==null) {
			 return null;
		 }
		 
		 ListNode cur=head;
		 
		 for(int i=1;i<step&&cur.next!=null;i++) {
			 cur=cur.next;
		 }
		 
		 ListNode right=cur.next;
		 cur.next=null;
		 return right;
		 
		 
	 }
	 
	 public static ListNode middleNode(ListNode head) {
		 if(head==null||head.next==null|head.next.next==null) {
			 return head;
		 }
		 
		 ListNode fast=head;
		 ListNode slow=head;
		 
		 while(fast.next!=null&&fast.next.next!=null) {
			 slow=slow.next;
			 fast=fast.next;
		 }
		 
		 return slow;
		 
		 
	 }
	 
	 
	 public static ListNode copyList(ListNode head) {
		 if(head==null) {
			 return null;
			 
		 }
		 
		 ListNode cur=head;
		 ListNode next=null;
		 
		 while(cur!=null) {
			 next=cur.next;
			 cur.next=new ListNode(cur.val);
			 cur.next.next=next;
			 cur=next;
		 }
		  	 
		 cur=head;
		 ListNode copy=null;
		 while(cur!=null) {
			 next=cur.next.next;
			 copy=cur.next;
			 cur.next=next;
			 copy.next=next!=null?next.next:null;
			 cur=next;
		 }
		 
		 return head;
		 
	 }
	 
	 
	 public static ListNode merge(ListNode left, ListNode right) {
		
		ListNode head=new ListNode(-1);
		ListNode res=head;
		
		while(left!=null&&right!=null) {
			if(left.val<right.val) {
				res.next=left;
				left=left.next;
			}else {
				res.next=right;
				right=right.next;
			}
			
			res=res.next;
		}
		if(left!=null) {
			res.next=left;
			
		}
		
		if(right!=null) {
			res.next=right;
		
		}
		
		return head.next;
		
	}
	 
	 
		public static void printLinkedList(ListNode node) {
	        while (node != null) {
	            System.out.print(node.val + " ");
	            node = node.next;
	        }
	        System.out.println();
	    }
		
		
		public static int getLength(ListNode head) {
			int length=0;
			
			while(head!=null) {
				length++;
				head=head.next;
			}
			
			return length;
		}
	 
		public static void main(String[] args) {
			ListNode test = null;
			test = new ListNode(5);
			test.next = new ListNode(3);
			test.next.next = new ListNode(1);
			test.next.next.next = new ListNode(7);
			test.next.next.next.next = new ListNode(4);
			test.next.next.next.next.next = new ListNode(5);
			test.next.next.next.next.next.next = new ListNode(0);
			test.next.next.next.next.next.next.next = new ListNode(6);
			//test.next.next.next.next.next.next.next.next = new Node(8);

			ListNode copy=copyList(test);
			
			System.out.println("复制链表:");
			
			printLinkedList(copy);
			
			
			
			ListNode ans = sortListRecursive(test);

		    System.out.println("链表排序用递归方法:");
		    printLinkedList(ans);
		    
		    ListNode ans2 = sortListNoRecursive(copy);

		    System.out.println("链表排序用非递归方法:");
		    printLinkedList(ans2);
		    
		}
}
