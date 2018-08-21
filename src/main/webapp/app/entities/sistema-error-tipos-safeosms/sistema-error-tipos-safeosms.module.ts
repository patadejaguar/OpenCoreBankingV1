import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { Safeosmsv2SharedModule } from '../../shared';
import {
    SistemaErrorTiposSafeosmsService,
    SistemaErrorTiposSafeosmsPopupService,
    SistemaErrorTiposSafeosmsComponent,
    SistemaErrorTiposSafeosmsDetailComponent,
    SistemaErrorTiposSafeosmsDialogComponent,
    SistemaErrorTiposSafeosmsPopupComponent,
    SistemaErrorTiposSafeosmsDeletePopupComponent,
    SistemaErrorTiposSafeosmsDeleteDialogComponent,
    sistemaErrorTiposRoute,
    sistemaErrorTiposPopupRoute,
    SistemaErrorTiposSafeosmsResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...sistemaErrorTiposRoute,
    ...sistemaErrorTiposPopupRoute,
];

@NgModule({
    imports: [
        Safeosmsv2SharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        SistemaErrorTiposSafeosmsComponent,
        SistemaErrorTiposSafeosmsDetailComponent,
        SistemaErrorTiposSafeosmsDialogComponent,
        SistemaErrorTiposSafeosmsDeleteDialogComponent,
        SistemaErrorTiposSafeosmsPopupComponent,
        SistemaErrorTiposSafeosmsDeletePopupComponent,
    ],
    entryComponents: [
        SistemaErrorTiposSafeosmsComponent,
        SistemaErrorTiposSafeosmsDialogComponent,
        SistemaErrorTiposSafeosmsPopupComponent,
        SistemaErrorTiposSafeosmsDeleteDialogComponent,
        SistemaErrorTiposSafeosmsDeletePopupComponent,
    ],
    providers: [
        SistemaErrorTiposSafeosmsService,
        SistemaErrorTiposSafeosmsPopupService,
        SistemaErrorTiposSafeosmsResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class Safeosmsv2SistemaErrorTiposSafeosmsModule {}
