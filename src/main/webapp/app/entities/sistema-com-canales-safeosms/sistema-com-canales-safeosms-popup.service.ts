import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { SistemaComCanalesSafeosms } from './sistema-com-canales-safeosms.model';
import { SistemaComCanalesSafeosmsService } from './sistema-com-canales-safeosms.service';

@Injectable()
export class SistemaComCanalesSafeosmsPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private sistemaComCanalesService: SistemaComCanalesSafeosmsService

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
                this.sistemaComCanalesService.find(id)
                    .subscribe((sistemaComCanalesResponse: HttpResponse<SistemaComCanalesSafeosms>) => {
                        const sistemaComCanales: SistemaComCanalesSafeosms = sistemaComCanalesResponse.body;
                        this.ngbModalRef = this.sistemaComCanalesModalRef(component, sistemaComCanales);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.sistemaComCanalesModalRef(component, new SistemaComCanalesSafeosms());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    sistemaComCanalesModalRef(component: Component, sistemaComCanales: SistemaComCanalesSafeosms): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.sistemaComCanales = sistemaComCanales;
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
