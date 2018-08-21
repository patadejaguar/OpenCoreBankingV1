import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaMsjLargoSafeosms } from './sistema-msj-largo-safeosms.model';
import { SistemaMsjLargoSafeosmsPopupService } from './sistema-msj-largo-safeosms-popup.service';
import { SistemaMsjLargoSafeosmsService } from './sistema-msj-largo-safeosms.service';

@Component({
    selector: 'jhi-sistema-msj-largo-safeosms-delete-dialog',
    templateUrl: './sistema-msj-largo-safeosms-delete-dialog.component.html'
})
export class SistemaMsjLargoSafeosmsDeleteDialogComponent {

    sistemaMsjLargo: SistemaMsjLargoSafeosms;

    constructor(
        private sistemaMsjLargoService: SistemaMsjLargoSafeosmsService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.sistemaMsjLargoService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'sistemaMsjLargoListModification',
                content: 'Deleted an sistemaMsjLargo'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-sistema-msj-largo-safeosms-delete-popup',
    template: ''
})
export class SistemaMsjLargoSafeosmsDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sistemaMsjLargoPopupService: SistemaMsjLargoSafeosmsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.sistemaMsjLargoPopupService
                .open(SistemaMsjLargoSafeosmsDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
