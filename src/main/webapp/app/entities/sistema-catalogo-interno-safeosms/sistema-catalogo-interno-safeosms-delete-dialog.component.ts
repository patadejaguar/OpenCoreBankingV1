import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaCatalogoInternoSafeosms } from './sistema-catalogo-interno-safeosms.model';
import { SistemaCatalogoInternoSafeosmsPopupService } from './sistema-catalogo-interno-safeosms-popup.service';
import { SistemaCatalogoInternoSafeosmsService } from './sistema-catalogo-interno-safeosms.service';

@Component({
    selector: 'jhi-sistema-catalogo-interno-safeosms-delete-dialog',
    templateUrl: './sistema-catalogo-interno-safeosms-delete-dialog.component.html'
})
export class SistemaCatalogoInternoSafeosmsDeleteDialogComponent {

    sistemaCatalogoInterno: SistemaCatalogoInternoSafeosms;

    constructor(
        private sistemaCatalogoInternoService: SistemaCatalogoInternoSafeosmsService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.sistemaCatalogoInternoService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'sistemaCatalogoInternoListModification',
                content: 'Deleted an sistemaCatalogoInterno'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-sistema-catalogo-interno-safeosms-delete-popup',
    template: ''
})
export class SistemaCatalogoInternoSafeosmsDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sistemaCatalogoInternoPopupService: SistemaCatalogoInternoSafeosmsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.sistemaCatalogoInternoPopupService
                .open(SistemaCatalogoInternoSafeosmsDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
