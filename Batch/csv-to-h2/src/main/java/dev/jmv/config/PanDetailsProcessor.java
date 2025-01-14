package dev.jmv.config;

import dev.jmv.model.PanDetails;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class PanDetailsProcessor implements ItemProcessor<PanDetails, PanDetails> {
    @Override
    public PanDetails process(PanDetails panDetails) throws Exception {
        return panDetails;
    }
}
