package dev.vlad.jstream;

public class Document {
    public final String content;

    public Document(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Document{" +
                "content='" + content + '\'' +
                '}';
    }
}
