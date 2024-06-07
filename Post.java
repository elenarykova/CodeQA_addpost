import java.util.ArrayList;

public class Post {
    private String title;
    private String body;
    private ArrayList<String> tags;
    private String difficulty;
    private String urgency;
    private ArrayList<String> comments;

    public Post() {
        tags = new ArrayList<>();
        comments = new ArrayList<>();
    }

    public boolean addPost(String title, String body, ArrayList<String> tags, String difficulty, String urgency) {
        // Condition 1: Title length check
        if (title.length() < 10 || title.length() > 250 || !Character.isLetter(title.charAt(0))) {
            return false;
        }
        // Condition 2: Body length check
        if (body.length() < 250) {
            return false;
        }
        // Condition 3: Tags validation
        if (tags.size() < 2 || tags.size() > 5 || tags.stream().anyMatch(tag -> tag.length() < 2 || tag.length() > 10 || !tag.equals(tag.toLowerCase()))) {
            return false;
        }
        // Condition 4: Difficulty check
        if ((difficulty.equals("Easy") && tags.size() > 3) || (difficulty.equals("Very Difficult") || difficulty.equals("Difficult")) && body.length() < 300) {
            return false;
        }
        // Condition 5: Urgency check
        if ((difficulty.equals("Easy") && (urgency.equals("Immediately Needed") || urgency.equals("Highly Needed"))) || (difficulty.equals("Very Difficult") || difficulty.equals("Difficult")) && urgency.equals("Ordinary")) {
            return false;
        }
        // All conditions passed, add post
        this.title = title;
        this.body = body;
        this.tags = tags;
        this.difficulty = difficulty;
        this.urgency = urgency;
        return true;
    }

    public boolean addComment(String comment) {
        // Condition 1: Comment length and first character check
        String[] words = comment.split(" ");
        if (words.length < 4 || words.length > 10 || !Character.isUpperCase(words[0].charAt(0))) {
            return false;
        }
        // Condition 2: Maximum number of comments check
        if ((difficulty.equals("Easy") || urgency.equals("Ordinary")) && comments.size() >= 3) {
            return false;
        }
        // Add comment
        comments.add(comment);
        return true;
    }
}
