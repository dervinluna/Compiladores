package codigo;
import java.util.ArrayList;
import java.util.Map;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;


public class Transacciones {
	public static ArrayList<Transacciones> miListaDeposito = new ArrayList<>();
	public static ArrayList<Transacciones> miListaRetiro = new ArrayList<>();
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
		int cuentaBuscada = deposito1.codigoCuenta;
		double nuevoSaldo = deposito1.monto;
		miListaDeposito.add(deposito1);
		LocalDate fechaBuscada = deposito1.fechaDeposito;
		if (miListaDeposito.contains(deposito1)) {//if 1
			
			//verificamos si el arraylist solo tiene un elemto
			if(miListaDeposito.size()==1) {//if 2
	    
	        for (Cuenta cuentaB : Cuenta.miListaCuenta) {// for 1
	            if (cuentaB.getcodigoCuenta()==cuentaBuscada) {//if 3
	            	double saldonew = nuevoSaldo + cuentaB.depositoInicial;  
	            	cuentaB.setSaldo(saldonew);
	            	 ip= "Primer Deposito realizado "+saldonew+"\n";
	            	
	            	Mando.cant_DepGen++;
	            	 return ip;
	            }//if 3
	        } //for 1
			}//if 2
			//si el arraylist tiene mas de un elemto
			else { //else 2
				/*recorremos la lista depositos desde el penultimo lugar al inicio 
				 * en busca de un deposito anterior en esa misma cuenta
				 * buscamos un deposito con el mismo numero de cuenta al que actualmente queremos hacer
				*/
				for (int i = miListaDeposito.size()-2; i >= 0; i--) { //for 2
					/*
					 * validamos si enconctramos un deposito realizado anteriormente en la misma cuenta a la que 
					 * queremos ralizarcelo actualmente*/
					if(cuentaBuscada==miListaDeposito.get(i).getcodigoCuenta()) { //if 4
					/*hacemos una evaluacion de que si la fecha de ese deposito  realizado con anterioridad es anterior
					 * o igual a la que trae el deposito actual
			        */
						LocalDate fechaListaDepo = miListaDeposito.get(i).getFechaDepo(); //guardamos la fecha que tiene la posicion actual de lista deposits
						if(fechaBuscada.isAfter(fechaListaDepo) || fechaBuscada.isEqual(fechaListaDepo)) {//if 5
			        for (Cuenta cuentaB : Cuenta.miListaCuenta) { //for 3
			            if (cuentaB.getcodigoCuenta()==cuentaBuscada) {//if 6
			            	double saldonew = nuevoSaldo + cuentaB.depositoInicial;  
			            	cuentaB.setSaldo(saldonew);
			            	 ip= "Deposito evaluado y realizado "+saldonew+"\n";
			            	 Mando.cant_DepGen++;
			            	 return ip;
			            }//if 6
			        }//for 3
					}//if 5
						else { ip= "Deposito no realizado fechas no coinciden \n";
						Mando.errores++;
						return ip;
						}
				
					
					}//if 4
					else {//else 3
						if(i==0) {
						//significa que no hay depositos anteriores a la misma cuenta por lo tanto podemos depositar sin evaluar las fechas
						for (Cuenta cuentaB : Cuenta.miListaCuenta) {
				            if (cuentaB.getcodigoCuenta()==cuentaBuscada) {
				            	double saldonew = nuevoSaldo + cuentaB.depositoInicial;  
				            	cuentaB.setSaldo(saldonew);
				            	 ip+= "Deposito realizado "+saldonew+"\n";
				            	 Mando.cant_DepGen++;
				            	 return ip;
				            	// Mando.cant_DepGen++;
				            }
				        }	
					
						}
					}//else 3
					}//for 2
				}// else 2
				
			}//if 1
		
		else {//else 1
			ip = "El deposito no se registro\n";
			Mando.errores++;
		}//else 1

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
		int cuentaBuscada = retiro1.codigoCuenta;
		double debito = retiro1.monto;
		miListaRetiro.add(retiro1);
		LocalDate fechaBuscada = retiro1.fechaDebito;
		if (miListaRetiro.contains(retiro1)) {//if 1
			
			//verificamos si el arraylist solo tiene un elemto
			if(miListaRetiro.size()==1) {//if 2
	    
	        for (Cuenta cuentaB : Cuenta.miListaCuenta) {// for 1
	            if (cuentaB.getcodigoCuenta()==cuentaBuscada) {//if 3  
	            	//evaluamos si el saldo de la cuenta es mayor o igual al retiro
	            	if(cuentaB.depositoInicial>=debito) {
		            	double saldonew = cuentaB.depositoInicial-debito;  
		            	ip= "Primer Retiro evaluado y realizado"+cuentaB.depositoInicial+"Debito:"+debito+"\n";
		            	cuentaB.setSaldo(saldonew);
		            	 //ip= "Primer Retiro evaluado y realizado"+cuentaB.depositoInicial+"Debito:"+debito+"\n";
		            	 Mando.cant_RetGen++;
		            	 return ip;
		            }else {ip= "Fondos insuficientes\n";return ip;}
	            }//if 3
	        } //for 1
			}//if 2
			//si el arraylist tiene mas de un elemto
			else { //else 2
				/*recorremos la lista depositos desde el penultimo lugar al inicio 
				 * en busca de un deposito anterior en esa misma cuenta
				 * buscamos un deposito con el mismo numero de cuenta al que actualmente queremos hacer
				*/
				for (int i = miListaRetiro.size()-2; i >= 0; i--) { //for 2
					/*
					 * validamos si enconctramos un deposito realizado anteriormente en la misma cuenta a la que 
					 * queremos ralizarcelo actualmente*/
					if(cuentaBuscada==miListaRetiro.get(i).getcodigoCuenta()) { //if 4
					/*hacemos una evaluacion de que si la fecha de ese deposito  realizado con anterioridad es anterior
					 * o igual a la que trae el deposito actual
			        */
						LocalDate fechaListaReti = miListaRetiro.get(i).getFechaReti(); //guardamos la fecha que tiene la posicion actual de lista deposits
						if(fechaBuscada.isAfter(fechaListaReti) || fechaBuscada.isEqual(fechaListaReti)) {//if 5
			        for (Cuenta cuentaB : Cuenta.miListaCuenta) { //for 3
			            if (cuentaB.getcodigoCuenta()==cuentaBuscada) {//if 6
			            	//evaluamos si el saldo de la cuenta es mayor o igual al retiro
			            	if(cuentaB.depositoInicial>=debito) {
			            	double saldonew = cuentaB.depositoInicial-debito;  
			            	cuentaB.setSaldo(saldonew);
			            	 ip= "Retiro evaluado y realizado\n";
			            	 Mando.cant_RetGen++;
			            	 return ip;
			            }else {ip= "Fondos insuficientes\n";return ip;}
			            }//if 6
			        }//for 3
					}//if 5
						else { ip= "Retiro no realizado fechas no coinciden \n";
						Mando.errores++;
						return ip;
						}
					}//if 4
					else {//else 3
						if(i==0) {
						//significa que no hay retiros anteriores a la misma cuenta por lo tanto podemos depositar sin evaluar las fechas
						for (Cuenta cuentaB : Cuenta.miListaCuenta) {
				            if (cuentaB.getcodigoCuenta()==cuentaBuscada) {
				            	//evaluamos si el saldo de la cuenta es mayor o igual al retiro
				            	if(cuentaB.depositoInicial>=debito) {
				            	double saldonew = cuentaB.depositoInicial -debito;  
				            	cuentaB.setSaldo(saldonew);
				            	 ip= "Retiro realizado\n";
				            	 Mando.cant_RetGen++;
				            	 return ip;
				            	// Mando.cant_DepGen++;
				            	}else {ip= "Fondos insuficientes\n";return ip;}
				            }
				        }
						}
					}//else 3
					}//for 2
				}// else 2
			}//if 1
		else {//else 1
			ip = "El Retiro no se registro\n";
			Mando.errores++;
		}//else 1
		return ip;	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//metodo obtener cod cuenta
		public int getcodigoCuenta() {
	        return codigoCuenta;
	    }
		//metodo que retorna fecha deposit
		private LocalDate getFechaDepo() {
			return fechaDeposito;
		}
		private LocalDate getFechaReti() {
			return fechaDebito;
		}
	
	
	 public void localizarcuenta(){
		 
		 
	 }

}
