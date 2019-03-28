import java.util.LinkedList;

public class Neuron {
    LinkedList<ConnectionNode> inputs;
    LinkedList<ConnectionNode> outputs;
    LinkedList<Neuron> inputLinks;
    LinkedList<Neuron> outputLinks;

    public Neuron() {
        this.inputs = new LinkedList<>();
        this.outputs = new LinkedList<>();
        this.inputLinks = new LinkedList<>();
        this.outputLinks = new LinkedList<>();
    }

    public static void wireInput(Neuron neuron, ConnectionNode connectionNode) {
        neuron.inputs.add(connectionNode);
        for (ConnectionNode output : neuron.outputs) {
            output.addProvider(connectionNode);
        }
    }

    public static void wireOutput(Neuron neuron, ConnectionNode connectionNode) {
        neuron.outputs.add(connectionNode);
        for (ConnectionNode input : neuron.inputs) {
            input.addConsumer(connectionNode);
        }
    }

    public static String nTabs(int tabs) {
        String s = "";
        for (int i = 0; i < tabs; i++) {
            s += "\t";
        }
        return s;
    }

    public void addConsumer(Neuron neuron) {
        this.outputLinks.add(neuron);
        neuron.inputLinks.add(this);
        ConnectionNode connectionNode = new ConnectionNode();
        Neuron.wireInput(neuron, connectionNode);
        Neuron.wireOutput(this, connectionNode);
    }

    public void addProvider(Neuron neuron) {
        this.inputLinks.add(neuron);
        neuron.outputLinks.add(this);
        ConnectionNode connectionNode = new ConnectionNode();
        Neuron.wireInput(this, connectionNode);
        Neuron.wireOutput(neuron, connectionNode);
    }

    public void outputsCascade(int tabs) {
        System.out.println(nTabs(tabs++) + this);
        for (Neuron outputLink : outputLinks) {
            outputLink.outputsCascade(tabs);
        }
    }

    public void inputsCascade(int tabs) {
        System.out.println(nTabs(tabs++) + this);
        for (Neuron inputLink : inputLinks) {
            inputLink.inputsCascade(tabs);
        }
    }


}
