import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaNivelRiesgoSafeosms } from './sistema-nivel-riesgo-safeosms.model';
import { SistemaNivelRiesgoSafeosmsPopupService } from './sistema-nivel-riesgo-safeosms-popup.service';
import { SistemaNivelRiesgoSafeosmsService } from './sistema-nivel-riesgo-safeosms.service';

@Component({
    selector: 'jhi-sistema-nivel-riesgo-safeosms-dialog',
    templateUrl: './sistema-nivel-riesgo-safeosms-dialog.component.html'
})
export class SistemaNivelRiesgoSafeosmsDialogComponent implements OnInit {

    sistemaNivelRiesgo: SistemaNivelRiesgoSafeosms;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private sistemaNivelRiesgoService: SistemaNivelRiesgoSafeosmsService,
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
        if (this.sistemaNivelRiesgo.id !== undefined) {
            this.subscribeToSaveResponse(
                this.sistemaNivelRiesgoService.update(this.sistemaNivelRiesgo));
        } else {
            this.subscribeToSaveResponse(
                this.sistemaNivelRiesgoService.create(this.sistemaNivelRiesgo));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<SistemaNivelRiesgoSafeosms>>) {
        result.subscribe((res: HttpResponse<SistemaNivelRiesgoSafeosms>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: SistemaNivelRiesgoSafeosms) {
        this.eventManager.broadcast({ name: 'sistemaNivelRiesgoListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-sistema-nivel-riesgo-safeosms-popup',
    template: ''
})
export class SistemaNivelRiesgoSafeosmsPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sistemaNivelRiesgoPopupService: SistemaNivelRiesgoSafeosmsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.sistemaNivelRiesgoPopupService
                    .open(SistemaNivelRiesgoSafeosmsDialogComponent as Component, params['id']);
            } else {
                this.sistemaNivelRiesgoPopupService
                    .open(SistemaNivelRiesgoSafeosmsDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
