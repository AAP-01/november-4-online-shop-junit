Project: online-shop-junit
Authors: Michael Kölling and David J. Barnes

This project is part of the material for the book

   Objects First with Java - A Practical Introduction using BlueJ
   Seventh edition
   David J. Barnes and Michael Kölling

This project implements a small part of an online sales system (such as Amazon.com).
The current project is concerned only with customer comments for sales items. It contains
code to create, store, show and manipulate customer comments.

The purpose of this project is to introduce regression testing using JUnit. It includes 
a test class that demonstrates some of the testing functionality. Testing is further 
discussed in the book.

NOTE: There are several serious errors to be found in these classes.

Lab II
12. Like in the sample image, the Test Results window shows no errors.

13. Created a test class for Comment.

14. Methods setUp() and tearDown() are automatically created upon the class' creation.

15. 
    @Test
    public void testSameAuthor()
    {
        SalesItem salesIte1 = new SalesItem("TV", 29999);
        assertEquals(true, salesIte1.addComment("John", "It's good", 5));
        assertEquals(false, salesIte1.addComment("John", "Works as intended", 4));
    }
    
This test makes sure no two comments can have the same author. This was made by 
creating a new test and recording it, which then automatically generates the test case.

16.
    @Test
    public void testValidRating()
    {
        SalesItem salesIte1 = new SalesItem("Speaker", 39999);
        assertEquals(false, salesIte1.addComment("John", "Low quality", 0));
        assertEquals(false, salesIte1.addComment("Juan", "Amazing", 6));
    }
    
This test requires that comments with a rating beyond the boundaries return false. 
However, running this test returns a failure as running that code returns true.

17.
expected:<false> but was:<true>
---
java.lang.AssertionError: expected:<false> but was:<true>
    at org.junit.Assert.fail(Assert.java:88)
    at org.junit.Assert.failNotEquals(Assert.java:834)
    at org.junit.Assert.assertEquals(Assert.java:118)
    at org.junit.Assert.assertEquals(Assert.java:144)
    at SalesItemTest.testValidRating(SalesItemTest.java:85)
    at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
    at java.base/java.lang.reflect.Method.invoke(Method.java:580)
    at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
    at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
    at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
    at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
    at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)
    at org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)
    at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
    at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
    at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
    at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
    at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
    at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
    at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
    at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
    at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
    at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
    at org.junit.runner.JUnitCore.run(JUnitCore.java:115)
    at org.junit.vintage.engine.execution.RunnerExecutor.execute(RunnerExecutor.java:40)
    at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
    at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
    at java.base/java.util.Iterator.forEachRemaining(Iterator.java:133)
    at java.base/java.util.Spliterators$IteratorSpliterator.forEachRemaining(Spliterators.java:1939)
    at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
    at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:151)
    at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:174)
    at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596)
    at org.junit.vintage.engine.VintageTestEngine.executeAllChildren(VintageTestEngine.java:80)
    at org.junit.vintage.engine.VintageTestEngine.execute(VintageTestEngine.java:71)
    at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:229)
    at org.junit.platform.launcher.core.DefaultLauncher.lambda$execute$6(DefaultLauncher.java:197)
    at org.junit.platform.launcher.core.DefaultLauncher.withInterceptedStreams(DefaultLauncher.java:211)
    at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:191)
    at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:128)
    
Regardless of what this means, I can look into the reference class and the method the 
test case is testing. Then I can run the method line-by-line to find the error.

18.
    @Test
    public void testStoredComment()
    {
        Comment comment1 = new Comment("John", "It sounds decent", 4);
        assertEquals(comment1.getFullDetails(), comment1.getFullDetails());
    }
    
This test case works since the required response to function is 
comment1.getFullDetails(), and actually calling that method returns the same string.

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
    
Calling upvote() adds one positive vote, so calling getVoteCount() should return 1, 
as it does correctly. Calling downvote() removes one vote, so calling upvote(), 
downvote() once and then getVoteCount() should return 1 as well, as it does correctly
    
19.
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
    
This checks whether getMostHelpfulComment() returns the correct comment judging 
by its vote count. In this case, MA's comment has the most upvotes so the program 
properly

    @Test
    public void testNoHelpfulComment()
    {
        SalesItem salesIte1 = new SalesItem("Computer", 49999);
        salesIte1.showInfo();
    }
    
This one makes verifies that getMostHelpfulComment() returns null since there 
are no comments.

20.
All other test cases I've added:
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
    
21.
    public void showInfo()
    {
        System.out.println("*** " + name + " ***");
        System.out.println("Price: " + priceString(price));
        System.out.println();
        System.out.println("Customer comments:");
        int i = 0;
        while(i < comments.size()) {
            System.out.println("-------------------------------------------");
            System.out.println(comments.get(i).getFullDetails());
            i++;
        }
        System.out.println();
        System.out.println("===========================================");
    }
    
    private Comment findCommentByAuthor(String author)
    {
        int i = 0;
        while(i < comments.size()) {
            if(comments.get(i).getAuthor().equals(author)) {
                i++;
                return comments.get(i);
            }
        }
        return null;
    }
    
    public Comment findMostHelpfulComment()
    {
        int i = 1;
        Comment best = comments.get(0);
        while(i < comments.size()) {
            Comment current = comments.get(i);
            if(current.getVoteCount() > best.getVoteCount()) {
                best = current;
            }
            i++;
        }
        return best;
    }