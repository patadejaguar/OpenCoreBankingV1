import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaProductosTiposSafeosms } from './sistema-productos-tipos-safeosms.model';
import { SistemaProductosTiposSafeosmsPopupService } from './sistema-productos-tipos-safeosms-popup.service';
import { SistemaProductosTiposSafeosmsService } from './sistema-productos-tipos-safeosms.service';

@Component({
    selector: 'jhi-sistema-productos-tipos-safeosms-delete-dialog',
    templateUrl: './sistema-productos-tipos-safeosms-delete-dialog.component.html'
})
export class SistemaProductosTiposSafeosmsDeleteDialogComponent {

    sistemaProductosTipos: SistemaProductosTiposSafeosms;

    constructor(
        private sistemaProductosTiposService: SistemaProductosTiposSafeosmsService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.sistemaProductosTiposService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'sistemaProductosTiposListModification',
                content: 'Deleted an sistemaProductosTipos'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-sistema-productos-tipos-safeosms-delete-popup',
    template: ''
})
export class SistemaProductosTiposSafeosmsDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sistemaProductosTiposPopupService: SistemaProductosTiposSafeosmsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.sistemaProductosTiposPopupService
                .open(SistemaProductosTiposSafeosmsDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
