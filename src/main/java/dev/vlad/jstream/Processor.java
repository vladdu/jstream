package dev.vlad.jstream;

import io.vavr.Tuple2;
import io.vavr.control.Either;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Processor {

    public void run(BatchService batchService, Receiver receiver) {
        Either<Error, Tuple2<List<Error>, List<Document>>> result = batchService.get().map(b -> processBatch(b, receiver));
        System.out.println("====" + result);

    }

    Tuple2<List<Error>, List<Document>> processBatch(Batch batch, Receiver receiver) {
        if( batch == null) {
            return new Tuple2<>(List.of(new Error("Batch is null")), List.of());
        }
        receiver.notify("Start processing batch: " + batch.index + "...");
        List<Either<Error, Document>> result = processBatch(batch);
        receiver.notify(batch, result);
        if(result==null) {
            return new Tuple2<>(List.of(), List.of());
        }
        return new Tuple2<>(
                result.stream().flatMap(e -> e.isLeft() ? Stream.of(e.getLeft()) : Stream.empty()).collect(toList()),
                result.stream().flatMap(e -> e.isRight() ? Stream.of(e.get()) : Stream.empty()).collect(toList())
        );
    }

    List<Either<Error, Document>> processBatch(Batch batch) {
        System.out.println("PROCESSING BATCH: " + batch.index + "...");
        List<Either<Error, Document>> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                result.add(Either.right(new Document(batch.index + " " + i)));
            } else {
                result.add(Either.left(new Error("Error processing document: " + i)));
            }
        }
        return result;
    }

}
