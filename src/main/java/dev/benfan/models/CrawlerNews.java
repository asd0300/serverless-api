package dev.benfan.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection ="NewsPost")
public class CrawlerNews {
    private String title;
    private String author;
    private Date publishDate;
    private String content;
    private String url;
    private Date retrievalDate;
}
