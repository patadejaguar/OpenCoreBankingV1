import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { SistemaErrorLogSafeosms } from './sistema-error-log-safeosms.model';
import { SistemaErrorLogSafeosmsService } from './sistema-error-log-safeosms.service';

@Injectable()
export class SistemaErrorLogSafeosmsPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private sistemaErrorLogService: SistemaErrorLogSafeosmsService

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
                this.sistemaErrorLogService.find(id)
                    .subscribe((sistemaErrorLogResponse: HttpResponse<SistemaErrorLogSafeosms>) => {
                        const sistemaErrorLog: SistemaErrorLogSafeosms = sistemaErrorLogResponse.body;
                        this.ngbModalRef = this.sistemaErrorLogModalRef(component, sistemaErrorLog);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.sistemaErrorLogModalRef(component, new SistemaErrorLogSafeosms());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    sistemaErrorLogModalRef(component: Component, sistemaErrorLog: SistemaErrorLogSafeosms): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.sistemaErrorLog = sistemaErrorLog;
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
