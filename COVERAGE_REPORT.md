# Code Coverage Report

## Coverage Summary for StudentService and Utils Classes

### StudentService Class

**Line Coverage:**
- Lines Covered: 20
- Lines Missed: 3
- Total Lines: 23
- **Line Coverage: 87%** (20/23)

**Branch Coverage:**
- Branches Covered: 8
- Branches Missed: 4
- Total Branches: 12
- **Branch Coverage: 67%** (8/12)

**Method Coverage:**
- Methods Covered: 5
- Methods Missed: 0
- **Method Coverage: 100%** (5/5)

**Details by Method:**
- `StudentService()`: 100% line coverage, 100% method coverage
- `addStudent(Student)`: 100% line coverage, 100% method coverage
- `getTopStudent()`: 86% line coverage, 75% branch coverage
- `calculateAverageGpa()`: 86% line coverage, 75% branch coverage
- `removeStudentByName(String)`: 83% line coverage, 50% branch coverage

---

### Utils Class

**Line Coverage:**
- Lines Covered: 4
- Lines Missed: 1
- Total Lines: 5
- **Line Coverage: 80%** (4/5)

**Branch Coverage:**
- Branches Covered: 6
- Branches Missed: 0
- Total Branches: 6
- **Branch Coverage: 100%** (6/6)

**Method Coverage:**
- Methods Covered: 2
- Methods Missed: 1 (default constructor not covered)
- **Method Coverage: 67%** (2/3)

**Details by Method:**
- `checkName(String)`: 100% line coverage, 100% branch coverage
- `isValidAge(int)`: 100% line coverage, 100% branch coverage
- `Utils()` (default constructor): 0% coverage (not tested, as expected)

---

## Summary Table

| Class | Line Coverage | Branch Coverage | Method Coverage |
|-------|--------------|-----------------|-----------------|
| **StudentService** | **87%** (20/23) | **67%** (8/12) | 100% (5/5) |
| **Utils** | **80%** (4/5) | **100%** (6/6) | 67% (2/3) |

---

## Coverage Report Location

Detailed HTML coverage reports are available at:
- `target/site/jacoco/index.html` - Main coverage report
- `target/site/jacoco/default/StudentService.html` - StudentService detailed report
- `target/site/jacoco/default/Utils.html` - Utils detailed report

## Notes

- The default constructor for `Utils` is not covered (expected, as it's not used)
- `StudentService.removeStudentByName()` has lower branch coverage (50%) due to incomplete test coverage of all code paths
- `StudentService.getTopStudent()` and `calculateAverageGpa()` have 75% branch coverage, indicating some conditional branches are not fully tested


