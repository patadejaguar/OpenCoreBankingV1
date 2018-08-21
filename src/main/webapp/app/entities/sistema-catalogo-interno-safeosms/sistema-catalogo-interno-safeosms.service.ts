import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { SistemaCatalogoInternoSafeosms } from './sistema-catalogo-interno-safeosms.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<SistemaCatalogoInternoSafeosms>;

@Injectable()
export class SistemaCatalogoInternoSafeosmsService {

    private resourceUrl =  SERVER_API_URL + 'api/sistema-catalogo-internos';
    private resourceSearchUrl = SERVER_API_URL + 'api/_search/sistema-catalogo-internos';

    constructor(private http: HttpClient) { }

    create(sistemaCatalogoInterno: SistemaCatalogoInternoSafeosms): Observable<EntityResponseType> {
        const copy = this.convert(sistemaCatalogoInterno);
        return this.http.post<SistemaCatalogoInternoSafeosms>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(sistemaCatalogoInterno: SistemaCatalogoInternoSafeosms): Observable<EntityResponseType> {
        const copy = this.convert(sistemaCatalogoInterno);
        return this.http.put<SistemaCatalogoInternoSafeosms>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<SistemaCatalogoInternoSafeosms>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<SistemaCatalogoInternoSafeosms[]>> {
        const options = createRequestOption(req);
        return this.http.get<SistemaCatalogoInternoSafeosms[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SistemaCatalogoInternoSafeosms[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    search(req?: any): Observable<HttpResponse<SistemaCatalogoInternoSafeosms[]>> {
        const options = createRequestOption(req);
        return this.http.get<SistemaCatalogoInternoSafeosms[]>(this.resourceSearchUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SistemaCatalogoInternoSafeosms[]>) => this.convertArrayResponse(res));
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: SistemaCatalogoInternoSafeosms = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<SistemaCatalogoInternoSafeosms[]>): HttpResponse<SistemaCatalogoInternoSafeosms[]> {
        const jsonResponse: SistemaCatalogoInternoSafeosms[] = res.body;
        const body: SistemaCatalogoInternoSafeosms[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to SistemaCatalogoInternoSafeosms.
     */
    private convertItemFromServer(sistemaCatalogoInterno: SistemaCatalogoInternoSafeosms): SistemaCatalogoInternoSafeosms {
        const copy: SistemaCatalogoInternoSafeosms = Object.assign({}, sistemaCatalogoInterno);
        return copy;
    }

    /**
     * Convert a SistemaCatalogoInternoSafeosms to a JSON which can be sent to the server.
     */
    private convert(sistemaCatalogoInterno: SistemaCatalogoInternoSafeosms): SistemaCatalogoInternoSafeosms {
        const copy: SistemaCatalogoInternoSafeosms = Object.assign({}, sistemaCatalogoInterno);
        return copy;
    }
}
