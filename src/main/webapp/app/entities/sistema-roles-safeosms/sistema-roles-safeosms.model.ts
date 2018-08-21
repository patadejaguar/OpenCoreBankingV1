import { BaseEntity } from './../../shared';

export class SistemaRolesSafeosms implements BaseEntity {
    constructor(
        public id?: number,
        public rolesid?: number,
        public tipoEnSistemaid?: number,
        public estatus?: number,
    ) {
    }
}
