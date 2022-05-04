package toyProject;

import java.sql.SQLException;

public class MainClass {

	public static void main(String[] args) throws SQLException {

		System.out.println("\t\t" + "### MEMBER MANAGEMENT PROGRAM START ###");
		
		MemberManager manager = new MemberManager();
		manager.readMenu();
		
		System.out.println("\t\t" + "### GOOD-BYE ###");

	}

}
