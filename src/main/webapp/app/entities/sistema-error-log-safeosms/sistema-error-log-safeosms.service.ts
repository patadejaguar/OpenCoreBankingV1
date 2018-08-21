import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { SistemaErrorLogSafeosms } from './sistema-error-log-safeosms.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<SistemaErrorLogSafeosms>;

@Injectable()
export class SistemaErrorLogSafeosmsService {

    private resourceUrl =  SERVER_API_URL + 'api/sistema-error-logs';
    private resourceSearchUrl = SERVER_API_URL + 'api/_search/sistema-error-logs';

    constructor(private http: HttpClient) { }

    create(sistemaErrorLog: SistemaErrorLogSafeosms): Observable<EntityResponseType> {
        const copy = this.convert(sistemaErrorLog);
        return this.http.post<SistemaErrorLogSafeosms>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(sistemaErrorLog: SistemaErrorLogSafeosms): Observable<EntityResponseType> {
        const copy = this.convert(sistemaErrorLog);
        return this.http.put<SistemaErrorLogSafeosms>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<SistemaErrorLogSafeosms>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<SistemaErrorLogSafeosms[]>> {
        const options = createRequestOption(req);
        return this.http.get<SistemaErrorLogSafeosms[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SistemaErrorLogSafeosms[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    search(req?: any): Observable<HttpResponse<SistemaErrorLogSafeosms[]>> {
        const options = createRequestOption(req);
        return this.http.get<SistemaErrorLogSafeosms[]>(this.resourceSearchUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SistemaErrorLogSafeosms[]>) => this.convertArrayResponse(res));
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: SistemaErrorLogSafeosms = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<SistemaErrorLogSafeosms[]>): HttpResponse<SistemaErrorLogSafeosms[]> {
        const jsonResponse: SistemaErrorLogSafeosms[] = res.body;
        const body: SistemaErrorLogSafeosms[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to SistemaErrorLogSafeosms.
     */
    private convertItemFromServer(sistemaErrorLog: SistemaErrorLogSafeosms): SistemaErrorLogSafeosms {
        const copy: SistemaErrorLogSafeosms = Object.assign({}, sistemaErrorLog);
        return copy;
    }

    /**
     * Convert a SistemaErrorLogSafeosms to a JSON which can be sent to the server.
     */
    private convert(sistemaErrorLog: SistemaErrorLogSafeosms): SistemaErrorLogSafeosms {
        const copy: SistemaErrorLogSafeosms = Object.assign({}, sistemaErrorLog);
        return copy;
    }
}
