import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { Safeosmsv2SharedModule } from '../../shared';
import {
    SistemaErrorLogSafeosmsService,
    SistemaErrorLogSafeosmsPopupService,
    SistemaErrorLogSafeosmsComponent,
    SistemaErrorLogSafeosmsDetailComponent,
    SistemaErrorLogSafeosmsDialogComponent,
    SistemaErrorLogSafeosmsPopupComponent,
    SistemaErrorLogSafeosmsDeletePopupComponent,
    SistemaErrorLogSafeosmsDeleteDialogComponent,
    sistemaErrorLogRoute,
    sistemaErrorLogPopupRoute,
    SistemaErrorLogSafeosmsResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...sistemaErrorLogRoute,
    ...sistemaErrorLogPopupRoute,
];

@NgModule({
    imports: [
        Safeosmsv2SharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        SistemaErrorLogSafeosmsComponent,
        SistemaErrorLogSafeosmsDetailComponent,
        SistemaErrorLogSafeosmsDialogComponent,
        SistemaErrorLogSafeosmsDeleteDialogComponent,
        SistemaErrorLogSafeosmsPopupComponent,
        SistemaErrorLogSafeosmsDeletePopupComponent,
    ],
    entryComponents: [
        SistemaErrorLogSafeosmsComponent,
        SistemaErrorLogSafeosmsDialogComponent,
        SistemaErrorLogSafeosmsPopupComponent,
        SistemaErrorLogSafeosmsDeleteDialogComponent,
        SistemaErrorLogSafeosmsDeletePopupComponent,
    ],
    providers: [
        SistemaErrorLogSafeosmsService,
        SistemaErrorLogSafeosmsPopupService,
        SistemaErrorLogSafeosmsResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class Safeosmsv2SistemaErrorLogSafeosmsModule {}
