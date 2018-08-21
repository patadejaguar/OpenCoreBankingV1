import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { SistemaErrorTiposSafeosms } from './sistema-error-tipos-safeosms.model';
import { SistemaErrorTiposSafeosmsService } from './sistema-error-tipos-safeosms.service';

@Injectable()
export class SistemaErrorTiposSafeosmsPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private sistemaErrorTiposService: SistemaErrorTiposSafeosmsService

    ) {
        this.ngbModalRef = null;
    }

    open(component: Component, id?: number | any): Promise<NgbModalRef> {
        return new Promise<NgbModalRef>((resolve, reject) => {
            const isOpen = this.ngbModalRef !== null;
            if (isOpen) {
                resolve(this.ngbModalRef);
            }

            if (id) {
                this.sistemaErrorTiposService.find(id)
                    .subscribe((sistemaErrorTiposResponse: HttpResponse<SistemaErrorTiposSafeosms>) => {
                        const sistemaErrorTipos: SistemaErrorTiposSafeosms = sistemaErrorTiposResponse.body;
                        this.ngbModalRef = this.sistemaErrorTiposModalRef(component, sistemaErrorTipos);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.sistemaErrorTiposModalRef(component, new SistemaErrorTiposSafeosms());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    sistemaErrorTiposModalRef(component: Component, sistemaErrorTipos: SistemaErrorTiposSafeosms): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.sistemaErrorTipos = sistemaErrorTipos;
        modalRef.result.then((result) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true, queryParamsHandling: 'merge' });
            this.ngbModalRef = null;
        }, (reason) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true, queryParamsHandling: 'merge' });
            this.ngbModalRef = null;
        });
        return modalRef;
    }
}
