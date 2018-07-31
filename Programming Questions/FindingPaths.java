import java.util.*;
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) {
      val = x;
      left=null;
      right=null;
     }
 }
public class RootToLeafSum{
	

	RootToLeafSum(){

	}
	static TreeNode root;
	ArrayList<ArrayList<Integer>> vinay= new ArrayList<ArrayList<Integer>>();

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
		Integer path[] = new Integer[1000];
		getpath(A,path,0,B);
		return vinay;
	}


	void getpath(TreeNode node, Integer[] al,int count, int desiredvalue){

		if(node==null)
			return;
		al[count]=node.val;
		count++;
		if(node.left==null && node.right==null){
			printlist(al,count, desiredvalue);
		}
		else{
			getpath(node.left,al,count,desiredvalue);
			getpath(node.right,al,count,desiredvalue);
		}
	}
	void printlist(Integer[] al, int n,int desiredvalue){
		int sum=0;
		ArrayList<Integer> boss= new ArrayList<Integer>();
		Integer[] als= new Integer[n];

		for (int i=0;i<n ;i++ ) {

			sum+=al[i];
		}
		if(sum==desiredvalue)
		{
			for(int i=0;i<als.length;i++){
				boss.add(al[i]);
			}
			vinay.add(boss);
		}
	}
	void insert(TreeNode root,int val){
		Queue<TreeNode> q= new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty()){
			TreeNode temp=q.peek();
			q.remove();

			if(temp.left==null){
				temp.left= new TreeNode(val);
				break;
			}
			else
				q.add(temp.left);
			if(temp.right==null){
				temp.right=new TreeNode(val);
				break;
			}
			else
				q.add(temp.right);
		}
	}
	void inorder(TreeNode root){
		if (root==null)
			return;
		inorder(root.left);
		System.out.println(root.val);
		inorder(root.right);
	}
	public static void main(String[] args) {
		RootToLeafSum tree= new RootToLeafSum();
		root= new TreeNode(5);
		// tree.insert(5);
        tree.insert(root,4);
        tree.insert(root,6);
        tree.insert(root,3);
        tree.insert(root,7);
        tree.insert(root,2);
        tree.insert(root,9);
        tree.insert(root,1);
        tree.insert(root,8);
        tree.insert(root,10);
		// tree.inorder(root);
		System.out.println(tree.pathSum(root,20));
	}
}