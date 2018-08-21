import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { SistemaNivelRiesgoSafeosms } from './sistema-nivel-riesgo-safeosms.model';
import { SistemaNivelRiesgoSafeosmsService } from './sistema-nivel-riesgo-safeosms.service';

@Injectable()
export class SistemaNivelRiesgoSafeosmsPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private sistemaNivelRiesgoService: SistemaNivelRiesgoSafeosmsService

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
                this.sistemaNivelRiesgoService.find(id)
                    .subscribe((sistemaNivelRiesgoResponse: HttpResponse<SistemaNivelRiesgoSafeosms>) => {
                        const sistemaNivelRiesgo: SistemaNivelRiesgoSafeosms = sistemaNivelRiesgoResponse.body;
                        this.ngbModalRef = this.sistemaNivelRiesgoModalRef(component, sistemaNivelRiesgo);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.sistemaNivelRiesgoModalRef(component, new SistemaNivelRiesgoSafeosms());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    sistemaNivelRiesgoModalRef(component: Component, sistemaNivelRiesgo: SistemaNivelRiesgoSafeosms): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.sistemaNivelRiesgo = sistemaNivelRiesgo;
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
