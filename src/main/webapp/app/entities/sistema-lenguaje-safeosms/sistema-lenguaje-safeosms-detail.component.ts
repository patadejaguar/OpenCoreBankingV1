import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaLenguajeSafeosms } from './sistema-lenguaje-safeosms.model';
import { SistemaLenguajeSafeosmsService } from './sistema-lenguaje-safeosms.service';

@Component({
    selector: 'jhi-sistema-lenguaje-safeosms-detail',
    templateUrl: './sistema-lenguaje-safeosms-detail.component.html'
})
export class SistemaLenguajeSafeosmsDetailComponent implements OnInit, OnDestroy {

    sistemaLenguaje: SistemaLenguajeSafeosms;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private sistemaLenguajeService: SistemaLenguajeSafeosmsService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInSistemaLenguajes();
    }

    load(id) {
        this.sistemaLenguajeService.find(id)
            .subscribe((sistemaLenguajeResponse: HttpResponse<SistemaLenguajeSafeosms>) => {
                this.sistemaLenguaje = sistemaLenguajeResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInSistemaLenguajes() {
        this.eventSubscriber = this.eventManager.subscribe(
            'sistemaLenguajeListModification',
            (response) => this.load(this.sistemaLenguaje.id)
        );
    }
}
