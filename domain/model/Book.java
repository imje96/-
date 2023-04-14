package domain.model;

import java.util.Date;
import java.util.Objects;

public class Book {
    private int isbn;
    private String title;
    private String author;
    private String publisher;
    private Date publicationDate;
    private Date registrationDate;

    public Book(int isbn, String title, String author, String publisher, Date publicationDate, Date registrationDate) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.registrationDate = registrationDate;
    }


    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isnb) {
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return isbn == other.isbn;
    }

    @Override
    public String toString() {
        return "Book [id=" + isbn + ", title=" + title + ", author=" + author + ", publisher="
                + publisher + ", publicationDate=" + publicationDate + ", registrationDate="
                + registrationDate + "]";
    }
    
}