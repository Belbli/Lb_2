package abstractTest;

import exeption.TestTypeExeption;

import java.util.Arrays;

public enum TestType {

    EXAM("exam"),
    TEST("test"),
    FINAL_EXAM("final exam"),
    DRIVE_EXAM("drive exam");

    private String name;

    TestType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static TestType resolve(String name) {
        return Arrays.stream(TestType.values())
                .filter(test -> test.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new TestTypeExeption("Unknown test name: " + name));
    }
}
