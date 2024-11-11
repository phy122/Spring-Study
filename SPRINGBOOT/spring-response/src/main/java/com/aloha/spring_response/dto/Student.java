package com.aloha.spring_response.dto;




public class Student extends Person {
    
    private int stdId;
    private String grade;

    public Student() {
        super();
        this.stdId = 10001;
        this.grade = "1";
    }

    @Override
    public String toString() {
        return "Student [stdId=" + stdId + ", grade=" + grade + ", getAge()=" + getAge() + ", getName()=" + getName()
                + "]";
    }

}
