package designpattern.command;

import java.util.Iterator;
import java.util.List;

public class Cockpit implements CommandControler{

	
private List<CommandControler> commandControls;

	

	public Cockpit(List<CommandControler> commandControls){

		commandControls.add(this);

		this.commandControls = commandControls;

	}

	

	public static final String TAKE_OFF = "TAKE_OFF";

	public static final String LAND = "LAND";

	public static final String REACH_ALTITUDE = "REACH_ALTITUDE";

	public static final String EXIT = "EXIT";

	

	@Override

	public void execute(String command) {

		Iterator<CommandControler> commandIterator = this.commandControls.iterator();

		while(commandIterator.hasNext()){

			CommandControler commandController = commandIterator.next();

			if(commandController instanceof Cockpit){

				switch (command) {

				case Cockpit.TAKE_OFF:

					this.takeOff();

					break;

				case Cockpit.LAND:

					this.land();

					break;

				case Cockpit.REACH_ALTITUDE:

					this.reachAltitudeAndFly();

					break;

				case Cockpit.EXIT:

					System.exit(1);

				}

			}else if(commandController.canHandle(command)){

				commandController.execute(command);

			}

		}

	}





	@Override

	public boolean canHandle(String command) {

		if(TAKE_OFF.equals(command)||LAND.equals(command)||

				REACH_ALTITUDE.equals(command)||EXIT.equals(command)){

			return true;

		}

		return false;

	}

	



	

	private void takeOff(){

		System.out.println("Fligh Take Off operations---------");

		this.execute(EngineControls.SPEED_UP);

		this.execute(WingControls.MOVE_UP);

		System.out.println("---------");

	}

	

	private void reachAltitudeAndFly(){

		System.out.println("Flying at an altitue---------");

		this.execute(EngineControls.SPEED_UP);

		this.execute(WingControls.KEEP_FLAT);

		System.out.println("---------");

	}

	

	private void land(){

		System.out.println("Landing the Flight----------");

		this.execute(EngineControls.SLOW_DOWN);

		this.execute(WingControls.MOVE_DOWN);

		System.out.println("---------");

	}
}
