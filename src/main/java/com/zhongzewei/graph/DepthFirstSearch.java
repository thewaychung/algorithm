package com.zhongzewei.graph;

import java.util.List;

/**
 * 深度优先算法
 * 算法描述：访问一个顶点时，将其标志为已访问，递归地访问它的所有没有被标记过的邻居顶点。
 *
 * Created by zhongz on 2017/7/6.
 */
public class DepthFirstSearch {

    private boolean[] marked; //标记过的顶点

    private void search(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;   //标注当前顶点
        List<Integer> adj = G.adj(v); //v的邻居顶点集合
        for (Integer w : adj) {
            if (!marked[w]) {
                dfs(G, w); //如果该邻居顶点未被标注，递归搜索该顶点
            }
        }
    }
}
