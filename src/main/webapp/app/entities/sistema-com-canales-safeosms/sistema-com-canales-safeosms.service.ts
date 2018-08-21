import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { SistemaComCanalesSafeosms } from './sistema-com-canales-safeosms.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<SistemaComCanalesSafeosms>;

@Injectable()
export class SistemaComCanalesSafeosmsService {

    private resourceUrl =  SERVER_API_URL + 'api/sistema-com-canales';
    private resourceSearchUrl = SERVER_API_URL + 'api/_search/sistema-com-canales';

    constructor(private http: HttpClient) { }

    create(sistemaComCanales: SistemaComCanalesSafeosms): Observable<EntityResponseType> {
        const copy = this.convert(sistemaComCanales);
        return this.http.post<SistemaComCanalesSafeosms>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(sistemaComCanales: SistemaComCanalesSafeosms): Observable<EntityResponseType> {
        const copy = this.convert(sistemaComCanales);
        return this.http.put<SistemaComCanalesSafeosms>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<SistemaComCanalesSafeosms>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<SistemaComCanalesSafeosms[]>> {
        const options = createRequestOption(req);
        return this.http.get<SistemaComCanalesSafeosms[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SistemaComCanalesSafeosms[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    search(req?: any): Observable<HttpResponse<SistemaComCanalesSafeosms[]>> {
        const options = createRequestOption(req);
        return this.http.get<SistemaComCanalesSafeosms[]>(this.resourceSearchUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SistemaComCanalesSafeosms[]>) => this.convertArrayResponse(res));
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: SistemaComCanalesSafeosms = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<SistemaComCanalesSafeosms[]>): HttpResponse<SistemaComCanalesSafeosms[]> {
        const jsonResponse: SistemaComCanalesSafeosms[] = res.body;
        const body: SistemaComCanalesSafeosms[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to SistemaComCanalesSafeosms.
     */
    private convertItemFromServer(sistemaComCanales: SistemaComCanalesSafeosms): SistemaComCanalesSafeosms {
        const copy: SistemaComCanalesSafeosms = Object.assign({}, sistemaComCanales);
        return copy;
    }

    /**
     * Convert a SistemaComCanalesSafeosms to a JSON which can be sent to the server.
     */
    private convert(sistemaComCanales: SistemaComCanalesSafeosms): SistemaComCanalesSafeosms {
        const copy: SistemaComCanalesSafeosms = Object.assign({}, sistemaComCanales);
        return copy;
    }
}
