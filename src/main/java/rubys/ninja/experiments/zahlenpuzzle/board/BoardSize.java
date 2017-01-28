package rubys.ninja.experiments.zahlenpuzzle.board;

public class BoardSize {
    private Integer width;
    private Integer height;

    public BoardSize(Integer width, Integer height) throws IllegalArgumentException {
        if (width < 0 || height < 0)
            throw new IllegalArgumentException("Size cannot be negative");

        this.width = width;
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "(" + this.getWidth() + ", " + this.getHeight() + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;

        BoardSize boardSize = (BoardSize) other;

        return width.equals(boardSize.width) && height.equals(boardSize.height);
    }
}
