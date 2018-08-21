import { BaseEntity } from './../../shared';

export class SistemaMsjLargoSafeosms implements BaseEntity {
    constructor(
        public id?: number,
        public msjLargoNom?: string,
        public msjLargoTexto?: string,
        public estatus?: number,
    ) {
    }
}
