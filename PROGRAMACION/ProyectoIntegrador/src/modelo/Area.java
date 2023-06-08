package modelo;

public class Area {
    private int id;
    private String nombre, descripcion;

    public Area(int id, String n, String d){
        this.id=id;
        this.nombre=n;
        this.descripcion=d;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
