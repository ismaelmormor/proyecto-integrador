package modelo;

public class Proyecto {
    private String nombre, curso, grupo, url;
    private int year, nota, idArea;

    public Proyecto(String n, String c, String g, int y,String url, int nota, int idAr){
        this.nombre = n;
        this.curso = c;
        this.grupo = g;
        this.year = y;
        this.url = url;
        this.nota = nota;
        this.idArea = idAr;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }
    
}
