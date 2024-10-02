package dev.vlad.jstream;

public interface Receiver {
    void notify(Batch batch, Object result);
}
