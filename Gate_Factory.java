
public class Gate_Factory {
	
	public static Gate Return_Concrete_Gate(String gate_name, String gate_type ){

		if(gate_type.equals("AND") )
		{
			return new AND_gate(gate_name,gate_type );
		}
		else if(gate_type.equals("OR") )
		{
			return new OR_gate(gate_name,gate_type );
		}
		else if(gate_type.equals("NOT") )
		{
			return new NOT_gate(gate_name,gate_type );
		}
		else if(gate_type.equals("NAND") )
		{
			return new NAND_gate(gate_name,gate_type );
		}
		else if(gate_type.equals("NOR"))
		{
			return new NOR_gate(gate_name,gate_type );
		}
		else						//Report error. Since the user input a nonexistent command.  
		{
			System.out.println(gate_type+"doesn't exist!");
			return null; 
		}
		
	}
}
