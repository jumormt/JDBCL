package com.itheima.b_datasourc.c_warp;

public class CarWarp implements Car {

	private Car car;

	public CarWarp(Car car){
		this.car=car;
	}
	@Override
	public void run() {
		System.out.println("加上电池");
		System.out.println("我终于可以5秒破百了..");
	}

	@Override
	public void stop() {
		car.stop();
	}

}
