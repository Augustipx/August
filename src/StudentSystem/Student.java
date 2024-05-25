package StudentSystem;

public class Student {
    private String id;
    private String name;
    private String age;
    private String ADD;

    public Student(String id, String name, String age, String add) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.ADD = add;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getADD() {
        return ADD;
    }

    public void setADD(String ADD) {
        this.ADD = ADD;
    }
}
