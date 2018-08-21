import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil } from 'ng-jhipster';

import { UserRouteAccessService } from '../../shared';
import { SistemaMsjLargoSafeosmsComponent } from './sistema-msj-largo-safeosms.component';
import { SistemaMsjLargoSafeosmsDetailComponent } from './sistema-msj-largo-safeosms-detail.component';
import { SistemaMsjLargoSafeosmsPopupComponent } from './sistema-msj-largo-safeosms-dialog.component';
import { SistemaMsjLargoSafeosmsDeletePopupComponent } from './sistema-msj-largo-safeosms-delete-dialog.component';

@Injectable()
export class SistemaMsjLargoSafeosmsResolvePagingParams implements Resolve<any> {

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

export const sistemaMsjLargoRoute: Routes = [
    {
        path: 'sistema-msj-largo-safeosms',
        component: SistemaMsjLargoSafeosmsComponent,
        resolve: {
            'pagingParams': SistemaMsjLargoSafeosmsResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaMsjLargo.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'sistema-msj-largo-safeosms/:id',
        component: SistemaMsjLargoSafeosmsDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaMsjLargo.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const sistemaMsjLargoPopupRoute: Routes = [
    {
        path: 'sistema-msj-largo-safeosms-new',
        component: SistemaMsjLargoSafeosmsPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaMsjLargo.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'sistema-msj-largo-safeosms/:id/edit',
        component: SistemaMsjLargoSafeosmsPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaMsjLargo.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'sistema-msj-largo-safeosms/:id/delete',
        component: SistemaMsjLargoSafeosmsDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaMsjLargo.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
