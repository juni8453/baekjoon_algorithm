package groom.week_2;

import java.io.IOException;

import java.util.*;

class Person implements Comparable<Person> {

    String name;
    String high;

    public Person(String name, String high) {
        this.name = name;
        this.high = high;
    }

    // 이름이 같다면 작은 키부터 큰 키로 오름차순 정렬
    // 이름이 다르다면 사전 순으로 정렬
    @Override
    public int compareTo(Person o) {
        if (this.name.equals(o.name)) {
            return this.high.compareTo(o.high);
        }

        return this.name.compareTo(o.name);
    }
}

public class 출석부 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 사람의 수
        int k = sc.nextInt(); // 찾아야 하는 수
        List<Person> personInfo = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String high = sc.next();

            personInfo.add(new Person(name, high));
        }

        Collections.sort(personInfo);

        System.out.print(personInfo.get(k - 1).name + " " + personInfo.get(k - 1).high);
    }
}
