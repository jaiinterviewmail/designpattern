package com.jai.bp;

interface Command{
	public void execute();
}


class Light{
	public void ligtOn() {
		System.out.println("light on");
	}
	public void lightOff() {
		System.out.println("light off");
	}
}


class LightOnCommand implements Command{

	 Light light;
	 
	 LightOnCommand(Light light){
		 this.light=light;
	 }
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		light.ligtOn();
	}
	
}

class LightOffCommand implements Command{
	Light light;
	LightOffCommand(Light light){
		this.light=light;
	}
	public void execute() {
		light.lightOff();
	}
	
}
class Remote {
	Command command;
	Remote(Command command){
		this.command=command;
	}
	
	public void press() {
		command.execute();
	}
}
public class CommandDesignPattern {
  public static void main(String[] args) {
	
	  Light light=new Light();
	  Command lightOnCommand=new LightOnCommand(light);
	  Command lightOffCommand=new LightOffCommand(light);
	  Remote remote =new Remote(lightOnCommand);
	  remote.press();
	  remote=new Remote(lightOffCommand);
	  remote.press();
	  
	  
}
}
