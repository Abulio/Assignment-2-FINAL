package chessBoard;

public class Square extends Shapes
{
    Integer width;
    Integer height;
    public Square(Integer x, Integer y, Integer size)
    {
        this.width = size;//height and width of square need to be identical
        this.height = size;
        this.posX = x;
        this.posY = y;
    }
}
