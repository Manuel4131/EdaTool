import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

//1. "Evaluate" function has to be changed.
//2. switch command added!
public class EDA_System {
	public static List<Circuit> Circuits= new ArrayList<Circuit>();
	public static Circuit Current_Curcuit= null; 
	public static String Circuit_name=""; 
	
	public static void main(String[] args) {
		
		String main_command= " ";
		List<Command> concrete_cmd_class= new ArrayList<Command>();				//The concrete classes of create/add/list/evaluate/delete/quit
		List<String> command_line= new ArrayList<String>();					//String list: create/add/list/evaluate/delete/quit
		//Read command name from text file. 
				String command_src= "src/commands.txt";
				String command_line_= " ";
				StringTokenizer command_tokens;
				String token= "	";
				String delimeter= "\t";
				BufferedReader read_command= null; 
				
				try {
					read_command = new BufferedReader(new FileReader(command_src));
					command_line_ = read_command.readLine(); 					//not handled by tokenizer.
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				
		//To create command. 
				command_tokens= new StringTokenizer(command_line_ ,delimeter);
				while(command_tokens.hasMoreTokens()){				
					command_line.add(command_tokens.nextToken());		//As u call .hasmoretoken the pointer will move to the next element! 					
				}
		//To create "concrete" command object list. 
				
				for(String tmp_cmd:command_line)
				{
					concrete_cmd_class.add(Command_Factory.Create_Concrete_Cmd(tmp_cmd));
				}
				
		
		
		//main Console.  
			int excution_times=0;
			Scanner scan_user_input= new Scanner(System.in);
			String user_input_string;
			StringTokenizer user_input_tokens;
			List<String> input_command_string= new ArrayList<String>();			//ie: add gate NAND t1
			String Execution_cmd_string=" "; 											//The main command(create/add/list...) which is going to be executed NOW.
			Command Execution_cmd;												//The command which is going to be executed NOW.
		while(!Execution_cmd_string.equals("quit"))
		{
			excution_times++;
			if(excution_times == 1){
				System.out.println("Welcome to NCUEDA 1.0, we are waiting for your command.");
			}
			System.out.print(Circuit_name +">");
			
			user_input_string= scan_user_input.nextLine();
			user_input_tokens= new StringTokenizer(user_input_string ," ");
			input_command_string.clear();
			while(user_input_tokens.hasMoreTokens()){				
				input_command_string.add(user_input_tokens.nextToken());		//As u call .has more token the pointer will move to the next element! 					
			}
														
			Execution_cmd_string= input_command_string.get(0);				//I probably got it.  i.e.:Execution_command_string= add || list || something...
			
			
			Execution_cmd= concrete_cmd_class.get( command_line.indexOf(Execution_cmd_string) );	//To get the concrete class! As I input add ~ ~ ~, I got the concrete class: "add"
			Execution_cmd.Set_input_cmd_str(input_command_string);					//To give the user's input to the concrete class. (Reuse again and again.)
			Execution_cmd.execute();
			
			
			
	
			
		}	
		int pause;
	}
	//private void create_a
	
	public static void Set_circuit(String circuit_name){
		Current_Curcuit= new Circuit(circuit_name);
		Circuits.add(Current_Curcuit);
		int check= 0; 
		
	}
	
	public static Circuit Get_circuit(){
		return Current_Curcuit;
	}
	
	
	public static void Set_Circuit_Name(String circuit_name)
	{
		Circuit_name= circuit_name;
	}
	
	public static String Get_circuit_name()
	{
		return Circuit_name; 
	}

		
}
