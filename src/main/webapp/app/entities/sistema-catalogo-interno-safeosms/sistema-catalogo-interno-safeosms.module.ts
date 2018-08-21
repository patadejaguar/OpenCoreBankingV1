import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { Safeosmsv2SharedModule } from '../../shared';
import {
    SistemaCatalogoInternoSafeosmsService,
    SistemaCatalogoInternoSafeosmsPopupService,
    SistemaCatalogoInternoSafeosmsComponent,
    SistemaCatalogoInternoSafeosmsDetailComponent,
    SistemaCatalogoInternoSafeosmsDialogComponent,
    SistemaCatalogoInternoSafeosmsPopupComponent,
    SistemaCatalogoInternoSafeosmsDeletePopupComponent,
    SistemaCatalogoInternoSafeosmsDeleteDialogComponent,
    sistemaCatalogoInternoRoute,
    sistemaCatalogoInternoPopupRoute,
    SistemaCatalogoInternoSafeosmsResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...sistemaCatalogoInternoRoute,
    ...sistemaCatalogoInternoPopupRoute,
];

@NgModule({
    imports: [
        Safeosmsv2SharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        SistemaCatalogoInternoSafeosmsComponent,
        SistemaCatalogoInternoSafeosmsDetailComponent,
        SistemaCatalogoInternoSafeosmsDialogComponent,
        SistemaCatalogoInternoSafeosmsDeleteDialogComponent,
        SistemaCatalogoInternoSafeosmsPopupComponent,
        SistemaCatalogoInternoSafeosmsDeletePopupComponent,
    ],
    entryComponents: [
        SistemaCatalogoInternoSafeosmsComponent,
        SistemaCatalogoInternoSafeosmsDialogComponent,
        SistemaCatalogoInternoSafeosmsPopupComponent,
        SistemaCatalogoInternoSafeosmsDeleteDialogComponent,
        SistemaCatalogoInternoSafeosmsDeletePopupComponent,
    ],
    providers: [
        SistemaCatalogoInternoSafeosmsService,
        SistemaCatalogoInternoSafeosmsPopupService,
        SistemaCatalogoInternoSafeosmsResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class Safeosmsv2SistemaCatalogoInternoSafeosmsModule {}
