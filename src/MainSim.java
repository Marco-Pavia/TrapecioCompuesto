// Marco Antonio Pavia Flores
// MainSim.java

public class MainSim {
    public static void main(String[] args) {
        double a = 0.0;
        double b = 2.0;
        double tolerancia = 0.0001;

        // Mandamos a llamar al método encapsulado
        double resultado = SimpsonCompuesto.integrarConTolerancia(a, b, tolerancia);

        System.out.println("\nResultado final obtenido: " + resultado);
    }
}