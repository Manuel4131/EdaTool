
public class AND_gate extends Gate{
		
	public AND_gate(String gate_name,String gate_type){
		Gate_name= gate_name; 
		type= gate_type;
	}

	@Override
	public boolean evaluate() {
		return Different_Evaluation.Evaluate(input_port1.Get_value(),input_port2.Get_value(),type);
	}
	
}
