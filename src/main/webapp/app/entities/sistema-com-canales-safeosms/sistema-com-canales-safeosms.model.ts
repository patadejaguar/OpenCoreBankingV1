import { BaseEntity } from './../../shared';

export class SistemaComCanalesSafeosms implements BaseEntity {
    constructor(
        public id?: number,
        public comCanalesNom?: string,
        public comCanalesAlias?: string,
        public estatus?: number,
    ) {
    }
}
