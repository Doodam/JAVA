package edu.java.lambda03;

import java.nio.file.spi.FileSystemProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaMain03 {

	public static void main(String[] args) {
			// Employee를 원소로 갖는 리스트를 선언, 생성
		List<Employee> employees = Arrays.asList (
				new Employee(100, "이재은", "개발1팀", "대리", 400.0),
				new Employee(101, "이도담", "개발2팀", "사원", 350.0),
				new Employee(200, "김자바", "개발2팀", "과장", 380.0),
				new Employee(201, "최자바", "개발1팀", "부장", 500.0),
				new Employee(300, "강자바", "인사팀", "사원", 300.0),
				new Employee(301, "위자바", "인사팀", "과장", 1000.0)
				);
		
		// 1. 모든 직원들의 정보를 한 줄에 한 명씩 출력.
		employees.forEach(x -> System.out.println(x));

//		for(Employee e : employees) {
//			System.out.println(e);
//		}

//		employees.forEach(System.out::println);

		
		
		// 2. 개발1,2팀에서 일하는 직원들의 급여의 합계를 출력.		
		double result = employees.stream()
				.filter(x -> x.getDept().contains("개발"))
				.mapToDouble(x -> x.getSalary())
				.sum();
		System.out.println("개발팀 급여 합계 : " + result);
		
//		double sum = 0;
//		int count = 0;
//		for(Employee e : employees) {
//			if(e.getDept().contains("개발")) {
//				sum += e.getSalary();
//				count ++;
//			}
//		}
//		System.out.println("개발팀 급여 합계 : " + sum);
		
		
		
		
		// 3. 개발1,2팀에서 일하는 직원들의 급여의 평균을 출력.
		double aver1 = employees.stream()
				.filter(x -> x.getDept().contains("개발"))
				.mapToDouble(x -> x.getSalary())
				.average()	// 개발팀이 없을 경우 average를 사용할 수 없음. 리턴타입이 선택적 평균(OptionalDouble)
				.orElseThrow();	// 평균을 못구하는 경우 Exception 메서드
		System.out.println("개발팀 급여 평균 : " + aver1);
		
//		System.out.println("개발팀 급여 평균 : " + (sum / count));		
		
		
		
		
		// 4. 직급이 사원인 직원들의 급여의 합계를 출력.
		result = employees.stream()
				.filter(x -> x.getEmpTitle().contains("사원"))
				.mapToDouble(x -> x.getSalary())
				.sum();
		System.out.println("사원 급여 합계 : " + result	);
		
//		double sum = 0;
//		int count = 0;
//		for(Employee e : employees) {
//			if(e.getEmpTitle().equals("사원")) {
//				sum += e.getSalary();
//				count++;
//			}
//			
//		}
//		System.out.println("사원 급여 합계 : " + sum);	
		
		
		
		
		
		// 5. 직급이 사원인 직원들의 급여의 평균을 출력.
		result = employees.stream()
				.filter(x -> x.getEmpTitle().contains("사원"))
				.mapToDouble(x -> x.getSalary())
				.average()
				.orElseThrow();
		System.out.println("사원 급여 평균 : " + result);
		
//		System.out.println("사원 급여 합계 : " + (sum / count));
	
		
		
		
		// 6. 급여가 400 이상인 직원들의 정보를 한 줄에 한 명씩 출력.
		employees.stream()
				.filter(x -> x.getSalary() >= 400.0)
				.forEach(System.out::println);	// x -> System.out.println(x)
		
//		for(Employee e : employees) {
//			if(e.getSalary() >= 400.0) {
//				System.out.println(e);
//			}
//			
//		}
		
		
	
		
		
		// 7. 개발1팀 직원들의 급여를 10% 인상하고, 그 직원들의 급여 평균을 계산하고 출력.
		result = employees.stream()
				.filter(x -> x.getDept().equals("개발1팀"))
				.mapToDouble(x -> x.getSalary() * 1.1)
				.average()
				.orElseThrow();
		System.out.println("개발1팀 급여 평균: " + result);
		
	
//		double sum = 0;
//		int count = 0;
//		for(Employee e : employees) {
//			if(e.getDept().equals("개발1팀")) {
//				double up = e.getSalary() * 1.1;
//				sum += up;
//				count++;
//			}
//		}
//		System.out.println("개발1팀 급여 평균: " + (sum / count));
		

		
		
		
		
		
		
		// 8. 직원 리스트에서 "사원"은 몇 명?
		long cnt = employees.stream()
				.filter(x -> x.getEmpTitle().equals("사원"))
				.count();	// 리턴 타입이 long
		System.out.println("사원은 몇명? " + cnt);
		
		
		int count = 0;
		for(Employee e : employees) {
			if(e.getEmpTitle().equals("사원")) {
				count++;
				
			}
		
		}
		System.out.println(count);
		
		
		
		
	}

}
