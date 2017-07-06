package com.zhongzewei.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 图类：用邻接表数据结构表示的图
 *
 * Created by zhongz on 2017/7/6.
 */
public class Graph {

    private final int V; //顶点数
    private int E; //边的数目
    private Bag<Integer>[] adj;//邻接表

    public Graph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V]; //创建邻接表
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>(v);//初始化所有链表
        }
    }

    //添加一条边
    public void addEdge(int v, int w) {
        adj[v].add(w); //将w添加到v的链表中
        adj[w].add(v); //将v添加到w的链表中
        E++;
    }

    //v的邻居顶点
    public List<Integer> adj(int v) {
        Bag<Integer> item = adj[v];
        List<Integer> list = new ArrayList<Integer>();
        Bag<Integer> next = item.next;
        while (next != null) {
            list.add(next.v);
            next = next.next;
        }
        return list;
    }

    public int V() {
        return V;
    }

    //邻接表元素
    private class Bag<V> {
        Bag<V> next;//下一个顶点
        V v; //当前顶点值
        void add(V v) {
            //查找到链表的最末端再添加
            Bag<V> last = next;
            while (last.next != null) {
                last = last.next;
            }
            //将添加的值添加到链表末端
            last.next = new Bag<V>(v);
        }

        public Bag(V v) {
            this.v = v;
        }
    }
}
