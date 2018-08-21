import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil } from 'ng-jhipster';

import { UserRouteAccessService } from '../../shared';
import { SistemaNivelRiesgoSafeosmsComponent } from './sistema-nivel-riesgo-safeosms.component';
import { SistemaNivelRiesgoSafeosmsDetailComponent } from './sistema-nivel-riesgo-safeosms-detail.component';
import { SistemaNivelRiesgoSafeosmsPopupComponent } from './sistema-nivel-riesgo-safeosms-dialog.component';
import { SistemaNivelRiesgoSafeosmsDeletePopupComponent } from './sistema-nivel-riesgo-safeosms-delete-dialog.component';

@Injectable()
export class SistemaNivelRiesgoSafeosmsResolvePagingParams implements Resolve<any> {

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

export const sistemaNivelRiesgoRoute: Routes = [
    {
        path: 'sistema-nivel-riesgo-safeosms',
        component: SistemaNivelRiesgoSafeosmsComponent,
        resolve: {
            'pagingParams': SistemaNivelRiesgoSafeosmsResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaNivelRiesgo.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'sistema-nivel-riesgo-safeosms/:id',
        component: SistemaNivelRiesgoSafeosmsDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaNivelRiesgo.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const sistemaNivelRiesgoPopupRoute: Routes = [
    {
        path: 'sistema-nivel-riesgo-safeosms-new',
        component: SistemaNivelRiesgoSafeosmsPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaNivelRiesgo.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'sistema-nivel-riesgo-safeosms/:id/edit',
        component: SistemaNivelRiesgoSafeosmsPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaNivelRiesgo.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'sistema-nivel-riesgo-safeosms/:id/delete',
        component: SistemaNivelRiesgoSafeosmsDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaNivelRiesgo.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
