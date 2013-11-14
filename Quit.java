
public class Quit extends Command{

	public Quit() {
		Command_name= "quit";
	}
	
	public String get_command_name(){
		return "quit";
	}

	@Override
	public void Response() {
		System.out.println("Bye ! Thank you for using NCUEDA 1.0!");
		
	}

	@Override
	public void execute() {
		Response();
		System.exit(1);		
	} 

}
