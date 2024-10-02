package dev.vlad.jstream;

import java.util.List;

public class Processor {

    public void run(BatchService batchService, List<Receiver> receivers) {
        batchService.batches().forEach(batch -> {
            processBatch(batch, receivers);
        });
    }

    private void processBatch(Batch batch, List<Receiver> receivers) {
        Object result = processBatch(batch, receivers);
        for (Receiver receiver : receivers) {
            receiver.receive(batch);
        }
    }

}
