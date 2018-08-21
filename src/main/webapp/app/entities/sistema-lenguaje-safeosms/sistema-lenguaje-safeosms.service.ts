import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { SistemaLenguajeSafeosms } from './sistema-lenguaje-safeosms.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<SistemaLenguajeSafeosms>;

@Injectable()
export class SistemaLenguajeSafeosmsService {

    private resourceUrl =  SERVER_API_URL + 'api/sistema-lenguajes';
    private resourceSearchUrl = SERVER_API_URL + 'api/_search/sistema-lenguajes';

    constructor(private http: HttpClient) { }

    create(sistemaLenguaje: SistemaLenguajeSafeosms): Observable<EntityResponseType> {
        const copy = this.convert(sistemaLenguaje);
        return this.http.post<SistemaLenguajeSafeosms>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(sistemaLenguaje: SistemaLenguajeSafeosms): Observable<EntityResponseType> {
        const copy = this.convert(sistemaLenguaje);
        return this.http.put<SistemaLenguajeSafeosms>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<SistemaLenguajeSafeosms>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<SistemaLenguajeSafeosms[]>> {
        const options = createRequestOption(req);
        return this.http.get<SistemaLenguajeSafeosms[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SistemaLenguajeSafeosms[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    search(req?: any): Observable<HttpResponse<SistemaLenguajeSafeosms[]>> {
        const options = createRequestOption(req);
        return this.http.get<SistemaLenguajeSafeosms[]>(this.resourceSearchUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SistemaLenguajeSafeosms[]>) => this.convertArrayResponse(res));
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: SistemaLenguajeSafeosms = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<SistemaLenguajeSafeosms[]>): HttpResponse<SistemaLenguajeSafeosms[]> {
        const jsonResponse: SistemaLenguajeSafeosms[] = res.body;
        const body: SistemaLenguajeSafeosms[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to SistemaLenguajeSafeosms.
     */
    private convertItemFromServer(sistemaLenguaje: SistemaLenguajeSafeosms): SistemaLenguajeSafeosms {
        const copy: SistemaLenguajeSafeosms = Object.assign({}, sistemaLenguaje);
        return copy;
    }

    /**
     * Convert a SistemaLenguajeSafeosms to a JSON which can be sent to the server.
     */
    private convert(sistemaLenguaje: SistemaLenguajeSafeosms): SistemaLenguajeSafeosms {
        const copy: SistemaLenguajeSafeosms = Object.assign({}, sistemaLenguaje);
        return copy;
    }
}
