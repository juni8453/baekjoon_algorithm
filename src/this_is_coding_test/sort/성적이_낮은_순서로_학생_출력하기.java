package this_is_coding_test.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {

    String name;
    int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    // 성적 순 오름차순
    @Override
    public int compareTo(Student o) {
        return this.grade - o.grade;
    }
}

public class 성적이_낮은_순서로_학생_출력하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int grade = Integer.parseInt(st.nextToken());

            students.add(new Student(name, grade));
        }

        Collections.sort(students);

        for (int i = 0; i < students.size(); i++) {
            System.out.print(students.get(i).name + " ");
        }
    }
}

// 학생의 이름, 학생의 성적으로 학생 정보가 구분된다.
// 성적이 낮은 순서대로 학생의 이름을 출력해라. (성적 오름차순)
