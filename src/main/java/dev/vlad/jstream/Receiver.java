package dev.vlad.jstream;

public class Receiver {

    public void notify(Batch batch, Object result) {
        System.out.println(">>>" + batch.index + ": " + result);
    }

    public void notify(String s) {
        System.out.println("!!>" + s);
    }
}
