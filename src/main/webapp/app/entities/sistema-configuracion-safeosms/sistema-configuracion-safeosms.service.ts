import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { SistemaConfiguracionSafeosms } from './sistema-configuracion-safeosms.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<SistemaConfiguracionSafeosms>;

@Injectable()
export class SistemaConfiguracionSafeosmsService {

    private resourceUrl =  SERVER_API_URL + 'api/sistema-configuracions';
    private resourceSearchUrl = SERVER_API_URL + 'api/_search/sistema-configuracions';

    constructor(private http: HttpClient) { }

    create(sistemaConfiguracion: SistemaConfiguracionSafeosms): Observable<EntityResponseType> {
        const copy = this.convert(sistemaConfiguracion);
        return this.http.post<SistemaConfiguracionSafeosms>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(sistemaConfiguracion: SistemaConfiguracionSafeosms): Observable<EntityResponseType> {
        const copy = this.convert(sistemaConfiguracion);
        return this.http.put<SistemaConfiguracionSafeosms>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<SistemaConfiguracionSafeosms>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<SistemaConfiguracionSafeosms[]>> {
        const options = createRequestOption(req);
        return this.http.get<SistemaConfiguracionSafeosms[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SistemaConfiguracionSafeosms[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    search(req?: any): Observable<HttpResponse<SistemaConfiguracionSafeosms[]>> {
        const options = createRequestOption(req);
        return this.http.get<SistemaConfiguracionSafeosms[]>(this.resourceSearchUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SistemaConfiguracionSafeosms[]>) => this.convertArrayResponse(res));
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: SistemaConfiguracionSafeosms = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<SistemaConfiguracionSafeosms[]>): HttpResponse<SistemaConfiguracionSafeosms[]> {
        const jsonResponse: SistemaConfiguracionSafeosms[] = res.body;
        const body: SistemaConfiguracionSafeosms[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to SistemaConfiguracionSafeosms.
     */
    private convertItemFromServer(sistemaConfiguracion: SistemaConfiguracionSafeosms): SistemaConfiguracionSafeosms {
        const copy: SistemaConfiguracionSafeosms = Object.assign({}, sistemaConfiguracion);
        return copy;
    }

    /**
     * Convert a SistemaConfiguracionSafeosms to a JSON which can be sent to the server.
     */
    private convert(sistemaConfiguracion: SistemaConfiguracionSafeosms): SistemaConfiguracionSafeosms {
        const copy: SistemaConfiguracionSafeosms = Object.assign({}, sistemaConfiguracion);
        return copy;
    }
}
