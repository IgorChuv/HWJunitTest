

public class Contact {
    private String name;
    private String surname;
    private String phone;
    private String group;

    public Contact(String name, String surname, String phone, String group) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public  String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "\nИмя: " + name + " Фамилия: " + surname + " Телефон: "+ phone + " Группа: " + group;
    }
}
