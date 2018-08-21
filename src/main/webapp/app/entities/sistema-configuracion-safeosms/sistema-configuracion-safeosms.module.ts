import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { Safeosmsv2SharedModule } from '../../shared';
import {
    SistemaConfiguracionSafeosmsService,
    SistemaConfiguracionSafeosmsPopupService,
    SistemaConfiguracionSafeosmsComponent,
    SistemaConfiguracionSafeosmsDetailComponent,
    SistemaConfiguracionSafeosmsDialogComponent,
    SistemaConfiguracionSafeosmsPopupComponent,
    SistemaConfiguracionSafeosmsDeletePopupComponent,
    SistemaConfiguracionSafeosmsDeleteDialogComponent,
    sistemaConfiguracionRoute,
    sistemaConfiguracionPopupRoute,
    SistemaConfiguracionSafeosmsResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...sistemaConfiguracionRoute,
    ...sistemaConfiguracionPopupRoute,
];

@NgModule({
    imports: [
        Safeosmsv2SharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        SistemaConfiguracionSafeosmsComponent,
        SistemaConfiguracionSafeosmsDetailComponent,
        SistemaConfiguracionSafeosmsDialogComponent,
        SistemaConfiguracionSafeosmsDeleteDialogComponent,
        SistemaConfiguracionSafeosmsPopupComponent,
        SistemaConfiguracionSafeosmsDeletePopupComponent,
    ],
    entryComponents: [
        SistemaConfiguracionSafeosmsComponent,
        SistemaConfiguracionSafeosmsDialogComponent,
        SistemaConfiguracionSafeosmsPopupComponent,
        SistemaConfiguracionSafeosmsDeleteDialogComponent,
        SistemaConfiguracionSafeosmsDeletePopupComponent,
    ],
    providers: [
        SistemaConfiguracionSafeosmsService,
        SistemaConfiguracionSafeosmsPopupService,
        SistemaConfiguracionSafeosmsResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class Safeosmsv2SistemaConfiguracionSafeosmsModule {}
