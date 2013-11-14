import java.util.List;
public class Line {
	public String Line_name;
	public String Start_gate_name;  
	public String Start_gate_port;
	public String End_gate_name;
	public String End_gate_port;
	public String Line_type=" "; 
	public Port Start_Port;
	public Port End_Port;
	
	Boolean test = null; 
	
	int Start_input_num;
	int End_input_num; 
	boolean USER_INPUT_VALUE;
	public Circuit current_circuit= EDA_System.Get_circuit();
	
	
	public Line()
	{
		
	}
	//Change it to just accept Start and End Port. And use a port to get its' name. 
	public Line(String name,String Start_gate_name,String Start_gate_port,String End_gate_name,String End_gate_port){
		Line_name= name; 
		this.Start_gate_name= Start_gate_name;
		this.Start_gate_port= Start_gate_port;
		this.End_gate_name= End_gate_name;
		this.End_gate_port= End_gate_port;
		if(this.Start_gate_name.equals("input")){
			this.Line_type= "input_line";
		} 
	}
	
	
	public String getLine_name() {
		return Line_name;
	}

	
}
