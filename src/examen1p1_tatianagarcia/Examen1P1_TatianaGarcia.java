
package examen1p1_tatianagarcia;
import java.util.Scanner;
import java.security.SecureRandom;
/**
 *
 * @author tatig
 */
public class Examen1P1_TatianaGarcia {
    static Scanner leer = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int opcion; 
       do 
       {
            System.out.println();
            System.out.println("--> Menu <--");
            System.out.println("1 -> Divisores Primos");
            System.out.println("2 -> Contorno de Piramide");
            System.out.println("3 -> Vecinos");
            System.out.println("4 -> Triangulo de Pascal");
            System.out.println("5 -> Salida");
            System.out.println();
            System.out.println(">> Ingrese una opcion: "); 
            opcion = leer.nextInt();
            
            switch (opcion)
            {
                case 1: 
                {
                    System.out.println();
                    System.out.println(">> Divisores primos <<");
                    System.out.println();
                    System.out.println("Ingrese un numero mayor o igual a 1: ");
                    int N = leer.nextInt();
                    
                    if (N >= 1)
                    {
                        
                        System.out.println("Los numeros primos que dividen el numero "+N+" son: "+ primos(N));
                    }
                    else 
                    {
                        System.out.println("El numero debe ser 1 o 0");
                    }
                    
                    break; 
                }
                case 2: 
                {
                    System.out.println();
                    System.out.println(">> Contorno de Piramide <<");
                    System.out.println();
                    System.out.println("Ingrese un numero impar: ");
                    int num = leer.nextInt();
                    
                    int validacion = num % 2;
                    
                    
                    if (validacion == 0)
                    {
                        System.out.println(">> El numero ingresado no es impar ");
                    }
                    else 
                    {
                        System.out.println(">> Resultado: ");
                        contorno(num);
                    }
                    
                    break;
                }
                case 3: 
                {
                    
                    
                    System.out.println();
                    System.out.println(">> Vecinos <<");
                    System.out.println();
                    System.out.println("Ingrese una cadena: ");
                    String cadena = leer.next();
                    
                    int ASCII = 0; 
                    boolean valid = false; 
                    
                    for (int i = 0; i < cadena.length(); i++)
                    {
                        char v = cadena.toLowerCase().charAt(i);
                        ASCII = (int)v;
                        
                        if (ASCII == 32 || ASCII >= 97 && ASCII <= 122 ||ASCII >= 65 && ASCII <= 90)
                        {
                            valid = true; 
                        }
                    }
                    if (valid)
                    {
                        System.out.println(">> Cadena resultante: "+ vecinos(cadena));
                    }
                    else 
                    {
                        System.out.println();
                        System.out.println(">> Solo puede ingresar letras");
                    }
                    
                    
                    
                    break; 
                }
                case 4:
                {
                    System.out.println();
                    System.out.println(">> Triangulo de Pascal <<");
                    System.out.println();
                    System.out.println("Ingrese un tamaño: ");
                    int N = leer.nextInt();
                    
                    pascal(N);
                }
                default: 
                {
                    System.out.println();
                    System.out.println(">> Salida...");
                    break; 
                }
            }//switch
            
            
       }while(opcion < 5);
    }//Fin del metodo main
    
    //Divisores Primos
    
    public static String primos(int N)
    {
        
        String divisores = "";
        int suma = 0; 
        for (int i =1; i < N; i++)
        {
            int res= N%i;
            if (res == 0)
            {
                divisores += i + ".";
                
            }
        }
        
        
        return divisores;
    }
    
    //Contorno de Piramide
    
    public static void contorno(int num)
    {
        
        int prim = (num-1)/2;
        int con = 0, con2 = 1; 
        for (int i = 0; i < prim; i++)
        {
            for (int j = 0; j < prim-con; j++)
            {
                System.out.print("*");
            }
            
            System.out.print("+");
            
            if (i ==0)
            {
                for (int j = 0; j < prim-con; j++)
                {
                    System.out.print("*");
                }
            }
            if (i>0 && i != prim-1)
            {
                
                for (int y = 0; y < con2; y++)
                {
                    System.out.print(" ");
                }
                con2+=2;
                System.out.print("+");
                for (int j = 0; j < prim-con; j++)
                {
                    System.out.print("*");
                }
                
            }
            if (i == prim-1)
            {
                for (int y = 0; y < con2; y++)
                {
                    System.out.print("+");
                }
                con2+=2;
                System.out.print("+");
                for (int j = 0; j < prim-con; j++)
                {
                    System.out.print("*");
                }
            }
            con++;
            System.out.println();
        }
        for (int i = 0; i < num; i++)
        {
            System.out.print("*");
        }
        
        System.out.println();
    }
    
    //Ejercicio 3 Vecinos
    
    public static String vecinos(String cadena)
    {
        String suma = "";
        
        SecureRandom random = new SecureRandom();
        int r = random.nextInt(2);
                    
                    
        System.out.println();
        System.out.println(">> Numero generado: "+ r);
        
        
        
        //Codigo
        
        for (int i = 0; i < cadena.length(); i++)
        {
            
            int Ascii = 0;
            
            char c = cadena.charAt(i);
            
            if (r == 0 && c != 'a' && c != 'b' && c != 'c')
            {
                Ascii = (int)c -1;
                suma += (char)Ascii;
                
            }
            else if (r == 1 && c != 'a' && c != 'b' && c != 'c')
            {
                Ascii = (int)c +1;
                suma += (char)Ascii;
                
            }
            else {}
            
            switch (c)
            {
                case 'b':
                    suma += 'a';
                    break; 
                
                case 'a':
                case 'c':
                    suma += 'b';
                    break; 
            }
        }
        
        return suma; 
    }
    
    
    ///Inicio de la opcion 4 del Triangulo de Pascal 
    
    
    public static int factorial(int N)
    {
        int factorial = 1;
        
        for (int i = 0; i <= N; i++)
        {
            if (i == 0)
            {
                factorial = 1;
            }
            else 
            {
                factorial *= i; 
            }
        }
        
        return factorial;
    }
    
    public static int permu (int n, int r)
    {
        int permu = 0; 
        
        int valor1, valor2, valor2fac; 
        
        valor1 = factorial(n);
        valor2 = (n-r);
        valor2fac = factorial(valor2);
        permu = valor1/valor2fac;
        return permu; 
    }
    public static int combi (int n, int r)
    {
        int combi = 0;
        
        int valor1, valor2; 
        
        valor1 = (permu(n,r));
        valor2 = factorial(r);
        combi = valor1/valor2; 
        return combi;
    }
    
    public static void pascal(int N)
    {
        int filas = N; 
        for (int i = 0; i < filas; i++)
        {
            for (int j = 0; j <= i; j++ )
            {
                System.out.print("["+combi(i,j)+"]");
            }
            System.out.println("");
        }
       
    }
    
  ///Fin del ejercicio 4 Triangulo de pascal
    
    
}//Fin de la clase
