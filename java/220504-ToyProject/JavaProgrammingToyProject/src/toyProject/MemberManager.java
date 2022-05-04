package toyProject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MemberManager {
	
	Scanner scanner;
	
	public MemberManager() {
		 scanner = new Scanner(System.in);
	}
	//Scanner scanner = new Scanner(System.in);
	
	public void readMenu(){
			
		while(true) {
			
		System.out.println("If you want LIST, press 1.");
		System.out.println("If you want INSERT, press 2.");
		System.out.println("If you want UPDATE, press 3.");
		System.out.println("If you want DELETE, press 4.");
		System.out.println("If you want END, press 0.");

		int i = scanner.nextInt();
		MemberDAO memberdao = new MemberDAO();
		
			if(i == 1) {
				memberdao.getMemberList();
			}
			else if(i == 2) {
				System.out.print("MEMBER_ID(Type : M-0001) : ");
				String str1 = scanner.next();
				if(memberdao.selectMember(str1) == false) {
					System.out.print("NAME : ");
					String str2 = scanner.next();
					System.out.print("PHONE_NUMBER(Type : 010-0000-0000) : ");
					String str3 = scanner.next();
					memberdao.insertMember(str1, str2, str3);
					System.out.println("\t\t" + "!! INSERT SUCCESS !!");
				} else {
					System.out.println("\t\t" + "!! This MEMEBER_ID already exists !!");
					continue;
				}
			}
			else if(i == 3) {
				System.out.print("Enter the MEMBER_ID(Type : M-0001) : ");
				String str1 = scanner.next();
				System.out.print("Enter the PHONE_NUMBER(Type : 010-0000-0000) : ");
				String str2 = scanner.next();
				memberdao.updateMember(str1, str2);
				System.out.println("\t\t" + "!! UPDATE SUCCESS !!");
			}
			else if(i == 4) {
				System.out.print("Enter the MEMBER_ID : ");
				String str1 = scanner.next();
				memberdao.deleteMember(str1);
				System.out.println("\t\t" + "!! DELETE SUCCESS !!");
			}
			else if (i == 0) {
				scanner.close();
				break;
			}
			else{
				System.out.println("\t\t" + "!! Please enter number again !!");
			}
		}
	}
}
