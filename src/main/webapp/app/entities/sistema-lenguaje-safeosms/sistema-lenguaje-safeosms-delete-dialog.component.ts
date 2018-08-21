import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaLenguajeSafeosms } from './sistema-lenguaje-safeosms.model';
import { SistemaLenguajeSafeosmsPopupService } from './sistema-lenguaje-safeosms-popup.service';
import { SistemaLenguajeSafeosmsService } from './sistema-lenguaje-safeosms.service';

@Component({
    selector: 'jhi-sistema-lenguaje-safeosms-delete-dialog',
    templateUrl: './sistema-lenguaje-safeosms-delete-dialog.component.html'
})
export class SistemaLenguajeSafeosmsDeleteDialogComponent {

    sistemaLenguaje: SistemaLenguajeSafeosms;

    constructor(
        private sistemaLenguajeService: SistemaLenguajeSafeosmsService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.sistemaLenguajeService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'sistemaLenguajeListModification',
                content: 'Deleted an sistemaLenguaje'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-sistema-lenguaje-safeosms-delete-popup',
    template: ''
})
export class SistemaLenguajeSafeosmsDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sistemaLenguajePopupService: SistemaLenguajeSafeosmsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.sistemaLenguajePopupService
                .open(SistemaLenguajeSafeosmsDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
