import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaRolesSafeosms } from './sistema-roles-safeosms.model';
import { SistemaRolesSafeosmsPopupService } from './sistema-roles-safeosms-popup.service';
import { SistemaRolesSafeosmsService } from './sistema-roles-safeosms.service';

@Component({
    selector: 'jhi-sistema-roles-safeosms-dialog',
    templateUrl: './sistema-roles-safeosms-dialog.component.html'
})
export class SistemaRolesSafeosmsDialogComponent implements OnInit {

    sistemaRoles: SistemaRolesSafeosms;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private sistemaRolesService: SistemaRolesSafeosmsService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.sistemaRoles.id !== undefined) {
            this.subscribeToSaveResponse(
                this.sistemaRolesService.update(this.sistemaRoles));
        } else {
            this.subscribeToSaveResponse(
                this.sistemaRolesService.create(this.sistemaRoles));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<SistemaRolesSafeosms>>) {
        result.subscribe((res: HttpResponse<SistemaRolesSafeosms>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: SistemaRolesSafeosms) {
        this.eventManager.broadcast({ name: 'sistemaRolesListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-sistema-roles-safeosms-popup',
    template: ''
})
export class SistemaRolesSafeosmsPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sistemaRolesPopupService: SistemaRolesSafeosmsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.sistemaRolesPopupService
                    .open(SistemaRolesSafeosmsDialogComponent as Component, params['id']);
            } else {
                this.sistemaRolesPopupService
                    .open(SistemaRolesSafeosmsDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
