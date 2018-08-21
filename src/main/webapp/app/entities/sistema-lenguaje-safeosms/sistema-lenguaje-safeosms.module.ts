import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { Safeosmsv2SharedModule } from '../../shared';
import {
    SistemaLenguajeSafeosmsService,
    SistemaLenguajeSafeosmsPopupService,
    SistemaLenguajeSafeosmsComponent,
    SistemaLenguajeSafeosmsDetailComponent,
    SistemaLenguajeSafeosmsDialogComponent,
    SistemaLenguajeSafeosmsPopupComponent,
    SistemaLenguajeSafeosmsDeletePopupComponent,
    SistemaLenguajeSafeosmsDeleteDialogComponent,
    sistemaLenguajeRoute,
    sistemaLenguajePopupRoute,
    SistemaLenguajeSafeosmsResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...sistemaLenguajeRoute,
    ...sistemaLenguajePopupRoute,
];

@NgModule({
    imports: [
        Safeosmsv2SharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        SistemaLenguajeSafeosmsComponent,
        SistemaLenguajeSafeosmsDetailComponent,
        SistemaLenguajeSafeosmsDialogComponent,
        SistemaLenguajeSafeosmsDeleteDialogComponent,
        SistemaLenguajeSafeosmsPopupComponent,
        SistemaLenguajeSafeosmsDeletePopupComponent,
    ],
    entryComponents: [
        SistemaLenguajeSafeosmsComponent,
        SistemaLenguajeSafeosmsDialogComponent,
        SistemaLenguajeSafeosmsPopupComponent,
        SistemaLenguajeSafeosmsDeleteDialogComponent,
        SistemaLenguajeSafeosmsDeletePopupComponent,
    ],
    providers: [
        SistemaLenguajeSafeosmsService,
        SistemaLenguajeSafeosmsPopupService,
        SistemaLenguajeSafeosmsResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class Safeosmsv2SistemaLenguajeSafeosmsModule {}
