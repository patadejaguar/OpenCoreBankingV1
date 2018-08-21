import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil } from 'ng-jhipster';

import { UserRouteAccessService } from '../../shared';
import { SistemaConfiguracionSafeosmsComponent } from './sistema-configuracion-safeosms.component';
import { SistemaConfiguracionSafeosmsDetailComponent } from './sistema-configuracion-safeosms-detail.component';
import { SistemaConfiguracionSafeosmsPopupComponent } from './sistema-configuracion-safeosms-dialog.component';
import { SistemaConfiguracionSafeosmsDeletePopupComponent } from './sistema-configuracion-safeosms-delete-dialog.component';

@Injectable()
export class SistemaConfiguracionSafeosmsResolvePagingParams implements Resolve<any> {

    constructor(private paginationUtil: JhiPaginationUtil) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const page = route.queryParams['page'] ? route.queryParams['page'] : '1';
        const sort = route.queryParams['sort'] ? route.queryParams['sort'] : 'id,asc';
        return {
            page: this.paginationUtil.parsePage(page),
            predicate: this.paginationUtil.parsePredicate(sort),
            ascending: this.paginationUtil.parseAscending(sort)
      };
    }
}

export const sistemaConfiguracionRoute: Routes = [
    {
        path: 'sistema-configuracion-safeosms',
        component: SistemaConfiguracionSafeosmsComponent,
        resolve: {
            'pagingParams': SistemaConfiguracionSafeosmsResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaConfiguracion.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'sistema-configuracion-safeosms/:id',
        component: SistemaConfiguracionSafeosmsDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaConfiguracion.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const sistemaConfiguracionPopupRoute: Routes = [
    {
        path: 'sistema-configuracion-safeosms-new',
        component: SistemaConfiguracionSafeosmsPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaConfiguracion.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'sistema-configuracion-safeosms/:id/edit',
        component: SistemaConfiguracionSafeosmsPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaConfiguracion.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'sistema-configuracion-safeosms/:id/delete',
        component: SistemaConfiguracionSafeosmsDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaConfiguracion.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
