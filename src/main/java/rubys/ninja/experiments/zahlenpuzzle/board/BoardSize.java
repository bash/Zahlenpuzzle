package rubys.ninja.experiments.zahlenpuzzle.board;

public class BoardSize {
    private Integer width;
    private Integer height;

    public BoardSize(Integer width, Integer height) throws Exception {
        if (width < 0 || height < 0)
            throw new Exception("Size cannot be negative");

        this.width = width;
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }
}
