import java.util.List;

class Teacher {
    private int id;
    private String name;

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class StudyGroup {
    private Teacher teacher;
    private List<Student> students;

    public StudyGroup(Teacher teacher, List<Student> students) {
        this.teacher = teacher;
        this.students = students;
    }
}

class StudyGroupService {
    public StudyGroup createStudyGroup(Teacher teacher, List<Student> students) {
        return new StudyGroup(teacher, students);
    }
}

class Controller {
    private StudyGroupService studyGroupService;

    public Controller(StudyGroupService studyGroupService) {
        this.studyGroupService = studyGroupService;
    }

    public StudyGroup createStudyGroupWithIds(int teacherId, List<Integer> studentIds) {
        Teacher teacher = new Teacher(teacherId, "Преподаватель");
        List<Student> students = getStudentsByIds(studentIds);
        
        return studyGroupService.createStudyGroup(teacher, students);
    }

    private List<Student> getStudentsByIds(List<Integer> studentIds) {
        return List.of(new Student(1, "Студент 1"), new Student(2, "Студент 2"));
    }
}