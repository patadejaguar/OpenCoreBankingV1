import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { Safeosmsv2SharedModule } from '../../shared';
import {
    SistemaRolesSafeosmsService,
    SistemaRolesSafeosmsPopupService,
    SistemaRolesSafeosmsComponent,
    SistemaRolesSafeosmsDetailComponent,
    SistemaRolesSafeosmsDialogComponent,
    SistemaRolesSafeosmsPopupComponent,
    SistemaRolesSafeosmsDeletePopupComponent,
    SistemaRolesSafeosmsDeleteDialogComponent,
    sistemaRolesRoute,
    sistemaRolesPopupRoute,
    SistemaRolesSafeosmsResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...sistemaRolesRoute,
    ...sistemaRolesPopupRoute,
];

@NgModule({
    imports: [
        Safeosmsv2SharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        SistemaRolesSafeosmsComponent,
        SistemaRolesSafeosmsDetailComponent,
        SistemaRolesSafeosmsDialogComponent,
        SistemaRolesSafeosmsDeleteDialogComponent,
        SistemaRolesSafeosmsPopupComponent,
        SistemaRolesSafeosmsDeletePopupComponent,
    ],
    entryComponents: [
        SistemaRolesSafeosmsComponent,
        SistemaRolesSafeosmsDialogComponent,
        SistemaRolesSafeosmsPopupComponent,
        SistemaRolesSafeosmsDeleteDialogComponent,
        SistemaRolesSafeosmsDeletePopupComponent,
    ],
    providers: [
        SistemaRolesSafeosmsService,
        SistemaRolesSafeosmsPopupService,
        SistemaRolesSafeosmsResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class Safeosmsv2SistemaRolesSafeosmsModule {}
