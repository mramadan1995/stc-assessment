package org.stc.assessment.assignment;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ReverseStringTest {

    private ReverseString reverseString;

    @Test
    void reverse() {

        reverseString = new ReverseString();
        // Test case 1
        String actualOutput1 = reverseString.reverse("abd(jnb)asdf");
        assertEquals("abd(bnj)asdf", actualOutput1);

        // Test case 2
        String actualOutput2 = reverseString.reverse("abdjnbasdf");
        assertEquals("abdjnbasdf", actualOutput2);

        // Test case 3
        String actualOutput3 = reverseString.reverse("dd(df)a(ghhh)");
        assertEquals("dd(fd)a(hhhg)", actualOutput3);
    }
}