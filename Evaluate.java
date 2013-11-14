import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Dictionary;

public class Evaluate extends Command{
	public List<String> input_line = new ArrayList<String>();
	public List<Boolean> input_line_value = new ArrayList<Boolean>();
	public Circuit Changed_circuit= EDA_System.Get_circuit();
	public List<Line> Circuit_line=Changed_circuit.Get_lines(); 
	public Gate Start_Evaluate_Gate; 
	public Line ourput_line; 
	public boolean result; 
	public int int_result; 
	 
	@Override
	public void Response() {
		for(Line l: Circuit_line)
		{
			if(l.End_gate_name.equals("output")){
				ourput_line= l;				
			}
		}
		System.out.println("Circuit "+Changed_circuit.Get_circuit_name()+ " output are:");
		if(result == true){
			int_result= 1; 
		}
		else
		{
			int_result= 0;
		}
		System.out.println(ourput_line.Line_name+" = "+ int_result);
	}

	@Override
	public void execute() {
	//Set each input line the boolean value. 
		
		boolean result; 
		Line indicate_line;									// the input line found in the circuit_lines 
		int input_line_value_index= 0;  
		boolean assing_value= false; 
		//Get input line
		for(int i= 1; i<= Input_cmd_string.size()-2 ; i+=2){
			input_line.add(Input_cmd_string.get(i));			
		}
		
		//Get the correspondin value of the input line. 
		for(int j= 2; j <= Input_cmd_string.size()- 1; j+=2){
			if( Integer.parseInt(  Input_cmd_string.get(j) ) == 1 ){
				assing_value= true;
			}
			else if( Integer.parseInt(  Input_cmd_string.get(j) ) == 0 ){
				assing_value= false;
			}	
			input_line_value.add(  assing_value );			
		}
		
		//針對line中每個End 的Port去set value:
		
		
		for(Line l: Circuit_line){
			if(l.Line_type.equals("input_line")){
				l.End_Port.Set_value(input_line_value.get(input_line_value_index));
				input_line_value_index++;
			}
				
		}
		/*
		 * for(String s: input_line){
		 
			for(int i= 0; i< circuit_lines.size() ;i++){
					if(s.equals(circuit_lines.get(i).Line_name))
					{
						indicate_line= circuit_lines.get(i);
						indicate_line.End_Port.Set_value(input_line_value.get(input_line_value_index));
		 			}				
			}//inner for
			input_line_value_index++;
		}//outter for 
	*/
	//To find the first gate which is going to manipulate.
		
	List<Gate> gates= Changed_circuit.Get_gates(); 
	for(Gate g: gates)
	{
		if(g.is_output== true){
			Start_Evaluate_Gate= g;  
		}		
	}
	 
	this.result= Start_Evaluate_Gate.evaluate();
	Response(); 
	
	input_line_value.clear(); 
	input_line.clear();
	
	
	
	}//execute()
	
	
	
	
	
	
	
	/*
	private static final String String = null;
	public String Input_string=""; 
	public BufferedReader rw; 
	public Map<String,String> map= new HashMap<String,String>();
	public Evaluate() {
		Command_name= "evaluate";
	}
	
	public String get_command_name()
	{
		return "evaluate";
	}

	@Override
	public void Response() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
		create_map();				//To create the map. 
		int i= 0;
		String Input_string="";
		for(i=2; i<8 ;i=i+2){
			Input_string +=Input_cmd_string.get(i);
			Input_string +=" ";
		}
		Input_string +=Input_cmd_string.get(i);
			
			String answer= (String) map.get(Input_string );
			System.out.println("Circuit "+EDA_System.Get_circuit_name()+" output are:");
			System.out.println("I = "+answer);
	     	int check= 1;	     	
	} 
	public void create_map(){
		String tmp_s;
		StringTokenizer tokens;
		String Key;
		String Value;
		

		try {
			rw= new BufferedReader(new FileReader("src/true_false.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			try{
				while((tmp_s= rw.readLine())!=null)
				{
					tokens= new StringTokenizer(tmp_s,"\t");
					while(tokens.hasMoreTokens()){
						Key= tokens.nextToken();
						Value= tokens.nextToken();
						map.put(Key, Value);
					}
					
				}
			} catch (IOException e) {				
				e.printStackTrace();
			}
		
	}
	*/

}
