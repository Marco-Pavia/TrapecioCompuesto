// Marco Antonio Pavia Flores
// SimpsonCompuesto.java

/**
 * Clase que implementa el método de Integración Numérica por Simpson 1/3 Compuesto,
 * reutilizando la función f(x) y el cálculo del paso h directamente de la clase TrapecioCompuesto.
 */
public class SimpsonCompuesto {

    /**
     * Método base que calcula la aproximación de la integral mediante la
     * regla de Simpson 1/3 Compuesta para un número par fijo de subintervalos (n).
     *
     * Fórmula: I = (h/3) * [ f(x_0) + 4*sum(f_impares) + 2*sum(f_pares) + f(x_n) ]
     *
     * @param a Límite inferior del intervalo.
     * @param b Límite superior del intervalo.
     * @param n Número de subintervalos (debe ser par).
     * @return La aproximación numérica de la integral para ese n.
     */
    private static double calcularSimpson(double a, double b, int n) {
        // Reutilizamos el método calcularH de la clase TrapecioCompuesto
        double h = TrapecioCompuesto.calcularH(a, b, n);
        double sumaImpares = 0.0;
        double sumaPares = 0.0;

        // Recorremos los puntos intermedios desde k = 1 hasta n-1
        for (int k = 1; k < n; k++) {
            double xk = a + k * h;
            if (k % 2 == 0) {
                sumaPares += TrapecioCompuesto.funcion(xk);   // Puntos pares se multiplican por 2
            } else {
                sumaImpares += TrapecioCompuesto.funcion(xk); // Puntos impares se multiplican por 4
            }
        }

        double suma = TrapecioCompuesto.funcion(a) + 4 * sumaImpares + 2 * sumaPares + TrapecioCompuesto.funcion(b);
        return (h / 3) * suma;
    }

    /**
     * Método iterativo que aplica el criterio de paro por error absoluto.
     * Duplica el número de subintervalos (n -> 2n) en cada iteración del ciclo while,
     * con lo que n siempre se mantiene par, hasta que la diferencia entre dos
     * aproximaciones sucesivas sea menor a la tolerancia.
     */
    public static double integrarConTolerancia(double a, double b, double tolerancia) {
        int n = 2; // Número inicial de subintervalos (Simpson requiere n par)
        double integralAnterior = calcularSimpson(a, b, n);
        double errorAbsoluto = 999.0; // Inicializamos con un valor grande para entrar al while

        System.out.println("--- ITERACIONES (SIMPSON 1/3 COMPUESTO) ---");
        System.out.println("n = " + n + " | Integral = " + integralAnterior);

        // Ciclo while para evaluar la convergencia iterativa
        while (errorAbsoluto > tolerancia) {
            n *= 2; // Duplicamos los subintervalos (el paso h se reduce a la mitad)
            double integralNueva = calcularSimpson(a, b, n);

            // Cálculo del error absoluto entre la iteración nueva y la anterior
            errorAbsoluto = Math.abs(integralNueva - integralAnterior);

            System.out.println("n = " + n + " | Integral = " + integralNueva + " | Error = " + errorAbsoluto);

            // Actualizamos el valor anterior para la siguiente comparación
            integralAnterior = integralNueva;
        }

        return integralAnterior;
    }
}
