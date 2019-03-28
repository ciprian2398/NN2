public class Distribution {
    double percent;
    ConnectionNode input;
    ConnectionNode output;

    public Distribution(
            double percent,
            ConnectionNode input,
            ConnectionNode output
    ) {
        this.percent = percent;
        this.input = input;
        this.output = output;
    }
}
