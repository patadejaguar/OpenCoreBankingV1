import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaNivelRiesgoSafeosms } from './sistema-nivel-riesgo-safeosms.model';
import { SistemaNivelRiesgoSafeosmsService } from './sistema-nivel-riesgo-safeosms.service';

@Component({
    selector: 'jhi-sistema-nivel-riesgo-safeosms-detail',
    templateUrl: './sistema-nivel-riesgo-safeosms-detail.component.html'
})
export class SistemaNivelRiesgoSafeosmsDetailComponent implements OnInit, OnDestroy {

    sistemaNivelRiesgo: SistemaNivelRiesgoSafeosms;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private sistemaNivelRiesgoService: SistemaNivelRiesgoSafeosmsService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInSistemaNivelRiesgos();
    }

    load(id) {
        this.sistemaNivelRiesgoService.find(id)
            .subscribe((sistemaNivelRiesgoResponse: HttpResponse<SistemaNivelRiesgoSafeosms>) => {
                this.sistemaNivelRiesgo = sistemaNivelRiesgoResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInSistemaNivelRiesgos() {
        this.eventSubscriber = this.eventManager.subscribe(
            'sistemaNivelRiesgoListModification',
            (response) => this.load(this.sistemaNivelRiesgo.id)
        );
    }
}
