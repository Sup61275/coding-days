class Solution {
    //Looks like bfs cause we playing with levels
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return helperbfs(root,val,depth);
    }
    TreeNode helperbfs(TreeNode root, int val,int depth){
        if(depth==1){
            TreeNode newNode= new TreeNode(val);
            newNode.left=root;
            return newNode;
        }
        Queue<TreeNode>que= new LinkedList<>();
        que.offer(root);
        int level=1;
        while(!que.isEmpty()){
            int size=que.size();
          for(int i=0;i<size;i++){
            TreeNode curr=que.poll();
                if(level==depth-1){
                    TreeNode temp1=new TreeNode(val);
                    TreeNode temp2=new TreeNode(val);
                    TreeNode lefttempNodeHolder=curr.left;
                    TreeNode righttempNodeHolder=curr.right;
                    curr.left=temp1;
                    curr.left.left=lefttempNodeHolder;
                    curr.right=temp2;
                    curr.right.right=righttempNodeHolder;
                  

                }
                else{
                    if(curr.left!=null){
                        que.offer(curr.left);
                    }
                    if(curr.right!=null){
                        que.offer(curr.right);
                    }
                }
          }

          level++;  
        }
        return root;
    }
}