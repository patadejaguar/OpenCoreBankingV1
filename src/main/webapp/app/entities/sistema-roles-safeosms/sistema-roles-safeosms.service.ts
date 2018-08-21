import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { SistemaRolesSafeosms } from './sistema-roles-safeosms.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<SistemaRolesSafeosms>;

@Injectable()
export class SistemaRolesSafeosmsService {

    private resourceUrl =  SERVER_API_URL + 'api/sistema-roles';
    private resourceSearchUrl = SERVER_API_URL + 'api/_search/sistema-roles';

    constructor(private http: HttpClient) { }

    create(sistemaRoles: SistemaRolesSafeosms): Observable<EntityResponseType> {
        const copy = this.convert(sistemaRoles);
        return this.http.post<SistemaRolesSafeosms>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(sistemaRoles: SistemaRolesSafeosms): Observable<EntityResponseType> {
        const copy = this.convert(sistemaRoles);
        return this.http.put<SistemaRolesSafeosms>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<SistemaRolesSafeosms>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<SistemaRolesSafeosms[]>> {
        const options = createRequestOption(req);
        return this.http.get<SistemaRolesSafeosms[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SistemaRolesSafeosms[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    search(req?: any): Observable<HttpResponse<SistemaRolesSafeosms[]>> {
        const options = createRequestOption(req);
        return this.http.get<SistemaRolesSafeosms[]>(this.resourceSearchUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SistemaRolesSafeosms[]>) => this.convertArrayResponse(res));
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: SistemaRolesSafeosms = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<SistemaRolesSafeosms[]>): HttpResponse<SistemaRolesSafeosms[]> {
        const jsonResponse: SistemaRolesSafeosms[] = res.body;
        const body: SistemaRolesSafeosms[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to SistemaRolesSafeosms.
     */
    private convertItemFromServer(sistemaRoles: SistemaRolesSafeosms): SistemaRolesSafeosms {
        const copy: SistemaRolesSafeosms = Object.assign({}, sistemaRoles);
        return copy;
    }

    /**
     * Convert a SistemaRolesSafeosms to a JSON which can be sent to the server.
     */
    private convert(sistemaRoles: SistemaRolesSafeosms): SistemaRolesSafeosms {
        const copy: SistemaRolesSafeosms = Object.assign({}, sistemaRoles);
        return copy;
    }
}
