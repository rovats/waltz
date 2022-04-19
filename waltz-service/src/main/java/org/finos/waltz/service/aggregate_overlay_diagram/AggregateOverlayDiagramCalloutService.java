package org.finos.waltz.service.aggregate_overlay_diagram;

import org.finos.waltz.data.aggregate_overlay_diagram.AggregateOverlayDiagramCalloutDao;
import org.finos.waltz.data.aggregate_overlay_diagram.AppCostWidgetDao;
import org.finos.waltz.data.aggregate_overlay_diagram.AppCountWidgetDao;
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagramCallout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AggregateOverlayDiagramCalloutService {


    private final AggregateOverlayDiagramCalloutDao aggregateOverlayDiagramCalloutDao;

    @Autowired
    public AggregateOverlayDiagramCalloutService(AggregateOverlayDiagramCalloutDao aggregateOverlayDiagramCalloutDao) {
        this.aggregateOverlayDiagramCalloutDao = aggregateOverlayDiagramCalloutDao;
    }


    public Set<AggregateOverlayDiagramCallout> findByDiagramInstanceId(Long diagramInstanceId) {
        return aggregateOverlayDiagramCalloutDao.findByDiagramInstanceId(diagramInstanceId);
    }


}
