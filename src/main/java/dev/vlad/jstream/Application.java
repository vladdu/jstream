package dev.vlad.jstream;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.run(new BatchService(), List.of(new DocumentReceiver(), new ErrorReceiver()));
    }
}
