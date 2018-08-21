import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil } from 'ng-jhipster';

import { UserRouteAccessService } from '../../shared';
import { SistemaErrorTiposSafeosmsComponent } from './sistema-error-tipos-safeosms.component';
import { SistemaErrorTiposSafeosmsDetailComponent } from './sistema-error-tipos-safeosms-detail.component';
import { SistemaErrorTiposSafeosmsPopupComponent } from './sistema-error-tipos-safeosms-dialog.component';
import { SistemaErrorTiposSafeosmsDeletePopupComponent } from './sistema-error-tipos-safeosms-delete-dialog.component';

@Injectable()
export class SistemaErrorTiposSafeosmsResolvePagingParams implements Resolve<any> {

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

export const sistemaErrorTiposRoute: Routes = [
    {
        path: 'sistema-error-tipos-safeosms',
        component: SistemaErrorTiposSafeosmsComponent,
        resolve: {
            'pagingParams': SistemaErrorTiposSafeosmsResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaErrorTipos.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'sistema-error-tipos-safeosms/:id',
        component: SistemaErrorTiposSafeosmsDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaErrorTipos.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const sistemaErrorTiposPopupRoute: Routes = [
    {
        path: 'sistema-error-tipos-safeosms-new',
        component: SistemaErrorTiposSafeosmsPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaErrorTipos.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'sistema-error-tipos-safeosms/:id/edit',
        component: SistemaErrorTiposSafeosmsPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaErrorTipos.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'sistema-error-tipos-safeosms/:id/delete',
        component: SistemaErrorTiposSafeosmsDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaErrorTipos.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
