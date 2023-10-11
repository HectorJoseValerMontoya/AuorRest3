/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author HJVM
 */
public class Mesa {
    private int codMesa;
    private String descripcion;
    private int estadoMesa;

    public int getCodMesa() {
        return codMesa;
    }

    public void setCodMesa(int codMesa) {
        this.codMesa = codMesa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(int estadoMesa) {
        this.estadoMesa = estadoMesa;
    }
    
    public String getImgMesa(){
        return estadoMesa == 1 ? "img/active_table.png" : estadoMesa == 2? "img/ocupaded_table.png" : "im/disabled_table.png";
    }
    
    public String getEstadoMesaEnNombre(){
        return estadoMesa == 1 ? "Activo" : estadoMesa == 2? "Ocupado" : "En Manteniemiento";
        
    }
    
    public String getEstadoACancelar(){
        return estadoMesa == 1 ? "No Cancelar" : estadoMesa == 2? "Cancelar" : "En Manteniemiento";
    }
    
    public String getEstadoMesaEnNombreSeguirComprando(){
        return estadoMesa == 1 ? "No se usa" : estadoMesa == 2? "En proceso" : "En Manteniemiento";
        
    }
}
