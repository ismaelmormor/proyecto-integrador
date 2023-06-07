package modelo;

public class Alumno {
    private String nombre, apellidos;
    private int nExpediente, idProyecto;

    public Alumno(String nom, String ap, int nExp, int idP){
        this.nombre = nom;
        this.apellidos = ap;
        this.nExpediente = nExp;
        this.idProyecto = idP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getnExpediente() {
        return nExpediente;
    }

    public void setnExpediente(int nExpediente) {
        this.nExpediente = nExpediente;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

}
