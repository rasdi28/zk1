package com.sdd.zk1.basic;

class Shape {
	int getCorner() {
		return 0;
	}
}

class Rectagle extends Shape {
	
	int getCorner() {
		return 4;
	}
	
	int getParentCorner() {
		return super.getCorner();
	}
}

class Car{
	String name;
	boolean isGigi;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isGigi() {
		return isGigi;
	}
	public void setGigi(boolean isGigi) {
		this.isGigi = isGigi;
	}
	
	
}
