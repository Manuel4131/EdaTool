
public class Create extends Command{
	public String circuit_name; 
	
	public void Create()
	{
		Command_name= "create";
		
	}
	
	public String get_command_name()
	{
		return "create";
	} 
	public void execute()								//CLASSICAL! THE OTHER COMMAND SHOULD FOLLOW THE PATTERN TOO. 1. INI THE VAR FROM THE COMMAND LIST 2.Do Something 3.Response.  
	{
		circuit_name= Input_cmd_string.get(2);
		EDA_System.Set_Circuit_Name(circuit_name);
		EDA_System.Set_circuit(circuit_name);			//Set_circuit is quite essential, without this instruction no circuit would be established. 
		Response();
	}

	//Override  
	public void Response() {						//more extension: Delegate the fucking response information to text file to reduce the chances to change your CODDE. Since it's "STATIC DATA".(Seperate the Unchanged part!) 
		System.out.println("An empty circuit called " + "\"" + circuit_name + "\"" +
				" has been created !");
		System.out.println("Any commands you do are toward to " + circuit_name );
		
		
	}
}
