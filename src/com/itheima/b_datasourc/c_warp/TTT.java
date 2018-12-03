package com.itheima.b_datasourc.c_warp;

public class TTT {

	public static void main(String[] args) {
		QQ qq = new QQ();
		/*qq.run();
		qq.stop();*/
		
		CarWarp warp = new CarWarp(qq);
		warp.run();
		warp.stop();
	}

}
