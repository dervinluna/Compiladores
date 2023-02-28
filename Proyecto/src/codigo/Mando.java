/**
 * 
 */
package codigo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.lang.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author dervin
 *
 */
public class Mando {
	//defino losatributos para el reporte final
	 public static int cant_ClientesCreados =0;
	 public static int cant_ClientesEliminados =0;
	 public static int cant_CuentasCreadas =0;
	 public static int cant_CuentasEliminadas =0;
	 public static int cant_DepCuenta =0;
	 public static int cant_DepGen =0;
	 public static int cant_RetCuenta =0;
	 public static int cant_RetGen =0;
	 public static int errores =0;	
	/**
	 * 
	 */
	public Mando() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//defino las varibles para el reporte final
		
		// TODO Auto-generated method stub
		//defino un arraylist donde guardare los datos de la creacion de clientes
		//ArrayList<Cliente> miListaCliente = new ArrayList<>();
		//defino la ruta del archivo .txt a leer
		String nombreFichero = "C:\\prueba.txt";
		// Declarar una variable BufferedReader
		BufferedReader br = null;
		try {
		    // Crear un objeto BufferedReader al que se le pasa 
		    //   un objeto FileReader con el nombre del fichero
		    br = new BufferedReader(new FileReader(nombreFichero));
		    // Leer la primera línea, guardando en un String
		    String texto = br.readLine();
		    // Repetir mientras no se llegue al final del fichero
		    while(texto != null) {
		        // Hacer lo que sea con la línea leída
		        // En este ejemplo sólo se muestra por consola
		    	//analizamos la cadena para ver que haremos
		    	switch(texto.substring(0,texto.indexOf('('))) 
		    	{	   
		    	//en caso de que sea crear cliente
		    	    case "CREAR_CLIENTE":
		    	    	//cortamos la cadena extraemos lo que esta dentro del parentesis
		    	    	String datos = texto.substring(texto.indexOf('(')+1,texto.indexOf(')'));
		    	    	//instanciamos la clase cliente
		    	    	Cliente objetoCliente = new Cliente(0, datos, datos, datos, null);	    	    	
		    	    	//asignamos la cadena datos a la cadena persona
		    	    	String persona = datos;
		    	    	//cortamos la cadena persona para poder extraer dato por dato
		    	    	//asi mismo guardamos cada dato extraido en el array de tipo string llamado partes
		    	    	String[] partes = persona.split(",");		 	    	 
		    	    	//asignamos cada una de las partes del array de forma ordenada a a cada atributo del objeto
		    	    	int codigoCliente = Integer.parseInt(partes[0]);
		    	    	String nombre = partes[1];
		    	    	String dirección = partes[2];
		    	    	String teléfono = partes[3];
		    	    	String fec =partes[4].replaceAll("\"", ""); 	
		    	    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		    	    	LocalDate fechaNacimiento = LocalDate.parse(fec, formatter);
		    	    	//probando
		    	    	int posicionEncontrada = -1;
		    	    	for (int i = 0; i < Cliente.miListaCliente.size(); i++) {
		    	    	    Cliente cliente = Cliente.miListaCliente.get(i);
		    	    	    //verificamos si hay una cuenta con el mismo codigo en la lista
		    	    	    if (cliente.codigoCliente==codigoCliente) {
		    	    	        posicionEncontrada = i;
		    	    	        break;
		    	    	    }
		    	    	}
		    	    	if (posicionEncontrada != -1) {
		    	    	    System.out.println("El cliente ya está existe" );
		    	    	} else {	    	    		
		    	    	  //creamos cliente por medio del metodo crear cliente de la clase Cliente
		    	    		System.out.println(objetoCliente.CREAR_CLIENTE(codigoCliente, nombre, dirección, teléfono, fechaNacimiento));
		    	    	}
		    	    	break;  			
		    			//en caso de que sea eliminar cliente
		    		case "ELIMINAR_CLIENTE":
		    			//cortamos la cadena extraemos lo que esta dentro del parentesis
		    	    	datos = texto.substring(texto.indexOf('(')+1,texto.indexOf(')'));
		    	    	partes = new String[0];
		    	    	partes = datos.split(",");
		    	    	objetoCliente = new Cliente();
		    	    	codigoCliente = Integer.parseInt(partes[0]);
		    	    	//Cuenta cuenta = new Cuenta();
		    	    	System.out.println(objetoCliente.ELIMINAR_CLIENTE(codigoCliente));    	    		
		    	    	
		    			break;
		    			//en caso de que sea crear cuenta
		    		case "CREAR_CUENTA":
		    			//cortamos la cadena extraemos lo que esta dentro del parentesis
		    			 datos="";
		    	    	 datos = texto.substring(texto.indexOf('(')+1,texto.indexOf(')'));
		    	    	//comprobamos que se halla extraido correctamente		
		    			//instanciamos la clase cliente
		    	    	Cuenta objetoCuenta = new Cuenta(0, datos, 0, null, null);	    	    	
		    	    	//asignamos la cadena datos a la cadena persona
		    	    	persona = datos;    	    	
		    	    	//cortamos la cadena persona para poder extraer dato por dato
		    	    	//asi mismo guardamos cada dato extraido en el array de tipo string llamado partes
		    	    	partes = new String[0];
		    	    	partes = persona.split(",");
		    	    	//asignamos cada una de las partes del array de forma ordenada a a cada atributo del objeto
		    	    	int codigoCuenta = Integer.parseInt(partes[0]);
		    	    	String nombreCuenta = partes[1];
		    	    	codigoCliente = Integer.parseInt(partes[2]);
		    	    	Double depositoInicial = Double.parseDouble(partes[3]);
		    	    	Boolean quetzales =Boolean.parseBoolean(partes[4]);
		    	    	//probando
		    	    	String nombreBuscado = "Pedro";
		    	    	 posicionEncontrada = -1;
		    	    	for (int i = 0; i < Cuenta.miListaCuenta.size(); i++) {
		    	    		Cuenta cuenta = Cuenta.miListaCuenta.get(i);
		    	    	    //verificamos si hay una cuenta con el mismo codigo en la lista
		    	    	    if (cuenta.codigoCuenta==codigoCuenta) {
		    	    	        posicionEncontrada = i;
		    	    	        break;
		    	    	    }
		    	    	}
		    	    	if (posicionEncontrada != -1) {
		    	    	    System.out.println("La cuenta ya está existe" );
		    	    	    Mando.errores++;
		    	    	} else {		    	   
		    	    	  //creamos cliente por medio del metodo crear cliente de la clase Cliente
		    	    		System.out.println(objetoCuenta.CREAR_CUENTA(codigoCuenta, nombreCuenta, codigoCliente, depositoInicial, quetzales));
		    	    		//contabilizamos clientes creados
		    	    	}
		    	    	break;
		    	    	
		    			//en caso de que sea eliminar cuenta
		    		case "ELIMINAR_CUENTA":
		    			//cortamos la cadena extraemos lo que esta dentro del parentesis
		    	    	datos = texto.substring(texto.indexOf('(')+1,texto.indexOf(')'));
		    	    	partes = new String[0];
		    	    	partes = datos.split(",");
		    	    	objetoCuenta = new Cuenta();
		    	    	codigoCuenta = Integer.parseInt(partes[0]);
		    	    	Cuenta cuenta = new Cuenta();
		    	    	System.out.println(cuenta.ELIMINAR_CUENTA(codigoCuenta));    	    		
		    	    	
		    			break;
		    			
		               //en caso de que sea deposito
		    		case "DEPOSITO":
		    			//cortamos la cadena extraemos lo que esta dentro del parentesis
		    	    	 datos = texto.substring(texto.indexOf('(')+1,texto.indexOf(')'));
		    			//instanciamos la clase cliente
		    	    	Transacciones depositos = new Transacciones(0,0.0,null,null);
		    	    	//cortamos la cadena persona para poder extraer dato por dato
		    	    	//asi mismo guardamos cada dato extraido en el array de tipo string llamado partes
		    	    	partes = new String[0];
		    	    	partes = datos.split(",");
		    	    	
		    	    	//asignamos cada una de las partes del array de forma ordenada a a cada atributo del objeto
		    	    	depositos.codigoCuenta = Integer.parseInt(partes[0]);
		    	    	depositos.monto = Double.parseDouble(partes[1]);
		    	    	fec =partes[2].replaceAll("\"", ""); 	
		    	    	formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		    	    	depositos.fechaDeposito = LocalDate.parse(fec, formatter);
		    	    	depositos.fechaDebito=null;
		    	    	System.out.print(depositos.DEPOSITO(depositos.codigoCuenta, depositos.monto, depositos.fechaDeposito,depositos.fechaDebito));
		    	    	break;
		    			
		    			//en caso de que sea retiro
		    		case "RETIRO":
                        //cortamos la cadena extraemos lo que esta dentro del parentesis
		    	    	
		    			datos = texto.substring(texto.indexOf('(')+1,texto.indexOf(')'));
		    
		    	    	//instanciamos la clase cliente
		    	    	Transacciones retiro = new Transacciones();
		    	    	
		    	    	//asignamos la cadena datos a la cadena persona
		    	    	persona = datos;
		    	    	
		    	    	//cortamos la cadena persona para poder extraer dato por dato
		    	    	//asi mismo guardamos cada dato extraido en el array de tipo string llamado partes
		    	    	partes = new String[0];
		    	    	partes = persona.split(",");
		    	    	
		    	    	//asignamos cada una de las partes del array de forma ordenada a a cada atributo del objeto
		    	    	codigoCuenta = Integer.parseInt(partes[0]);
		    	    	double monto = Double.parseDouble(partes[1]);
		    	    	//limpiamos el string de fecha para darle formato
		    	    	fec =partes[2].replaceAll("\"", ""); 	
		    	    	formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		    	    	LocalDate fechaDebito = LocalDate.parse(fec, formatter);
		    	    	LocalDate fechaDeposito = null;
		    	    	System.out.print(retiro.RETIRO(codigoCuenta, monto, fechaDeposito,fechaDebito));
		    			break;
	                	//si no se reconoce la opcion
		    		    default:
		    			Mando.errores++;
		    			System.out.println("Instruccion No Reconocida");
		    			break;	
		    	}
		    	
		        System.out.println(texto);
		        // Leer la siguiente línea
		        texto = br.readLine();
		    }
		}
		// Captura de excepción por fichero no encontrado
		catch (FileNotFoundException ex) {
			Mando.errores++;
		    System.out.println("Error: Fichero no encontrado");
		    ex.printStackTrace();
		}
		// Captura de cualquier otra excepción
		catch(Exception ex) {
			Mando.errores++;
		    System.out.println("Error de lectura del fichero");
		    ex.printStackTrace();
		}
		// Asegurar el cierre del fichero en cualquier caso
		
    	
		finally {
		    try {
		        // Cerrar el fichero si se ha podido abrir
		    	
		        if(br != null) {
		            br.close();
		        }
		    }
		    catch (Exception ex) {
		    	Mando.errores++;
		        System.out.println("Error al cerrar el fichero");
		        ex.printStackTrace();
		    }
		}
		
		
		
		
		//creamos y escribimos o sobreescribimos en un archivo
		 String contenido = "------------------------------------------------------------------------------\n"
		 		+ "------------------------Reporte De Acciones-----------------------------------\n"
		 		+ "------------------------------------------------------------------------------\n"
		 		+ "|Cantidad de Clientes creados:                             "+cant_ClientesCreados+"   |\n"
		 		+ "|Cantidad de Clientes eliminados:                          "+cant_ClientesEliminados+"   |\n"
		 		+ "|Cantidad de Cuentas creadas:                              "+cant_CuentasCreadas+"   |\n"
		 		+ "|Cantidad de Cuentas eliminadas:                           "+cant_CuentasEliminadas+"   |\n"
		 		+ "|Cantidad de depósitos realizados por cuenta:              "+cant_DepCuenta+"   |\n"
		 		+ "|Cantidad de depósitos realizados en general:              "+cant_DepGen+"   |\n"
		 		+ "|Cantidad de retiros realizados por cuenta:                "+cant_RetGen+"   |\n"
		 		+ "|Cantidad de retiros realizados en general:                "+cant_RetCuenta+"   |\n"
		 		+ "|Errores encontrados en el archivo(instrucciones no validas):"+errores+"|\n"
		 		+ "------------------------------------------------------------------------------\n";

	        try {
	            File archivo = new File("C:\\reporte.txt");
	            FileWriter escritorArchivo = new FileWriter(archivo, false);
	            BufferedWriter escritorBuffer = new BufferedWriter(escritorArchivo);
	            escritorBuffer.write(contenido);
	            escritorBuffer.close();
	            System.out.println("Archivo creado o sobrescrito correctamente.");
	        } catch (IOException e) {
	            System.out.println("Ha ocurrido un error al crear o sobrescribir el archivo.");
	            e.printStackTrace();
	        }
		
		
		
		
		System.out.println("--------------------------------------------");
		System.out.println("leemos lista cuentas");
		System.out.println("--------------------------------------------");
		for (Cuenta persona : Cuenta.miListaCuenta ) {
			System.out.println("codigoCuenta: " + persona.codigoCuenta);
            System.out.println("nombre: " + persona.nombreCuenta);
            System.out.println("codigoCliente: " + persona.codigoCliente);
            System.out.println("saldo: " + persona.depositoInicial);
            System.out.println("quetzales: " + persona.quetzales);
		    System.out.println("--------------------------------------------");
		}
		 System.out.println("leemos lista clientes");
		 System.out.println("--------------------------------------------");
		for (Cliente vart : Cliente.miListaCliente) {
			System.out.println("codigoCliente: " + vart.codigoCliente);
            System.out.println("nombre: " + vart.nombre);
            System.out.println("direccion: " + vart.dirección);
            System.out.println("telefono: " + vart.teléfono);
            System.out.println("fechanac: " + vart.fechaNacimiento);
            System.out.println("--------------------------------------------");
		}
		
		System.out.println("leemos lista Depositos");
		System.out.println("--------------------------------------------");
		 for ( Transacciones persona : Transacciones.miListaDeposito) {
	            System.out.println("codigoCuenta: " + persona.codigoCuenta);
	            System.out.println("monto: " + persona.monto);
	            System.out.println("fechaDeposito: " + persona.fechaDeposito);
	            System.out.println("fechaDebito: " + persona.fechaDebito);
	            System.out.println("--------------------------------------------");
	        }
		 System.out.println("leemos lista Retiros");
			System.out.println("--------------------------------------------");
			 for ( Transacciones persona : Transacciones.miListaRetiro) {
		            System.out.println("codigoCuenta: " + persona.codigoCuenta);
		            System.out.println("monto: " + persona.monto);
		            System.out.println("fechaDeposito: " + persona.fechaDeposito);
		            System.out.println("fechaDebito: " + persona.fechaDebito);
		            System.out.println("--------------------------------------------");
		        }

		
	}

}
