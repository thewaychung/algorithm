package com.zhongzewei.graph;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * 广度优先搜索查找路径
 *
 * 算法描述：使用一个队列来保存所有已经被标记过，但领接表还未被检查过的顶点。先将起点加入队列，
 * 取队列中下一个顶点v并标记它，将与v相邻且未被标记过的顶点加入队列。
 *
 * Created by zhongz on 2017/7/6.
 */
public class BreadthFirstPath {

    private boolean[] marked; //顶点是否已被标记
    private int[] edgeTo; //到达该顶点的已知路径上上一个顶点
    private final  int s; //起点

    public BreadthFirstPath(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    //广度优先搜索查找
    private void bfs(Graph G, int v) {
        Queue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(v);
        marked[s] = true;//标记起点
        while (!queue.isEmpty()) {
            int x = queue.poll(); //从队列中取出一个顶点
            for (int w : G.adj(x)) { //遍历该顶点的所有邻接点
                if (!marked[w]) { //如果该顶点未被标记，则添加到路径中
                    edgeTo[w] = x; //到该节点最短路径的上一个顶点
                    marked[w] = true; //标记该节点
                    queue.add(w); //将该节点添加到队列中
                }
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
