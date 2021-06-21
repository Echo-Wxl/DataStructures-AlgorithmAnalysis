// DFS解决连通域问题
class Solution{
    boolean vis[N]; // 判断是否被访问过
    public void DFS(int start) {
        // 条件满足，遍历成功
        if (start == end) {
            success = true;
            return;
        }

        // 遍历当前所有的可能选择
        for opt int getOptions(start){
            if(!vis[opt]){
                vis[opt]=true;
                dfs(opt);
                if(success){
                    return;
                }
            }
        }
    }
}

// DFS解决最优解问题：回溯，从所有解中找到最优解
class Solution{
    public void dfs(A, int i, vis, box, ans) {
        final int N = A==null ? 0:A.length;

        if(状态满足要求){
            if(curAns 优于 ans){
                ans = cueAns;
            }
            return;
        }

        for next in {start点的后继点}{
            if(!vis){
                box.append(next);
                vis[next] = true;
                dfs(A, next, vis, box, ans);
                box.pop();
                vis[next] = false;
            }
        }
    }
}