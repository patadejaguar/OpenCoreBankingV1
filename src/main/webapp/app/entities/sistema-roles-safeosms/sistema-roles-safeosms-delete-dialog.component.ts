import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaRolesSafeosms } from './sistema-roles-safeosms.model';
import { SistemaRolesSafeosmsPopupService } from './sistema-roles-safeosms-popup.service';
import { SistemaRolesSafeosmsService } from './sistema-roles-safeosms.service';

@Component({
    selector: 'jhi-sistema-roles-safeosms-delete-dialog',
    templateUrl: './sistema-roles-safeosms-delete-dialog.component.html'
})
export class SistemaRolesSafeosmsDeleteDialogComponent {

    sistemaRoles: SistemaRolesSafeosms;

    constructor(
        private sistemaRolesService: SistemaRolesSafeosmsService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.sistemaRolesService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'sistemaRolesListModification',
                content: 'Deleted an sistemaRoles'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-sistema-roles-safeosms-delete-popup',
    template: ''
})
export class SistemaRolesSafeosmsDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sistemaRolesPopupService: SistemaRolesSafeosmsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.sistemaRolesPopupService
                .open(SistemaRolesSafeosmsDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
