package com.zhongzewei.graph;

import java.util.Stack;

/**
 * 深度优先搜索查找图中的路径（从一个顶点s到另一个顶点v）
 *
 * 算法描述：首先从s顶点开始对图进行搜索，找出s到它连通的所有顶点的路径，然后使用一个栈来保存到顶点v的路径
 *
 * Created by zhongz on 2017/7/6.
 */
public class DepthFirstPath {

    private boolean[] marked; //某个顶点是否已被标记过
    private int[] edgeTo; //从s开始的连通路径上，某一个顶点的上一个顶点
    private int s; //起点

    //图G，起始顶点s
    public DepthFirstPath(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    //从s开始对图进行搜索，找到连通所有顶点的路径
    private void dfs(Graph G, int v) {
        marked[v] = true;
        //遍历v的邻居顶点
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v; //如果当前顶点未被标记过，那从v到w有一条路径
                dfs(G, w);
            }
        }
    }
    //从s到v是否有路径可达
    private boolean hasPathTo(int v) {
        return marked[v];
    }
    //查找s到v的路径
    private Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;

        Stack<Integer> path = new Stack<Integer>();
        //从v顶点开始往上寻找上一个顶点，一直找到s为止
        for (int w = v; w != s; w = edgeTo[w]) {
            path.push(w);
        }
        path.push(s);
        return path;
    }
}
