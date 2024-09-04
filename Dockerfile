FROM maven:3.8.5-openjdk-21
LABEL authors="jholkin"
WORKDIR /franchises
COPY . .
ENTRYPOINT ["top", "-b"]