pipeline {
   agent {
          node {
              label 'maven'
          }
      }


  stages {
    stage('拉取代码') {
      agent none
      steps {
        git(url: 'https://gitee.com/zengrenshang/springboot-jdk8.git',  branch: "${params.BRANCH_NAME}")
        script {
            BRANCH_TAG = sh(returnStdout: true, script: 'git rev-parse --short HEAD').trim()
            echo "BRANCH_TAG: $BRANCH_TAG"
        }
      }
    }

    stage('编译代码') {
      agent none
      steps {
        container('maven') {
          sh 'mvn clean package -DskipTests=true'
        }

      }
    }

    stage('构建镜像并且推送到远程仓库') {
      agent none
      steps {
        container('maven') {
          sh "docker build -f Dockerfile -t $REGISTRY/$DOCKERHUB_NAMESPACE/$APP_NAME:$BRANCH_TAG ."
          withCredentials([usernamePassword(credentialsId : 'harbor' ,passwordVariable : 'DOCKER_PASSWORD' ,usernameVariable : 'DOCKER_USERNAME' ,)]) {
            sh 'echo "$DOCKER_PASSWORD" | docker login $REGISTRY -u "$DOCKER_USERNAME" --password-stdin'
            sh "docker push  $REGISTRY/$DOCKERHUB_NAMESPACE/$APP_NAME:$BRANCH_TAG"
          }
//           sh "docker build -f Dockerfile -t $REGISTRY/$DOCKERHUB_NAMESPACE/$APP_NAME:$COMMIT_ID ."
//           withCredentials([usernamePassword(credentialsId : 'harbor' ,passwordVariable : 'DOCKER_PASSWORD' ,usernameVariable : 'DOCKER_USERNAME' ,)]) {
//             sh 'echo "$DOCKER_PASSWORD" | docker login $REGISTRY -u "$DOCKER_USERNAME" --password-stdin'
//             sh "docker push  $REGISTRY/$DOCKERHUB_NAMESPACE/$APP_NAME:$COMMIT_ID"
//           }

        }

      }
    }

    stage('部署项目') {
       steps {
      //             input(id: 'deploy-to-dev', message: 'deploy to dev?')
          container ('maven') {
              withCredentials([
                  kubeconfigFile(
                  credentialsId: "$KUBECONFIG_CREDENTIAL_ID",
                  variable: 'KUBECONFIG')
                  ]) {
                  sh 'envsubst < deploy/*.yaml | kubectl apply -f -'
              }
          }
        }
    }

    stage('deploy to production') {
      steps {
        input(id: 'deploy-to-production', message: 'deploy to production?')
        kubernetesDeploy(configs: 'deploy/prod-ol/**', enableConfigSubstitution: true, kubeconfigId: "$KUBECONFIG_CREDENTIAL_ID")
      }
    }

  }
    environment {
          DOCKER_CREDENTIAL_ID = 'harbor'
          GITHUB_CREDENTIAL_ID = 'github-id'
          KUBECONFIG_CREDENTIAL_ID = 'demo-kubeconfig'
          REGISTRY = '192.168.6.132:30002'
          DOCKERHUB_NAMESPACE = 'myproject'
          GITHUB_ACCOUNT = 'kubesphere'
          APP_NAME = 'test-jdk8'
          BRANCH_TAG = "laster"
      }
      parameters {
          string(name: 'BRANCH_NAME', defaultValue: 'master', description: 'Git branch to build')
      }
}