package edu.java.contact.fileutil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import edu.java.contact.model.Contact;

// 도우미 클래스 - 파일 관련(read, write, 폴더생성) 기능을 제공하기 위한 클래스.
// 모든 필드와 메서드는 static 으로 선언, 객체 생성은 하지 못하도록.
public class FileUtil {
	
	// 상수 정의
	public static final String DATA_DIR = "data";	// 데이터 폴더 이름
	public static final String DATA_FILE = "contacts.dat";	// 데이터 파일 이름
	//-> .\data\contacts.dat 파일에 연락처 리스트를 저장하기 위해서.
	
	
	// private 생성자 - 다른 클래스에는 생성자가 보이지 않기 때문에 객체를 생성할 수 없음.
	private FileUtil() {}
	
	/**
	 * 연락처 데이터 파일을 저장하는 폴더가 존재하지 않으면 생성하고, File 객체를 리턴.
	 * 이미 폴더가 생성되어 있는 경우에는, 그 폴더의 File 객체를 리턴.
	 * 
	 * @return 데이터 파일을 저장할 폴더의 File 객체.
	 */
	public static File initDataDir() {
		File newFolder = new File(DATA_DIR);
//		if (!newFolder.exists()) { // 폴더가 존재하지 않으면
//			newFolder.mkdir();
//			System.out.println("새 폴더를 생성했습니다.");
//		} else {
//		}
//		System.out.println("폴더가 이미 있습니다.");
//		return newFolder;
		
		if(newFolder.exists()) {
			System.out.println("폴더가 이미 있습니다.");
		} else {
			newFolder.mkdir();
			System.out.println("새 폴더를 생성했습니다.");
		}
		return newFolder;	
	}
	
	
	/**
	 * readDataFromFile.(메서드 이름)
	 * argument로 전달된 File 객체를 사용해서, 파일에 저장된 연락처 정보를 읽고,
	 * 그 결과를 List<Contact> 타입의 객체로 리턴.
	 * 
	 * @param file 연락처 정보가 저장된 파일 경로를 가지고 있는 File 타입 객체를 read.
	 * @return Contact 타입을 원소로 갖는 리스트(List)
	 */
	public static List<Contact> readDataFromFile(File file) {
		List<Contact> list = new ArrayList<>();	// 리턴할 변수 선언
		
		try (
			  FileInputStream in = new FileInputStream(file); // FileInputStream(File file) 메서드
			  BufferedInputStream bin = new BufferedInputStream(in);
			  ObjectInputStream oin = new ObjectInputStream(bin);
		) {	
			list = (List<Contact>) oin.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}

	
	/**
	 * writeDataToFile.	
	 * argument로 전달된 data를 (직렬화해서) file에 씀. OOS 사용
	 * 
	 * @param data 파일에 쓸 데이터. Contact 타입을 저장하는 리스트(List<Contact>).
	 * @param file 데이터 파일(File) 객체
	 * 리턴타입이 없을시, void
	 */						
								//List는 Serializable 가지고 있지만<Contact>는 없음. Contact클래스에 implemants
	public static void writeDataToFile(List<Contact> data, File file) {  

		try (
				FileOutputStream out = new FileOutputStream(file); // FileOutputStream(File file) 메서드
				BufferedOutputStream bout = new BufferedOutputStream(out);
				ObjectOutputStream oout = new ObjectOutputStream(bout);
		) {
		    	oout.writeObject(data);	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	/**
	 * initData.
	 * 연락처 데이터 파일이 있으면, 파일의 내용을 읽어서 (readDataFromFile메서드) 리스트를 생성하고 리턴.
	 * 연락처 데이터 파일이 없으면, 빈 리스트를 생성 후 리턴.
	 * 
	 * @return Contact 타입을 원소로 갖는 리스트(List<Contact>)
	 */
	public static List<Contact> initData() {
    	File dataFile = new File(DATA_DIR ,DATA_FILE);  // 현재 폴더(DATA_DIR) 밑에 , 파일 생성 (DATA_FILE)
    	
    	List<Contact> list = new ArrayList<>();
    	if(dataFile.exists()) {	// 파일이 존재하면
    		list = readDataFromFile(dataFile);
    		System.out.println("연락처 파일 로딩...");
    	} 
    	
    	return list;
    	
		
		
		
	}
}
