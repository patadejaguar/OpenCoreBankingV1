import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { SistemaCatalogoInternoSafeosms } from './sistema-catalogo-interno-safeosms.model';
import { SistemaCatalogoInternoSafeosmsService } from './sistema-catalogo-interno-safeosms.service';

@Injectable()
export class SistemaCatalogoInternoSafeosmsPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private sistemaCatalogoInternoService: SistemaCatalogoInternoSafeosmsService

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
                this.sistemaCatalogoInternoService.find(id)
                    .subscribe((sistemaCatalogoInternoResponse: HttpResponse<SistemaCatalogoInternoSafeosms>) => {
                        const sistemaCatalogoInterno: SistemaCatalogoInternoSafeosms = sistemaCatalogoInternoResponse.body;
                        this.ngbModalRef = this.sistemaCatalogoInternoModalRef(component, sistemaCatalogoInterno);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.sistemaCatalogoInternoModalRef(component, new SistemaCatalogoInternoSafeosms());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    sistemaCatalogoInternoModalRef(component: Component, sistemaCatalogoInterno: SistemaCatalogoInternoSafeosms): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.sistemaCatalogoInterno = sistemaCatalogoInterno;
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
