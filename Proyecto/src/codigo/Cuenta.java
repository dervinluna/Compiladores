package codigo;
import java.util.ArrayList;
import java.util.Map;
public class Cuenta {
    public static ArrayList<Cuenta> miListaCuenta = new ArrayList<>();
	public int codigoCuenta;
	public String nombreCuenta;
	public int codigoCliente;
	public Double depositoInicial;
	public Boolean quetzales;
    //1 clse constructor
	public Cuenta(int codigoCuenta, String nombreCuenta, int codigoCliente, 
			Double depositoInicial, Boolean quetzales) {
		this.codigoCuenta = codigoCuenta;
		this.nombreCuenta = nombreCuenta;
		this.codigoCliente = codigoCliente;
		this.depositoInicial = depositoInicial;
		this.quetzales = quetzales;
		// TODO Auto-generated constructor stub
	}
	
	//2clase constructor2
	public Cuenta() {
		// TODO Auto-generated constructor stub
	}

     //metodo crear cuenta
	public String CREAR_CUENTA (int codigoCuenta, String nombreCuenta, int codigoCliente, 
			Double depositoInicial, Boolean quetzales) {
		String ip = "";
		Cuenta cuenta1 = new Cuenta();
		cuenta1.codigoCuenta=codigoCuenta;
		cuenta1.nombreCuenta=nombreCuenta;
		cuenta1.codigoCliente=codigoCliente;
		cuenta1.depositoInicial=depositoInicial;
		cuenta1.quetzales=quetzales;
		miListaCuenta.add(cuenta1);	
		if (miListaCuenta.contains(cuenta1)) {
			ip = "La cuenta se Creo";
			Mando.cant_CuentasCreadas++;
		} else {
			ip = "La no cuenta se Creo";
			Mando.errores++;
		}
		return ip;
	}
	
	//metodo eliminar cuenta
	public String ELIMINAR_CUENTA(int codigoCuenta){
		String ip="";
		//asignamos el parametro
	    this.codigoCuenta=codigoCuenta;
	    int cuentaBuscada = this.codigoCuenta;
	    for(int i = 0; i < miListaCuenta.size(); i++) {
	            
            if (miListaCuenta.get(i).getcodigoCuenta()==cuentaBuscada) {//if 6
            	//evaluamos si el saldo de la cuenta es 0
            	if(miListaCuenta.get(i).getSaldo()==0.0) {
            		//eliminamos la cuenta de la lista
            	  miListaCuenta.remove(i);  
            	  ip= "Cuenta encontrada y eliminada";
            	  Mando.cant_RetGen++;
            	  return ip;
                }else {ip= "La cuenta no eliminada, aun tiene fondos"; Mando.errores++;return ip;}
            }else {ip= "Cuenta no fue encontrada";Mando.errores++;}//if 6
        
	}
	return ip;	
	}
	
	//metodo obtener cod cliente
	public int getCodigoCliente() {
        return codigoCliente;
    }
	
//metodo obtener cod cuenta
	public int getcodigoCuenta() {
        return codigoCuenta;
    }
	//actualizar saldo 
	 public void setSaldo(double valor) {
	        this.depositoInicial = valor;
	    }
	 //obtener saldo
	 public Double getSaldo() {
	        return depositoInicial;
	    }
	 public Double getDepoIni() {
			return depositoInicial;
		}
	 
}
