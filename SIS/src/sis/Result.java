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
public class Result {
    private String studentid;
    private String gpa;
    private String course;
    private String semester;

    public Result(String studentid, String gpa, String course, String semester) {
        this.studentid = studentid;
        this.gpa = gpa;
        this.course = course;
        this.semester = semester;
    }

    public String getStudentId() {
        return studentid;
    }

    public String getGpa() {
        return gpa;
    }

    public String getCourse() {
        return course;
    }

    public String getSemester() {
        return semester;
    }

    public void setId(String id) {
        this.studentid = id;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Result{" + "id=" + studentid + ", gpa=" + gpa + ", course=" + course + ", semester=" + semester + '}';
    }
    
}
