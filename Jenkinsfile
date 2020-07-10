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
						Var1= props['name']
						Var2= props['action']
						echo "Var1=${Var1}"
						echo "Var2=${Var2}"
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
                expression { Var2 == 'UPGRADE'}
            }
            steps {
                echo "Hello, UPGRADE PIPELINE CALLED !"
            }
    }
    stage ('Build Project') {
      when {
                expression { Var2 != 'UPGRADE'}
            }
            steps {
                echo "Build Project Called"
            }
    }
   stage ('PUSH to ALM') {
      when {
                expression { Var2 != 'UPGRADE'}
            }
            steps {
                echo "PUSH to ALM Called!"
            }
        }
		
	stage ('TEST In ALM') {
      when {
                expression { Var2 != 'UPGRADE'}
            }
            steps {
                echo "TEST In ALM Called!"
            }
        }
		
	stage ('PUSH to NEXUS') {
      when {
                expression { Var2 != 'UPGRADE'}
            }
            steps {
                echo "PUSH to NEXUS Called!"
            }
        }
		
	stage ('PUSH to SOM Catalog') {
      when {
                expression { Var2 != 'UPGRADE'}
            }
            steps {
                echo "PUSH to SOM Catalog Called!"
            }
        }
		
  }
}