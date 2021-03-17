package com.hakimen.entity;

public class CalendarEvent {
    private int courseId;
    private int eventId;
    private String type;
    private String status;
    private String icon;
    private String title;
    private String link;
    private String description;

    //Course Specifics
    private String courseLink;
    private String course;

    //Day Specific
    private String date;
    private String dateLink;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateLink() {
        return dateLink;
    }

    public void setDateLink(String dateLink) {
        this.dateLink = dateLink;
    }

    public String getCourseLink() {
        return courseLink;
    }

    public void setCourseLink(String courseLink) {
        this.courseLink = courseLink;
    }

    @Override
    public String toString() {
        return "CalendarEvent{" +
                "courseId=" + courseId +
                ",\n eventId=" + eventId +
                ",\n type='" + type + '\'' +
                ",\n status='" + status + '\'' +
                ",\n icon='" + icon + '\'' +
                ",\n title='" + title + '\'' +
                ",\n link='" + link + '\'' +
                ",\n description='" + description + '\'' +
                ",\n courseLink='" + courseLink + '\'' +
                ",\n course='" + course + '\'' +
                ",\n date='" + date + '\'' +
                ",\n dateLink='" + dateLink + "'\n" +
                "}";
    }
}
