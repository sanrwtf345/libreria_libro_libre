package proyecto.model;

import proyecto.exceptions.LibroNoDisponibleExcepcion;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Libreria {

  public static final Logger log = Logger.getLogger(Libreria.class.getName());

  private ArrayList<Libro> libros;
  private float ganancias;
  private int cantidadDeVentas;

  public Libreria() {
  }

  public Libreria(ArrayList<Libro> libros, float ganancias, int cantidadDeVentas) {
    this.libros = (libros != null) ? libros : new ArrayList<>();
    this.ganancias = ganancias;
    this.cantidadDeVentas = cantidadDeVentas;
  }

  //seters
  public void setLibros(ArrayList<Libro> libros) {
    this.libros = libros;
  }

  public void setGanancias(float ganancias) {
    this.ganancias = ganancias;
  }

  public void setCantidadDeVentas(int cantidadDeVentas) {
    this.cantidadDeVentas = cantidadDeVentas;
  }

  //getters
  public float getGanancias() {
    return ganancias;
  }

  public ArrayList<Libro> getLibros() {
    return libros;
  }

  public int getCantidadDeVentas() {
    return cantidadDeVentas;
  }

  //metodos
  public void agregarLibro(Libro l) {
    if (libros.size() < 1000) {
      libros.add(l);
      log.info("Bicicleta agrgada al inventario" + " " + l.getISBN());
    } else {
      log.info("Ya no se pueden agregar mas bicicletas");
    }
  }

  private Libro bucarLibroPorISBN(String ISBN) {
    for (Libro b : libros) {
      if (b.getISBN().equalsIgnoreCase(ISBN)) {
        return b;
      }
    }
    return null;
  }

  public void venderLibro(String ISBN) throws LibroNoDisponibleExcepcion {
    Libro encontrado = bucarLibroPorISBN(ISBN);
    if (encontrado != null) {
      float precioFinal = encontrado.calcularPrecioFinal();
      ganancias += precioFinal;
      cantidadDeVentas++;
      libros.remove(encontrado);
      log.info("Venta realizada. Precio final: $" + precioFinal);
    } else {
      throw new LibroNoDisponibleExcepcion("El libro con el ISBN: " + ISBN + " no está en stock.");
    }
  }

  public void mostrarLibrosDisponibles() {
    if (libros.isEmpty()) {
      log.info("No hay libros disponibles");
    } else {
      for (Libro l : libros) {
        log.info(l.getISBN() + " - " + l.getTitulo() + " - " + l.getAnioPublicacion() + " - $" + l.calcularPrecioFinal());
      }
    }
  }
}
