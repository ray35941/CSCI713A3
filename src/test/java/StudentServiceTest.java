import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ConcurrentModificationException;

class StudentServiceTest {

    @Test
    void testAddStudentAndTopStudent() {
        StudentService service = new StudentService();
        Student s1 = new Student("Alice", 20, 3.5);
        Student s2 = new Student("Bob", 22, 3.9);

        service.addStudent(s1);
        service.addStudent(s2);

        // Note: getTopStudent() has a bug - it finds LOWEST GPA, not highest
        // Test reflects actual behavior (lowest GPA student)
        Student top = service.getTopStudent();
        assertEquals("Alice", top.getName()); // Alice has lower GPA (3.5 < 3.9)
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
        service.addStudent(new Student("Alice", 20, 3.5));
        service.addStudent(new Student("Bob", 22, 3.9));
        service.addStudent(new Student("Alice", 21, 3.7)); // Add another Alice to ensure exception

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
    void checkName_shouldReturnFalseForNull() {
        // Valid test, but shows method name is misleading:
        // "checkName" suggests thorough validation, but does almost nothing
        assertFalse(Utils.checkName(null));
    }

    @Test
    void checkName_shouldReturnFalseForEmptyString() {
        assertFalse(Utils.checkName(""));
    }

    @Test
    void checkName_shouldReturnTrueForWhitespace_only() {
        // This exposes a code smell:
        // Method returns TRUE even though whitespace-only name is invalid.
        // Shows logic is overly simplistic and misleading.
        assertTrue(Utils.checkName("   "));
    }

    @Test
    void checkName_containsDuplicateLogic_smell() {
        // The logic: "if (condition) return true; else return false"
        // is duplicated and unnecessary, so we test behavior
        // but also highlight the code smell in comments.
        assertTrue(Utils.checkName("Alice"));
    }

    @Test
    void checkName_nameIsMisleading_smell() {
        // The method does NOT "check" name—it's just a length > 0 check.
        // This test demonstrates that invalid names pass.
        assertTrue(Utils.checkName("123"));   // probably not a real name
        assertTrue(Utils.checkName("@@@"));   // invalid name still true
    } 
     @Test
    void isValidAge_shouldReturnFalseForNegativeAge() {
        assertFalse(Utils.isValidAge(-1));
    }

    @Test
    void isValidAge_shouldReturnTrueForNormalAge() {
        assertTrue(Utils.isValidAge(20));
    }

    @Test
    void isValidAge_shouldReturnTrueForVeryLargeAge_BugExpected() {
        // Bug: method currently returns true for invalid ages such as 150
        assertTrue(Utils.isValidAge(150));
    }
}
