import java.util.LinkedList;

public class Bulk {
    LinkedList<Neuron> neurons;

    public Bulk(int size) {
        this.neurons = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            neurons.add(new Neuron());
        }
    }

    public void setAsOutput(Bulk bulk) {
        for (Neuron neuron : this.neurons) {
            for (Neuron bulkNeuron : bulk.neurons) {
                neuron.addConsumer(bulkNeuron);
            }
        }
    }

    public void setAsInput(Bulk bulk){
        for (Neuron neuron : this.neurons) {
            for (Neuron bulkNeuron : bulk.neurons) {
                neuron.addProvider(bulkNeuron);
            }
        }
    }
}