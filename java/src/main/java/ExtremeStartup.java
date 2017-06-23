import static spark.Spark.get;
import static spark.Spark.port;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtremeStartup {

    private final String teamName;

    public ExtremeStartup(String teamName) {
        this.teamName = teamName;
    }

    public String answer(String question) {
        System.out.println(question);
        if (question == null)
            return teamName;
        Matcher sumMatcher = Pattern.compile(".*what is the sum of (\\d+) and (\\d+)").matcher(question);
        if (sumMatcher.matches()) {
            return String.valueOf(Integer.parseInt(sumMatcher.group(1)) + Integer.parseInt(sumMatcher.group(2)));
        }
        return teamName;
    }

    public static void main(String[] args) {
        final ExtremeStartup server = new ExtremeStartup("team name");
        port(1337);
        get("/", (request, response) -> server.answer(request.queryParams("q")));
    }

}
