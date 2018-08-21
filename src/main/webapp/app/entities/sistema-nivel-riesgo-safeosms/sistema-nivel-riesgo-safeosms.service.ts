import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { SistemaNivelRiesgoSafeosms } from './sistema-nivel-riesgo-safeosms.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<SistemaNivelRiesgoSafeosms>;

@Injectable()
export class SistemaNivelRiesgoSafeosmsService {

    private resourceUrl =  SERVER_API_URL + 'api/sistema-nivel-riesgos';
    private resourceSearchUrl = SERVER_API_URL + 'api/_search/sistema-nivel-riesgos';

    constructor(private http: HttpClient) { }

    create(sistemaNivelRiesgo: SistemaNivelRiesgoSafeosms): Observable<EntityResponseType> {
        const copy = this.convert(sistemaNivelRiesgo);
        return this.http.post<SistemaNivelRiesgoSafeosms>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(sistemaNivelRiesgo: SistemaNivelRiesgoSafeosms): Observable<EntityResponseType> {
        const copy = this.convert(sistemaNivelRiesgo);
        return this.http.put<SistemaNivelRiesgoSafeosms>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<SistemaNivelRiesgoSafeosms>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<SistemaNivelRiesgoSafeosms[]>> {
        const options = createRequestOption(req);
        return this.http.get<SistemaNivelRiesgoSafeosms[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SistemaNivelRiesgoSafeosms[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    search(req?: any): Observable<HttpResponse<SistemaNivelRiesgoSafeosms[]>> {
        const options = createRequestOption(req);
        return this.http.get<SistemaNivelRiesgoSafeosms[]>(this.resourceSearchUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SistemaNivelRiesgoSafeosms[]>) => this.convertArrayResponse(res));
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: SistemaNivelRiesgoSafeosms = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<SistemaNivelRiesgoSafeosms[]>): HttpResponse<SistemaNivelRiesgoSafeosms[]> {
        const jsonResponse: SistemaNivelRiesgoSafeosms[] = res.body;
        const body: SistemaNivelRiesgoSafeosms[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to SistemaNivelRiesgoSafeosms.
     */
    private convertItemFromServer(sistemaNivelRiesgo: SistemaNivelRiesgoSafeosms): SistemaNivelRiesgoSafeosms {
        const copy: SistemaNivelRiesgoSafeosms = Object.assign({}, sistemaNivelRiesgo);
        return copy;
    }

    /**
     * Convert a SistemaNivelRiesgoSafeosms to a JSON which can be sent to the server.
     */
    private convert(sistemaNivelRiesgo: SistemaNivelRiesgoSafeosms): SistemaNivelRiesgoSafeosms {
        const copy: SistemaNivelRiesgoSafeosms = Object.assign({}, sistemaNivelRiesgo);
        return copy;
    }
}
