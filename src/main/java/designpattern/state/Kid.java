package designpattern.state;

public class Kid {

	private int age;

	private KidsState kidState;

	public Kid(int age){

		this.setAge(age);

	}

	

	public void play(){

		kidState.play();

	}

	

	public void eat(){

		kidState.eat();

	}

	

	public void setAge(int age){

		this.age = age;

		if(age == 1){

			kidState = new FirstYear();

		}else if(age ==2){

			kidState = new SecondYear();

		}else if(age ==3){

			kidState = new ThirdYear();

		}else if(age == 4){

			kidState = new FourthYear();

		}else{

			kidState = new FirstYear();

		}

	}
}
