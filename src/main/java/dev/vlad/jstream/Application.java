package dev.vlad.jstream;

public class Application {

    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.run(new BatchService(), new Receiver());
    }
}
