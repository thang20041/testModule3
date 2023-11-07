package Model;

public class Student {
    private int id;
    private String name;
    private String email;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;
    private Clasez clasez;

    public Student(int id, String name, String email, String dateOfBirth, String address, String phoneNumber, Clasez clasez) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.clasez = clasez;
    }

    public Student(String name, String email, String dateOfBirth, String address, String phoneNumber, Clasez clasez) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.clasez = clasez;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Clasez getClasez() {
        return clasez;
    }

    public void setClasez(Clasez clasez) {
        this.clasez = clasez;
    }
}
