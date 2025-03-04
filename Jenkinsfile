pipeline {
    agent { label 'agent2' }

    tools {
        git 'Default'
    }

    stages {
        stage('Prepare Environment') {
            steps {
                sh 'chmod +x ./gradlew'
            }
        }
        stage('Check') {
            steps {
                sh './gradlew check -P"dotenv.filename"="/var/agent-jdk21/env/.env.develop"'
            }
        }
        stage('Package') {
            steps {
                sh './gradlew build -P"dotenv.filename"="/var/agent-jdk21/env/.env.develop"'
            }
        }
        stage('JaCoCo Report') {
            steps {
                sh './gradlew jacocoTestReport -P"dotenv.filename"="/var/agent-jdk21/env/.env.develop"'
            }
        }
        stage('JaCoCo Verification') {
            steps {
                sh './gradlew jacocoTestCoverageVerification -P"dotenv.filename"="/var/agent-jdk21/env/.env.develop"'
            }
        }
        stage('Get project version') {
            steps {
                script {
                   def VERSION = sh(script: './gradlew printVersion -q', returnStdout: true).trim()
                   env.VERSION = VERSION
                   echo "Project version: ${env.VERSION}"
                }
            }
        }
        stage('Docker Build') {
            steps {
                sh "docker build --build-arg VERSION=${env.VERSION} -t job4j_devops ."
            }
        }
        stage('Update DB') {
            steps {
                script {
                    sh './gradlew update -P"dotenv.filename"="/var/agent-jdk21/env/.env.develop"'
                }
            }
        }
    }

    post {
        always {
            script {
                def buildInfo = """
                    Build number: ${currentBuild.number}
                    Build status: ${currentBuild.currentResult}
                    Started at: ${new Date(currentBuild.startTimeInMillis)}
                    Duration: ${currentBuild.durationString}
                """
                telegramSend(message: buildInfo)
            }
        }
    }
}