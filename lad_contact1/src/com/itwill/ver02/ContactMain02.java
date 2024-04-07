package com.itwill.ver02;

import java.util.Scanner;

import com.itwill.ver01.Contact;

// MVC 아키텍쳐에서 View 역할.
public class ContactMain02 {

	private final Scanner scanner = new Scanner(System.in);
	private ContactDaoImpl dao = ContactDaoImpl.getInstance();

	public static void main(String[] args) {

		ContactMain02 app = new ContactMain02();

		System.out.println("------ 연락처 프로그램 v0.2 -------");

		boolean run = true;
		while (run) {

			int menu = app.selectMainMenu();
			switch (menu) {
			case 0:
				run = false;
				break;
			case 1:
				app.saveNewMember();
				break;
			case 2:
				app.readAllMembers();
				break;
			case 3:
				app.readMemberByIndex();
				break;
			case 4:
				app.updateMember();
				break;

			}
		}

		System.out.println(">>> 프로그램 종료 >>>");
	}

	private void updateMember() {
		System.out.println("\n------연락처 수정-----");

		int index = 0;
		System.out.print("수정 할 인덱스>> ");

		try {
			index = Integer.parseInt(scanner.nextLine());

			if (!dao.isValidIndex(index)) {
				System.out.println("\n수정 할 연락처가 없습니다.");
				return;
			}

			Contact contact = dao.read(index);
			System.out.println("수정 전: " + contact);

			System.out.print("새 이름>>> ");
			String name = scanner.nextLine();
			System.out.print("새 전화번호>>> ");
			String phone = scanner.nextLine();
			System.out.print("새 이메일주소>>> ");
			String email = scanner.nextLine();

			int result = dao.update(index, contact);
			if (result == 1) {
				System.out.println("\n연락처가 변경 되었습니다.");
			} else {
				System.out.println("\n연락처 변경이 되지 않았습니다.");
			}

		} catch (NumberFormatException e) {
			System.out.println("인덱스는 정수를 입력해야합니다.");
		}
	}

	private void readMemberByIndex() {
		System.out.println("\n-----인덱스로 연락처 검색-----");
		System.out.print("검색할 인덱스>>> ");
		int index = 0;
		try {
			index = Integer.parseInt(scanner.nextLine());

			Contact contact = dao.read(index);
			if (contact != null) {
				System.out.println(contact);
			}
			System.out.println("\n[" + index + "]" + "번에는 회원 정보가 없습니다.");

		} catch (Exception e) {
			System.out.println("인덱스는 정수로 입력해주세요.");
		}

	}

	private void readAllMembers() {
		System.out.println("\n--- 전체 연락처 목록 ---");
		if (!(dao.isMemoryFull())) {
			System.out.println("\n저장된 연락처가 없습니다.");
		}
		Contact[] contacts = dao.read();
		int index = 0;
		for (Contact i : contacts) {
			System.out.println("[" + index + "] >>> " + i);
			index++;
		}

	}

	private void saveNewMember() {
		System.out.println("\n------- 새 연락처 저장 ------");

		if (dao.isMemoryFull()) {
			System.out.println("\n저장할 메모리가 부족합니다.");
			return;
		}

		System.out.print("이름>>> ");
		String name = scanner.nextLine();

		System.out.print("전화번호>>> ");
		String phone = scanner.nextLine();

		System.out.print("이메일주소>>> ");
		String email = scanner.nextLine();

		Contact contact = new Contact(name, phone, email);
		int result = dao.create(contact);
		if (result == 1) {
			System.out.println("\n연락처가 저장 되었습니다.");
		} else {
			System.out.println("\n연락처가 저장 되지 않았습니다.");
		}
	}

	private int selectMainMenu() {
		System.out.println("\n=====================================");
		System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정");
		System.out.println("=====================================");
		System.out.print("메뉴선택>>> ");
		int menu = 5;
		try {
			menu = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("메뉴(0 ~ 4)를 다시 입력해주세요.");
		} finally {
			return menu;  
		}
	}
}
