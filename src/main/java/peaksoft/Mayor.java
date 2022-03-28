package peaksoft;

public class Mayor {
    private int id;
    private String mayorName;
    private String mayorSurname;
    private int age;
    private String nationality;

    public Mayor() {
    }

    public Mayor(String mayorName, String mayorSurname, int age, String nationality) {
        this.mayorName = mayorName;
        this.mayorSurname = mayorSurname;
        this.age = age;
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMayorName() {
        return mayorName;
    }

    public void setMayorName(String mayorName) {
        this.mayorName=mayorName;
    }

    public String getMayorSurname() {
        return mayorSurname;
    }

    public void setMayorSurname(String mayorSurname) {
        this.mayorSurname=mayorSurname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Mayor{" +
                "id=" + id +
                ", mayorName='" + mayorName + '\'' +
                ", mayorSurname='" +  + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
