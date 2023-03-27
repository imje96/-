package Loan;

public class Loan {
	private String id; // 대출한 회원
	private String bookTitle; // 대출한 책
	private String loanDate; // 대출 날짜
	private String dueDate; // 반납 기한
	private boolean isRenewStatus; // 연장 상태

	public String getId() {
		return id;
	}

	public void setId(String memberName) {
		this.id = memberName;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public boolean getIsRenewStatus() {
		return isRenewStatus;
	}

	public void setIsRenewStatus(boolean isRenewStatus) {
		this.isRenewStatus = isRenewStatus;
	}

}
