/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int cnt =0;
    long sum =0;
    public int pathSum(TreeNode root, int targetSum) {

        Map<Long,Integer> map = new HashMap<>();
        map.put(0L,1);

        prefix(root,targetSum,map);

        return cnt;
    }

    void prefix(TreeNode root,int k,Map<Long,Integer> map){

        if(root == null) return;

        sum += root.val;

        if(map.containsKey(sum-k)) cnt += map.get(sum-k);

        map.put(sum,map.getOrDefault(sum,0)+1);

        prefix(root.left,k,map);
        prefix(root.right,k,map);

        map.put(sum,map.get(sum) -1);

        sum -= root.val;
    }
}