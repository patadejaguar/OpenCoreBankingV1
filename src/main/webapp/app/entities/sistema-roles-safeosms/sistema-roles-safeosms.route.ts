import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil } from 'ng-jhipster';

import { UserRouteAccessService } from '../../shared';
import { SistemaRolesSafeosmsComponent } from './sistema-roles-safeosms.component';
import { SistemaRolesSafeosmsDetailComponent } from './sistema-roles-safeosms-detail.component';
import { SistemaRolesSafeosmsPopupComponent } from './sistema-roles-safeosms-dialog.component';
import { SistemaRolesSafeosmsDeletePopupComponent } from './sistema-roles-safeosms-delete-dialog.component';

@Injectable()
export class SistemaRolesSafeosmsResolvePagingParams implements Resolve<any> {

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

export const sistemaRolesRoute: Routes = [
    {
        path: 'sistema-roles-safeosms',
        component: SistemaRolesSafeosmsComponent,
        resolve: {
            'pagingParams': SistemaRolesSafeosmsResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaRoles.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'sistema-roles-safeosms/:id',
        component: SistemaRolesSafeosmsDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaRoles.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const sistemaRolesPopupRoute: Routes = [
    {
        path: 'sistema-roles-safeosms-new',
        component: SistemaRolesSafeosmsPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaRoles.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'sistema-roles-safeosms/:id/edit',
        component: SistemaRolesSafeosmsPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaRoles.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'sistema-roles-safeosms/:id/delete',
        component: SistemaRolesSafeosmsDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'safeosmsv2App.sistemaRoles.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
