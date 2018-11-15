package designpattern.command;

public interface CommandControler {

	public void execute(String command);
	public boolean canHandle(String command);
}
