def pomLocation = "springboot-rest-example-parent"
def targetLocation = "springboot-rest-example-parent/springboot-rest-example/target"

node {

    stage('Checkout') {
        checkout scm
    }

    stage('Build') {

        try {
            sh "mvn -B -V -U -e -f " + pomLocation + "/pom.xml clean install"
        } finally {
            junit targetLocation + '/surefire-reports/*.xml'

            publishHTML(target: [
                    allowMissing         : true,
                    alwaysLinkToLastBuild: false,
                    keepAll              : true,
                    reportDir            : targetLocation + '/pit-reports',
                    reportFiles          : 'index.html',
                    reportName           : "springboot-rest-example pit report"
            ])
        }
    }
}