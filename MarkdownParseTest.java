import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void test_get_links_test_file() throws IOException{
        Path fileName = Path.of("mytest-file.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("https://something.com","some-page.html"),links);
    }

    @Test
    public void test_get_links_breaking_test() throws IOException{
        Path fileName = Path.of("breaking_test.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("www.something.com"),links);
    }

    @Test
    public void test_get_links_othertest() throws IOException{
        Path fileName = Path.of("othertest.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("","www.github.com"),links);
    }

    /*@Test
    public void testGetLinks(){
        try{


        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
