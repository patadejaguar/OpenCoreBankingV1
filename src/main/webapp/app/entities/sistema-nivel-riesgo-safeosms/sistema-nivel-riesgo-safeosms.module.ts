import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { Safeosmsv2SharedModule } from '../../shared';
import {
    SistemaNivelRiesgoSafeosmsService,
    SistemaNivelRiesgoSafeosmsPopupService,
    SistemaNivelRiesgoSafeosmsComponent,
    SistemaNivelRiesgoSafeosmsDetailComponent,
    SistemaNivelRiesgoSafeosmsDialogComponent,
    SistemaNivelRiesgoSafeosmsPopupComponent,
    SistemaNivelRiesgoSafeosmsDeletePopupComponent,
    SistemaNivelRiesgoSafeosmsDeleteDialogComponent,
    sistemaNivelRiesgoRoute,
    sistemaNivelRiesgoPopupRoute,
    SistemaNivelRiesgoSafeosmsResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...sistemaNivelRiesgoRoute,
    ...sistemaNivelRiesgoPopupRoute,
];

@NgModule({
    imports: [
        Safeosmsv2SharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        SistemaNivelRiesgoSafeosmsComponent,
        SistemaNivelRiesgoSafeosmsDetailComponent,
        SistemaNivelRiesgoSafeosmsDialogComponent,
        SistemaNivelRiesgoSafeosmsDeleteDialogComponent,
        SistemaNivelRiesgoSafeosmsPopupComponent,
        SistemaNivelRiesgoSafeosmsDeletePopupComponent,
    ],
    entryComponents: [
        SistemaNivelRiesgoSafeosmsComponent,
        SistemaNivelRiesgoSafeosmsDialogComponent,
        SistemaNivelRiesgoSafeosmsPopupComponent,
        SistemaNivelRiesgoSafeosmsDeleteDialogComponent,
        SistemaNivelRiesgoSafeosmsDeletePopupComponent,
    ],
    providers: [
        SistemaNivelRiesgoSafeosmsService,
        SistemaNivelRiesgoSafeosmsPopupService,
        SistemaNivelRiesgoSafeosmsResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class Safeosmsv2SistemaNivelRiesgoSafeosmsModule {}
