import { BaseEntity } from './../../shared';

export class SistemaErrorTiposSafeosms implements BaseEntity {
    constructor(
        public id?: number,
        public errorTiposNom?: string,
        public errorTiposAlias?: string,
        public estatus?: number,
    ) {
    }
}
