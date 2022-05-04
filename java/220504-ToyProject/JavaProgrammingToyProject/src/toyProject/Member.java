package toyProject;

public class Member {

	private String MEMBER_ID;
	private String NAME;
	private String PHONE_NUMBER;
	
	Member(String MEMBER_ID, String NAME, String PHONE_NUMBER){
		this.MEMBER_ID = MEMBER_ID;
		this.NAME = NAME;
		this.PHONE_NUMBER = PHONE_NUMBER;
	}

	@Override
	public String toString() {
		return "Member [MEMBER_ID=" + MEMBER_ID + ", NAME=" + NAME + ", PHONE_NUMBER=" + PHONE_NUMBER + "]";
	}

	public String getMEMBER_ID() {
		return MEMBER_ID;
	}

	public void setMEMBER_ID(String mEMBER_ID) {
		MEMBER_ID = mEMBER_ID;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getPHONE_NUMBER() {
		return PHONE_NUMBER;
	}

	public void setPHONE_NUMBER(String pHONE_NUMBER) {
		PHONE_NUMBER = pHONE_NUMBER;
	}
	
	
}
