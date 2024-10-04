package dev.vlad.jstream;

import java.util.Collections;
import java.util.List;

public class Batch {
    public final int index;
    private final List<Entry> entries;

    public Batch(int index, List<Entry> entries) {
        this.index = index;
        this.entries = Collections.unmodifiableList(entries);
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void addEntry(Entry entry) {
        entries.add(entry);
    }
}
