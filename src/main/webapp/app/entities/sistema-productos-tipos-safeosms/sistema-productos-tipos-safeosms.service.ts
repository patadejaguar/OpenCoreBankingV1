import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { SistemaProductosTiposSafeosms } from './sistema-productos-tipos-safeosms.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<SistemaProductosTiposSafeosms>;

@Injectable()
export class SistemaProductosTiposSafeosmsService {

    private resourceUrl =  SERVER_API_URL + 'api/sistema-productos-tipos';
    private resourceSearchUrl = SERVER_API_URL + 'api/_search/sistema-productos-tipos';

    constructor(private http: HttpClient) { }

    create(sistemaProductosTipos: SistemaProductosTiposSafeosms): Observable<EntityResponseType> {
        const copy = this.convert(sistemaProductosTipos);
        return this.http.post<SistemaProductosTiposSafeosms>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(sistemaProductosTipos: SistemaProductosTiposSafeosms): Observable<EntityResponseType> {
        const copy = this.convert(sistemaProductosTipos);
        return this.http.put<SistemaProductosTiposSafeosms>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<SistemaProductosTiposSafeosms>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<SistemaProductosTiposSafeosms[]>> {
        const options = createRequestOption(req);
        return this.http.get<SistemaProductosTiposSafeosms[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SistemaProductosTiposSafeosms[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    search(req?: any): Observable<HttpResponse<SistemaProductosTiposSafeosms[]>> {
        const options = createRequestOption(req);
        return this.http.get<SistemaProductosTiposSafeosms[]>(this.resourceSearchUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SistemaProductosTiposSafeosms[]>) => this.convertArrayResponse(res));
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: SistemaProductosTiposSafeosms = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<SistemaProductosTiposSafeosms[]>): HttpResponse<SistemaProductosTiposSafeosms[]> {
        const jsonResponse: SistemaProductosTiposSafeosms[] = res.body;
        const body: SistemaProductosTiposSafeosms[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to SistemaProductosTiposSafeosms.
     */
    private convertItemFromServer(sistemaProductosTipos: SistemaProductosTiposSafeosms): SistemaProductosTiposSafeosms {
        const copy: SistemaProductosTiposSafeosms = Object.assign({}, sistemaProductosTipos);
        return copy;
    }

    /**
     * Convert a SistemaProductosTiposSafeosms to a JSON which can be sent to the server.
     */
    private convert(sistemaProductosTipos: SistemaProductosTiposSafeosms): SistemaProductosTiposSafeosms {
        const copy: SistemaProductosTiposSafeosms = Object.assign({}, sistemaProductosTipos);
        return copy;
    }
}
