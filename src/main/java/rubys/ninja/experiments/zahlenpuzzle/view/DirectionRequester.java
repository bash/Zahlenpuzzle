package rubys.ninja.experiments.zahlenpuzzle.view;

public interface DirectionRequester {
    enum Direction {
        up,
        right,
        down,
        left
    }

    Direction getDirection();
}
