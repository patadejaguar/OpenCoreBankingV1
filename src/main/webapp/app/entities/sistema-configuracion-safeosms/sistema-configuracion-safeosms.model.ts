import { BaseEntity } from './../../shared';

export class SistemaConfiguracionSafeosms implements BaseEntity {
    constructor(
        public id?: number,
        public configuracionNom?: string,
        public configuracionTipo?: string,
        public configuracionVal?: string,
        public estatus?: number,
    ) {
    }
}
