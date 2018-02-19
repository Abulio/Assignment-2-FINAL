package chessBoard;

public class Oblong extends Shapes
{
    Integer width;
    Integer height;

    public Oblong(Integer x, Integer y, Integer width, Integer height)
    {
        this.width = width;
        this.height = height;
        this.posX = x;
        this.posY = y;
    }
}
