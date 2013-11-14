
public abstract class Gate {
	public String Gate_name; 
	public String type; 
	public boolean is_output= false;
	public boolean is_input= false;
	public boolean input_value;
	//For maintain the line connection information only.
    public Port input_port1;
    public Port input_port2;
    public Port output_port;
    
    //For much faster calculation, the real member variables used as we need to evaluate. 
    public Gate input_1;
    public Gate input_2;
	
	public Gate(){		//YOU SHOULD INI HERE! AND CALL SUPER(~) in Subclasses.  
	 
		input_port1= new Port("i1");
		input_port2= new Port("i2");
		output_port= new Port("o1");
	
	}
	public void Set_Gate_name(String gate_name){
		Gate_name= gate_name;
	}
	
	public void Change_Get_type(String gate_type){
		this.type= gate_type; 
		
	}
	
	/**For switch command.
	 * 
	 */
	public void Change_Gate_type(String new_type)
	{
		this.type= new_type;
	}
	
	public void Set_is_output(boolean is_output)
	{
		this.is_output= is_output; 
	}
	
	public Port Get_port(String port_name)
	{
		if(port_name.equals("i1"))
		{
			return input_port1;
		}
		else if(port_name.equals("i2"))
		{
			return input_port2;
		}
		else if(port_name.equals("o1"))
		{
			return output_port;
		}
		
		System.out.println("Fault input.");
		return null;
	}
	
	public abstract boolean evaluate();			//just declaration.	

	/*
	public boolean evaluate(String operation){
		if(operation.equals("AND"))
		{
			
		}
		else if(operation.equals("NAND")){
			
		}
		else if(operation.equals("OR")){
			
		}
		else if(operation.equals("NOR")){
			
		}
		else if(operation.equals("NOT")){
			
		}
		else{
			
		}
			
		
		
	}*/
}
