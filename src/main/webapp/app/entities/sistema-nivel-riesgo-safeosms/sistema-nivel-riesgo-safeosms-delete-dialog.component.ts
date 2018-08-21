import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaNivelRiesgoSafeosms } from './sistema-nivel-riesgo-safeosms.model';
import { SistemaNivelRiesgoSafeosmsPopupService } from './sistema-nivel-riesgo-safeosms-popup.service';
import { SistemaNivelRiesgoSafeosmsService } from './sistema-nivel-riesgo-safeosms.service';

@Component({
    selector: 'jhi-sistema-nivel-riesgo-safeosms-delete-dialog',
    templateUrl: './sistema-nivel-riesgo-safeosms-delete-dialog.component.html'
})
export class SistemaNivelRiesgoSafeosmsDeleteDialogComponent {

    sistemaNivelRiesgo: SistemaNivelRiesgoSafeosms;

    constructor(
        private sistemaNivelRiesgoService: SistemaNivelRiesgoSafeosmsService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.sistemaNivelRiesgoService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'sistemaNivelRiesgoListModification',
                content: 'Deleted an sistemaNivelRiesgo'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-sistema-nivel-riesgo-safeosms-delete-popup',
    template: ''
})
export class SistemaNivelRiesgoSafeosmsDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sistemaNivelRiesgoPopupService: SistemaNivelRiesgoSafeosmsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.sistemaNivelRiesgoPopupService
                .open(SistemaNivelRiesgoSafeosmsDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
