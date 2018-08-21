import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { SistemaMsjLargoSafeosms } from './sistema-msj-largo-safeosms.model';
import { SistemaMsjLargoSafeosmsService } from './sistema-msj-largo-safeosms.service';

@Component({
    selector: 'jhi-sistema-msj-largo-safeosms-detail',
    templateUrl: './sistema-msj-largo-safeosms-detail.component.html'
})
export class SistemaMsjLargoSafeosmsDetailComponent implements OnInit, OnDestroy {

    sistemaMsjLargo: SistemaMsjLargoSafeosms;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private sistemaMsjLargoService: SistemaMsjLargoSafeosmsService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInSistemaMsjLargos();
    }

    load(id) {
        this.sistemaMsjLargoService.find(id)
            .subscribe((sistemaMsjLargoResponse: HttpResponse<SistemaMsjLargoSafeosms>) => {
                this.sistemaMsjLargo = sistemaMsjLargoResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInSistemaMsjLargos() {
        this.eventSubscriber = this.eventManager.subscribe(
            'sistemaMsjLargoListModification',
            (response) => this.load(this.sistemaMsjLargo.id)
        );
    }
}
