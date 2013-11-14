
public class List extends Command{

	public List() {
		Command_name= "list";
	}
	
	public String get_command_name()
	{
		return "list";
	}

	@Override
	public void Response() {
		
		
	}

	Circuit current_circuit; 
	@Override
	public void execute() {
		current_circuit= EDA_System.Get_circuit();
		System.out.println("Gate information:");
		for(Gate g:current_circuit.Get_gates()){
			System.out.println(g.Gate_name+ "\t" +g.type);
		}
		System.out.println("Line information:");
		String l_temp;
		for(Line l:current_circuit.Get_lines()){
			l_temp= "Line "+l.getLine_name()+":"+ l.Start_gate_name+ "."+l.Start_gate_port+ " "+l.End_gate_name+"."+l.End_gate_port;
			l_temp= l_temp.replaceFirst(".0", " ");
			System.out.println(l_temp);
		}
		
	} 
	
}
