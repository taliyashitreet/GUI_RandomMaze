public class Edge
{
    /**
     * this class represent an Edge that connects two vertices (from "first" to "secound")
     */
    private int _first;
    private int _second;

    public Edge(int first, int second)
    {
        _first = first;
        _second = second;
    }

    public int get_first()
    {
        return _first;
    }

    public int get_second()
    {
        return _second;
    }
}
