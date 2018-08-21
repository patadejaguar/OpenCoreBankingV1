import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaComCanalesSafeosms } from './sistema-com-canales-safeosms.model';
import { SistemaComCanalesSafeosmsPopupService } from './sistema-com-canales-safeosms-popup.service';
import { SistemaComCanalesSafeosmsService } from './sistema-com-canales-safeosms.service';

@Component({
    selector: 'jhi-sistema-com-canales-safeosms-dialog',
    templateUrl: './sistema-com-canales-safeosms-dialog.component.html'
})
export class SistemaComCanalesSafeosmsDialogComponent implements OnInit {

    sistemaComCanales: SistemaComCanalesSafeosms;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private sistemaComCanalesService: SistemaComCanalesSafeosmsService,
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
        if (this.sistemaComCanales.id !== undefined) {
            this.subscribeToSaveResponse(
                this.sistemaComCanalesService.update(this.sistemaComCanales));
        } else {
            this.subscribeToSaveResponse(
                this.sistemaComCanalesService.create(this.sistemaComCanales));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<SistemaComCanalesSafeosms>>) {
        result.subscribe((res: HttpResponse<SistemaComCanalesSafeosms>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: SistemaComCanalesSafeosms) {
        this.eventManager.broadcast({ name: 'sistemaComCanalesListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-sistema-com-canales-safeosms-popup',
    template: ''
})
export class SistemaComCanalesSafeosmsPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sistemaComCanalesPopupService: SistemaComCanalesSafeosmsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.sistemaComCanalesPopupService
                    .open(SistemaComCanalesSafeosmsDialogComponent as Component, params['id']);
            } else {
                this.sistemaComCanalesPopupService
                    .open(SistemaComCanalesSafeosmsDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
