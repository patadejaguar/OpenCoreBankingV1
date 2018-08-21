import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil } from 'ng-jhipster';

import { UserRouteAccessService } from '../../shared';
import { SistemaErrorLogSafeosmsComponent } from './sistema-error-log-safeosms.component';
import { SistemaErrorLogSafeosmsDetailComponent } from './sistema-error-log-safeosms-detail.component';
import { SistemaErrorLogSafeosmsPopupComponent } from './sistema-error-log-safeosms-dialog.component';
import { SistemaErrorLogSafeosmsDeletePopupComponent } from './sistema-error-log-safeosms-delete-dialog.component';

@Injectable()
export class SistemaErrorLogSafeosmsResolvePagingParams implements Resolve<any> {

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

export const sistemaErrorLogRoute: Routes = [
    {
        path: 'sistema-error-log-safeosms',
        component: SistemaErrorLogSafeosmsComponent,
        resolve: {
            'pagingParams': SistemaErrorLogSafeosmsResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaErrorLog.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'sistema-error-log-safeosms/:id',
        component: SistemaErrorLogSafeosmsDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaErrorLog.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const sistemaErrorLogPopupRoute: Routes = [
    {
        path: 'sistema-error-log-safeosms-new',
        component: SistemaErrorLogSafeosmsPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaErrorLog.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'sistema-error-log-safeosms/:id/edit',
        component: SistemaErrorLogSafeosmsPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaErrorLog.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'sistema-error-log-safeosms/:id/delete',
        component: SistemaErrorLogSafeosmsDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaErrorLog.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
