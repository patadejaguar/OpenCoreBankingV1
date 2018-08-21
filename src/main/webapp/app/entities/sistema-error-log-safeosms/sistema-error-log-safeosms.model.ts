import { BaseEntity } from './../../shared';

export class SistemaErrorLogSafeosms implements BaseEntity {
    constructor(
        public id?: number,
        public uuidorigen?: string,
        public errorLogTextContentType?: string,
        public errorLogText?: any,
        public entidadid?: number,
        public personasid?: number,
        public contratosid?: number,
        public recibosid?: number,
        public iplocal?: string,
        public ipproxy?: string,
        public ippublic?: string,
        public usuariosid?: number,
        public tiempo?: number,
        public estatus?: number,
        public errorTiposidId?: number,
    ) {
    }
}
