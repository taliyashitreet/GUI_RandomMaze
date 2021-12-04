import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.*;

public class MazeCanvas extends JComponent
{
    private int _w;
    private int _h;
    private ArrayList<Edge> _outEdges;
    private int _line, _col;


    public MazeCanvas(int x, int y, int width, int height, int line, ArrayList<Edge> outEdges)
    {
        setBounds(x, y, width+1, height+1);
        setCanvas(width, height, line, outEdges);
    }
    public void setCanvas(int width, int height,int line, ArrayList<Edge> outEdges)
    {
        _line = line;
        _col = width / line;
        _w = width;
        _h = height;
        _outEdges = outEdges;
    }

    private Line2D.Double getLine(int x1, int y1, int x2, int y2)
    {
        return new Line2D.Double(x1, y1, x2, y2); //line to paint from point to another point
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        // a 2D graph
        Graphics2D canvas = (Graphics2D) g;
        canvas.setColor(Color.BLACK);

        //set the border
        canvas.draw(getLine(0, 0, _w, 0));
        canvas.draw(getLine(0, _h, _w, _h));
        canvas.draw(getLine(_w, 0, _w, _h - _line));
        canvas.draw(getLine(0, _line, 0, _h));

        for (Edge edge: _outEdges)
        {
            int first = edge.get_first();
            int second = edge.get_second();
            int i = (first / _col);
            int j = (first % _col);

            if (second - first == 1) // the wall must be between them vertically
            {
                i = i * _line;  // y point mult line
                j = (j + 1) * _line;
                Line2D.Double line = getLine(j, i, j, i+ _line);
                canvas.draw(line);
            }
            else // the wall must be between them horizontally
            {
                i = (i + 1) * _line;
                j = j * _line;
                Line2D.Double line = getLine(j, i, j + _line, i);
                canvas.draw(line);

            }
        }

    }
}
