package designpattern.command;

import java.util.ArrayList;
import java.util.List;

public class Exec {

	public static void main(String[] args) {
		
		WingControls wingControls = new WingControls();

		EngineControls engineControls = new EngineControls();

		List<CommandControler> commandControllers = new ArrayList<CommandControler>();

		commandControllers.add(wingControls);

		commandControllers.add(engineControls);

		Cockpit cockpit = new Cockpit(commandControllers);

				

		Pilot pilot = new Pilot(cockpit);

		pilot.fly();
	}

}
