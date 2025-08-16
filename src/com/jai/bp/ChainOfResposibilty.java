package com.jai.bp;

abstract class SupportHandler {
	SupportHandler supportHandler;

	public void setNext(SupportHandler supportHandler) {
		// TODO Auto-generated method stub
		this.supportHandler=supportHandler;
	}

	protected abstract void requestHandler(String string);
	
	

}

class FornLineHandler extends SupportHandler {

	@Override
	protected void requestHandler(String string) {
		// TODO Auto-generated method stub
		if(string.equals("low")) {
			System.out.println("low");
		}else if(supportHandler!=null) {
			supportHandler.requestHandler(string);	
		}
	}

}

class MiddleLevelHandler extends SupportHandler {

	@Override
	protected void requestHandler(String string) {
		if(string.equals("middle")) {
			System.out.println("middle");
		}else if(supportHandler!=null) {
			supportHandler.requestHandler(string);
		}
		
	}

}

class ManagereLevelHandler extends SupportHandler {

	@Override
	protected void requestHandler(String string) {
		if(string.equals("high")) {
			System.out.println("high");
		}else {
			System.out.println("can't handler");
		}
		
	}

}

public class ChainOfResposibilty {
	public static void main(String[] args) {
		SupportHandler fornLineHandler=new FornLineHandler();
		SupportHandler middleLevelHandler=new MiddleLevelHandler();
		SupportHandler managereLevelHandler=new ManagereLevelHandler();
		
		fornLineHandler.setNext(middleLevelHandler);
		middleLevelHandler.setNext(managereLevelHandler);
		
		fornLineHandler.requestHandler("low");
		
		fornLineHandler.requestHandler("high");
		fornLineHandler.requestHandler("middle");
		
		
		
		
	}
}
