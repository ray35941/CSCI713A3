# Mutation Coverage Report (PIT)

## Summary

Mutation testing was performed using PIT (Pitest) on **StudentService** and **Utils** classes.

### Overall Statistics
- **Total Mutations Generated:** 50
- **Mutations Killed:** 41
- **Mutations Survived:** 9
- **Mutations with No Coverage:** 1
- **Overall Mutation Coverage:** 82% (41/50)
- **Test Strength:** 84% (41/49, excluding no coverage)

---

## StudentService Class

### Mutation Coverage Statistics
- **Total Mutations:** 30
- **Mutations Killed:** 25
- **Mutations Survived:** 4
- **Mutations with No Coverage:** 1
- **Mutation Coverage:** **83.3%** (25/30)
- **Test Strength:** **86.2%** (25/29, excluding no coverage)

### Survived Mutations (Weaknesses in Test Suite)

1. **Line 32 - `calculateAverageGpa()`**
   - **Mutator:** `RemoveConditionalMutator_ORDER_IF`
   - **Issue:** Test doesn't verify behavior when `students.size() > 0` condition is removed
   - **Location:** Condition `if (students.size() > 0)`

2. **Line 19 - `getTopStudent()`**
   - **Mutator:** `ConditionalsBoundaryMutator`
   - **Issue:** Test doesn't catch boundary condition changes in comparison
   - **Location:** Condition `if (s.getGpa() < top.getGpa())`

3. **Line 17 - `getTopStudent()`**
   - **Mutator:** `InlineConstantMutator`
   - **Issue:** Test doesn't verify behavior when index constant is mutated
   - **Location:** `students.get(0)`

4. **Line 19 - `getTopStudent()`**
   - **Mutator:** `NonVoidMethodCallMutator`
   - **Issue:** Test doesn't catch mutation in method call
   - **Location:** `s.getGpa()`

5. **Line 19 - `getTopStudent()`**
   - **Mutator:** `RemoveConditionalMutator_ORDER_ELSE`
   - **Issue:** Test doesn't verify behavior when else branch is removed
   - **Location:** Conditional logic in loop

6. **Line 42 - `removeStudentByName()`**
   - **Mutator:** `RemoveConditionalMutator_EQUAL_IF`
   - **Issue:** Test doesn't catch when equality check is removed
   - **Location:** `if (s.getName().equals(name))`

### Mutation Breakdown by Method

#### `StudentService()` Constructor
- **Mutations:** 2
- **Killed:** 2 (100%)
- **Coverage:** Excellent

#### `addStudent(Student)`
- **Mutations:** 1
- **Killed:** 1 (100%)
- **Coverage:** Excellent

#### `calculateAverageGpa()`
- **Mutations:** 12
- **Killed:** 10 (83.3%)
- **Survived:** 1
- **No Coverage:** 1
- **Coverage:** Good (but has gaps)

#### `getTopStudent()`
- **Mutations:** 9
- **Killed:** 5 (55.6%)
- **Survived:** 4
- **Coverage:** Needs improvement

#### `removeStudentByName(String)`
- **Mutations:** 6
- **Killed:** 5 (83.3%)
- **Survived:** 1
- **Coverage:** Good

---

## Utils Class

### Mutation Coverage Statistics
- **Total Mutations:** 20
- **Mutations Killed:** 19
- **Mutations Survived:** 1
- **Mutation Coverage:** **95%** (19/20)
- **Test Strength:** **95%** (19/20)

### Survived Mutations (Weaknesses in Test Suite)

1. **Line 11 - `isValidAge(int)`**
   - **Mutator:** `ConditionalsBoundaryMutator`
   - **Issue:** Test doesn't catch boundary condition changes
   - **Location:** Condition `if (age < 0)`
   - **Note:** This reveals a bug - the method doesn't check upper bound (age > 120), which is why the boundary mutation survives

### Mutation Breakdown by Method

#### `checkName(String)`
- **Mutations:** 12
- **Killed:** 12 (100%)
- **Coverage:** Excellent

#### `isValidAge(int)`
- **Mutations:** 8
- **Killed:** 7 (87.5%)
- **Survived:** 1
- **Coverage:** Very Good (but reveals actual bug in code)

---

## Key Findings

### Strengths
1. **Utils.checkName()** has 100% mutation coverage - all mutations are killed
2. **StudentService** constructor and `addStudent()` have perfect mutation coverage
3. Overall test suite is strong with 82% mutation coverage

### Weaknesses
1. **StudentService.getTopStudent()** has only 55.6% mutation coverage - needs more comprehensive tests
2. **Utils.isValidAge()** has one survived mutation that reveals a real bug (missing upper bound check)
3. **StudentService.calculateAverageGpa()** has one mutation with no coverage (line 35 - return 0.0 branch)

### Recommendations

1. **Add tests for `getTopStudent()`:**
   - Test with single student
   - Test with students having same GPA
   - Test boundary conditions in comparison logic

2. **Fix `Utils.isValidAge()`:**
   - Add upper bound check (e.g., `age <= 120`)
   - Add corresponding test cases

3. **Improve `calculateAverageGpa()` coverage:**
   - Add test for empty list scenario (currently has no coverage for return 0.0 branch)

4. **Improve `removeStudentByName()` coverage:**
   - Add test that verifies equality check behavior

---

## Detailed Reports

HTML mutation reports are available at:
- Main report: `target/pit-reports/index.html`
- StudentService: `target/pit-reports/default/StudentService.java.html`
- Utils: `target/pit-reports/default/Utils.java.html`

CSV data: `target/pit-reports/mutations.csv`

---

## Comparison: Line/Branch Coverage vs Mutation Coverage

| Class | Line Coverage | Branch Coverage | Mutation Coverage |
|-------|--------------|-----------------|-------------------|
| **StudentService** | 87% (20/23) | 67% (8/12) | **83.3%** (25/30) |
| **Utils** | 80% (4/5) | 100% (6/6) | **95%** (19/20) |

**Note:** Mutation coverage is generally more stringent than line/branch coverage as it tests whether tests can detect actual code changes (mutations). A high mutation coverage indicates that tests are not just executing code, but actually verifying behavior.


