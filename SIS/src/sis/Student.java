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
public class Student {
    private String id;
    private String name;
    private String email;
    private String dept;
    private String age;

    public Student(String id, String name , String age, String email, String dept) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dept = dept;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDept() {
        return dept;
    }

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", email=" + email + ", dept=" + dept + ", age=" + age + '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setAge(String age) {
        this.age = age;
    }
    
    
}
