package Java8.methodreference;

 interface Messagable{
	
	public Message say(String str);
}

class Message{
	
	Message(String msg){
		System.out.println(msg);
	}
}
public class ConstructorMethodReference {
	
	public static void main(String[] args){
		

	Messagable m=Message::new;
	m.say("hello");
	}
}
