import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { Safeosmsv2SistemaRolesSafeosmsModule } from './sistema-roles-safeosms/sistema-roles-safeosms.module';
import { Safeosmsv2SistemaConfiguracionSafeosmsModule } from './sistema-configuracion-safeosms/sistema-configuracion-safeosms.module';
import { Safeosmsv2SistemaCatalogoInternoSafeosmsModule } from './sistema-catalogo-interno-safeosms/sistema-catalogo-interno-safeosms.module';
import { Safeosmsv2SistemaNivelRiesgoSafeosmsModule } from './sistema-nivel-riesgo-safeosms/sistema-nivel-riesgo-safeosms.module';
import { Safeosmsv2SistemaMsjLargoSafeosmsModule } from './sistema-msj-largo-safeosms/sistema-msj-largo-safeosms.module';
import { Safeosmsv2SistemaErrorTiposSafeosmsModule } from './sistema-error-tipos-safeosms/sistema-error-tipos-safeosms.module';
import { Safeosmsv2SistemaComCanalesSafeosmsModule } from './sistema-com-canales-safeosms/sistema-com-canales-safeosms.module';
import { Safeosmsv2SistemaErrorLogSafeosmsModule } from './sistema-error-log-safeosms/sistema-error-log-safeosms.module';
import { Safeosmsv2SistemaLenguajeSafeosmsModule } from './sistema-lenguaje-safeosms/sistema-lenguaje-safeosms.module';
import { Safeosmsv2SistemaProductosTiposSafeosmsModule } from './sistema-productos-tipos-safeosms/sistema-productos-tipos-safeosms.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        Safeosmsv2SistemaRolesSafeosmsModule,
        Safeosmsv2SistemaConfiguracionSafeosmsModule,
        Safeosmsv2SistemaCatalogoInternoSafeosmsModule,
        Safeosmsv2SistemaNivelRiesgoSafeosmsModule,
        Safeosmsv2SistemaMsjLargoSafeosmsModule,
        Safeosmsv2SistemaErrorTiposSafeosmsModule,
        Safeosmsv2SistemaComCanalesSafeosmsModule,
        Safeosmsv2SistemaErrorLogSafeosmsModule,
        Safeosmsv2SistemaLenguajeSafeosmsModule,
        Safeosmsv2SistemaProductosTiposSafeosmsModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class Safeosmsv2EntityModule {}
