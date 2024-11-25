package com.itwill.lambda04;

import java.util.Arrays;
import java.util.List;

public class LambdaMain04 {
	
	public static void main(String[] args) {
		
		
		// 직원(Employee)들의 리스트
		
        List<Employee> employees = Arrays.asList(
                new Employee(101, "김민석", "개발1팀", "과장", 700),
                new Employee(201, "김종후", "개발2팀", "부장", 800),
                new Employee(102, "안상찬", "개발1팀", "대리", 500),
                new Employee(202, "이수빈", "개발2팀", "부장", 1_000),
                new Employee(301, "이지해", "인사팀", "회장", 100),
                new Employee(203, "장세은", "개발2팀", "대리", 900),
                new Employee(302, "조희성", "인사팀", "차장", 900),
                new Employee(401, "최하신", "총무", "대리", 300),
                new Employee(402, "최호철", "총무", "과장", 1_000),
                new Employee(103, "허유진", "개발1팀", "과장", 500)
        );

        
        // TODO
        // Ex1. 모든 직원들의 정보를 한 줄에 한 명씩 출력.
        System.out.println("*** 직원 리스트 ***");
        employees.forEach(System.out::println); // (x -> System.out.println(x));
        System.out.println("-----------------------------------------");
        List<Employee> sumSalaryGroup = employees.stream()
        		.filter(x -> x.getDept().equals("개발1팀") || x.getDept().equals("개발2팀"))
        		.toList();
        // Ex2. 개발(1, 2)팀에서 일하는 직원들의 급여 합계. 
//        double sumOneTwo = sumSalaryGroup.stream().mapToDouble(x -> x.getSalary()).sum();
//        System.out.println("개발(1, 2)팀 급여 합계 : " + sumOneTwo);
        System.out.println("Ex.2, Ex.3 ------");
        double sum = 0; // 급여 합계
        int count = 0; // 개발(1,2)팀에서 일하는 직원 수
        for(Employee e : employees) {
        	if(e.getDept().contains("개발")) {
        		count++;
        		sum += e.getSalary();
        	}
        }
        System.out.println("급여 합계 = " + sum);
        double mean = sum / count; // 급여 평균
        System.out.println("급여 평균 = " + mean);
        
        // Stream & Lambda
        sum = employees.stream()
        		.filter(e -> e.getDept().contains("개발"))
        		.mapToDouble(e -> e.getSalary()) // 급여들로만 이루어진 리스트를 만들어 준다.
        		.sum();
        System.out.println("sum = "+ sum);
        
        mean = employees.stream().filter(e -> e.getDept().equals("개발1팀") || e.getDept().equals("개발2팀"))
        		.mapToDouble(e -> e.getSalary())
        		// 일반적으로 map 일반적으로 A->B로 규칙에 의해서 바꾼다 매핑이고 매핑은 객체를 정수,더블,문자,모든 종류에 대해 다 쓸수있는게 맵 메서드
        		// 맵을 숫자로 매핑할 때 정수 더블로 바꾸면 합계 평균 같은걸 구할 수 있다. 그냥 map은 안됨.
        		.average() // -> 리턴 타입: OptionalDouble - 정상 값 또는 예외를 저장하는 객체. 
        		// 나눠주는게 0이 될 수있기 때문에 무조건 더블 타입이 될 수 없고 , O 나눌 수 있는 경우라면 계산된 평균, 나눌수 없는 예외를 갖고있는 
        		.orElseThrow(); // 정상적인 값을 갖고 있으면 그냥 리턴하고 만약 나눌수 없어서 예외가 있으면 내가 주는 디폴트 값을 값을 넣음
        // 정상적인값이 없으면 예외를 던지고
        
        System.out.println("mean = " +mean);
        
        // Ex3. 개발팀에서 일하는 직원들의 급여 평균.
//        double sumAll = employees.stream().mapToDouble(x -> x.getSalary()).sum();
//        System.out.println("개발팀 전직원 급여 : " + sumAll);
//        double avgSalary = employees.stream().mapToDouble(x -> x.getSalary()).average().orElse(0.0);
//        System.out.println("개발팀 전직원 급여 평균 : " + avgSalary);
        
        // Ex4. 직급이 부장인 직원들의 급여 합계.
//        double sumGm = employees.stream().filter(x -> x.getJobTitle().equals("부장")).mapToDouble(x -> x.getSalary()).sum();
//        System.out.println("개발팀 부장 급여 합계 : " + sumGm);
        // Ex5. 직급이 부장인 직원들의 급여 평균.
//        double avgGm = employees.stream().filter(x -> x.getJobTitle().equals("부장")).mapToDouble(x -> x.getSalary()).average().orElse(0.0);
//        System.out.println("개발팀 부장 급여 평균 : " + avgGm);
//        System.out.println("-----------------------------------------");
        System.out.println("Ex.4, Ex.5 ------------");
        count = 0; // 부장 직원 수
        sum = 0; // 부장 급여 합계
        for(Employee e : employees) {
        	if(e.getJobTitle().equals("부장")){
        		count++;
        		sum += e.getSalary();        		
        	}
        	
        }
        mean = sum / count; // 부장 급여 평균
        System.out.println("부장 급여 합계 = "+sum);
        System.out.println("부장 급여 평균 = " + mean);
        
        
        // Stream & Lambda
        sum = employees.stream()
        		.filter(e -> e.getJobTitle().equals("부장")) 
        		.mapToDouble(e -> e.getSalary())
        		.sum();
        System.out.println("sum = " + sum);
        
        mean = employees.stream()
        		.filter(e -> e.getJobTitle().equals("부장"))
        		.mapToDouble(e -> e.getSalary())
        		.average()
        		.orElseThrow();
        System.out.println("mean =" + mean);
        
        
        
        
        // Ex6. 급여가 1,000 이상인 직원들의 정보를 한 줄에 한 명씩 출력.
//        List<Employee> highSalary = employees.stream().filter(x -> x.getSalary() >= 1000).toList();
//        highSalary.forEach(System.out::println); 
        
        System.out.println("Ex.6 -----------");
        for(Employee e : employees) {
        	if(e.getSalary() >= 1_000) {
        		System.out.println(e);
        	}
        }
        
        // Stream & Lambda
        employees.stream()
        		.filter(e -> e.getSalary() >= 1_000)
        		.forEach(System.out::println); //(e -> System.out.println(e));
        
        // Ex7. 개발1팀 직원들의 급여를 10% 인상하면 인상된 급여의 평균?
        
        System.out.println("Ex.7 ----------");
        sum = 0;
        count = 0;
        for (Employee e : employees) {
        	if(e.getDept().equals("개발1팀")) {
        		count++;
        		sum += e.getSalary() * 1.1;
        	}
        }
        
        mean = sum / count; 
        System.out.println("개발1팀 급여 합계 = " + sum);
        System.out.println("개발1팀 급여 평균 = " + mean);
        
        // Stream & Lambda
        sum = employees.stream()
        			.filter(e -> e.getDept().equals("개발1팀"))
        			.mapToDouble(e -> e.getSalary() * 1.1)
        			.sum();
        System.out.println("sum = " + sum);
        
        mean = employees.stream()
        		.filter(e -> e.getDept().equals("개발1팀"))
        		.mapToDouble(e -> e.getSalary() * 1.1)
        		.average()
        		.orElseThrow();
        System.out.println("mean = " + mean);
//        double avg1Group = employees.stream().filter(x -> x.getDept().equals("개발1팀")).mapToDouble(x -> x.getSalary() * 1.1).average().orElse(0.0);
//        System.out.println("개발 1팀 급여 10% 인상 평균 : " +avg1Group);
//        System.out.println("-----------------------------------------");
        // Ex8. 직원들 중 대리는 몇 명?
        System.out.println("Ex.8 ------------");
        
        count = 0;
        for(Employee e : employees) {
        	if(e.getJobTitle().equals("대리")) {
        		count++;
        	}
        }
		System.out.println("대리 수 = " + count);

		// Stream & Lambda
		long empCount = employees.stream()
				.filter(e -> e.getJobTitle().equals("대리"))
				.count();
		System.out.println("empCount = " + empCount);
//        List<Employee> listAm = employees.stream().filter(x -> x.getJobTitle().contains("대리")).toList();
//        System.out.println("\n--- 개발팀 대리 인원 ---");
//        listAm.forEach(System.out::println);
        
	
	}
	
}
