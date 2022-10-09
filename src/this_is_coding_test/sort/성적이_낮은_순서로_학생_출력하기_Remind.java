package this_is_coding_test.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Student2 implements Comparable<Student2>{
    String name;
    int grade;

    public Student2(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public int compareTo(Student2 o) {
        return this.grade - o.grade;
    }
}

public class 성적이_낮은_순서로_학생_출력하기_Remind {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Student2> students = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int grade = Integer.parseInt(st.nextToken());
            students.add(new Student2(name, grade));
        }

        Collections.sort(students);

        for (Student2 student : students) {
            System.out.print(student.name + " ");
        }
    }
}
