
public class Different_Evaluation {
	
	public static boolean Evaluate(boolean port1_value,boolean port2_value,String operation)
	{
		if(operation.equals("AND"))
		{
		  return (port1_value&port2_value);
		}
		else if(operation.equals("NAND")) 
		{
			return !(port1_value & port2_value );
		}
		else if(operation.equals("OR"))
		{
			return (port1_value | port2_value) ;
		}
		else if(operation.equals("NOR"))
		{
			return  !( port1_value | port2_value );
		}
		else if(operation.equals("NOT"))
		{
			return  !(port1_value); 
		}
		else
		{
			System.out.println("Fault operation");
			return false; 
		}
		
	}
}
