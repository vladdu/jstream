package dev.vlad.jstream;

import io.vavr.control.Either;

import java.util.List;
import java.util.function.Supplier;

public class BatchService implements Supplier<Either<Error, Batch>> {
    private int current = 0;

    @Override
    public Either<Error, Batch> get() {
        current++;
        if (current < 10) {
            return Either.right(new Batch(current, List.of(new Entry("Entry1"))));
        } else {
            return Either.left(new Error("No more batches available"));
        }
    }
}
