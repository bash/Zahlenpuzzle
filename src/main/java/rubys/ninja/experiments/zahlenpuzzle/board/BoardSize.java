package rubys.ninja.experiments.zahlenpuzzle.board;

public class BoardSize {
    private Integer width;
    private Integer height;

    public class InvalidValueException extends Exception {
        InvalidValueException(String message) {
            super(message);
        }
    }

    public BoardSize(Integer width, Integer height) throws InvalidValueException {
        if (width < 0 || height < 0)
            throw new InvalidValueException("Size cannot be negative");

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
