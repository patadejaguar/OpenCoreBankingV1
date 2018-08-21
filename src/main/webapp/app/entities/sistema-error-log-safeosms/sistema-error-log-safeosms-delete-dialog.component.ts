import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaErrorLogSafeosms } from './sistema-error-log-safeosms.model';
import { SistemaErrorLogSafeosmsPopupService } from './sistema-error-log-safeosms-popup.service';
import { SistemaErrorLogSafeosmsService } from './sistema-error-log-safeosms.service';

@Component({
    selector: 'jhi-sistema-error-log-safeosms-delete-dialog',
    templateUrl: './sistema-error-log-safeosms-delete-dialog.component.html'
})
export class SistemaErrorLogSafeosmsDeleteDialogComponent {

    sistemaErrorLog: SistemaErrorLogSafeosms;

    constructor(
        private sistemaErrorLogService: SistemaErrorLogSafeosmsService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.sistemaErrorLogService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'sistemaErrorLogListModification',
                content: 'Deleted an sistemaErrorLog'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-sistema-error-log-safeosms-delete-popup',
    template: ''
})
export class SistemaErrorLogSafeosmsDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sistemaErrorLogPopupService: SistemaErrorLogSafeosmsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.sistemaErrorLogPopupService
                .open(SistemaErrorLogSafeosmsDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
