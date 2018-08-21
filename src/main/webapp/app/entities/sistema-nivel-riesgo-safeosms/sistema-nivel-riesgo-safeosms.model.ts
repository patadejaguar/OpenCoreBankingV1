import { BaseEntity } from './../../shared';

export class SistemaNivelRiesgoSafeosms implements BaseEntity {
    constructor(
        public id?: number,
        public nivelRiesgoNom?: string,
        public nivelRiesgoAlias?: string,
        public estatus?: number,
    ) {
    }
}
