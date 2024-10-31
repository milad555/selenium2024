package ClassWork;

import java.util.ArrayList;
import java.util.List;

public class ArrayHWmain {

    public static void main(String[] args) {
        Person anna = new Person("Anna", 20);
        Person donna = new Person("Donna", 30);
        Person zhanna = new Person("Zhanna", 40);

        ArrayList<Person> people = new ArrayList<>();
        people.add(anna);
        people.add(donna);
        people.add(zhanna);

        for (int i = 0; i < people.size(); i++) {
            people.get(i).getName();
            people.get(i).getAge();
            System.out.println(people.get(i).getName() + " is " + people.get(i).getAge() + " old");
        }

        List<String> names = people.stream().map(Person::getName).toList();
        System.out.println(names);
    }
}
