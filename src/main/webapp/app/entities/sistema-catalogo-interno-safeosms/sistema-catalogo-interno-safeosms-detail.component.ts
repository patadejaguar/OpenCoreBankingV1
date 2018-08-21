import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaCatalogoInternoSafeosms } from './sistema-catalogo-interno-safeosms.model';
import { SistemaCatalogoInternoSafeosmsService } from './sistema-catalogo-interno-safeosms.service';

@Component({
    selector: 'jhi-sistema-catalogo-interno-safeosms-detail',
    templateUrl: './sistema-catalogo-interno-safeosms-detail.component.html'
})
export class SistemaCatalogoInternoSafeosmsDetailComponent implements OnInit, OnDestroy {

    sistemaCatalogoInterno: SistemaCatalogoInternoSafeosms;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private sistemaCatalogoInternoService: SistemaCatalogoInternoSafeosmsService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInSistemaCatalogoInternos();
    }

    load(id) {
        this.sistemaCatalogoInternoService.find(id)
            .subscribe((sistemaCatalogoInternoResponse: HttpResponse<SistemaCatalogoInternoSafeosms>) => {
                this.sistemaCatalogoInterno = sistemaCatalogoInternoResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInSistemaCatalogoInternos() {
        this.eventSubscriber = this.eventManager.subscribe(
            'sistemaCatalogoInternoListModification',
            (response) => this.load(this.sistemaCatalogoInterno.id)
        );
    }
}
