package ui;
import java.util.Scanner;
import java.util.ArrayList;
import controlers.*;



public class ABMCPersonaConsole {
	private Scanner s;
	private  CtrlABMCPersona ctrl;
	public ABMCPersonaConsole()
	{
		s = new Scanner(System.in);
		ctrl = new CtrlABMCPersona();
		
	}
public void start()
{
	 String rta = "";
	 boolean continua = true;
	do 
	 {
		System.out.println("Alta, Baja, Modificacion y Carga de personas \n\n\n");
		System.out.println("#########\n\n\n");
		System.out.println("Ingrese a -> Alta\n b -> Baja\n m -> Modificar\n c -> Cargar\n\n Cualquier otra letra para salir");
		rta = s.nextLine();
		switch (rta.toLowerCase())
		{
			case "a":
				this.alta();
				break;
			case "b":
				this.baja();
				break;
			case "m":
				this.modifica();
				break;
			case  "c":
				this.carga();
				break;
			default: 
				continua = false;
				break;
		}
		
	 }while(continua);
	 s.close();
}

	private void alta() {
		
		
	}

	private void carga() {
				
	}

	private void modifica() {
				
	}

	private void baja() {
				
	}
	

}
