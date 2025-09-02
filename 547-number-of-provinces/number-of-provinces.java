class Solution {
    List<List<Integer>> list;
    public void form(int[][] arr){
        for(int i = 0 ;i<arr.length;i++){
            list.add(new ArrayList());
        }
        for(int i= 0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] != 0){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
    }
    public void fun(List<List<Integer>> list, int root , boolean[] vis){
        if(vis[root]){
            return;
        }
        vis[root] = true;
        for(int i=0;i<list.get(root).size();i++){
            int child = list.get(root).get(i);
            if(!vis[child]){
               fun(list, child, vis );
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        list = new ArrayList<>();
        form(isConnected);
        int count = 0;
        boolean[] vis = new boolean[isConnected.length];
        for(int i=0;i<list.size();i++){
            if(!vis[i]){
                count++;
                fun(list,i,vis);
            }
        }
        return count;
    }
}