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
		String ip="";
		//asignamos el parametro
	    this.codigoCliente=codigoCliente;
	    int clienteBuscado = codigoCliente;
	    Double montoTotal=1.00;
	    
	    for(int i = 0; i <Cuenta.miListaCuenta.size(); i++) {
            if (Cuenta.miListaCuenta.get(i).getCodigoCliente()==clienteBuscado) {//if 6
            	//evaluamos si el saldo de las cuentas del cliente estan a 0 
            	if(Cuenta.miListaCuenta.get(i).getSaldo()==0.0) {
            		ip="entro al if 2";
            		//esta variable nos ayudara a revisar si todas la scuentas del cliente estan a 0.0
            		montoTotal+=Cuenta.miListaCuenta.get(i).getSaldo();
                }else {montoTotal++;}
            }
	}
        /*
         * evaluamos si la o las cuentas del cliente tenian dinero 
         * por medio de un sumador llamado montoTotal
         * */
	    if(montoTotal==1) {
	    	 for(int i = 0; i < Cliente.miListaCliente.size(); i++) {
	    		 ip="entro al for 3 "+montoTotal+" "+Cliente.miListaCliente.get(i).getCodigoCliente()+"  "+clienteBuscado;
	    		 if (Cliente.miListaCliente.get(i).getCodigoCliente()==clienteBuscado) {
	    			 miListaCliente.remove(i);
	    			 ip="Cliente eliminado ";return ip;
	    		 }
	    		 
	    	 }
	    	
	    }else {//si el cliente auntiene sus cuentas con dinero
	    	ip="Cliente no eliminado aun tiene saldo en sus cuentas";return ip;
	    	}
	    return ip;
	    
		}
	
	
	
	public int getCodigoCliente() {
        return codigoCliente;
    }
	

	}
	

