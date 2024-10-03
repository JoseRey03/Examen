public class Pelicula {
    private final String id;
    private final String titulo;
    private final int año;
    private final String director;
    private final String genero;

    public Pelicula(String id, String titulo, int año, String director, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.año = año;
        this.director = director;
        this.genero = genero;
    }

    // Getters
    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public int getAño() { return año; }
    public String getDirector() { return director; }
    public String getGenero() { return genero; }


    @Override
    public String toString() {
        return id + "," + titulo + "," + año + "," + director + "," + genero;
    }
}


