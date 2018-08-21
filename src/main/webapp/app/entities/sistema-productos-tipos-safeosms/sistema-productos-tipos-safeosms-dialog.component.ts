import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaProductosTiposSafeosms } from './sistema-productos-tipos-safeosms.model';
import { SistemaProductosTiposSafeosmsPopupService } from './sistema-productos-tipos-safeosms-popup.service';
import { SistemaProductosTiposSafeosmsService } from './sistema-productos-tipos-safeosms.service';

@Component({
    selector: 'jhi-sistema-productos-tipos-safeosms-dialog',
    templateUrl: './sistema-productos-tipos-safeosms-dialog.component.html'
})
export class SistemaProductosTiposSafeosmsDialogComponent implements OnInit {

    sistemaProductosTipos: SistemaProductosTiposSafeosms;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private sistemaProductosTiposService: SistemaProductosTiposSafeosmsService,
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
        if (this.sistemaProductosTipos.id !== undefined) {
            this.subscribeToSaveResponse(
                this.sistemaProductosTiposService.update(this.sistemaProductosTipos));
        } else {
            this.subscribeToSaveResponse(
                this.sistemaProductosTiposService.create(this.sistemaProductosTipos));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<SistemaProductosTiposSafeosms>>) {
        result.subscribe((res: HttpResponse<SistemaProductosTiposSafeosms>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: SistemaProductosTiposSafeosms) {
        this.eventManager.broadcast({ name: 'sistemaProductosTiposListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-sistema-productos-tipos-safeosms-popup',
    template: ''
})
export class SistemaProductosTiposSafeosmsPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sistemaProductosTiposPopupService: SistemaProductosTiposSafeosmsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.sistemaProductosTiposPopupService
                    .open(SistemaProductosTiposSafeosmsDialogComponent as Component, params['id']);
            } else {
                this.sistemaProductosTiposPopupService
                    .open(SistemaProductosTiposSafeosmsDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
