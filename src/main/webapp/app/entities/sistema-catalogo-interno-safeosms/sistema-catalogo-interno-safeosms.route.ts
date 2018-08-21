import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil } from 'ng-jhipster';

import { UserRouteAccessService } from '../../shared';
import { SistemaCatalogoInternoSafeosmsComponent } from './sistema-catalogo-interno-safeosms.component';
import { SistemaCatalogoInternoSafeosmsDetailComponent } from './sistema-catalogo-interno-safeosms-detail.component';
import { SistemaCatalogoInternoSafeosmsPopupComponent } from './sistema-catalogo-interno-safeosms-dialog.component';
import {
    SistemaCatalogoInternoSafeosmsDeletePopupComponent
} from './sistema-catalogo-interno-safeosms-delete-dialog.component';

@Injectable()
export class SistemaCatalogoInternoSafeosmsResolvePagingParams implements Resolve<any> {

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

export const sistemaCatalogoInternoRoute: Routes = [
    {
        path: 'sistema-catalogo-interno-safeosms',
        component: SistemaCatalogoInternoSafeosmsComponent,
        resolve: {
            'pagingParams': SistemaCatalogoInternoSafeosmsResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaCatalogoInterno.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'sistema-catalogo-interno-safeosms/:id',
        component: SistemaCatalogoInternoSafeosmsDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaCatalogoInterno.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const sistemaCatalogoInternoPopupRoute: Routes = [
    {
        path: 'sistema-catalogo-interno-safeosms-new',
        component: SistemaCatalogoInternoSafeosmsPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaCatalogoInterno.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'sistema-catalogo-interno-safeosms/:id/edit',
        component: SistemaCatalogoInternoSafeosmsPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaCatalogoInterno.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'sistema-catalogo-interno-safeosms/:id/delete',
        component: SistemaCatalogoInternoSafeosmsDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaCatalogoInterno.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
