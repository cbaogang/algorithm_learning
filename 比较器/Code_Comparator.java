package 比较器;
import java.util.*;
public class Code_Comparator {

	public static void main(String[]args) {
		
		Student stu1 = new Student("A",1,20);
		Student stu2 = new Student("B",4,25);
		Student stu3 = new Student("C",3,21);
		Student stu4 = new Student("D",7,22);
		Student stu5 = new Student("E",5,18);
		Student stu6 = new Student("F",5,26);
		
		Student [] students = new Student[] {stu1,stu2,stu3,stu4,stu5,stu6};
		
		Arrays.sort(students,new IdAscendingAgeDescendingComparator());
		
		System.out.println("数组打印-----------------------");

		for(int i=0;i<students.length;i++) {
			Student s = students[i]; 
			System.out.println(s.name+","+s.id+","+s.age);
		}
		
		
		ArrayList<Student> sList = new ArrayList<>();
		sList.add(stu1);
		sList.add(stu2);
		sList.add(stu3);
		sList.add(stu4);
		sList.add(stu5);
		sList.add(stu6);
		sList.sort(new IdAscendingAgeDescendingComparator());
		
		System.out.println("链表打印-----------------------");

		for(Student s : sList) {
			 
			System.out.println(s.name+","+s.id+","+s.age);
		}
		
		//TreeMap<Student,String>treeMap = new TreeMap<>(new IdAscendingAgeDescendingComparator());
		//有序表 不会加重复的key
		TreeMap<Student,String>treeMap = new TreeMap<>((a,b)->a.id-b.id);
		
		treeMap.put(stu1, "i name student 1, my name is A");
		treeMap.put(stu2, "i name student 2, my name is B");	
		treeMap.put(stu3, "i name student 3, my name is C");	
		treeMap.put(stu4, "i name student 4, my name is D");	
		treeMap.put(stu5, "i name student 5, my name is E");
		treeMap.put(stu6, "i name student 6, my name is F");
		
		
		System.out.println("有序表打印-----------------------");
		for(Student s:treeMap.keySet()) {
		
			System.out.println(s.name+","+s.id+","+s.age);
		}
		
		
	}
	
	
	public static class Student{
		public String name;
		public int age;
		public int id;
		
		
		public Student(String name, int id, int age) {
			this.name=name;
			this.id=id;
			this.age=age;
		}
	}
	
	
	public static class AgeAscendingComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			// TODO Auto-generated method stub
			
			
			return o1.age-o2.age;
		}
		
	}
	
	public static class IdDescendingComparator implements Comparator<Student>{

		/**
		 * if(o1.id>o2.id){
		 * return -1;}
		 * else if(o1.id<o2.id){
		 * return 1;}
		 * else {return 0;}
		 */
		@Override
		public int compare(Student o1, Student o2) {
			// TODO Auto-generated method stub
			return o2.id-o1.id;
		}
		
	}
	
	public static class IdAscendingAgeDescendingComparator implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			// TODO Auto-generated method stub
			return o1.id!=o2.id? (o1.id-o2.id):(o2.age-o1.age);
		}
		
	}
		
}
