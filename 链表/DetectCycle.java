package 链表;


/**142. 环形链表 II
 * https://leetcode.cn/problems/linked-list-cycle-ii/description/
 * @param val
 * @param next
 */

public class DetectCycle {
	
	
	 public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	 
	
	public static ListNode detectCycle(ListNode head) {
		
		
		ListNode fast=head,slow=head;
		while(true) {
			if(fast==null||fast.next==null) {
				return null;
			}
			fast=fast.next.next;
			slow=slow.next;
			
			if(fast==slow) {
				break;
			}
		}
		
		fast=head;
		
		while(fast!=slow) {
			fast=fast.next;
			slow=slow.next;
		}
		
		return slow;
		
	}

}
