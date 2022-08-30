import java.beans.ConstructorProperties;
import java.io.Serializable;
import java.utils.Objects;

public class Posicao implements Serializable {
    private Integer x;
    private Integer y;

    @ConstructorProperties({"x", "y"})
    public Posicao(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

}