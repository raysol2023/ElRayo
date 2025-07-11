package com.elrayo.entidad;

import com.elrayo.modelo.IReportable;

public class CierreCentral implements IReportable {
    @Override
    public String generarReporte() {
        return "📊 Reporte de cierre central generado.";
    }
}
