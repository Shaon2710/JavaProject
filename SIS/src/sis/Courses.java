/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis;

/**
 *
 * @author Shazzad
 */
public class Courses {
    private String code;
    private String title;
    private int creadit;

    public Courses(String code, String title, int creadit) {
        this.code = code;
        this.title = title;
        this.creadit = creadit;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getCreadit() {
        return creadit;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreadit(int creadit) {
        this.creadit = creadit;
    }

    @Override
    public String toString() {
        return "Courses{" + "code=" + code + ", title=" + title + ", creadit=" + creadit + '}';
    }
    
}
