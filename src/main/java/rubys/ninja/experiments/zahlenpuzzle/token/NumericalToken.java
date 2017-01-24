package rubys.ninja.experiments.zahlenpuzzle.token;

/**
 * @author Ruben Schmidmeister (bash)
 */
public class NumericalToken implements Token {
    private Integer value;

    public NumericalToken(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
