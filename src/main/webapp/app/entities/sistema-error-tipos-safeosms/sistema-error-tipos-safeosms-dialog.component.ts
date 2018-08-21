import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaErrorTiposSafeosms } from './sistema-error-tipos-safeosms.model';
import { SistemaErrorTiposSafeosmsPopupService } from './sistema-error-tipos-safeosms-popup.service';
import { SistemaErrorTiposSafeosmsService } from './sistema-error-tipos-safeosms.service';

@Component({
    selector: 'jhi-sistema-error-tipos-safeosms-dialog',
    templateUrl: './sistema-error-tipos-safeosms-dialog.component.html'
})
export class SistemaErrorTiposSafeosmsDialogComponent implements OnInit {

    sistemaErrorTipos: SistemaErrorTiposSafeosms;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private sistemaErrorTiposService: SistemaErrorTiposSafeosmsService,
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
        if (this.sistemaErrorTipos.id !== undefined) {
            this.subscribeToSaveResponse(
                this.sistemaErrorTiposService.update(this.sistemaErrorTipos));
        } else {
            this.subscribeToSaveResponse(
                this.sistemaErrorTiposService.create(this.sistemaErrorTipos));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<SistemaErrorTiposSafeosms>>) {
        result.subscribe((res: HttpResponse<SistemaErrorTiposSafeosms>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: SistemaErrorTiposSafeosms) {
        this.eventManager.broadcast({ name: 'sistemaErrorTiposListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-sistema-error-tipos-safeosms-popup',
    template: ''
})
export class SistemaErrorTiposSafeosmsPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sistemaErrorTiposPopupService: SistemaErrorTiposSafeosmsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.sistemaErrorTiposPopupService
                    .open(SistemaErrorTiposSafeosmsDialogComponent as Component, params['id']);
            } else {
                this.sistemaErrorTiposPopupService
                    .open(SistemaErrorTiposSafeosmsDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
