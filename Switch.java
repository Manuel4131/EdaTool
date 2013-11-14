import java.util.List; 
public class Switch extends Command{

	public static Circuit current_curcuit;
	//public List<Gate> current_curcuit_gates;
	public String New_gate_type; 
	public Gate Gate_to_be_replaced; 
	public String Current_gate_name; 
	public Switch(){
		current_curcuit= EDA_System.Get_circuit();
		
	}
	
	
	
	@Override
	public void Response() {
		// TODO Auto-generated method stub
		System.out.println("The type of the gate " + "\""+ Current_gate_name +"\""+" has become " + New_gate_type);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		Current_gate_name= Input_cmd_string.get(2);
		
		New_gate_type= Input_cmd_string.get(3);
		
		//Find the gate which is going to be replaced by name. And set the New_gate_type variable  to the gate.  
		Gate_to_be_replaced= EDA_System.Get_circuit().Get_gate(Current_gate_name);
		Gate_to_be_replaced.Change_Get_type(New_gate_type);
		Response();
	}
	
	

}

/* This is not right, WHY?
 *  public String Current_gate_name; 
	public Switch(){
		current_curcuit= EDA_System.Get_circuit();
		
	}
 *   Gate_to_be_replaced= current_curcuit.Get_gate(Current_gate_name);
 *   
 * */
