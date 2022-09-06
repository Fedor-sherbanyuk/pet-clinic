pipeline {
      agent any
      parameters {
          booleanParam(name: 'DEPLOY', defaultValue: true, description: 'Server to deploy')
      }
      stages {
        stage("Build") {
            steps {
                echo 'Building...'
                bat """
                    mvn clean install -DskipTests=true
                """
            }
        }
        stage("Test") {
            steps {
                echo 'Testing...'
                bat """
                    mvn test -Dsurefire.useFile=false
                """
            }
        }
        stage('SonarQube analysis') {
            steps {
                echo 'My SonarQube Server...'
                bat """
                    mvn compile org.sonarsource.scanner.maven:sonar-maven-plugin:3.4.0.905:sonar  -D sonar.login=admin -D sonar.password=ndsF3755
                """
            }
        }
    }
}