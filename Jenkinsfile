def name = 'UNKNOWN'
def targetRelease = 'UNKNOWN'
def action = 'UNKNOWN'
def helmRelease = 'UNKNOWN'
def descriptor = 'UNKNOWN'
def version = 'UNKNOWN'
def Var1 = 'UNKNOWN'
def Var2 = 'UNKNOWN'


 pipeline {
    agent any 
  stages {
  
  stage('Read File') {
            steps {
				script {
					try {
						echo 'Starting Reading File'
						def data = readFile(file: 'assembly.properties')
						def props = readProperties  file: 'assembly.properties'
						name = props['name']
						targetRelease = props['targetRelease']
						action = props['action']
						helmRelease = props['helmRelease']
						Var1= props['name']
						Var2= props['action']
						echo "name=${name}"
						echo "targetRelease=${targetRelease}"
						echo "action=${action}"
						echo "helmRelease=${helmRelease}"
						println(data)

					}

					catch (err) {
						currentBuild.result = 'UNSTABLE'
						echo 'Inside catch .. caught exception'
						echo 'Incremental Build has failed!'
						echo 'Err: Incremental Build failed with Error: ' + err.getLocalizedMessage()	
						test_failed()
						throw new Exception("Testing failed. Something went wrong!")
					}
				}
            }
        }
  
    stage ('CALL UPGRADE PIPELINE Project') {
      when {
                expression { action == 'UPGRADE'}
            }
            steps {
                echo "Hello, UPGRADE PIPELINE CALLED !"
				build job: 'CNF_UPGRADE', parameters: [string(name: ${name}, targetRelease: ${targetRelease}, action: ${action}, helmRelease: ${helmRelease})], wait: false
            }
    }
    stage ('Build Project') {
      when {
                expression { action != 'UPGRADE'}
            }
            steps {
                echo "Build Project Called"
            }
    }
   stage ('PUSH to ALM') {
      when {
                expression { action != 'UPGRADE'}
            }
            steps {
                echo "PUSH to ALM Called!"
            }
        }
		
	stage ('TEST In ALM') {
      when {
                expression { action != 'UPGRADE'}
            }
            steps {
                echo "TEST In ALM Called!"
            }
        }
		
	stage ('PUSH to NEXUS') {
      when {
                expression { action != 'UPGRADE'}
            }
            steps {
                echo "PUSH to NEXUS Called!"
            }
        }
		
	stage ('PUSH to SOM Catalog') {
      when {
                expression { action != 'UPGRADE'}
            }
            steps {
                echo "PUSH to SOM Catalog Called!"
            }
        }
		
  }
}
