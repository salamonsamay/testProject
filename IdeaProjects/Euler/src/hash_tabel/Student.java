package hash_tabel;

public class Student {
    private String name;
    private int age;
    private Integer id;

    public Student(){
        this.name="dani";
        age=26;
        id=new Integer(123456);
    }

    public Student(String name, int age, Integer id){
        this.name=name;
        this.age=age;
        this.id=new Integer(id);
    }
    public Student(Student s){
        this.name=s.name;
        this.age=s.age;
        this.id=s.id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String toString(){
        return name+" "+age+" "+id;
    }
}
