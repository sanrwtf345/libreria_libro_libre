package proyecto.model;

public class Novela extends Libro implements Vendible {
  public Novela(String ISBN, String titulo, int anioPublicacion, float precio){
    super(ISBN, titulo, anioPublicacion, precio);
  }

  @Override
  public String getGenero(){
    return "Novela";
  }

  @Override
  public float calcularPrecioFinal() {
    // 10% de descuento si es anterior a 2023
    return (getAnioPublicacion() < 2023) ? getPrecio() * 0.90f : getPrecio();
  }
}
