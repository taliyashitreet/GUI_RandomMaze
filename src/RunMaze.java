import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RunMaze //contains the main function
{
    public static final int W = 1300;
    public static final int H = 800;
    private ArrayList<Edge> edges;
    private int x, y;
    int _width, _height, _line;

    public RunMaze(int n, int m, int line)
    {
        Maze maze = new Maze(n, m);
        edges = maze.getOutEdge();
        JFrame frame = new JFrame("Taliya & Gilad's Amazing Maze");
        frame.setSize(W, H);

        setProperties(n,m);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        MazeCanvas canvas = new MazeCanvas((W - _width)/2, (H - _height)/2, _width, _height, _line, edges);
        panel.add(canvas);

        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void setProperties(int n, int m)
    {
        int maxW = W - 200;
        int maxH = H - 200;

        if (n > m)
        {
            _line = maxH / n;
            if (_line * m > maxW)
            {
                _line = maxW / m;
            }
        }
        else
        {
            _line = maxW / m;
            if (_line * n > maxH)
            {
                _line = maxH / n;
            }
        }

        _width = _line * m;
        _height = _line * n;

    }

    public static void main(String[] args)
    {
        RunMaze MazeApp = new RunMaze(30, 35, 45);
    }

}
