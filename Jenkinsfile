pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'set'
            }
        }
    }
}
pipeline {
    agent any
    stages {
        stage('Deploy') {
            steps {
                retry(3) {
                    bat './flakey-deploy.sh'
                }

                timeout(time: 3, unit: 'MINUTES') {
                    bat './health-check.bat'
                }
            }
        }
    }
}
pipeline {
    agent any
    stages {
        stage('Deploy') {
            steps {
                timeout(time: 3, unit: 'MINUTES') {
                    retry(5) {
                        bat './flakey-deploy.bat'
                    }
                }
            }
        }
    }
}
pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                bat 'echo "Fail!"; exit 1'
            }
        }
    }
    post {
        always {
            echo 'This will always run'
        }
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }
}
