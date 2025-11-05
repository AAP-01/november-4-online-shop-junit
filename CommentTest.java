

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CommentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommentTest
{
    /**
     * Default constructor for test class CommentTest
     */
    public CommentTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testSameAuthor()
    {
        SalesItem salesIte1 = new SalesItem("TV", 29999);
        assertEquals(true, salesIte1.addComment("John", "It's good", 5));
        assertEquals(false, salesIte1.addComment("John", "Works as intended", 4));
    }

    @Test
    public void testValidRating()
    {
        SalesItem salesIte1 = new SalesItem("TV", 39999);
        assertEquals(false, salesIte1.addComment("John", "Not worth it", 0));
    }
}

