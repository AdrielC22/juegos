pipeline {
    agent any

    environment{
        REMOTE_HOST = "ec2-user@3.82.176.67"
        PEM_PATH = "/.ssh-keys/docker-vm-key.pem"
        REPO_URL= "https://github.com/AdrielC22/juegos.git"
        REPO_DIR = "/home/ec2-user/github-repos"
        MULTIJUEGOS_DIR = "/home/ec2-user/github-repos/juegos"
    }

    stages{
        stage('limpieza'){
            steps{
                sh """
                    sudo ssh -i $PEM_PATH $REMOTE_HOST << EOF
                        echo "Paso1:Limpieza"
                        sudo rm -rf $MULTIJUEGOS_DIR
                        sudo mkdir -p $REPO_DIR
                        exit
                    EOF
                """
            }
        }

        stage('clonado'){
            steps{
                sh """
                    sudo ssh -i $PEM_PATH $REMOTE_HOST << EOF
                        echo "Paso2:clonado repo"
                        cd $REPO_DIR
                        sudo git clone $REPO_URL
                        exit
                    EOF
                """
            }
        }

        stage('build'){
            steps{
                sh """
                    sudo ssh -i $PEM_PATH $REMOTE_HOST << EOF
                        echo "Paso3:Creación de imagen"
                        cd $MULTIJUEGOS_DIR
                        sudo docker build -t multi-image .
                        exit
                    EOF
                """
            }
        }

        stage('ejecucion'){
            steps{
                sh """
                    sudo ssh -i $PEM_PATH $REMOTE_HOST << EOF
                        echo "Paso4:Ejecución de imagen - correr contenedor"
                        sudo docker rm -f multi-1 || true
                        sudo docker run --name multi-1 -d -p 8090:8080 multi-image
                        exit
                    EOF
                """
            }
        }
    }
}