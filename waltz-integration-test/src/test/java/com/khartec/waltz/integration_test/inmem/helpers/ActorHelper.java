package com.khartec.waltz.integration_test.inmem.helpers;

import com.khartec.waltz.data.actor.ActorDao;
import com.khartec.waltz.data.application.ApplicationDao;
import com.khartec.waltz.model.Criticality;
import com.khartec.waltz.model.EntityKind;
import com.khartec.waltz.model.EntityLifecycleStatus;
import com.khartec.waltz.model.EntityReference;
import com.khartec.waltz.model.actor.ImmutableActorCreateCommand;
import com.khartec.waltz.model.application.*;
import com.khartec.waltz.model.rating.RagRating;
import com.khartec.waltz.service.actor.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.khartec.waltz.model.EntityReference.mkRef;

@Service
public class ActorHelper {

    @Autowired
    private ActorService actorService;

    public Long createActor(String nameStem) {
        return actorService.create(
                ImmutableActorCreateCommand
                        .builder()
                        .name(nameStem)
                        .description(nameStem + " Desc")
                        .isExternal(true)
                        .build(),
                "actorHelper");
    }
}
