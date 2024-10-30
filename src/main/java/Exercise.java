import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;

public class Exercise {
  public static void main(String[] args) throws IOException, InterruptedException {

    // Import library
    if (checksum()) {
      System.out.println("Successfully imported the Apache Commons IO library");
    } else {
      System.out.println("Wrong version of the library");
    }

    // Working with Streams
    readWebPage("https://digitalcareerinstitute.org/");

    // Working with files
    readFile("LoremIpsum.txt");
    copyFile("LoremIpsum.txt");

    // Find files with extension .java in other project
    findJavaFiles("./");
  }


  private static boolean checksum() throws IOException {

    File file = new File("lib/commons-io-2.11.0.jar");
    long checksum = FileUtils.checksumCRC32(file);

    return checksum == 2449403980L;
  }

  private static void readWebPage(String url) throws IOException {
    System.out.println("\n\nReading " + url);

    HttpURLConnection connection = null;
    try {
      URL dci_url = new URL(url);

      connection = (HttpURLConnection) dci_url.openConnection();
      connection.setRequestProperty("User-Agent", "Mozilla/5.0");

      InputStream in = connection.getInputStream() ;

      System.out.println(IOUtils.toString(in, StandardCharsets.UTF_8));
      IOUtils.closeQuietly(in);

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (connection != null) {
        connection.disconnect();
      }
    }
   }

  private static void readFile(String fileName) throws IOException {
    System.out.println("\n\nReading LoremIpsum.txt:");

    File sourceFile = new File("src/main/resources/LoremIpsum.txt");
    String fileContents = FileUtils.readFileToString(sourceFile, "UTF-8");
    System.out.println("Contents of LoremIpsum.txt:");
    System.out.println(fileContents);
  }

  private static void copyFile(String fileName) throws IOException, InterruptedException {
    File tmpDirectory = FileUtils.getTempDirectory();
    System.out.println("\n\nCreating a copy of LoremIpsum.txt in " + tmpDirectory);


    File file = new File("src/main/resources/" + fileName);
    FileUtils.copyToDirectory(file, tmpDirectory);

    Thread.sleep(1000);
    System.out.println(tmpDirectory  + fileName);

    System.out.println("\n\nDeleting a copy of LoremIpsum.txt in " + FileUtils.getTempDirectoryPath() + "/" + fileName);
    File tmpFile = new File(FileUtils.getTempDirectoryPath() + "/" + fileName);
    FileUtils.delete(tmpFile);
  }

  private static void findJavaFiles(String relativePath) {
    System.out.println("\n\nListing all java files in directory " + relativePath);

    File projectDirectory  = new File(relativePath);

    Collection<File> javaFiles = FileUtils.listFiles(projectDirectory , new WildcardFileFilter("*.java"), TrueFileFilter.INSTANCE);

    for (File javaFile : javaFiles) {
      System.out.println(javaFile.getName());
    }
  }
}
