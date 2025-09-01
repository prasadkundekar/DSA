class Solution {
    static int count = 0;
    public void dfs(int curr, int vis[], List<List<Integer>> rooms) {
        vis[curr] = 1;
        count++;

        for(int con : rooms.get(curr)) {
            if(vis[con] == 0) {
                vis[con] = 1;
                dfs(con, vis, rooms);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        count = 0;
        int n = rooms.size();
        int vis[] = new int[n];
        dfs(0, vis, rooms); // 0 indicate starting room
        if(count == n) {
            return true;
        } else {
            return false;
        }
    }
}