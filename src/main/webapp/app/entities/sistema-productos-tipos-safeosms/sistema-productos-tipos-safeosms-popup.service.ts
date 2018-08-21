import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { SistemaProductosTiposSafeosms } from './sistema-productos-tipos-safeosms.model';
import { SistemaProductosTiposSafeosmsService } from './sistema-productos-tipos-safeosms.service';

@Injectable()
export class SistemaProductosTiposSafeosmsPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private sistemaProductosTiposService: SistemaProductosTiposSafeosmsService

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
                this.sistemaProductosTiposService.find(id)
                    .subscribe((sistemaProductosTiposResponse: HttpResponse<SistemaProductosTiposSafeosms>) => {
                        const sistemaProductosTipos: SistemaProductosTiposSafeosms = sistemaProductosTiposResponse.body;
                        this.ngbModalRef = this.sistemaProductosTiposModalRef(component, sistemaProductosTipos);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.sistemaProductosTiposModalRef(component, new SistemaProductosTiposSafeosms());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    sistemaProductosTiposModalRef(component: Component, sistemaProductosTipos: SistemaProductosTiposSafeosms): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.sistemaProductosTipos = sistemaProductosTipos;
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
