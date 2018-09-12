package setest;

/**
 * Created by zsl on 2018/9/11.
 */
public class Student {
    private String name;
    private int age;
    private String studentNo;

    public Student(String name,int age,String studentNo){
        this.name = name;
        this.age = age;
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }
}
