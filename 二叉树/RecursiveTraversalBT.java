package 二叉树;

public class RecursiveTraversalBT {

	public static class TreeNode{
		int val;
		TreeNode left,right;
		
		TreeNode(){}
		
		TreeNode(int val){
			this.val=val;
		}
		
		TreeNode(int val,TreeNode left,TreeNode right){
			this.val=val;
			this.left=left;
			this.right=right;
		}
	}
	
	
	public static void pre(TreeNode head) {
		if(head==null) {
			return; 
		}
		
		print(head.val);
		pre(head.left);
		pre(head.right);
	}
	
	
	public static void in(TreeNode head) {
		
		if(head==null) {
			return;
		}
		
		in(head.left);
		print(head.val);
		in(head.right);
		
	}
	
	public static void pos(TreeNode head) {
		if(head==null) {
			return;
		}
		pos(head.left);
		pos(head.right);
		print(head.val);
		
	}
	
	public static void print(int val) {
		System.out.println(val);
	}
	
	
	
	
	
	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.left = new TreeNode(4);
		head.left.right = new TreeNode(5);
		head.right.left = new TreeNode(6);
		head.right.right = new TreeNode(7);

		pre(head);
		System.out.println("========");
		in(head);
		System.out.println("========");
		pos(head);
		System.out.println("========");

	}
	
	
	
	
}
