package chessBoard;

public class Polygon extends Shapes
{
    Integer corners;
    int[] posX;
    int[] posY;
    public Polygon(Integer corners, int[] x, int[] y)
    {
        this.corners = corners;//number of corners the polygon has (3 to make a triangle, 5 for pentagon etc)
        this.posX = x;
        this.posY = y;
    }
}
