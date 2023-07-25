package edu.java.file07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;


public class FileMain07 {

	public static void main(String[] args) {
		// TODO 
		// 1. ArrayList<Student> 객체 생성
		// 2. 1,000,000개의 Student 객체를 리스트에 저장. - Random(시험점수)
		// 3. 리스트를 students.dat 파일에 (직렬화해서) 씀.
		// 4. 파일에서 데이터를 읽어서 역직렬화 -> 읽은 데이터 같은지 확인.
		
		ArrayList<Student> students = new ArrayList<>();
		Random random = new Random();
		
		// 저장하기 위해서 순서대로 Score -> Student -> ArrayList<Student>에 저장
		for (int i = 0; i < 1_000_000; i++) {
			Score score = new Score(random.nextInt(101), random.nextInt(101), random.nextInt(101));
			Student student = new Student(i, "NAME_" + i, score);
//			Student s = new Student(i, "NAME_" + i, random.nextInt(101), random.nextInt(101), random.nextInt(101));
			students.add(student);
		}

		String file = "data/students.dat";

		try (   FileOutputStream out = new FileOutputStream(file);
				BufferedOutputStream bout = new BufferedOutputStream(out);
				ObjectOutputStream oout = new ObjectOutputStream(bout);) {
			long start = System.currentTimeMillis();

			oout.writeObject(students); // 직렬화

			long end = System.currentTimeMillis();
			System.out.println("write time: " + (end - start) + " ms");

		} catch (Exception e) {
			e.printStackTrace();
		}

//		FileOutputStream out = null;
//		BufferedOutputStream bout = null;
//		ObjectOutputStream oout = null;
//		try {
//			 out = new FileOutputStream(file);
//			 bout = new BufferedOutputStream(out);
//		     oout = new ObjectOutputStream(bout);
//				
//		     oout.writeObject(students);
//		  
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				oout.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} 
		
		
		

		// 역직렬화
		try (
			FileInputStream in = new FileInputStream(file);
			BufferedInputStream bin = new BufferedInputStream(in);
			ObjectInputStream oin = new ObjectInputStream(bin);
			
		) {
			long start = System.currentTimeMillis();
			
			ArrayList<Student> result = (ArrayList<Student>) oin.readObject();
			
			long end = System.currentTimeMillis();
			System.out.println("read time: " + (end - start) + " ms");
			
			// 데이터 확인
			System.out.println("students size = " + result.size());
			int index = random.nextInt(1_000_000);
			System.out.println("students :" + result.get(index));
			
			System.out.println("list size = " + students.size());
			System.out.println("list : " + students.get(index));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
