import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil } from 'ng-jhipster';

import { UserRouteAccessService } from '../../shared';
import { SistemaComCanalesSafeosmsComponent } from './sistema-com-canales-safeosms.component';
import { SistemaComCanalesSafeosmsDetailComponent } from './sistema-com-canales-safeosms-detail.component';
import { SistemaComCanalesSafeosmsPopupComponent } from './sistema-com-canales-safeosms-dialog.component';
import { SistemaComCanalesSafeosmsDeletePopupComponent } from './sistema-com-canales-safeosms-delete-dialog.component';

@Injectable()
export class SistemaComCanalesSafeosmsResolvePagingParams implements Resolve<any> {

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

export const sistemaComCanalesRoute: Routes = [
    {
        path: 'sistema-com-canales-safeosms',
        component: SistemaComCanalesSafeosmsComponent,
        resolve: {
            'pagingParams': SistemaComCanalesSafeosmsResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaComCanales.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'sistema-com-canales-safeosms/:id',
        component: SistemaComCanalesSafeosmsDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaComCanales.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const sistemaComCanalesPopupRoute: Routes = [
    {
        path: 'sistema-com-canales-safeosms-new',
        component: SistemaComCanalesSafeosmsPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaComCanales.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'sistema-com-canales-safeosms/:id/edit',
        component: SistemaComCanalesSafeosmsPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaComCanales.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'sistema-com-canales-safeosms/:id/delete',
        component: SistemaComCanalesSafeosmsDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaComCanales.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
