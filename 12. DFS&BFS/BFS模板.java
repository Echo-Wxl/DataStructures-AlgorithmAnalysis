class Solution {
    boolean vis[
    N]; // 判断是否被访问过

    public void bfs(start) {
        Q = new queue();
        q.offer(start); // 创建队列，并加入初始点
        vis[start] true; // 标记初始点已访问

        while (!Q.isEmpty()) {
            cur = Q.poll(); // 得到当前节点
            for next in getNext(cur) {
                if (!vis[next]) { // 如果后继还没访问过
                    Q.push(next);
                    vis[next] = true;
                }
            }
        }
    }
}