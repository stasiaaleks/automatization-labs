import org.gradle.api.Plugin
import org.gradle.api.Project

class GameStatsPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.extensions.create('gameStats', GameStatsExtension)

        project.tasks.register('generateReport') {
            group = 'game'
            description = 'Get a Rock-Paper-Scissors Games Report'

            doLast {
                def reportDir = project.layout.buildDirectory.dir("reports/game-stats").get().asFile
                reportDir.mkdirs()

                def reportFile = new File(reportDir, 'game-report.txt')
                reportFile.text = generateReport(project)
                println "Report generated: ${reportFile.absolutePath}"
            }
        }

        project.tasks.register('showGameProjectInfo') {
            group = 'game'
            description = 'Views project general info'

            doLast {
                println "-------"
                println "Project info:"
                println "Project: ${project.name}"
                println "Version: ${project.version}"
                println "Modules: ${project.rootProject.subprojects.collect { it.name }}"
                println "-------"
            }
        }
    }

    private static String generateReport(Project project) {
        def timestamp = new Date().toString()

        return """
            Latest game stats report
            =====================
            Generated: ${timestamp}
            Project: ${project.name}
            Version: ${project.version}
            
            Available modules:
            ${project.rootProject.subprojects.collect { "- ${it.name}" }.join('\n')}
            """
        }
    }

    class GameStatsExtension {
        String reportFormat = 'txt'
        boolean includeTimestamp = true
        String outputDir = 'build/reports/game-stats'
    }