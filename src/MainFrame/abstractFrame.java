package MainFrame;

import controller.GameController;
import entity.Player;

import java.util.ArrayList;

public interface abstractFrame {
    ArrayList<Player> players=new ArrayList<>();

    GameController controller = new GameController();
    public abstract void setController(ArrayList<Player> players);
}
