package com.example.yildirim.retrofit2rxjava.Model;

/**
 * Created by Yildirim on 9.04.2018.
 */

public class Post
{
    public int id ;
    public String username ;
    public String email ;
    public String name ;

    public Post() {
    }

    public Post(int id, String username, String email, String name) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.name = name;
    }
}