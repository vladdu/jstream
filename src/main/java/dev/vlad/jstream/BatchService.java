package dev.vlad.jstream;

import java.util.stream.Stream;

public class BatchService {

    public Stream<Batch> batches() {
        // Implementation to fetch batches from a data source
        // For example, from a database or a file
        return Stream.of(new Batch(), new Batch());
    }

}
