pipeline {
    agent any
    stages {
        stage('Create Directory') {
            steps {
                script {
                    def dirName = 'my_new_directory'
                    
                    // Create the directory if it doesn't exist
                    sh """
                    if [ ! -d ${dirName} ]; then
                        mkdir ${dirName}
                        echo "Directory '${dirName}' created successfully."
                    else
                        echo "Directory '${dirName}' already exists."
                    fi
                    """
                }
            }
        }
        stage('Commit and Push Changes') {
            steps {
                script {
                    sh """
                    # Configure Git user (required for commits)
                    git config user.name "Jenkins CI"
                    git config user.email "jenkins@example.com"

                    # Add changes, commit, and push
                    git add .
                    git commit -m "Add new directory ${dirName}"
                    git push origin main
                    """
                }
            }
        }
    }
}
