import { BaseEntity } from './../../shared';

export class SistemaCatalogoInternoSafeosms implements BaseEntity {
    constructor(
        public id?: number,
        public catalogoInternoTbl?: string,
        public catalogoInternoNom?: string,
        public catalogoInternoVal?: string,
        public estatus?: number,
    ) {
    }
}
