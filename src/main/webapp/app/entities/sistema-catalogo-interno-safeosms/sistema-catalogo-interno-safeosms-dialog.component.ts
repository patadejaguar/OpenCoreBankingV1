import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaCatalogoInternoSafeosms } from './sistema-catalogo-interno-safeosms.model';
import { SistemaCatalogoInternoSafeosmsPopupService } from './sistema-catalogo-interno-safeosms-popup.service';
import { SistemaCatalogoInternoSafeosmsService } from './sistema-catalogo-interno-safeosms.service';

@Component({
    selector: 'jhi-sistema-catalogo-interno-safeosms-dialog',
    templateUrl: './sistema-catalogo-interno-safeosms-dialog.component.html'
})
export class SistemaCatalogoInternoSafeosmsDialogComponent implements OnInit {

    sistemaCatalogoInterno: SistemaCatalogoInternoSafeosms;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private sistemaCatalogoInternoService: SistemaCatalogoInternoSafeosmsService,
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
        if (this.sistemaCatalogoInterno.id !== undefined) {
            this.subscribeToSaveResponse(
                this.sistemaCatalogoInternoService.update(this.sistemaCatalogoInterno));
        } else {
            this.subscribeToSaveResponse(
                this.sistemaCatalogoInternoService.create(this.sistemaCatalogoInterno));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<SistemaCatalogoInternoSafeosms>>) {
        result.subscribe((res: HttpResponse<SistemaCatalogoInternoSafeosms>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: SistemaCatalogoInternoSafeosms) {
        this.eventManager.broadcast({ name: 'sistemaCatalogoInternoListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-sistema-catalogo-interno-safeosms-popup',
    template: ''
})
export class SistemaCatalogoInternoSafeosmsPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sistemaCatalogoInternoPopupService: SistemaCatalogoInternoSafeosmsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.sistemaCatalogoInternoPopupService
                    .open(SistemaCatalogoInternoSafeosmsDialogComponent as Component, params['id']);
            } else {
                this.sistemaCatalogoInternoPopupService
                    .open(SistemaCatalogoInternoSafeosmsDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
