import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaErrorTiposSafeosms } from './sistema-error-tipos-safeosms.model';
import { SistemaErrorTiposSafeosmsPopupService } from './sistema-error-tipos-safeosms-popup.service';
import { SistemaErrorTiposSafeosmsService } from './sistema-error-tipos-safeosms.service';

@Component({
    selector: 'jhi-sistema-error-tipos-safeosms-delete-dialog',
    templateUrl: './sistema-error-tipos-safeosms-delete-dialog.component.html'
})
export class SistemaErrorTiposSafeosmsDeleteDialogComponent {

    sistemaErrorTipos: SistemaErrorTiposSafeosms;

    constructor(
        private sistemaErrorTiposService: SistemaErrorTiposSafeosmsService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.sistemaErrorTiposService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'sistemaErrorTiposListModification',
                content: 'Deleted an sistemaErrorTipos'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-sistema-error-tipos-safeosms-delete-popup',
    template: ''
})
export class SistemaErrorTiposSafeosmsDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sistemaErrorTiposPopupService: SistemaErrorTiposSafeosmsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.sistemaErrorTiposPopupService
                .open(SistemaErrorTiposSafeosmsDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
