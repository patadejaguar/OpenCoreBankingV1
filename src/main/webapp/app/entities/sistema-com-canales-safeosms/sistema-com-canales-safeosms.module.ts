import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { Safeosmsv2SharedModule } from '../../shared';
import {
    SistemaComCanalesSafeosmsService,
    SistemaComCanalesSafeosmsPopupService,
    SistemaComCanalesSafeosmsComponent,
    SistemaComCanalesSafeosmsDetailComponent,
    SistemaComCanalesSafeosmsDialogComponent,
    SistemaComCanalesSafeosmsPopupComponent,
    SistemaComCanalesSafeosmsDeletePopupComponent,
    SistemaComCanalesSafeosmsDeleteDialogComponent,
    sistemaComCanalesRoute,
    sistemaComCanalesPopupRoute,
    SistemaComCanalesSafeosmsResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...sistemaComCanalesRoute,
    ...sistemaComCanalesPopupRoute,
];

@NgModule({
    imports: [
        Safeosmsv2SharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        SistemaComCanalesSafeosmsComponent,
        SistemaComCanalesSafeosmsDetailComponent,
        SistemaComCanalesSafeosmsDialogComponent,
        SistemaComCanalesSafeosmsDeleteDialogComponent,
        SistemaComCanalesSafeosmsPopupComponent,
        SistemaComCanalesSafeosmsDeletePopupComponent,
    ],
    entryComponents: [
        SistemaComCanalesSafeosmsComponent,
        SistemaComCanalesSafeosmsDialogComponent,
        SistemaComCanalesSafeosmsPopupComponent,
        SistemaComCanalesSafeosmsDeleteDialogComponent,
        SistemaComCanalesSafeosmsDeletePopupComponent,
    ],
    providers: [
        SistemaComCanalesSafeosmsService,
        SistemaComCanalesSafeosmsPopupService,
        SistemaComCanalesSafeosmsResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class Safeosmsv2SistemaComCanalesSafeosmsModule {}
