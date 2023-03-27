package Book;

import java.text.*;

public class Book {
    private String isbn; // 책 고유번호
    private String title; // 도서명
    private String author; // 작가명
    private String publishDate; // 출판일
    private boolean isAvailable; // 대출 가능 여부

   
    
    @Override
	public String toString() {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		return "Isbn=" + isbn + 
				", title=" + title + 
				", author=" + author + 
				", publishDate=" + dateFormat.format(publishDate) +
				", isAvailable=" + isAvailable;
	}

	public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // toSting

}
