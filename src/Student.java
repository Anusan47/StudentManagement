public class Student {
    private static int idCounter = 1000;


    private int studentId ;
    private String name ;
    private int age ;
    private String course;

    Student( String name , int age , String  course){
        this.studentId = ++idCounter;
        this.name = name;
        this.age = age;
        this.course = course;
    }

//    public void setStudentId(int id ){
//        this.studentId=id;
//    }
    public static int peekNextId() {
        return idCounter + 1;
    }

    public int getStudentId(){
        return studentId;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }


    @Override
    public String toString(){
        return "ID: " + studentId + " | Name: " + name + " | Age: " + age + " | Course: " + course;
    }

}
