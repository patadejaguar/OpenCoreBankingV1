import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { SistemaLenguajeSafeosms } from './sistema-lenguaje-safeosms.model';
import { SistemaLenguajeSafeosmsService } from './sistema-lenguaje-safeosms.service';

@Injectable()
export class SistemaLenguajeSafeosmsPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private sistemaLenguajeService: SistemaLenguajeSafeosmsService

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
                this.sistemaLenguajeService.find(id)
                    .subscribe((sistemaLenguajeResponse: HttpResponse<SistemaLenguajeSafeosms>) => {
                        const sistemaLenguaje: SistemaLenguajeSafeosms = sistemaLenguajeResponse.body;
                        this.ngbModalRef = this.sistemaLenguajeModalRef(component, sistemaLenguaje);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.sistemaLenguajeModalRef(component, new SistemaLenguajeSafeosms());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    sistemaLenguajeModalRef(component: Component, sistemaLenguaje: SistemaLenguajeSafeosms): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.sistemaLenguaje = sistemaLenguaje;
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
