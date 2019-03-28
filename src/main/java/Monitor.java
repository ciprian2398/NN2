import java.util.Collection;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class Monitor implements Observer {
    LinkedList<ConnectionNode> connectionNodes;

    public Monitor() {
        this.connectionNodes = new LinkedList<>();
    }

    public void followAll(Collection<ConnectionNode> c) {
        c.forEach(this::follow);
    }

    public void follow(ConnectionNode c) {
        this.connectionNodes.add(c);
        c.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
