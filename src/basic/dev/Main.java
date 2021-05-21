package basic.dev;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Main {
	static List<Shape> readFromFile(String fileName) throws Exception{
		List<Shape> arrList  = new ArrayList<Shape>();
		
		FileInputStream fts = new FileInputStream(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(fts));
		String strLine;
		
		while((strLine = br.readLine()) != null) {
			if(strLine.indexOf("#Rec") == 0){
				String name = strLine.substring(1,strLine.length());
				double canhA = Double.parseDouble(br.readLine());
				double canhB = Double.parseDouble(br.readLine());
				Shape rec = new Rectangle(name,canhA, canhB);
				arrList.add(rec);
			}
			if(strLine.indexOf("#Cir") == 0){
				String name = strLine.substring(1,strLine.length());
				double banKinh = Double.parseDouble(br.readLine());
				Shape cir = new Circle(name, banKinh);
				arrList.add(cir);
			}
			if(strLine.indexOf("#Tri") == 0){
				String name = strLine.substring(1,strLine.length());
				double canhA = Double.parseDouble(br.readLine());
				double canhB = Double.parseDouble(br.readLine());
				double canhC = Double.parseDouble(br.readLine());
				Shape tri = new Triangle(name, canhA, canhB, canhC);
				arrList.add(tri);
			}
		}
		
		return arrList;
	}
	static void print(List<Shape> list) {
		for (Shape shape : list) {
			String str = String.format("Ten: %s  -- Chu vi: %f -- Dien tich: %f",shape.name(),shape.chuVi(),shape.dienTich());
			System.out.println(str);
		}
	}
	static void findMinMax(List<Shape> list) {
		Iterator<Shape> it = list.iterator();
		Shape minCV = list.get(0);
		Shape minDT = list.get(0);
		Shape maxCV = list.get(0);
		Shape maxDT = list.get(0);
		
		while(it.hasNext()){
			Shape shape = it.next();
			if(minCV.chuVi() > shape.chuVi()) {
				minCV = shape;
			}
			if(minDT.dienTich() > shape.dienTich()) {
				minDT = shape;
			}
			if(maxCV.chuVi() < shape.chuVi()) {
				maxCV = shape;
			}
			if(maxDT.dienTich() < shape.dienTich()) {
				maxDT = shape;
			}
		}
		String str1 = String.format("Chu vi nho nhat: %s ---- %f", minCV.name(),minCV.chuVi());
		String str2 = String.format("Chu vi lon nhat: %s ---- %f", maxCV.name(),maxCV.chuVi());
		String str3 = String.format("Dien tich nho nhat: %s ---- %f", minDT.name(),minDT.dienTich());
		String str4 = String.format("Dien tich lon nhat: %s ---- %f", maxDT.name(),maxDT.dienTich());
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
	}
	static void sort(List<Shape> list) {
		
		Collections.sort(list,new Comparator<Shape>() {

			@Override
			public int compare(Shape arg0, Shape arg1) {
				// TODO Auto-generated method stub
				if(arg0.chuVi() < arg1.chuVi()) {
					return -1;
				}else if(arg0.chuVi() > arg1.chuVi()) {
					return 1;
				}else {
					return 0;
				}
			}
			
		});
		print(list);
	}
	public static void main(String[] args) throws Exception {
		List<Shape> listS = new ArrayList<Shape>();
		listS = readFromFile("input.txt");
		print(listS);
		System.out.println("----------");
		findMinMax(listS);
		System.out.println("-----------------------");
		sort(listS);
		
	}
}
