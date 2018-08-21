import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaProductosTiposSafeosms } from './sistema-productos-tipos-safeosms.model';
import { SistemaProductosTiposSafeosmsService } from './sistema-productos-tipos-safeosms.service';

@Component({
    selector: 'jhi-sistema-productos-tipos-safeosms-detail',
    templateUrl: './sistema-productos-tipos-safeosms-detail.component.html'
})
export class SistemaProductosTiposSafeosmsDetailComponent implements OnInit, OnDestroy {

    sistemaProductosTipos: SistemaProductosTiposSafeosms;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private sistemaProductosTiposService: SistemaProductosTiposSafeosmsService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInSistemaProductosTipos();
    }

    load(id) {
        this.sistemaProductosTiposService.find(id)
            .subscribe((sistemaProductosTiposResponse: HttpResponse<SistemaProductosTiposSafeosms>) => {
                this.sistemaProductosTipos = sistemaProductosTiposResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInSistemaProductosTipos() {
        this.eventSubscriber = this.eventManager.subscribe(
            'sistemaProductosTiposListModification',
            (response) => this.load(this.sistemaProductosTipos.id)
        );
    }
}
