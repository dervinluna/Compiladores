package codigo;
import java.util.ArrayList;
import java.util.Map;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;


public class Transacciones {
	public static ArrayList<Transacciones> miListaTrans = new ArrayList<>();
	public int codigoCuenta;
	public Double monto;
	public LocalDate fechaDeposito;
	public LocalDate fechaDebito;

	public Transacciones(int codigoCuenta, Double monto, LocalDate fechaDeposito, LocalDate fechaDebito) {
		this.codigoCuenta = codigoCuenta;
		this.monto = monto;
		this.fechaDeposito = fechaDeposito;
		this.fechaDebito = fechaDebito;
		// TODO Auto-generated constructor stub
	}
	public Transacciones() {
		// TODO Auto-generated constructor stub
	}
	public String DEPOSITO(int codigoCuenta, Double monto, LocalDate fechaDeposito,LocalDate fechaDebito) {
		String ip="";
		//recibimos los parametros
		Transacciones deposito1 = new Transacciones(); 
		deposito1.codigoCuenta = codigoCuenta;
		deposito1.monto = monto;
		deposito1.fechaDeposito = fechaDeposito;
		deposito1.fechaDebito = fechaDebito;
		miListaTrans.add(deposito1);
		if (miListaTrans.contains(deposito1)) {
			ip = "El deposito se registro\n";
			int cuentaBuscada = deposito1.codigoCuenta;
	        double nuevoSaldo = deposito1.monto;

	        for (Cuenta cuentaB : Cuenta.miListaCuenta) {
	            if (cuentaB.getcodigoCuenta()==cuentaBuscada) {
	            	double saldonew = nuevoSaldo + cuentaB.depositoInicial;  
	            	cuentaB.setSaldo(saldonew);
	            	 ip= "Deposito realizado\n";
	            	 Mando.cant_DepGen++;
	                break;
	            }
	        }
		} else {
			ip = "El deposito no se registro\n";
			Mando.errores++;
		}

		return ip;
	}
	
	
	public String RETIRO(int codigoCuenta, Double monto, LocalDate fechaDeposito,LocalDate fechaDebito){
		//string para retorno
		String ip="";
		//recibimos los parametros
		Transacciones retiro1 = new Transacciones(); 
		retiro1.codigoCuenta = codigoCuenta;
		retiro1.monto = monto;
		retiro1.fechaDeposito = fechaDeposito;
		retiro1.fechaDebito = fechaDebito;
		miListaTrans.add(retiro1);
		if (miListaTrans.contains(retiro1)) {
			ip = "El retiro se registro\n";
			int cuentaBuscada = retiro1.codigoCuenta;
	        double nuevoSaldo = retiro1.monto;

	        for (Cuenta cuentaB : Cuenta.miListaCuenta) {
	            if (cuentaB.getcodigoCuenta()==cuentaBuscada) {
	            	
	            	double saldonew = nuevoSaldo - cuentaB.depositoInicial;
	            	cuentaB.setResSaldo(saldonew);
	            	 ip= "Retiro realizado\n";
	            	 Mando.cant_RetCuenta++;
	                break;
	            }
	        }
		} else {
			ip = "El deposito no se registro\n";
			Mando.errores++;
		}
		return ip;
		
	}
	//metodo obtener cod cuenta
		public int getcodigoCuenta() {
	        return codigoCuenta;
	    }
		//metodo que retorna fecha deposit
		private LocalDate getFechaDepo() {
			// TODO Auto-generated method stub
			return fechaDeposito;
		}
	
	//para ver la lista de transacciones
	 public String toString() {
	        return "Transaccion [ " + codigoCuenta + " " + monto + " " + " "+ fechaDeposito+ " "+fechaDebito+"] ";
	    }
	 public void localizarcuenta(){
		 
		 
	 }

}
