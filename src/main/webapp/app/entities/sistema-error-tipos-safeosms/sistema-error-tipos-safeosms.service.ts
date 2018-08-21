import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { SistemaErrorTiposSafeosms } from './sistema-error-tipos-safeosms.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<SistemaErrorTiposSafeosms>;

@Injectable()
export class SistemaErrorTiposSafeosmsService {

    private resourceUrl =  SERVER_API_URL + 'api/sistema-error-tipos';
    private resourceSearchUrl = SERVER_API_URL + 'api/_search/sistema-error-tipos';

    constructor(private http: HttpClient) { }

    create(sistemaErrorTipos: SistemaErrorTiposSafeosms): Observable<EntityResponseType> {
        const copy = this.convert(sistemaErrorTipos);
        return this.http.post<SistemaErrorTiposSafeosms>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(sistemaErrorTipos: SistemaErrorTiposSafeosms): Observable<EntityResponseType> {
        const copy = this.convert(sistemaErrorTipos);
        return this.http.put<SistemaErrorTiposSafeosms>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<SistemaErrorTiposSafeosms>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<SistemaErrorTiposSafeosms[]>> {
        const options = createRequestOption(req);
        return this.http.get<SistemaErrorTiposSafeosms[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SistemaErrorTiposSafeosms[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    search(req?: any): Observable<HttpResponse<SistemaErrorTiposSafeosms[]>> {
        const options = createRequestOption(req);
        return this.http.get<SistemaErrorTiposSafeosms[]>(this.resourceSearchUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SistemaErrorTiposSafeosms[]>) => this.convertArrayResponse(res));
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: SistemaErrorTiposSafeosms = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<SistemaErrorTiposSafeosms[]>): HttpResponse<SistemaErrorTiposSafeosms[]> {
        const jsonResponse: SistemaErrorTiposSafeosms[] = res.body;
        const body: SistemaErrorTiposSafeosms[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to SistemaErrorTiposSafeosms.
     */
    private convertItemFromServer(sistemaErrorTipos: SistemaErrorTiposSafeosms): SistemaErrorTiposSafeosms {
        const copy: SistemaErrorTiposSafeosms = Object.assign({}, sistemaErrorTipos);
        return copy;
    }

    /**
     * Convert a SistemaErrorTiposSafeosms to a JSON which can be sent to the server.
     */
    private convert(sistemaErrorTipos: SistemaErrorTiposSafeosms): SistemaErrorTiposSafeosms {
        const copy: SistemaErrorTiposSafeosms = Object.assign({}, sistemaErrorTipos);
        return copy;
    }
}
