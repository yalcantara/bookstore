package com.gbh;

import com.gbh.entities.Book;
import com.gbh.entities.BookPage;
import com.gbh.services.BookService;
import com.thedeanda.lorem.LoremIpsum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DatabaseFiller {

    private static final int GENERATE_BOOKS = 100;
    private static final int MIN_PAGES = 10;
    private static final int MAX_PAGES = 450;


    private static final Logger log = LoggerFactory.getLogger(DatabaseFiller.class);


    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(App.class);
        insertData(ctx);
    }

    public static void insertData(ApplicationContext ctx){


        BookService srv = ctx.getBean(BookService.class);
        if(srv.count() > 0){
            System.out.println("The database has data. No need to fill it.");
            return;
        }

        LoremIpsum lorem = new LoremIpsum();
        log.info("=================================================");
        log.info("Generating books...");
        log.info("\n");
        long start = System.nanoTime();
        for (int i = 0; i < GENERATE_BOOKS; i++) {

            Book b = generateBook(lorem);
            srv.save(b);

            List<BookPage> pages = generatePages(lorem, b);
            srv.savePages(b.getId(), pages);
        }
        long end = System.nanoTime();
        long took = TimeUnit.NANOSECONDS.toMillis(end - start);
        log.info("Finished");
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(true);
        nf.setMinimumFractionDigits(0);

        log.info("Took: " + nf.format(took) + " millis");
        log.info("Generated: " + GENERATE_BOOKS +" books");
        log.info("=================================================");
    }


    private static Book generateBook(LoremIpsum lorem) {


        Book b = new Book();

        int count = 2 + (int) (5 * Math.random());
        String title = lorem.getTitle(count);

        String firstName = lorem.getFirstName();
        String lastName = lorem.getLastName();

        String author = lastName + ", " + firstName;


        int pages = MIN_PAGES + (int)((MAX_PAGES - MIN_PAGES) * Math.random());

        String publisher = lorem.getLastName();

        Instant publishedDate = randDate();


        b.setTitle(title);
        b.setAuthor(author);
        b.setPages(pages);
        b.setPublisher(publisher);
        b.setPublicationDate(publishedDate);

        return b;
    }

    private static List<BookPage> generatePages(LoremIpsum lorem, Book book){

        List<BookPage> list = new ArrayList<>();

        int pages = book.getPages();
        for(int i =1; i <= pages; i++){
            BookPage page = generatePage(lorem, book, i, pages);
            list.add(page);
        }

        return list;
    }

    private static int getCount(int min, int max) {
        if (min < 0)
            min = 0;
        if (max < min)
            max = min;

        Random random = new Random();
        int count = max != min ? random.nextInt(max - min) + min : min;
        return count;
    }

    private static BookPage generatePage(LoremIpsum lorem, Book book, int pageNum, int totalPages){

        int count = getCount(3, 5);


        StringBuilder sb = new StringBuilder();
        sb.append("<html>\n");
        sb.append("<head>\n");
        sb.append("\t<title>");

        String title = book.getTitle() + " (" + pageNum +" of " + totalPages +")";
        sb.append(title);
        sb.append("</title>");
        sb.append("</head>\n");
        sb.append("<body>\n");


        StringBuilder paragraphs = new StringBuilder();
        for(int i =0; i < count; i++){
            String paragraph = lorem.getParagraphs(1, 1);
            sb.append("<p>\n");
            sb.append(paragraph);
            sb.append("\n</p>\n");

            paragraphs.append(paragraph);
            paragraphs.append("\n\n");
        }

        sb.append("\n");
        sb.append("</body>\n");
        sb.append("</html>\n");

        String textFormat = paragraphs.toString();
        String htmlFormat = sb.toString();



        BookPage page = new BookPage();
        page.setBookId(book);
        page.setPage(pageNum);
        page.setTextFormat(textFormat);
        page.setHtmlFormat(htmlFormat);


        return page;
    }




    private static Instant randDate() {
        Instant startDate = Instant.parse("1870-01-01T00:00:00.00Z");
        Instant endDate = Instant.parse("2010-01-01T00:00:00.00Z");

        Duration duration = Duration.between(startDate, endDate);

        long seconds = duration.getSeconds();
        long randSeconds = (long) (seconds * Math.random());

        return startDate.plusSeconds(randSeconds);
    }
}
