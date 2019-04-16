package turnup.ideas.numerology.magic.numerologymagicserver.Model;


public class User
{
    private String Name ;
    private String Email ;
    private String IsStaff ;
    private String Password;
    private String Phone;
    private String Dateofbirth ;
    private String Country ;


    public User() {
    }

    public User(String name, String email, String password, String phone, String dateofbirth, String country ) {
        Name = name;
        Email = email;
        IsStaff = "false";
        Password = password;
        Phone = phone;
        Dateofbirth = dateofbirth;
        Country = country;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getIsStaff() {
        return IsStaff;
    }

    public void setIsStaff(String isStaff) {
        IsStaff = isStaff;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getDateofbirth() {
        return Dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        Dateofbirth = dateofbirth;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}

