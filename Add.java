
public class Add extends Command{
	public String gate_or_line;
	public String gate_name;
	public String gate_type;
	public Gate new_gate;
	public Circuit Changed_circuit; 
	public String line_name;
	public String Start_gate_name;
	public String Start_gate_port;
	public String End_gate_name;
	public String End_gate_port;
	public Gate Start_Gate;
	public Gate End_Gate;
	public Gate input_gate;

	
	public Line new_line; 
	public Add() {
		Command_name= "add";
	}
	
	public String get_command_name()
	{
		return "add";
	}

	@Override
	public void execute() {
		  
		gate_or_line= Input_cmd_string.get(1);			//feed. add gate/line ~~~~
		
		
		if(gate_or_line.equals("gate"))
		{
			gate_name= Input_cmd_string.get(3);
			gate_type= Input_cmd_string.get(2);
			
			new_gate= Gate_Factory.Return_Concrete_Gate(gate_name,gate_type);	//(get_name, get_type)
			Changed_circuit= EDA_System.Get_circuit();
			Changed_circuit.Add_a_gate(new_gate);
			Response();
			int check=1;
		}
		else if(gate_or_line.equals("line"))
		{
			Changed_circuit= EDA_System.Get_circuit();
			line_name= Input_cmd_string.get(2);
			Start_gate_name= Input_cmd_string.get(4);
			Start_gate_port= Input_cmd_string.get(5);
			End_gate_name= Input_cmd_string.get(7);
			End_gate_port= Input_cmd_string.get(8);
			
			//new a line
			Line a_line = new Line(line_name,Start_gate_name,Start_gate_port,End_gate_name,End_gate_port);
			
			//if the input is a input line, we prevent it a gate called ~line_name~ exist. 
			//create_input_gate(line_name);
			set_line_start_and_end(a_line);
			Changed_circuit.Add_a_line(a_line);
			
			if(End_gate_name.equals("output"))
			{
				//set the input gate is_output true; 
				Changed_circuit.Get_gate(Start_gate_name).is_output= true;   
			}
			if(Start_gate_name.equals("input"))
			{
				if(End_gate_port.equals("i1"))
				{
					Changed_circuit.Get_gate(End_gate_name).Get_port("i1").Set_is_input_port(true);
				}
				else if(End_gate_port.equals("i2"))
				{
					Changed_circuit.Get_gate(End_gate_name).Get_port("i2").Set_is_input_port(true);
				}
				
			}
			if(!(End_gate_name.equals("output")) &&  !( Start_gate_name.equals("input") )  ){
				Changed_circuit.Get_gate(End_gate_name).Get_port(End_gate_port).link= Changed_circuit.Get_gate(Start_gate_name);
			}
			
			Response();
			int check= 1;
			
		}
		else
		{
			Error();//Direct to Error Handling. 
		}
		
	} 
	
	//as the input is not Gate really, it is a value input instead...
	private void create_input_gate(String line_name)
	{
		if(Start_gate_name.equals("input"))
		{
			input_gate= new Value_gate(line_name,"input");
			Changed_circuit.Add_a_gate(input_gate);	//Value gate's type and name are both "input"
		}
	}
	
	//Set a line's Start and End. 
	private void set_line_start_and_end(Line a_line)
	{
		if(Start_gate_name.equals("input"))
		{
			a_line.Start_gate_port= null;
			a_line.End_Port= Changed_circuit.Get_gate(End_gate_name).Get_port(End_gate_port);
		}
		else if(End_gate_name.equals("output")){
			a_line.Start_Port= Changed_circuit.Get_gate(Start_gate_name).Get_port(Start_gate_port);
			a_line.End_Port= null;
		}
		else{
			a_line.Start_Port= Changed_circuit.Get_gate(Start_gate_name).Get_port(Start_gate_port);
			a_line.End_Port= Changed_circuit.Get_gate(End_gate_name).Get_port(End_gate_port);
		}
		
			
		
		/*
		if(Start_gate_name.equals("input")) 
		{
			a_line.Start_Port= null;
		}
		else
		{
			a_line.Start_Port= Changed_circuit.Get_gate(Start_gate_name).Get_port(Start_gate_port);
		}
		
		
		if(End_gate_name.equals("output")) 
		{
			a_line.End_Port= null;

		}
		else
		{
			a_line.End_Port= Changed_circuit.Get_gate(End_gate_name).Get_port(End_gate_port);
		}
		*/		
	}
	
	
	@Override
	public void Response() {
		if(gate_or_line.equals("gate"))
		{
			System.out.println("one " + gate_type+"-gate called "+ "\""+ gate_name+ "\""+" has been added to circuit "+ Changed_circuit.Get_circuit_name());
		}
		else if(gate_or_line.equals("line"))
		{
			System.out.println("You have add a line called " + "\""+line_name + "\""+ " and its two ends are connected:");
			if(Start_gate_name.equals("input")){
				System.out.println( line_name + ".START:as input");								
			}
			else{
				System.out.println( line_name + ".START:the output 1 of gate "+"\""+ Start_gate_name +"\"");
			}
			
			if(End_gate_name.equals("output")){
				System.out.println(line_name + ".END:as output");
			}
			else{
				System.out.println(line_name + ".END:the input " +End_gate_port.charAt(1)+" of gate "+"\""+ End_gate_name+"\"");				
			}		
		}	
	}




}
