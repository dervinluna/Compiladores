package codigo;
import java.time.LocalDate;
import java.util.*;

public class Cliente {
	public static ArrayList<Cliente> miListaCliente = new ArrayList<>();
	public int codigoCliente;
	public String nombre;
	public String dirección;
	public String teléfono;
	public LocalDate fechaNacimiento;
	public Cliente(int codigoCliente, String nombre, String dirección, 
			String teléfono, LocalDate fechaNacimiento) {
		this.codigoCliente = codigoCliente;
		this.nombre = nombre;
		this.dirección = dirección;
		this.teléfono = teléfono;
		this.fechaNacimiento = fechaNacimiento;
	}
	public Cliente(int codigoCliente2) {
		// TODO Auto-generated constructor stub
	}
	
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String CREAR_CLIENTE(int codigoCliente, String nombre, String dirección, 
			String teléfono, LocalDate fechaNacimiento) {
		String ip = "";
		Cliente cliente1 = new Cliente();
		cliente1.codigoCliente=codigoCliente;
		cliente1.nombre=nombre;
		//cliente1.codigoCliente=codigoCliente;
		cliente1.dirección=dirección;
		cliente1.teléfono=teléfono;
		cliente1.fechaNacimiento=fechaNacimiento;
		miListaCliente.add(cliente1);	
		if (miListaCliente.contains(cliente1)) {
			ip = "El Cliente se creo";
			Mando.cant_ClientesCreados++;
		} else {
			ip = "El Cliente no se creo";
			Mando.errores++;
		}
		return ip; 
 }
	
	
	public String ELIMINAR_CLIENTE(int codigoCliente) {
		//prueva
				Cliente cliente1 = new Cliente();
				String ip="";
				//asignamos el parametro
				cliente1.codigoCliente=codigoCliente;
			    if (miListaCliente.contains(cliente1.codigoCliente)) {
					ip = "El Cliente no se elimino";
					Mando.errores++;					
				} else {
					ip = "El Cliente se ha eliminado";
					Mando.cant_ClientesEliminados++;
				}
					
				//prueva			
			return ip;	
		}
	public int getCodigoCliente() {
		Cliente objCliente = new Cliente();
        return objCliente.codigoCliente;
    }
	
	
	 public String toString() {
	        return "Clientes [ " + codigoCliente + " " +  nombre + " " +dirección+ " "+ teléfono+ " " +fechaNacimiento+ "]";
	    }
	 
	

	}
	

