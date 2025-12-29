FROM tomcat:9.0

RUN apt-get update \
 && apt-get install -y \
    git \
    git-lfs \
    openjdk-17-jdk \
    default-mysql-client \
 && git lfs install \
 && rm -rf /var/lib/apt/lists/*