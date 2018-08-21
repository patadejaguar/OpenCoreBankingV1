import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil } from 'ng-jhipster';

import { UserRouteAccessService } from '../../shared';
import { SistemaProductosTiposSafeosmsComponent } from './sistema-productos-tipos-safeosms.component';
import { SistemaProductosTiposSafeosmsDetailComponent } from './sistema-productos-tipos-safeosms-detail.component';
import { SistemaProductosTiposSafeosmsPopupComponent } from './sistema-productos-tipos-safeosms-dialog.component';
import {
    SistemaProductosTiposSafeosmsDeletePopupComponent
} from './sistema-productos-tipos-safeosms-delete-dialog.component';

@Injectable()
export class SistemaProductosTiposSafeosmsResolvePagingParams implements Resolve<any> {

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

export const sistemaProductosTiposRoute: Routes = [
    {
        path: 'sistema-productos-tipos-safeosms',
        component: SistemaProductosTiposSafeosmsComponent,
        resolve: {
            'pagingParams': SistemaProductosTiposSafeosmsResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaProductosTipos.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'sistema-productos-tipos-safeosms/:id',
        component: SistemaProductosTiposSafeosmsDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaProductosTipos.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const sistemaProductosTiposPopupRoute: Routes = [
    {
        path: 'sistema-productos-tipos-safeosms-new',
        component: SistemaProductosTiposSafeosmsPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaProductosTipos.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'sistema-productos-tipos-safeosms/:id/edit',
        component: SistemaProductosTiposSafeosmsPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaProductosTipos.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'sistema-productos-tipos-safeosms/:id/delete',
        component: SistemaProductosTiposSafeosmsDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaProductosTipos.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
