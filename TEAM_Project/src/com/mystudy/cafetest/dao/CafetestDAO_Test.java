package com.mystudy.cafetest.dao;

import java.util.List;

import com.mystudy.cafetest.dao.MenuDAO;
import com.mystudy.cafetest.vo.MenuVO;


public class CafetestDAO_Test {

	public static void main(String[] args) {
		MenuDAO dao = new MenuDAO();
		
		List<MenuVO> list = dao.selectAll();
		
		System.out.println("메뉴 가격 조회");
		int selectMenuId = 1;
		MenuVO stu = dao.selectPrice(selectMenuId);
		int selectPrice = stu.getPrice();
		System.out.println("선택 메뉴 가격 : " + selectPrice);
		
		System.out.println();
		// 단순 조회
//		for (MenuVO vo : list) {
//			System.out.print(vo);
//		}
		
//		for (MenuVO vo : list) {
//		System.out.println(vo.getName() + "\t" + "\t" + vo.getPrice() );
//	}
		
//		System.out.println("--- insert(vo) ---");
//		MenuVO memu = new MenuVO(4, "블루베리 스무디", 6500);
//		int insertCount = dao.insert(memu);
//		System.out.println("입력 건수 : " + insertCount);
//		
//		System.out.println("--- update(vo) ---");
//		memu = new MenuVO(4, "딸기 스무디", 6000);
//		int updateCount = dao.update(memu);
//		System.out.println("입력 건수 : " + updateCount);
//		
//		System.out.println("--- delete(menuid) ---");
//		System.out.println("삭제할 MENUID : " );

	}

}
