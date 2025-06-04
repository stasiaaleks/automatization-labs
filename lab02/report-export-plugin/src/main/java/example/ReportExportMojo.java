package example;

import com.example.ReportController;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


@Mojo(name = "export-json")
public class ReportExportMojo extends AbstractMojo {
    /**
     * Params:
     * - filename with extension (path specified from root folder)
     */
    @Parameter(property = "exportFile", defaultValue = "report.json")
    private String exportFile;

    @Override
    public void execute() throws MojoExecutionException {
        getLog().info("Exporting as JSON from plugin...");
        ReportController controller = new ReportController();

        try {
            List<WeatherDailyReportModel> reports = controller.GetAllReports();
            String json = StringUtils.stringifyToJson(reports);

            try (FileWriter writer = new FileWriter(exportFile)) {
                writer.write(json);
                getLog().info("JSON exported to: " + exportFile);
            }
        } catch (JsonProcessingException e) {
            throw new MojoExecutionException("Failed to process JSON", e);
        } catch (IOException e) {
            throw new MojoExecutionException("Failed to export JSON", e);
        }
    }
}