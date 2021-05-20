package basic.dev;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
* Viet chuong trinh xay dung lop abstract class Shape voi phuong thuc tru tuong
* tinhChuVi
* tinhDienTich
*
* Xay dung 3 lop con ke thua lop Shape
* Circle: banKinh
* Rectangle: canhA, canhB
* Triangle: canhA, canhB, canhC
* 1. Viet ham nhap, xuat vao danh sach List<Shape> list doc tu file input
* 2. Viet ham tim xem hinh nao co chu vi lon nhat, be nhat, hinh nao co dien tich lon nhat, be nhat
* 3. Viet ham sap xep list theo danh sach chu vi be den lon
* @author TranThanhBinh
*
*/
public class Main {
	static List<Shape> readFromFile(String fileName) throws IOException {
		List<Shape> shapeList = new ArrayList<Shape>();
		FileInputStream fstream = new FileInputStream(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String strLine;
		while((strLine = br.readLine()) != null) {
			if(strLine.indexOf('#') == 0 && strLine.indexOf('C') == 1) {
				String name = strLine.substring(1, strLine.length());
				float banKinh = Float.parseFloat(br.readLine());
				Shape cir = new Circle(name, banKinh);
				shapeList.add(cir);
			}
			if(strLine.indexOf('#') == 0 && strLine.indexOf('R') == 1) {
				String name = strLine.substring(1, strLine.length());
				float canhA = Float.parseFloat(br.readLine());
				float canhB = Float.parseFloat(br.readLine());
				Shape rec = new Rectangle(name, canhA, canhB);
				shapeList.add(rec);
			}
			if(strLine.indexOf('#') == 0 && strLine.indexOf('T') == 1) {
				String name = strLine.substring(1, strLine.length());
				float canhA = Float.parseFloat(br.readLine());
				float canhB = Float.parseFloat(br.readLine());
				float canhC = Float.parseFloat(br.readLine());
				Shape triag = new Triangle(name, canhA, canhB, canhC);
				shapeList.add(triag);
			}
		}
		return shapeList;
		}
	static void print(List<Shape> shapeList) {
		for (Iterator iterator = shapeList.iterator(); iterator.hasNext();) {
				Shape sh = (Shape) iterator.next();
				System.out.println(sh.name()+" - CV= "+ sh.chuVi());
		}
		}
	
	static void find(List<Shape> listS) {
		listS = new ArrayList<Shape>();
		Shape arrS[]  = listS.toArray(new Shape[listS.size()]);
		float preCV = arrS[0].chuVi();
		int indexMaxCV = 0;
		float preDT = arrS[0].dienTich();
		int indexMaxDT = 0;
		for (int i = 0; i < arrS.length; i++) {
			if(arrS[i].chuVi() > preCV) {
				preCV = arrS[i].chuVi();
				indexMaxCV = i;
			}
			if(arrS[i].dienTich() > preDT) {
				preDT = arrS[i].dienTich();
				indexMaxDT = i;
			}
		}
			
		
		String strCVMax = String.format("Chu vi lon nhat: %s, Chu vi: %f" , arrS[indexMaxCV].name(), preCV);
		String strDTMax = String.format("Dien tich lon nhat: %s, Dien tich: %f" , arrS[indexMaxDT].name(), preDT);
		
		preCV = arrS[0].chuVi();
		indexMaxCV = 0;
		preDT = arrS[0].dienTich();
		indexMaxDT = 0;
		
		for (int i = 0; i < arrS.length; i++) {
			if(arrS[i].chuVi() < preCV) {
				preCV = arrS[i].chuVi();
				indexMaxCV = i;
			}
			if(arrS[i].dienTich() < preDT) {
				preDT = arrS[i].dienTich();
				indexMaxDT = i;
			}
		}
		
		String strCVMin = String.format("Chu vi be nhat: %s, Chu vi: %f" , arrS[indexMaxCV].name(), preCV);
		String strDTMin = String.format("Dien tich be nhat: %s, Dien tich: %f" , arrS[indexMaxDT].name(), preDT);
		
		System.out.println(strCVMin);
		System.out.println(strCVMax);
		System.out.println(strDTMin);
		System.out.println(strDTMax);
	}
	
	static List<Shape> shortList(List<Shape> listS){
		
		Collections.sort(listS,new Comparator<Shape>() {

			@Override
			public int compare(Shape s1, Shape s2) {
				// TODO Auto-generated method stub
				if(s1.chuVi() < s2.chuVi()) {
					return -1;
				}else if(s1.chuVi() > s2.chuVi()) {
					return 1;
				}else {
					return 0;
				}
			}
		});
		return listS;
	}
	public static void main(String[] args) throws IOException {
		List<Shape> listShape = new ArrayList<Shape>();
		listShape = readFromFile("input.txt");
		
		//in ra mang
		System.out.println("Chu vi truoc sx");
		print(listShape);
		//sap xep chu vi
		
		shortList(listShape);
		System.out.println("\nChu vi sau sx");
		print(listShape);
		//tim min max
		find(listShape);
		
	}
}
