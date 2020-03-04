package com.example.firstprojectjob;

public class Post {
    private String login;
    private String date;
    private String post;
    private int likeCnt;
    private int profileImg;
    private String name;
    private String commentCnt;
    private String tweetCnt;
    private boolean isLiked;
    private int redlike;

    public Post(String name, String login, String date, String post, int profileImg, String commentCnt, String tweetCnt, int likeCnt, boolean isLiked, int redlike) {
        this.name = name;
        this.login = login;
        this.date = date;
        this.post = post;
        this.profileImg  = profileImg;
        this.commentCnt = commentCnt;
        this.tweetCnt = tweetCnt;
        this.likeCnt = likeCnt;
        this.isLiked = isLiked;
        this.redlike = redlike;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public void setLikeCnt(int likeCnt) {
        this.likeCnt = likeCnt;
    }

    public String getLogin() {
        return login;
    }

    public String getDate() {
        return date;
    }

    public String getPost() {
        return post;
    }

    public int getLikeCnt() {
        return likeCnt;
    }

    public int getProfileImg() {
        return profileImg;
    }

    public String getName() {
        return name;
    }

    public String getCommentCnt() {
        return commentCnt;
    }

    public String getTweetCnt() {
        return tweetCnt;
    }

    public int getRedlike() {
        return redlike;
    }

    public void setRedlike(int redlike) {
        this.redlike = redlike;
    }
}
