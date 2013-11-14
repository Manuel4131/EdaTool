
public class Port{
	
	public String Port_name;
	public Gate link;				//要讓port去指向Gate.
	public boolean value; 
	public boolean is_input_port=false; 
	
	public Port(String name)
	{
		Port_name= name; 
	}
	
	public String Get_Port_Name()
	{
		return Port_name; 
	}
	
	public void Set_value(boolean value){
		this.value= value; 		
	}
	
	public void Set_is_input_port(boolean judge)
	{
		this.is_input_port= judge; 
	}
	
	public boolean Get_value(){
	
		if(is_input_port == true){
			return this.value;
		}
		else{
			return link.evaluate(); 
		}
		 		
	}
}
