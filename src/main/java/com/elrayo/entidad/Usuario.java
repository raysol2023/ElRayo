package com.elrayo.entidad;

public class Usuario extends Persona {
    private String usuario;
    private String clave;
    private String rol;

    public Usuario() {}

    public Usuario(String nombre, String telefono, String direccion, String usuario, String clave, String rol) {
        super(nombre, telefono, direccion);
        this.usuario = usuario;
        this.clave = clave;
        this.rol = rol;
    }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public boolean login(String inputClave) {
        return this.clave.equals(inputClave);
    }
}
