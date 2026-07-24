package com.mycompany.webapp;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class WelcomeServletTest {

    @Test
    public void testAppBuildsSuccessfully() {
        // Placeholder sanity test so 'mvn test' has something to run
        // and the pipeline demonstrates a passing test stage.
        String expected = "Good Mrng";
        String actual = "Good Mrng..";
        assertEquals(expected, actual);
    }
}
