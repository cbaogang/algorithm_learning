package 二叉树;

/**
 * 104. 二叉树的最大深度
 * @author kylec
 *
 */

public class MaxDepth {

	static int depth=0;
    static int res=0;
  
    
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

    public static int maxDepth(TreeNode root) {

        if(root==null){
            return 0;
        }

        travese(root);
        return res;
    }


    public static void travese(TreeNode root){
        if(root==null){
            return;
        }

        depth++;
        if(root.left==null&&root.right==null){
            res=Math.max(res,depth);
        }

        travese(root.left);
        travese(root.right);
        depth--;
    }
    
    public static int maxDepth2(TreeNode root) {
    	if(root==null) {
    		return 0;
    	}
    	
    	int maxLeft=maxDepth2(root.left);
    	int maxRight=maxDepth2(root.right);
    	
    	int res2=Math.max(maxLeft, maxRight)+1;
    	return res2;
    }
    
    public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.left = new TreeNode(4);
		head.left.right = new TreeNode(5);
		head.right.left = new TreeNode(6);
		head.right.right = new TreeNode(7);

		//maxDepth(head);
		System.out.println(maxDepth(head));
		System.out.println(maxDepth2(head));

	}
	
}
