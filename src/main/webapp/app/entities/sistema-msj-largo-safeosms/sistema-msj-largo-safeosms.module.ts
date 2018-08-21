import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { Safeosmsv2SharedModule } from '../../shared';
import {
    SistemaMsjLargoSafeosmsService,
    SistemaMsjLargoSafeosmsPopupService,
    SistemaMsjLargoSafeosmsComponent,
    SistemaMsjLargoSafeosmsDetailComponent,
    SistemaMsjLargoSafeosmsDialogComponent,
    SistemaMsjLargoSafeosmsPopupComponent,
    SistemaMsjLargoSafeosmsDeletePopupComponent,
    SistemaMsjLargoSafeosmsDeleteDialogComponent,
    sistemaMsjLargoRoute,
    sistemaMsjLargoPopupRoute,
    SistemaMsjLargoSafeosmsResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...sistemaMsjLargoRoute,
    ...sistemaMsjLargoPopupRoute,
];

@NgModule({
    imports: [
        Safeosmsv2SharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        SistemaMsjLargoSafeosmsComponent,
        SistemaMsjLargoSafeosmsDetailComponent,
        SistemaMsjLargoSafeosmsDialogComponent,
        SistemaMsjLargoSafeosmsDeleteDialogComponent,
        SistemaMsjLargoSafeosmsPopupComponent,
        SistemaMsjLargoSafeosmsDeletePopupComponent,
    ],
    entryComponents: [
        SistemaMsjLargoSafeosmsComponent,
        SistemaMsjLargoSafeosmsDialogComponent,
        SistemaMsjLargoSafeosmsPopupComponent,
        SistemaMsjLargoSafeosmsDeleteDialogComponent,
        SistemaMsjLargoSafeosmsDeletePopupComponent,
    ],
    providers: [
        SistemaMsjLargoSafeosmsService,
        SistemaMsjLargoSafeosmsPopupService,
        SistemaMsjLargoSafeosmsResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class Safeosmsv2SistemaMsjLargoSafeosmsModule {}
