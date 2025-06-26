package proyecto;


import proyecto.exceptions.LibroNoDisponibleExcepcion;
import proyecto.model.Ciencia;
import proyecto.model.Infantil;
import proyecto.model.Libreria;
import proyecto.model.Novela;

import java.util.logging.Logger;

public class Main {
  public static final Logger log = Logger.getLogger(Main.class.getName());
  public static void main(String[] args) {
    //creamos la libreria
    Libreria libroLibre = new Libreria(null, 0, 0);

    //creamos 3 libros de distinto genero
    libroLibre.agregarLibro(new Novela("006248","Desesperacion", 2022, 45000));
    libroLibre.agregarLibro(new Ciencia("008924", "Sapiens", 2019, 35000 ));
    libroLibre.agregarLibro(new Infantil("001576", "Necronomicon", 2025, 40000));

    //mostramos el stock
    libroLibre.mostrarLibrosDisponibles();

    //vendemos un libro en stock
    try {
      libroLibre.venderLibro("006248");
    } catch (LibroNoDisponibleExcepcion e) {
      log.info("Error: " + e.getMessage());
    }

    //Vendemos un libro que no este en stock
    try {
      libroLibre.venderLibro("25648");
    } catch (LibroNoDisponibleExcepcion e) {
      log.info("Error: " + e.getMessage());
    }

  }
}