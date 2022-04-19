/*
 * Waltz - Enterprise Architecture
 * Copyright (C) 2016, 2017, 2018, 2019 Waltz open source project
 * See README.md for more information
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific
 *
 */

package org.finos.waltz.web.endpoints.api;

import org.finos.waltz.common.DateTimeUtilities;
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagramCallout;
import org.finos.waltz.model.overlay_diagram.CostWidgetDatum;
import org.finos.waltz.model.overlay_diagram.CountWidgetDatum;
import org.finos.waltz.service.aggregate_overlay_diagram.AggregateOverlayDiagramCalloutService;
import org.finos.waltz.service.aggregate_overlay_diagram.AggregateOverlayDiagramService;
import org.finos.waltz.web.DatumRoute;
import org.finos.waltz.web.ListRoute;
import org.finos.waltz.web.WebUtilities;
import org.finos.waltz.web.endpoints.Endpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.finos.waltz.common.Checks.checkNotNull;
import static org.finos.waltz.web.WebUtilities.*;
import static org.finos.waltz.web.endpoints.EndpointUtilities.*;

@Service
public class AggregateOverlayDiagramCalloutEndpoint implements Endpoint {

    private static final Logger LOG = LoggerFactory.getLogger(AggregateOverlayDiagramCalloutEndpoint.class);
    private static final String BASE_URL = WebUtilities.mkPath("api", "aggregate-overlay-diagram-callout");

    private final AggregateOverlayDiagramCalloutService aggregateOverlayDiagramCalloutService;


    @Autowired
    public AggregateOverlayDiagramCalloutEndpoint(AggregateOverlayDiagramCalloutService aggregateOverlayDiagramCalloutService) {
        checkNotNull(aggregateOverlayDiagramCalloutService, "aggregateOverlayDiagramCalloutService must not be null");

        this.aggregateOverlayDiagramCalloutService = aggregateOverlayDiagramCalloutService;
    }


    @Override
    public void register() {

        String findByDiagramInstanceIdPath = mkPath(BASE_URL, "diagram-instance-id", ":id");

        ListRoute<AggregateOverlayDiagramCallout> findByDiagramInstanceIdRoute = (request, response) -> {
            return aggregateOverlayDiagramCalloutService.findByDiagramInstanceId(getId(request));
        };

        getForList(findByDiagramInstanceIdPath, findByDiagramInstanceIdRoute);
    }

}
