import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaMsjLargoSafeosms } from './sistema-msj-largo-safeosms.model';
import { SistemaMsjLargoSafeosmsPopupService } from './sistema-msj-largo-safeosms-popup.service';
import { SistemaMsjLargoSafeosmsService } from './sistema-msj-largo-safeosms.service';

@Component({
    selector: 'jhi-sistema-msj-largo-safeosms-dialog',
    templateUrl: './sistema-msj-largo-safeosms-dialog.component.html'
})
export class SistemaMsjLargoSafeosmsDialogComponent implements OnInit {

    sistemaMsjLargo: SistemaMsjLargoSafeosms;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private sistemaMsjLargoService: SistemaMsjLargoSafeosmsService,
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
        if (this.sistemaMsjLargo.id !== undefined) {
            this.subscribeToSaveResponse(
                this.sistemaMsjLargoService.update(this.sistemaMsjLargo));
        } else {
            this.subscribeToSaveResponse(
                this.sistemaMsjLargoService.create(this.sistemaMsjLargo));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<SistemaMsjLargoSafeosms>>) {
        result.subscribe((res: HttpResponse<SistemaMsjLargoSafeosms>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: SistemaMsjLargoSafeosms) {
        this.eventManager.broadcast({ name: 'sistemaMsjLargoListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-sistema-msj-largo-safeosms-popup',
    template: ''
})
export class SistemaMsjLargoSafeosmsPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sistemaMsjLargoPopupService: SistemaMsjLargoSafeosmsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.sistemaMsjLargoPopupService
                    .open(SistemaMsjLargoSafeosmsDialogComponent as Component, params['id']);
            } else {
                this.sistemaMsjLargoPopupService
                    .open(SistemaMsjLargoSafeosmsDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
