

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
    public void testStoredComment()
    {
        Comment comment1 = new Comment("John", "It sounds decent", 4);
        assertEquals(comment1.getFullDetails(), comment1.getFullDetails());
    }

    @Test
    public void testUpvote()
    {
        Comment comment1 = new Comment("Lorem Ipsum", "It's one of the speakers", 3);
        comment1.upvote();
        assertEquals(1, comment1.getVoteCount());
    }

    @Test
    public void testDownvote()
    {
        Comment comment1 = new Comment("Lorem Ipsum", "It's one of the speakers", 3);
        comment1.upvote();
        comment1.upvote();
        comment1.downvote();
        assertEquals(1, comment1.getVoteCount());
    }

    @Test
    public void testDownvoteWithNoVotes()
    {
        Comment comment2 = new Comment("VA", "I like it", 4);
        comment2.downvote();
        assertEquals(-1, comment2.getVoteCount());
    }

    @Test
    public void testAuthor()
    {
        Comment comment1 = new Comment("NM", "Works but expensive", 3);
        assertEquals("NM", comment1.getAuthor());
    }
}






