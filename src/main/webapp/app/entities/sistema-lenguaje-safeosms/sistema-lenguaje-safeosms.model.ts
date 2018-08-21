import { BaseEntity } from './../../shared';

export class SistemaLenguajeSafeosms implements BaseEntity {
    constructor(
        public id?: number,
        public lenguajeID?: string,
        public lenguajeVal?: string,
    ) {
    }
}
