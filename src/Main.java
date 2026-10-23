// Marco Antonio Pavia Flores
// Main.java
// Clase para obtener el resultado de la clase Trapecio Compuesto

public class Main {
    public static void main(String[] args) {
        double a = 0.0;
        double b = 2.0;
        double tolerancia = 0.0001;

        // Mandamos a llamar al método encapsulado
        double resultado = TrapecioCompuesto.integrarConTolerancia(a, b, tolerancia);

        System.out.println("\nResultado final obtenido: " + resultado);
    }
}
