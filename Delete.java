
public class Delete extends Command{

	public Delete() {
		Command_name= "delete";
	}
	
	public String get_command_name(){
		return "delete";
	} 
	
	public void execute(){
		Response();
		EDA_System.Set_Circuit_Name("");	
	}

	@Override
	public void Response() {
		System.out.println("Your circuit "+EDA_System.Get_circuit_name() +" is deleted.");
		
	}
	
}
