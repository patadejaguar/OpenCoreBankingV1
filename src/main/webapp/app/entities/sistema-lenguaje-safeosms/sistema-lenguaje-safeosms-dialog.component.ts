import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaLenguajeSafeosms } from './sistema-lenguaje-safeosms.model';
import { SistemaLenguajeSafeosmsPopupService } from './sistema-lenguaje-safeosms-popup.service';
import { SistemaLenguajeSafeosmsService } from './sistema-lenguaje-safeosms.service';

@Component({
    selector: 'jhi-sistema-lenguaje-safeosms-dialog',
    templateUrl: './sistema-lenguaje-safeosms-dialog.component.html'
})
export class SistemaLenguajeSafeosmsDialogComponent implements OnInit {

    sistemaLenguaje: SistemaLenguajeSafeosms;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private sistemaLenguajeService: SistemaLenguajeSafeosmsService,
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
        if (this.sistemaLenguaje.id !== undefined) {
            this.subscribeToSaveResponse(
                this.sistemaLenguajeService.update(this.sistemaLenguaje));
        } else {
            this.subscribeToSaveResponse(
                this.sistemaLenguajeService.create(this.sistemaLenguaje));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<SistemaLenguajeSafeosms>>) {
        result.subscribe((res: HttpResponse<SistemaLenguajeSafeosms>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: SistemaLenguajeSafeosms) {
        this.eventManager.broadcast({ name: 'sistemaLenguajeListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-sistema-lenguaje-safeosms-popup',
    template: ''
})
export class SistemaLenguajeSafeosmsPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sistemaLenguajePopupService: SistemaLenguajeSafeosmsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.sistemaLenguajePopupService
                    .open(SistemaLenguajeSafeosmsDialogComponent as Component, params['id']);
            } else {
                this.sistemaLenguajePopupService
                    .open(SistemaLenguajeSafeosmsDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
