package mlp.buli;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SeasonCsvFile {
    private final Path path;

    public SeasonCsvFile(String path) {
        this.path = Path.of(path);
    }

    public Season read() throws IOException {
        List<String> lines = Files.readAllLines(this.path);
        lines.remove(0);

        Season season = new Season();

        for (String current : lines) {
            season.addMatch(parseMatch(current));
        }

        return season;
    }

    public Match parseMatch(String match) {
        String[] splits = match.split(";");
        return new Match(splits[1], splits[2], Integer.parseInt(splits[3]), Integer.parseInt(splits[4]));
    }
}
