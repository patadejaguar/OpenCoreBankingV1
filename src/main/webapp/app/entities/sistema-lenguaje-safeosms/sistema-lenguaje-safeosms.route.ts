import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil } from 'ng-jhipster';

import { UserRouteAccessService } from '../../shared';
import { SistemaLenguajeSafeosmsComponent } from './sistema-lenguaje-safeosms.component';
import { SistemaLenguajeSafeosmsDetailComponent } from './sistema-lenguaje-safeosms-detail.component';
import { SistemaLenguajeSafeosmsPopupComponent } from './sistema-lenguaje-safeosms-dialog.component';
import { SistemaLenguajeSafeosmsDeletePopupComponent } from './sistema-lenguaje-safeosms-delete-dialog.component';

@Injectable()
export class SistemaLenguajeSafeosmsResolvePagingParams implements Resolve<any> {

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

export const sistemaLenguajeRoute: Routes = [
    {
        path: 'sistema-lenguaje-safeosms',
        component: SistemaLenguajeSafeosmsComponent,
        resolve: {
            'pagingParams': SistemaLenguajeSafeosmsResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaLenguaje.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'sistema-lenguaje-safeosms/:id',
        component: SistemaLenguajeSafeosmsDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaLenguaje.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const sistemaLenguajePopupRoute: Routes = [
    {
        path: 'sistema-lenguaje-safeosms-new',
        component: SistemaLenguajeSafeosmsPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaLenguaje.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'sistema-lenguaje-safeosms/:id/edit',
        component: SistemaLenguajeSafeosmsPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaLenguaje.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'sistema-lenguaje-safeosms/:id/delete',
        component: SistemaLenguajeSafeosmsDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaLenguaje.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
