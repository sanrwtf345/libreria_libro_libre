package proyecto.model;

public abstract class Libro implements Vendible {
  private String ISBN;
  private String titulo;
  private int anioPublicacion;
  private float precio;

  public Libro() {
  }

  public Libro(String ISBN, String titulo, int anioPublicacion, float precio) {
    this.ISBN = ISBN;
    this.titulo = titulo;
    this.anioPublicacion = anioPublicacion;
    this.precio = precio;
  }

  //seters
  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public void setAnioPublicacion(int anioPublicacion) {
    this.anioPublicacion = anioPublicacion;
  }

  public void setPrecio(float precio) {
    this.precio = precio;
  }

  //getters
  public String getISBN() {
    return ISBN;
  }

  public String getTitulo() {
    return titulo;
  }

  public int getAnioPublicacion() {
    return anioPublicacion;
  }

  public float getPrecio() {
    return precio;
  }

  public String getGenero() {
    return "";
  }
}
