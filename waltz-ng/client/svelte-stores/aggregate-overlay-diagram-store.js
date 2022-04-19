import {remote} from "./remote";
import {checkIsEntityRef} from "../common/checks";


export function mkOverlayDiagramStore() {

    const getById = (id, force = false) => {
        return remote
            .fetchViewDatum(
                "GET",
                `api/aggregate-overlay-diagram/id/${id}`,
                {force});
    };


    const findAll = (force = false) => {
        return remote
            .fetchViewList(
                "GET",
                "api/aggregate-overlay-diagram/all",
                [],
                {force});
    };


    const findAppCountsForDiagram = (diagramId, vantagePointRef, force = false) => {
        return remote
            .fetchViewList(
                "POST",
                `api/aggregate-overlay-diagram/diagram-id/${diagramId}/app-count-widget`,
                vantagePointRef,
                {force});
    };

    const findAppCostForDiagram = (diagramId, vantagePointRef, force = false) => {
        return remote
            .fetchViewList(
                "POST",
                `api/aggregate-overlay-diagram/diagram-id/${diagramId}/app-cost-widget`,
                vantagePointRef,
                {force});
    };

    return {
        getById,
        findAll,
        findAppCountsForDiagram,
        findAppCostForDiagram
    };
}


export const aggregateOverlayDiagramStore = mkOverlayDiagramStore();