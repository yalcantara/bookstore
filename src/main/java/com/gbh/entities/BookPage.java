package com.gbh.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Cacheable(false)
@Table(name = "BOOK_PAGES")
public class BookPage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable = false, name = "book_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Book bookId;

    private int page;

    @Lob
    @NotNull
    @JsonIgnore
	@Column(name = "html_format")
    private String htmlFormat;

    @Lob
    @NotNull
    @JsonIgnore
	@Column(name = "text_format")
    private String textFormat;

    public BookPage(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getHtmlFormat() {
        return htmlFormat;
    }

    public void setHtmlFormat(String htmlFormat) {
        this.htmlFormat = htmlFormat;
    }

    public String getTextFormat() {
        return textFormat;
    }

    public void setTextFormat(String textFormat) {
        this.textFormat = textFormat;
    }

    @Override
    public String toString() {
        return "BookPage{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", page=" + page +
                '}';
    }
}
