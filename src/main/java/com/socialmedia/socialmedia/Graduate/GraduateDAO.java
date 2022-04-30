package com.socialmedia.socialmedia.Graduate;

public interface GraduateDAO {
    public Graduate save(Graduate graduate, Passport passport);
    public Graduate findById(int id);
}
