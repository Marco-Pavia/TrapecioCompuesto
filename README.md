# Integración Numérica en Java (Trapecio y Simpson 1/3 Compuesto)

Implementación de métodos de **integración numérica** con criterio de paro iterativo basado en error absoluto y duplicación progresiva de subintervalos ($n \to 2n$):

- **Trapecio Compuesto** (`TrapecioCompuesto`): Aproximación mediante suma de trapecios en subintervalos.
- **Simpson 1/3 Compuesto** (`SimpsonCompuesto`): Aproximación mediante parábolas de segundo grado, reutilizando la función $f(x)$ y el cálculo del paso $h$ de la clase `TrapecioCompuesto`.

**Autor:** Marco Antonio Pavia Flores  
**Lenguaje de programación:** Java (JDK 17 o superior recomendado)

---

## Estructura del proyecto

| Archivo | Descripción |
|---|---|
| `TrapecioCompuesto.java` | Implementación de la regla del Trapecio Compuesto. Define la función $f(x)$, el cálculo del paso $h$ y el método iterativo de integración con tolerancia. |
| `SimpsonCompuesto.java` | Implementación de la regla de Simpson 1/3 Compuesta. Reutiliza $f(x)$ y $h$ de `TrapecioCompuesto`. |
| `Main.java` | Clase principal para probar la integración por **Trapecio Compuesto**. |
| `MainSim.java` | Clase principal para probar la integración por **Simpson 1/3 Compuesto**. |

---

## Comparativa de Métodos

| Aspecto | Trapecio Compuesto | Simpson 1/3 Compuesto |
|---|---|---|
| **Aproximación** | Polinomios de grado 1 (Líneas rectas) | Polinomios de grado 2 (Parábolas) |
| **Requisito de $n$** | $n \ge 1$ (cualquier entero) | $n$ debe ser un número **par** |
| **Fórmula Base** | $I \approx \frac{h}{2} \left[ f(a) + 2\sum_{k=1}^{n-1} f(x_k) + f(b) \right]$ | $I \approx \frac{h}{3} \left[ f(a) + 4\sum f_{\text{impares}} + 2\sum f_{\text{pares}} + f(b) \right]$ |
| **Convergencia** | $O(h^2)$ | $O(h^4)$ (Suele converger en menos iteraciones) |
| **Criterio de Paro** | Error absoluto entre iteraciones $< \text{tolerancia}$ | Error absoluto entre iteraciones $< \text{tolerancia}$ |

---

## Métodos y Métricas

- **Función integrada:** $f(x) = x^2$
- **Límites de integración predeterminados:** $a = 0.0$, $b = 2.0$
- **Tolerancia de error:** `0.0001`
- **Paso $h$:** $h = \frac{b - a}{n}$

---

## Cómo compilar y ejecutar

### Desde la terminal

1. Clona el repositorio (o descarga los archivos en una misma carpeta):
   ```bash
   git clone https://github.com/Marco-Pavia/IntegracionNumerica-MarcoPavia.git
   cd IntegracionNumerica-MarcoPavia
   ```

2. Compila todos los archivos del proyecto:
   ```bash
   javac *.java
   ```

3. Ejecuta la prueba de **Trapecio Compuesto**:
   ```bash
   java Main
   ```

4. Ejecuta la prueba de **Simpson 1/3 Compuesto**:
   ```bash
   java MainSim
   ```

### Desde IntelliJ IDEA / NetBeans / Eclipse

1. Abre la carpeta del proyecto en tu IDE (*File → Open*).
2. Abre el archivo `Main.java` o `MainSim.java`.
3. Presiona el botón de ejecución ▶ (*Run*).

---

## Ejemplo de ejecución

### Trapecio Compuesto (`java Main`)

```text
--- ITERACIONES (TRAPECIO COMPUESTO) ---
n = 2 | Integral = 2.75
n = 4 | Integral = 2.6875 | Error = 0.0625
n = 8 | Integral = 2.671875 | Error = 0.015625
n = 16 | Integral = 2.66796875 | Error = 0.00390625
n = 32 | Integral = 2.6669921875 | Error = 9.765625E-4
n = 64 | Integral = 2.666748046875 | Error = 2.44140625E-4
n = 128 | Integral = 2.66668701171875 | Error = 6.103515625E-5

Resultado final obtenido: 2.66668701171875
```

### Simpson 1/3 Compuesto (`java MainSim`)

```text
--- ITERACIONES (SIMPSON 1/3 COMPUESTO) ---
n = 2 | Integral = 2.6666666666666665
n = 4 | Integral = 2.6666666666666665 | Error = 0.0

Resultado final obtenido: 2.6666666666666665
```

> **Nota:** La integral exacta de $f(x) = x^2$ en el intervalo $[0, 2]$ es $\frac{8}{3} \approx 2.666666...$. El método de Simpson 1/3 alcanza el resultado exacto con $n = 2$ debido a que integra polinomios de grado $\le 3$ sin error de aproximación polinomial.