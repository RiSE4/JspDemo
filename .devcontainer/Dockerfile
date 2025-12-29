FROM tomcat:9.0

RUN apt-get update \
 && apt-get install -y \
    git \
    openjdk-17-jdk \
    default-mysql-client \
 && rm -rf /var/lib/apt/lists/*