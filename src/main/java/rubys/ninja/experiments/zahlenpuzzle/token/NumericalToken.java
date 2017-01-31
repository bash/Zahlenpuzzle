package rubys.ninja.experiments.zahlenpuzzle.token;

public class NumericalToken implements Token {
    private Integer value;

    public NumericalToken(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public String toString() {
        return value.toString();
    }
}
