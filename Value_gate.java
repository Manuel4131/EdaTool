
public class Value_gate extends Gate{

	public boolean value; 
	public Value_gate(String gate_name,String gate_type){
		Gate_name= gate_name;
		type= gate_type; 
	}
	
	@Override
	public boolean evaluate() {
		return this.value;
	}
	
	public void Set_value(boolean value)
	{
		this.value= value; 
	}
}