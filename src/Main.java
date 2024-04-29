import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Double operando1, operando2, resultado;
        char operacion;

        operando1 = solicitarOperando("Ingrese primer numero:");
        operando2 = solicitarOperando("Ingrese segundo numero:");

        System.out.println("Operando 1: " + operando1);
        System.out.println("Operando 2: " + operando2);

        operacion = solicitarOperacion("Ingrese operacion:");
        System.out.println("Operacion: " + operacion);

        try {
            resultado = realizarOperacion(operando1, operando2, operacion);
        } catch(Exception e){
            System.out.println(e.getMessage());
            main(args);
            return;
        }
        System.out.println("RESULTADO: \t" + resultado);
    }

    private static Double realizarOperacion(Double operando1, Double operando2, char operacion) throws Exception {
        switch(operacion){
            case '+':
                return operando1 + operando2;

            case '-':
                return operando1-operando2;

            case '*':
                return operando1 * operando2;

            case '/':
                if (operando2 == 0) {
                    throw new Exception("No se puede dividir por cero");
                }
                return operando1 / operando2;

            default:
                throw new Exception("Operacion no valida.");
        }
    }

    public static Double solicitarOperando(String mensaje){
        System.out.println("##############  Calculadora  ##############\n" + mensaje + "\t" );

        Scanner input = new Scanner(System.in);
        String texto = input
                .next()
                .trim();

        Double numero;

        try {
            numero = Double.parseDouble(texto);
        }
        catch(Exception error){
            System.err.println("Ingrese un numero valido!");
            numero = solicitarOperando(mensaje);
        }
        return numero;
    }

    public static char solicitarOperacion(String mensaje){
        System.out.println("##############  Calculadora  ##############\n" + mensaje + "\t" );
        char letra = ' ';
        String texto = "";
        Scanner input = new Scanner(System.in);

        try {
            texto = input
                    .next()
                    .trim();
        } catch(NullPointerException error){
            System.out.println(error.getMessage());
        }
        if(!texto.isEmpty()) {
            letra = texto.charAt(0);

            if(letra == '-' | letra == '+' | letra == '/' | letra == '*'){
                return letra;
            }
            else {
                System.out.println("Ingrese un operador valido");
                letra = solicitarOperacion(mensaje);
            }
        }

        return letra;
    }
}