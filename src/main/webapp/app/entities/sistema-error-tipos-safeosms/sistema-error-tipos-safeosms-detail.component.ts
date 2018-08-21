import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaErrorTiposSafeosms } from './sistema-error-tipos-safeosms.model';
import { SistemaErrorTiposSafeosmsService } from './sistema-error-tipos-safeosms.service';

@Component({
    selector: 'jhi-sistema-error-tipos-safeosms-detail',
    templateUrl: './sistema-error-tipos-safeosms-detail.component.html'
})
export class SistemaErrorTiposSafeosmsDetailComponent implements OnInit, OnDestroy {

    sistemaErrorTipos: SistemaErrorTiposSafeosms;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private sistemaErrorTiposService: SistemaErrorTiposSafeosmsService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInSistemaErrorTipos();
    }

    load(id) {
        this.sistemaErrorTiposService.find(id)
            .subscribe((sistemaErrorTiposResponse: HttpResponse<SistemaErrorTiposSafeosms>) => {
                this.sistemaErrorTipos = sistemaErrorTiposResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInSistemaErrorTipos() {
        this.eventSubscriber = this.eventManager.subscribe(
            'sistemaErrorTiposListModification',
            (response) => this.load(this.sistemaErrorTipos.id)
        );
    }
}
