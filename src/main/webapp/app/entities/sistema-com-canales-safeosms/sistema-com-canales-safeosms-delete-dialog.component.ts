import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaComCanalesSafeosms } from './sistema-com-canales-safeosms.model';
import { SistemaComCanalesSafeosmsPopupService } from './sistema-com-canales-safeosms-popup.service';
import { SistemaComCanalesSafeosmsService } from './sistema-com-canales-safeosms.service';

@Component({
    selector: 'jhi-sistema-com-canales-safeosms-delete-dialog',
    templateUrl: './sistema-com-canales-safeosms-delete-dialog.component.html'
})
export class SistemaComCanalesSafeosmsDeleteDialogComponent {

    sistemaComCanales: SistemaComCanalesSafeosms;

    constructor(
        private sistemaComCanalesService: SistemaComCanalesSafeosmsService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.sistemaComCanalesService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'sistemaComCanalesListModification',
                content: 'Deleted an sistemaComCanales'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-sistema-com-canales-safeosms-delete-popup',
    template: ''
})
export class SistemaComCanalesSafeosmsDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sistemaComCanalesPopupService: SistemaComCanalesSafeosmsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.sistemaComCanalesPopupService
                .open(SistemaComCanalesSafeosmsDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
