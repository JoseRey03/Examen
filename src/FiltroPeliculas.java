import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FiltroPeliculas {

    public List<Pelicula> leerPeliculas(String archivo) throws IOException {
        List<Pelicula> peliculas = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;

        br.readLine();

        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            String id = datos[0];
            String titulo = datos[1];
            int año = Integer.parseInt(datos[2]);
            String director = datos[3];
            String genero = datos[4];
            Pelicula pelicula = new Pelicula(id, titulo, año, director, genero);
            peliculas.add(pelicula);
        }
        br.close();
        return peliculas;
    }

    public List<Pelicula> filtrarPorAñoExacto(List<Pelicula> peliculas, int añoFiltro) {
        List<Pelicula> peliculasFiltradas = new ArrayList<>();
        for (Pelicula p : peliculas) {
            if (p.getAño() == añoFiltro) {
                peliculasFiltradas.add(p);
            }
        }
        return peliculasFiltradas;
    }

    public List<Pelicula> filtrarPorAño(List<Pelicula> peliculas, Integer añoDesde) {
        List<Pelicula> peliculasFiltradas = new ArrayList<>();
        for (Pelicula p : peliculas) {
            if (p.getAño() >= añoDesde) {
                peliculasFiltradas.add(p);
            }
        }
        return peliculasFiltradas;
    }

    public void escribirPeliculas(String archivoSalida, List<Pelicula> peliculas) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida));
        bw.write("ID,Titulo,Año,Director,Genero\n");
        for (Pelicula pelicula : peliculas) {
            bw.write(pelicula.toString() + "\n");
        }
        bw.close();
    }

    public static void main(String[] args) {
        FiltroPeliculas filtro = new FiltroPeliculas();
        try {
            List<Pelicula> peliculas = filtro.leerPeliculas("peliculas.csv");

            Integer añoDesde = 2000;
            List<Pelicula> peliculasFiltradas = filtro.filtrarPorAño(peliculas, añoDesde);

            filtro.escribirPeliculas("PeliculasPosterioresA" + añoDesde, peliculasFiltradas);

            System.out.println("Películas filtradas y guardadas en PeliculasPosterioresA2000.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
