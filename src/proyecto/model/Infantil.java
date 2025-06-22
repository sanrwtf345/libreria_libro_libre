package proyecto.model;

public class Infantil extends Libro implements Vendible{
  public Infantil(String ISBN, String titulo, int anioPublicacion, float precio){
    super(ISBN, titulo, anioPublicacion, precio);
  }

  @Override
  public String getGenero(){
    return "Infantil";
  }

  @Override
  public float calcularPrecioFinal() {
    // 10% de descuento si es anterior a 2023
    return (getAnioPublicacion() < 2023) ? getPrecio() * 0.90f : getPrecio();
  }
}
