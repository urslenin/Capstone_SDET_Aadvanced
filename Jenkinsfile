pipeline {
    agent any

     stages {
              
        stage('SauceDemo BDD Execution') {
            steps {
                 dir("${env.WORKSPACE}"){
                 bat "mvn -D clean test"
                }
              } 
            post {
              success{
                 echo "Test Success"
                }
            }
        }
    }
}
