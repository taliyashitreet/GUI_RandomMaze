import java.util.ArrayList;
import java.util.Random;

public class Maze
        /**
         * this class represent the maze that hold on Edge's array- this array contains
         * only edges that separate different binding components
         */
{
    private ArrayList<Edge> outEdge;

    public Maze(int n, int m)
    {
        Edge[] edges = createEdgeArray(n, m);
        int len = edges.length;
        Random random = new Random();
        UnionFind unionFind = new UnionFind(n, m);
        outEdge = new ArrayList<>();

        for (int k = 0; k < 3; k++)  //O(3*(nm)) = O(nm) This loop causes the selection to be made more randomly
        {
            for (int i = 0; i < len; i++)
            {
                int randInd = random.nextInt(len); //select a random index
                //Swap:
                Edge temp = edges[i];
                edges[i] = edges[randInd];
                edges[randInd] = temp;
            }
        }

        for (Edge edge: edges)
        {
            int a = edge.get_first();
            int b = edge.get_second();
            if (!unionFind.union(a, b)) //different binding components
            {
                outEdge.add(edge);
            }
        }
    }

    public static Edge[] createEdgeArray(int n, int m)
    {
        int len = (n-1) * m + n * (m - 1); //The amount of arches possible in the maze
        Edge[] edges = new Edge[len];
        int index = 0; //start position
        //i * m + j
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (j != m - 1)
                {
                    edges[index++] = new Edge(m*i + j, m * i + (j + 1));
                }
                if (i != n-1)
                {
                    edges[index++] = new Edge(m*i + j, m * (i + 1) + j);
                }
            }
        }
        return edges;
    }

    public ArrayList<Edge> getOutEdge()
    {
        return outEdge;
    }
}
