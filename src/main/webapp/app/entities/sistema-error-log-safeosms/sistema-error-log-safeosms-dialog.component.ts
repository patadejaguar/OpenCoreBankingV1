import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService, JhiDataUtils } from 'ng-jhipster';

import { SistemaErrorLogSafeosms } from './sistema-error-log-safeosms.model';
import { SistemaErrorLogSafeosmsPopupService } from './sistema-error-log-safeosms-popup.service';
import { SistemaErrorLogSafeosmsService } from './sistema-error-log-safeosms.service';
import { SistemaErrorTiposSafeosms, SistemaErrorTiposSafeosmsService } from '../sistema-error-tipos-safeosms';

@Component({
    selector: 'jhi-sistema-error-log-safeosms-dialog',
    templateUrl: './sistema-error-log-safeosms-dialog.component.html'
})
export class SistemaErrorLogSafeosmsDialogComponent implements OnInit {

    sistemaErrorLog: SistemaErrorLogSafeosms;
    isSaving: boolean;

    sistemaerrortipos: SistemaErrorTiposSafeosms[];

    constructor(
        public activeModal: NgbActiveModal,
        private dataUtils: JhiDataUtils,
        private jhiAlertService: JhiAlertService,
        private sistemaErrorLogService: SistemaErrorLogSafeosmsService,
        private sistemaErrorTiposService: SistemaErrorTiposSafeosmsService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.sistemaErrorTiposService.query()
            .subscribe((res: HttpResponse<SistemaErrorTiposSafeosms[]>) => { this.sistemaerrortipos = res.body; }, (res: HttpErrorResponse) => this.onError(res.message));
    }

    byteSize(field) {
        return this.dataUtils.byteSize(field);
    }

    openFile(contentType, field) {
        return this.dataUtils.openFile(contentType, field);
    }

    setFileData(event, entity, field, isImage) {
        this.dataUtils.setFileData(event, entity, field, isImage);
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.sistemaErrorLog.id !== undefined) {
            this.subscribeToSaveResponse(
                this.sistemaErrorLogService.update(this.sistemaErrorLog));
        } else {
            this.subscribeToSaveResponse(
                this.sistemaErrorLogService.create(this.sistemaErrorLog));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<SistemaErrorLogSafeosms>>) {
        result.subscribe((res: HttpResponse<SistemaErrorLogSafeosms>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: SistemaErrorLogSafeosms) {
        this.eventManager.broadcast({ name: 'sistemaErrorLogListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(error: any) {
        this.jhiAlertService.error(error.message, null, null);
    }

    trackSistemaErrorTiposById(index: number, item: SistemaErrorTiposSafeosms) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-sistema-error-log-safeosms-popup',
    template: ''
})
export class SistemaErrorLogSafeosmsPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sistemaErrorLogPopupService: SistemaErrorLogSafeosmsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.sistemaErrorLogPopupService
                    .open(SistemaErrorLogSafeosmsDialogComponent as Component, params['id']);
            } else {
                this.sistemaErrorLogPopupService
                    .open(SistemaErrorLogSafeosmsDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
