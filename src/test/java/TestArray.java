import org.example.EjemploTest;
import org.example.Tiempo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TestArray {

    @Test
    @DisplayName("Prueba interseccion")
    void interseccionArray(){
        int [] arr1 = {1,2,3,5,6};
        int [] arr2 = {7,9,0,5,6};
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(6);
        EjemploTest ejemploTest = new EjemploTest();
        assertEquals(set, ejemploTest.interseccion(arr1,arr2),"El resultado debe ser 5,6");
    }

    @DisplayName("Intersección de números")
    @ParameterizedTest(name = "{index} --> interseccion entre {0} y {1} es {2}")
    @MethodSource("source.FactoryMethod#factoryInterseccion")
    void interseccion(int[] cadena1, int [] cadena2, Set<Integer> valorEsperado){
        EjemploTest ejemploTest = new EjemploTest();
        assertEquals(valorEsperado, ejemploTest.interseccion(cadena1,cadena2),()-> "Resultado esperado" + valorEsperado);
    }

    @Test
    @DisplayName("Suma array")
    void sumaArray(){
        Integer [] arr1 = {1,2,3,5,6};
        EjemploTest ejemploTest = new EjemploTest();
        assertEquals(17, ejemploTest.sumaCadena(arr1),"El valor esperado es 17");
    }


    //Prueba parametrizada utilizando @CsvSource
    @ParameterizedTest()
    @CsvSource(textBlock = """
            HOLA,   4
            MUNDO,  5
            JAVIER, 8
            PRUEBA, 6
            """)
           /*{
                    "HOLA, 4",
                    "MUNDO, 5",
                    "JAVIER, 8",
                    "PRUEBA, 6"
            }*/
    void tamCadena(String cadena, int expectedResult){
        EjemploTest ejemploTest = new EjemploTest();
        assertEquals(expectedResult, ejemploTest.tamCadena(cadena), ()-> cadena + " el tamaño" + expectedResult);
    }

    //Separador personalizado con un caracter
    @ParameterizedTest
    @CsvSource(delimiter = '-', textBlock = """
    Esto es una cadena    - Soy una cadena   - 18
    Buen día           - BUENA TARDE         - 11
    Saludos               - Saludos          -  0
    ''              - otro ejemplo           -  12
    """)
    void compararCadena( String cadena1, String cadena2, int valorEsperado){
        EjemploTest ejemploTest = new EjemploTest();
        assertEquals(valorEsperado, ejemploTest.compararCadena(cadena1,cadena2),"Esto es una prueba");
    }


    //Separador personalizado por cadena personalizada
    @DisplayName("Delimitador personzalizado")
    @ParameterizedTest
    @CsvSource(delimiterString = "*--*", textBlock= """
            ' Esto es una cadena ' *--*   'ESTO ES UNA CADENA'
            ' BUEN DIA '           *--*   'BUEN DIA'       \s
            ' Saludos '            *--*   'SALUDOS'        \s
            ' ejemplo separador '  *--*   'ejemplo separador' \s
            """)

    void procesarCadena(String cadena1, String valorEsperado){
        EjemploTest ejemploTest = new EjemploTest();
        assertEquals(valorEsperado,ejemploTest.procesarCadena(cadena1),"ESto es otro ejemplo");
    }




    //Prueba parametrizada a tarves de name
    @DisplayName("Prueba para el calculo de suma: ")
    @ParameterizedTest(name = "{index} => {0}: [{1} y {2}]")
    @CsvSource( delimiter = '|', textBlock = """
            valores positivos         |  20  |  100  |  120
            valores negativos         | -20  |  -20  |  -40
            valor positivo y negativo |  20  |   -10 |   10
            """)

    void suma(String mensaje, int a, int b, int resultadoEsperado){
        EjemploTest ejemploTest = new EjemploTest();
        assertEquals(resultadoEsperado, ejemploTest.suma(a,b),"Eejemplo con name");
    }

    /*Parametro único @ValueResource permite especificar una matriz de literales de tipos primitivos
    short, byte, int, long, float, double, char, boolean, String, o Class
    */
    @DisplayName("Prueba es mayuscula")
    @ParameterizedTest
    @ValueSource(strings ={"hola","MUNDO", "EJEMPLO"})
    void validarCadena(String cadena){
        EjemploTest ejemploTest = new EjemploTest();
        assertTrue(ejemploTest.validarCadena(cadena));
    }

    @DisplayName("Evaluar número primo")
    @ParameterizedTest(name = "{index} ---> {0}")
    @ValueSource(ints = {2,4,6,45,23,89})
    void evaluarPrimo(int value){
        EjemploTest ejemploTest = new EjemploTest();
        assertTrue(ejemploTest.evaluarPrimo(value));
    }


    //@EnumSOurce
    @DisplayName("EJemplo Enum 1")
    @ParameterizedTest(name = "{index} --> {0}")
    @EnumSource(Tiempo.class)
    void validarDatosNoNulos(Tiempo tiempo){
        assertNotNull(tiempo);
    }

    @DisplayName("EJemplo Enum 2")
    @ParameterizedTest(name = "{index} --> {0}")
    @EnumSource(names = {"MINUTOS", "HORAS"})
    void validarNombres(Tiempo tiempo){
        assertNotNull(tiempo);
    }

    //@NullSource & @EmptySource
    @DisplayName("EJemplo  @NullSource & @EmptySource")
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = { "hhhhhhh" })
    void validaNull(String text) {
        EjemploTest ejemploTest = new EjemploTest();
        assertTrue(text == null || ejemploTest.cadenaVacia(text));
    }


    //@MethodSource permite hacer referencia a un método propio que devuelve los argumentos.
    // Dichos métodos deben devolver un Stream, Iterable, Iteratoro una serie de argumentos.

    @DisplayName("@MethodSource ")
    @ParameterizedTest(name = "{index} ---> {0} ===> Valor esperado {1}")
    @MethodSource("factory")
    void suma(Integer [] values, int valorEsperado){
        EjemploTest ejemploTest = new EjemploTest();
        assertEquals(valorEsperado,ejemploTest.sumaCadena( values), ()-> Arrays.toString(values) + " la suma de valores esperado debe ser" + valorEsperado);
    }


    private static Stream<Arguments> factory(){
        return Stream.of(
                Arguments.of((new Integer[] { 2, 2, 4 }), 8),
                Arguments.of((new Integer[] { 2, 2, 2 }), 6),
                Arguments.of((new Integer[] { 2, 1, 2, 3, 4 }), 12)
        );
    }






}
