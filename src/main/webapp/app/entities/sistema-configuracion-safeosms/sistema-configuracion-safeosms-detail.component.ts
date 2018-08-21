import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaConfiguracionSafeosms } from './sistema-configuracion-safeosms.model';
import { SistemaConfiguracionSafeosmsService } from './sistema-configuracion-safeosms.service';

@Component({
    selector: 'jhi-sistema-configuracion-safeosms-detail',
    templateUrl: './sistema-configuracion-safeosms-detail.component.html'
})
export class SistemaConfiguracionSafeosmsDetailComponent implements OnInit, OnDestroy {

    sistemaConfiguracion: SistemaConfiguracionSafeosms;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private sistemaConfiguracionService: SistemaConfiguracionSafeosmsService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInSistemaConfiguracions();
    }

    load(id) {
        this.sistemaConfiguracionService.find(id)
            .subscribe((sistemaConfiguracionResponse: HttpResponse<SistemaConfiguracionSafeosms>) => {
                this.sistemaConfiguracion = sistemaConfiguracionResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInSistemaConfiguracions() {
        this.eventSubscriber = this.eventManager.subscribe(
            'sistemaConfiguracionListModification',
            (response) => this.load(this.sistemaConfiguracion.id)
        );
    }
}
