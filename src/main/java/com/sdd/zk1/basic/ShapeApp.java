package com.sdd.zk1.basic;

import java.util.ArrayList;
import java.util.List;

class ShapeApp {

	public static void main(String[] args) {
		Car mobil1 = new Car();
		mobil1.setName("daihatsu");
		mobil1.setGigi(true);
		
		Car mobil2 = new Car();
		mobil2.setGigi(true);
		mobil2.setName("Honda");
		
		if(mobil2.isGigi==true) {
			System.out.println("silahkan menggunakan gigi");
		}else {
			System.out.println("tidak menggunakan gigi");
		}
		
		ArrayList<Integer> deret = new ArrayList<>();
		
		for (int i=1; i<10; i++) {
			deret.add(i+3);
		
		}
		
		for (int i=0;i<deret.size(); i++) {
			System.out.println("element ke"+i+" "+ deret.get(i));
		}
		
		System.out.println("memeriksa array apakah ada yang kosong:");
		System.out.println(deret.isEmpty());
		
		System.out.println(deret.indexOf(10));
		System.out.println(deret.contains(8));
		System.out.println(deret.get(4));		
		System.out.println("setelah ditambahkan sizenya menjadi "+deret.size());
		deret.remove(8);
		deret.remove(2);
		
		deret.add(7, 90);
		deret.add(8,100);
		deret.add(9,100);

		System.out.println("setelah dihapus sizenya menjadi:" +deret.size());
		System.out.println("index ke "+deret.getClass()+"yaitu");
		
	}
	
}
