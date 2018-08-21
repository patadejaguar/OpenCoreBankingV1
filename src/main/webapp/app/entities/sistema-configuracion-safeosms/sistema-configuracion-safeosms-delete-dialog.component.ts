import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaConfiguracionSafeosms } from './sistema-configuracion-safeosms.model';
import { SistemaConfiguracionSafeosmsPopupService } from './sistema-configuracion-safeosms-popup.service';
import { SistemaConfiguracionSafeosmsService } from './sistema-configuracion-safeosms.service';

@Component({
    selector: 'jhi-sistema-configuracion-safeosms-delete-dialog',
    templateUrl: './sistema-configuracion-safeosms-delete-dialog.component.html'
})
export class SistemaConfiguracionSafeosmsDeleteDialogComponent {

    sistemaConfiguracion: SistemaConfiguracionSafeosms;

    constructor(
        private sistemaConfiguracionService: SistemaConfiguracionSafeosmsService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.sistemaConfiguracionService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'sistemaConfiguracionListModification',
                content: 'Deleted an sistemaConfiguracion'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-sistema-configuracion-safeosms-delete-popup',
    template: ''
})
export class SistemaConfiguracionSafeosmsDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sistemaConfiguracionPopupService: SistemaConfiguracionSafeosmsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.sistemaConfiguracionPopupService
                .open(SistemaConfiguracionSafeosmsDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
