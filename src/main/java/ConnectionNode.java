import java.util.LinkedList;
import java.util.Observable;

public class ConnectionNode extends Observable {
    LinkedList<Distribution> inputs;
    LinkedList<Distribution> outputs;

    public ConnectionNode() {
        this.inputs = new LinkedList<>();
        this.outputs = new LinkedList<>();
    }

    public void addConsumer(ConnectionNode connectionNode) {
        Distribution distribution = new Distribution(0, this, connectionNode);
        this.outputs.add(distribution);
    }

    public void addProvider(ConnectionNode connectionNode) {
        Distribution distribution = new Distribution(0, connectionNode, this);
        this.inputs.add(distribution);
    }
}
