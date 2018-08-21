import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaComCanalesSafeosms } from './sistema-com-canales-safeosms.model';
import { SistemaComCanalesSafeosmsService } from './sistema-com-canales-safeosms.service';

@Component({
    selector: 'jhi-sistema-com-canales-safeosms-detail',
    templateUrl: './sistema-com-canales-safeosms-detail.component.html'
})
export class SistemaComCanalesSafeosmsDetailComponent implements OnInit, OnDestroy {

    sistemaComCanales: SistemaComCanalesSafeosms;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private sistemaComCanalesService: SistemaComCanalesSafeosmsService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInSistemaComCanales();
    }

    load(id) {
        this.sistemaComCanalesService.find(id)
            .subscribe((sistemaComCanalesResponse: HttpResponse<SistemaComCanalesSafeosms>) => {
                this.sistemaComCanales = sistemaComCanalesResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInSistemaComCanales() {
        this.eventSubscriber = this.eventManager.subscribe(
            'sistemaComCanalesListModification',
            (response) => this.load(this.sistemaComCanales.id)
        );
    }
}
