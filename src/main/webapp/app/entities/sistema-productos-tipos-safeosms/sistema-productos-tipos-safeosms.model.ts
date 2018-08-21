import { BaseEntity } from './../../shared';

export class SistemaProductosTiposSafeosms implements BaseEntity {
    constructor(
        public id?: number,
        public lenguajeID?: string,
        public lenguajeVal?: string,
    ) {
    }
}
