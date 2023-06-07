package modelo;

public class Proyecto {
    private String nombre, curso, grupo, url;
    private int idProyecto, year, nota, idArea;
    /**
     * Constructor sin id Proyecto para cuando insertemos el alumno (desconocemos su id)
     * @param n
     * @param c
     * @param g
     * @param y
     * @param url
     * @param nota
     * @param idAr
     */
    public Proyecto(String n, String c, String g, int y,String url, int nota, int idAr){
        this.nombre = n;
        this.curso = c;
        this.grupo = g;
        this.year = y;
        this.url = url;
        this.nota = nota;
        this.idArea = idAr;
    }
    /**
     * Constructor con id Proyecto para cuando lo modifiquemos
     * 
     * @param idP
     * @param n
     * @param c
     * @param g
     * @param y
     * @param url
     * @param nota
     * @param idAr
     * 
     */
    public Proyecto(int idP, String n, String c, String g, int y,String url, int nota, int idAr){
        this.idProyecto = idP;
        this.nombre = n;
        this.curso = c;
        this.grupo = g;
        this.year = y;
        this.url = url;
        this.nota = nota;
        this.idArea = idAr;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
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
