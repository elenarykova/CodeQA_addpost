import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class PostTest {

    @Test
    public void testAddPost() {
        Post post = new Post();

        // Test case 1: Title length less than 10 characters
        assertFalse(post.addPost("Short", "A".repeat(250), new ArrayList<>(List.of("tag1", "tag2")), "Easy", "Ordinary"));

        // Test case 2: Title starts with special character
        assertFalse(post.addPost("!InvalidTitle", "A".repeat(250), new ArrayList<>(List.of("tag1", "tag2")), "Easy", "Ordinary"));

        // Test case 3: Body length less than 250 characters
        assertFalse(post.addPost("Valid Title", "Short Body", new ArrayList<>(List.of("tag1", "tag2")), "Easy", "Ordinary"));

        // Test case 4: Insufficient number of tags
        assertFalse(post.addPost("Valid Title", "A".repeat(250), new ArrayList<>(List.of("tag1")), "Easy", "Ordinary"));

        // Test case 5: Tags contain upper-case letters
        assertFalse(post.addPost("Valid Title", "A".repeat(250), new ArrayList<>(List.of("Tag1", "tag2")), "Easy", "Ordinary"));

        // Test case 6: Easy post with more than 3 tags
        assertFalse(post.addPost("Valid Title", "A".repeat(250), new ArrayList<>(List.of("tag1", "tag2", "tag3", "tag4")), "Easy", "Ordinary"));
    }

    @Test
    public void testAddComment() {
        Post post = new Post();
        post.addPost("Valid Title", "A".repeat(250), new ArrayList<>(List.of("tag1", "tag2")), "Easy", "Ordinary");

        // Test case 1: Comment length less than 4 words
        assertFalse(post.addComment("Short comment."));

        // Test case 2: Comment starts with lowercase letter
        assertFalse(post.addComment("invalid comment text"));

        // Add comments to reach the maximum limit for an "Easy" post
        post.addComment("Valid Comment One.");
        post.addComment("Valid Comment Two.");
        post.addComment("Valid Comment Three.");

        // Test case 3: Maximum number of comments reached for Easy/Ordinary post
        assertFalse(post.addComment("Valid Comment Four."));

        // Test case 4: Valid comment addition (after modifying constraints if needed)
        assertTrue(post.addComment("Valid Comment Four."));  // Adjust this test based on actual constraints
    }
}
