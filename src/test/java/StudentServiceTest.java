import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void testAddStudentAndTopStudent() {
        StudentService service = new StudentService();
        Student s1 = new Student("Alice", 20, 3.5);
        Student s2 = new Student("Bob", 22, 3.9);

        service.addStudent(s1);
        service.addStudent(s2);

        // Test if top student is correctly identified
        Student top = service.getTopStudent();
        assertEquals("Bob", top.getName());
    }

    @Test
    void testCalculateAverageGpa() {
        StudentService service = new StudentService();
        service.addStudent(new Student("Alice", 20, 3.5));
        service.addStudent(new Student("Bob", 22, 3.5));

        double avg = service.calculateAverageGpa();
        assertEquals(3.5, avg, 0.001);
    }

    // Intentionally leave out tests for:
    // - removeStudentByName
    @Test
    void removeStudentByName_shouldThrowConcurrentModificationException() {
        StudentService service = new StudentService();
        service.addStudent(new Student("Alice"));
        service.addStudent(new Student("Bob"));

        assertThrows(ConcurrentModificationException.class, () -> {
            service.removeStudentByName("Alice");
        });
    }
    // - behavior with empty student list
    @Test
    void getTopStudent_shouldThrowExceptionWhenListIsEmpty() {
        StudentService service = new StudentService(); // students list is empty

        assertThrows(IndexOutOfBoundsException.class, () -> {
            service.getTopStudent();
        });
    }
    // - Utils methods
     @Test
    void checkName_shouldReturnTrueForValidName() {
        assertTrue(StudentService.checkName("Alice"));
    }

    @Test
    void checkName_shouldReturnFalseForEmptyString() {
        assertFalse(StudentService.checkName(""));
    }

    @Test
    void checkName_shouldReturnFalseForNull() {
        assertFalse(StudentService.checkName(null));
    }
    
}
