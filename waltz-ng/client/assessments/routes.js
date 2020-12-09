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

// import ViewPage from "./pages/view/app-group-view";
import EditPage from "./pages/edit/assessment-rating-bulk-upload";

const baseState = {
    url: "assessment-bulk-upload"
};


// const viewState = {
//     url: "/{definition-id:int}",
//     views: { "content@": ViewPage }
// };


const editState = {
    url: "/{definitionId:int}/edit",
    views: { "content@": EditPage }
};


function setupRoutes($stateProvider) {
    $stateProvider
        .state("main.assessment-bulk-upload", baseState)
        // .state("main.assessment-bulk-upload.view", viewState)
        .state("main.assessment-bulk-upload.edit", editState);
}

setupRoutes.$inject = ["$stateProvider"];


export default setupRoutes;