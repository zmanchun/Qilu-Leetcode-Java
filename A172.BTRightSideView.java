/**
Given a binary tree, imagine yourself standing on the right side of it, 
return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].


Solution:

This problem can be easily solved using Level Order Traversal. Our task is to find 
the last TreeNode at each level and add it to the result list.
Use one queue and two integers (current and next) to perform Binary Tree Level Order 
Traversal. When current is 0, which means the current node is the last node of this 
level, we add the value of current node to the result list. 

Time complexity: O(n)
Space complexity: O(n)


Follow-Up: what if we want to get the left side view of Binary Tree?

The method is almost the same. 
The only difference is in each pass of the loop, we need to firstly add right child to queue, then add left child. 
Then we will scan each level from right to left so that the leftmost node would be the last node of each level.
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int current=1, next=0;
        while(queue.size()!=0){
            TreeNode curr = queue.remove();
            current--;
            if(curr.left!=null){
                queue.add(curr.left);
                next++;
            }
            if(curr.right!=null){
                queue.add(curr.right);
                next++;
            }
            if(current==0){
                result.add(curr.val);
                current=next;
                next=0;
            }
        }
        return result;
    }
}
