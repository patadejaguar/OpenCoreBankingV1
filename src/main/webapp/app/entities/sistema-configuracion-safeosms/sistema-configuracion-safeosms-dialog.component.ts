import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaConfiguracionSafeosms } from './sistema-configuracion-safeosms.model';
import { SistemaConfiguracionSafeosmsPopupService } from './sistema-configuracion-safeosms-popup.service';
import { SistemaConfiguracionSafeosmsService } from './sistema-configuracion-safeosms.service';

@Component({
    selector: 'jhi-sistema-configuracion-safeosms-dialog',
    templateUrl: './sistema-configuracion-safeosms-dialog.component.html'
})
export class SistemaConfiguracionSafeosmsDialogComponent implements OnInit {

    sistemaConfiguracion: SistemaConfiguracionSafeosms;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private sistemaConfiguracionService: SistemaConfiguracionSafeosmsService,
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
        if (this.sistemaConfiguracion.id !== undefined) {
            this.subscribeToSaveResponse(
                this.sistemaConfiguracionService.update(this.sistemaConfiguracion));
        } else {
            this.subscribeToSaveResponse(
                this.sistemaConfiguracionService.create(this.sistemaConfiguracion));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<SistemaConfiguracionSafeosms>>) {
        result.subscribe((res: HttpResponse<SistemaConfiguracionSafeosms>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: SistemaConfiguracionSafeosms) {
        this.eventManager.broadcast({ name: 'sistemaConfiguracionListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-sistema-configuracion-safeosms-popup',
    template: ''
})
export class SistemaConfiguracionSafeosmsPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sistemaConfiguracionPopupService: SistemaConfiguracionSafeosmsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.sistemaConfiguracionPopupService
                    .open(SistemaConfiguracionSafeosmsDialogComponent as Component, params['id']);
            } else {
                this.sistemaConfiguracionPopupService
                    .open(SistemaConfiguracionSafeosmsDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
