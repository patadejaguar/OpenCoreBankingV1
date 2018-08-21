import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiDataUtils } from 'ng-jhipster';

import { SistemaErrorLogSafeosms } from './sistema-error-log-safeosms.model';
import { SistemaErrorLogSafeosmsService } from './sistema-error-log-safeosms.service';

@Component({
    selector: 'jhi-sistema-error-log-safeosms-detail',
    templateUrl: './sistema-error-log-safeosms-detail.component.html'
})
export class SistemaErrorLogSafeosmsDetailComponent implements OnInit, OnDestroy {

    sistemaErrorLog: SistemaErrorLogSafeosms;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private dataUtils: JhiDataUtils,
        private sistemaErrorLogService: SistemaErrorLogSafeosmsService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInSistemaErrorLogs();
    }

    load(id) {
        this.sistemaErrorLogService.find(id)
            .subscribe((sistemaErrorLogResponse: HttpResponse<SistemaErrorLogSafeosms>) => {
                this.sistemaErrorLog = sistemaErrorLogResponse.body;
            });
    }
    byteSize(field) {
        return this.dataUtils.byteSize(field);
    }

    openFile(contentType, field) {
        return this.dataUtils.openFile(contentType, field);
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInSistemaErrorLogs() {
        this.eventSubscriber = this.eventManager.subscribe(
            'sistemaErrorLogListModification',
            (response) => this.load(this.sistemaErrorLog.id)
        );
    }
}
