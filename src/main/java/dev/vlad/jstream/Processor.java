package dev.vlad.jstream;

import java.util.List;

public class Processor {

    public void run(BatchService batchService, List<Receiver> receivers) {
        batchService.batches().forEach(batch -> {
            processBatch(batch, receivers);
        });
    }

    void processBatch(Batch batch, List<Receiver> receivers) {
        Object result = processBatch(batch);
        if (result == null) {
            return;
        }
        for (Receiver receiver : receivers) {
            receiver.notify(batch, result);
        }
    }

    Object processBatch(Batch batch) {
        return null;
    }

}
