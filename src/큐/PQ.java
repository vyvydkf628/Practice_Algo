package 큐;
import java.util.*;
public class PQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//or
		PriorityQueue<Student> pq = new PriorityQueue<>(1, new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			// TODO Auto-generated method stub
			if (o1.age < o2.age) {
				return -1;
			} else {
				return 1;
			}
		}
		});
		pq.add(new Student("ASD", 12));
		pq.add(new Student("ASD", 5));
		pq.add(new Student("ASD", 14));
		pq.add(new Student("ASD", 11));
		System.out.println(pq.poll());
	}

}
class Student implements Comparable<Student> {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student target) {
        return this.age <= target.age ? 1 : - 1;
    }

    @Override
    public String toString() {
        return "이름 : " + name + ", 나이 : " + age;
    }
}