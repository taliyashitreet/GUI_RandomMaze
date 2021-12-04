public class UnionFind
{
    private int[] parent;
    private int[] size;

    public UnionFind(int n, int m)
    {
        parent = new int[n * m];
        size = new int[n * m];
        for (int i = 0; i < parent.length; i++)
        {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x)
    {
        if (parent[x] != x)
        {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    boolean union(int a, int b) //return true if a and b are on the same binding components
    {
        a = find(a);
        b = find(b);
        if (a != b)
        {
            if (size[a] <= size[b])
            {
                parent[a] = b;
                size[b] += size[a];
            }
            else
            {
                parent[b] = a;
                size[a] += size[b];
            }
            return true;
        }
        return false;
    }
}
