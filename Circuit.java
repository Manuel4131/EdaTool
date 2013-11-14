import java.util.ArrayList;
import java.util.List;

public class Circuit {
	public static String name;
	public static List<Gate> gates= new ArrayList<Gate>();
	public static List<Line> lines= new ArrayList<Line>();
	
	public Circuit(String name){
		this.name= name; 
	}
	
	public void Add_a_gate(Gate g){
		gates.add(g);
	}
	
	public void Add_a_line(Line l){
		lines.add(l);
	}
	
	public boolean evaluate(){
		
		
		return false; //tmp
	}
	
	public static String Get_circuit_name()
	{
		return name; 
	}
	
	public static void delete(){
		gates= null;
		lines= null; 			// to let garbage collector to detect the existing object become dangling. 
	}
	
	public static List<Gate> Get_gates(){
		return gates; 		
	}
	
	public static List<Line> Get_lines(){
		return lines; 		
	}
	
	//return the gate. 
	public Gate Get_gate(String gate_name){
		if(gate_name.equals("input"))
		{
			return null; 
		}
		
		for(int i= 0;i< gates.size();i++)
		{
			if(gate_name.equals(gates.get(i).Gate_name))
			{
				return gates.get(i);
			}			
		}
		//error handle
			return null; 				
	}
	
}
