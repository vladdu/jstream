package dev.vlad.jstream;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ProcessorTest {

    @Test
    public void shouldHandleNullBatchGracefully() {
        Batch nullBatch = null;
        Receiver mockReceiver = Mockito.mock(Receiver.class);
        List<Receiver> receivers = Arrays.asList(mockReceiver);

        Processor processor = new Processor();
        processor.processBatch(nullBatch, receivers);

        Mockito.verify(mockReceiver, Mockito.never()).notify(Mockito.any(), Mockito.any());
    }

    @Test
    public void shouldProcessBatchSuccessfully() {
        Batch mockBatch = Mockito.mock(Batch.class);
        Receiver mockReceiver1 = Mockito.mock(Receiver.class);
        Receiver mockReceiver2 = Mockito.mock(Receiver.class);
        List<Receiver> receivers = Arrays.asList(mockReceiver1, mockReceiver2);

        Processor processor = new Processor();
        processor.processBatch(mockBatch, receivers);

        Mockito.verify(mockReceiver1, Mockito.times(1)).notify(mockBatch, Mockito.any());
        Mockito.verify(mockReceiver2, Mockito.times(1)).notify(mockBatch, Mockito.any());
    }
}
