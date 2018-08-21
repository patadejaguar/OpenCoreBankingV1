import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { Safeosmsv2SharedModule } from '../../shared';
import {
    SistemaProductosTiposSafeosmsService,
    SistemaProductosTiposSafeosmsPopupService,
    SistemaProductosTiposSafeosmsComponent,
    SistemaProductosTiposSafeosmsDetailComponent,
    SistemaProductosTiposSafeosmsDialogComponent,
    SistemaProductosTiposSafeosmsPopupComponent,
    SistemaProductosTiposSafeosmsDeletePopupComponent,
    SistemaProductosTiposSafeosmsDeleteDialogComponent,
    sistemaProductosTiposRoute,
    sistemaProductosTiposPopupRoute,
    SistemaProductosTiposSafeosmsResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...sistemaProductosTiposRoute,
    ...sistemaProductosTiposPopupRoute,
];

@NgModule({
    imports: [
        Safeosmsv2SharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        SistemaProductosTiposSafeosmsComponent,
        SistemaProductosTiposSafeosmsDetailComponent,
        SistemaProductosTiposSafeosmsDialogComponent,
        SistemaProductosTiposSafeosmsDeleteDialogComponent,
        SistemaProductosTiposSafeosmsPopupComponent,
        SistemaProductosTiposSafeosmsDeletePopupComponent,
    ],
    entryComponents: [
        SistemaProductosTiposSafeosmsComponent,
        SistemaProductosTiposSafeosmsDialogComponent,
        SistemaProductosTiposSafeosmsPopupComponent,
        SistemaProductosTiposSafeosmsDeleteDialogComponent,
        SistemaProductosTiposSafeosmsDeletePopupComponent,
    ],
    providers: [
        SistemaProductosTiposSafeosmsService,
        SistemaProductosTiposSafeosmsPopupService,
        SistemaProductosTiposSafeosmsResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class Safeosmsv2SistemaProductosTiposSafeosmsModule {}
