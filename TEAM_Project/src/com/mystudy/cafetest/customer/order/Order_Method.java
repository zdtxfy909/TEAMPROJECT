package com.mystudy.cafetest.customer.order;

import java.util.List;
import java.util.Scanner;

import com.mystudy.cafetest.dao.MenuDAO;
import com.mystudy.cafetest.vo.MenuVO;

public class Order_Method {
	static Scanner scan = new Scanner(System.in);
	static MenuDAO dao = new MenuDAO();
	static List<MenuVO> list = dao.selectAll();
	static int selectMenuId =0;
	static int selectPrice = 0;
	static int selectCount = 0;
	static int totPrice = 0;
	static int inMoney = 0;
	static int income = 0;
	
	public static void startCafe () {
		while (true) {
			int num = runningCafe();
			if(num == 0) {
				break;
			}
		}
	}
	// 메인 메뉴 -------------------------------------
	public static void showMenu () {
		System.out.println("================= Cafe =================");
		System.out.println("[1.주문하기 2. 주문 확인 3. 주문 변경 4.회원가입 5.관리자 0.종료]");
		System.out.print(">> ");
	}
	
	// 음료 메뉴판-----------------------------------
	public static void showCoffeeMenu () {

	System.out.println("===== 주문하기 =====");
	System.out.println("--------- Menu ------");
	for (MenuVO vo : list) {
		System.out.println(vo.getMenuid()+ ". " + vo.getName() + "\t" + "\t" + vo.getPrice() + "원");
	}
	System.out.println("---------------------");
	
	}
	
	// 카페 운영 -----------------------------------
	public static int runningCafe () {
		// 메인 메뉴 표시
		showMenu();
		
		int num = -1; // try문 밖에서도 사용하기 위해 임의의 값 넣어줌
		
		try {
			 num = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) { 
			// 숫자가 아닌 데이터(문자) 입력 시 예외 처리
			System.out.println("메뉴 숫자(1 ~ 5)만 입력하세요");
		}
		// 선택 작업
		if (num == 1) {
			coffeeChoice(); 
		} 
		if (num == 2) {
			
		}
		if (num == 3) {
			
		}
		if (num == 2) {
			
		}
		// 종료
		if (num == 0) {
			System.out.println(":: Cafe 종료");
			return num;
		}
		
		return num;
	}
	
	// 커피 메뉴 선택 
	public static void coffeeChoice() {
		showCoffeeMenu();
		System.out.println("음료와 수량을 입력하세요");
		System.out.print(">> 음료 : ");
		selectMenuId = Integer.parseInt(scan.nextLine()); // 선택 음료
		MenuVO stu = dao.selectPrice(selectMenuId); // menuid 가격 저장
		selectPrice = stu.getPrice(); // 고른 메뉴 가격
		System.out.print(">> 수량 : ");
		selectCount = Integer.parseInt(scan.nextLine()); // 수량
		totPrice += (selectPrice * selectCount); // 가격 * 수량
		System.out.println("장바구니에 담겼습니다.");
		System.out.println("음료 : " + stu.getName() + " /  수량 : " + selectCount);
		System.out.println("금액 : " + totPrice );
		plusOrder();
	}
	
	public static void plusOrder() {
		System.out.println("바로 결제 : 1 / 더 담으러 가기 : 2");
		System.out.print(">> ");
		int plusSelect = Integer.parseInt(scan.nextLine());
		if (plusSelect == 1) {
			Payment(); 
		}
		if (plusSelect == 2) {
			coffeeChoice();
		}
	}
	
	// 결제 메소드 
	public static void Payment() {
		System.out.println("총 금액 : " + totPrice);
		System.out.print(">> 입금액 : ");
		inMoney = Integer.parseInt(scan.nextLine());
		// 계산 처리 메소드
		int change = change(inMoney,totPrice);
		System.out.println("잔액 : " + change);
		// 판매금액 누적 (매출액)
		income += totPrice;
	}
	
	public static int change (int inMoney, int totPrice) {
		int result = 0;
		result = (inMoney - totPrice);
		return result;
	}
	
	
	
	
}
