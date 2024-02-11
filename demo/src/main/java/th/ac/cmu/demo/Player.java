package th.ac.cmu.demo;
import lombok.Getter;

@Getter
public class Player {
    private final String name;
    private Integer clicked;

    public Player(String name) {
        this.name = name;
        this.clicked = 0;
    }

    public int getClicked() {
        return this.clicked;
    }

    public void incrementClicked() {
        this.clicked++;
    }
}
