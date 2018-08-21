import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { SistemaMsjLargoSafeosms } from './sistema-msj-largo-safeosms.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<SistemaMsjLargoSafeosms>;

@Injectable()
export class SistemaMsjLargoSafeosmsService {

    private resourceUrl =  SERVER_API_URL + 'api/sistema-msj-largos';
    private resourceSearchUrl = SERVER_API_URL + 'api/_search/sistema-msj-largos';

    constructor(private http: HttpClient) { }

    create(sistemaMsjLargo: SistemaMsjLargoSafeosms): Observable<EntityResponseType> {
        const copy = this.convert(sistemaMsjLargo);
        return this.http.post<SistemaMsjLargoSafeosms>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(sistemaMsjLargo: SistemaMsjLargoSafeosms): Observable<EntityResponseType> {
        const copy = this.convert(sistemaMsjLargo);
        return this.http.put<SistemaMsjLargoSafeosms>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<SistemaMsjLargoSafeosms>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<SistemaMsjLargoSafeosms[]>> {
        const options = createRequestOption(req);
        return this.http.get<SistemaMsjLargoSafeosms[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SistemaMsjLargoSafeosms[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    search(req?: any): Observable<HttpResponse<SistemaMsjLargoSafeosms[]>> {
        const options = createRequestOption(req);
        return this.http.get<SistemaMsjLargoSafeosms[]>(this.resourceSearchUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SistemaMsjLargoSafeosms[]>) => this.convertArrayResponse(res));
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: SistemaMsjLargoSafeosms = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<SistemaMsjLargoSafeosms[]>): HttpResponse<SistemaMsjLargoSafeosms[]> {
        const jsonResponse: SistemaMsjLargoSafeosms[] = res.body;
        const body: SistemaMsjLargoSafeosms[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to SistemaMsjLargoSafeosms.
     */
    private convertItemFromServer(sistemaMsjLargo: SistemaMsjLargoSafeosms): SistemaMsjLargoSafeosms {
        const copy: SistemaMsjLargoSafeosms = Object.assign({}, sistemaMsjLargo);
        return copy;
    }

    /**
     * Convert a SistemaMsjLargoSafeosms to a JSON which can be sent to the server.
     */
    private convert(sistemaMsjLargo: SistemaMsjLargoSafeosms): SistemaMsjLargoSafeosms {
        const copy: SistemaMsjLargoSafeosms = Object.assign({}, sistemaMsjLargo);
        return copy;
    }
}
