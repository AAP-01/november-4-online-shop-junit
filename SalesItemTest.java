import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  mik
 * @version 0.1
 */
public class SalesItemTest
{
    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test that a comment can be added, and that the comment count is correct afterwards.
     */
    @Test
    public void testAddComment()
    {
        SalesItem salesIte1 = new SalesItem("Brain surgery for Dummies", 21998);
        assertEquals(true, salesIte1.addComment("James Duckling", "This book is great. I perform brain surgery every week now.", 4));
        assertEquals(1, salesIte1.getNumberOfComments());
    }

    /**
     * Test that a comment using an illegal rating value is rejected.
     */
    @Test
    public void testIllegalRating()
    {
        SalesItem salesIte1 = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        assertEquals(false, salesIte1.addComment("Joshua Black", "Not worth the money. The font is too small.", -5));
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testInit()
    {
        SalesItem salesIte1 = new SalesItem("test name", 1000);
        assertEquals("test name", salesIte1.getName());
        assertEquals(1000, salesIte1.getPrice());
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
        SalesItem salesIte1 = new SalesItem("Speaker", 39999);
        assertEquals(false, salesIte1.addComment("John", "Low quality", 0));
        assertEquals(false, salesIte1.addComment("Juan", "Amazing", 6));
    }

    @Test
    public void testMostHelpfulComment()
    {
        SalesItem salesIte1 = new SalesItem("Radio", 9999);
        assertEquals(true, salesIte1.addComment("MA", "Cheap but works well", 5));
        salesIte1.upvoteComment(0);
        salesIte1.upvoteComment(0);
        assertEquals(true, salesIte1.addComment("MI", "Received a defect", 1));
        salesIte1.upvoteComment(1);
        Comment comment1 = salesIte1.findMostHelpfulComment();
        assertEquals(comment1, comment1);
    }

    @Test
    public void testNoHelpfulComment()
    {
        SalesItem salesIte1 = new SalesItem("Computer", 49999);
        salesIte1.showInfo();
    }

    @Test
    public void testNumberOfComments()
    {
        SalesItem salesIte1 = new SalesItem("Phone", 59999);
        salesIte1.addComment("WI", "Good phone", 5);
        salesIte1.addComment("CA", "Overpriced", 3);
        assertEquals(2, salesIte1.getNumberOfComments());
    }

    @Test
    public void testNoComments()
    {
        SalesItem salesIte1 = new SalesItem("Headphones", 19999);
        assertEquals(0, salesIte1.getNumberOfComments());
    }
}





