import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaRolesSafeosms } from './sistema-roles-safeosms.model';
import { SistemaRolesSafeosmsService } from './sistema-roles-safeosms.service';

@Component({
    selector: 'jhi-sistema-roles-safeosms-detail',
    templateUrl: './sistema-roles-safeosms-detail.component.html'
})
export class SistemaRolesSafeosmsDetailComponent implements OnInit, OnDestroy {

    sistemaRoles: SistemaRolesSafeosms;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private sistemaRolesService: SistemaRolesSafeosmsService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInSistemaRoles();
    }

    load(id) {
        this.sistemaRolesService.find(id)
            .subscribe((sistemaRolesResponse: HttpResponse<SistemaRolesSafeosms>) => {
                this.sistemaRoles = sistemaRolesResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInSistemaRoles() {
        this.eventSubscriber = this.eventManager.subscribe(
            'sistemaRolesListModification',
            (response) => this.load(this.sistemaRoles.id)
        );
    }
}
