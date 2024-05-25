FROM gradle:jdk21-alpine
ARG PRODUCTION
ARG JDBC_DATABASE_PASSWORD
ARG JDBC_DATABASE_URL
ARG JDBC_DATABASE_USERNAME
ARG JWT_SECRET

ENV PRODUCTION ${PRODUCTION}
ENV JDBC_DATABASE_PASSWORD ${JDBC_DATABASE_PASSWORD}
ENV JDBC_DATABASE_URL ${JDBC_DATABASE_URL}
ENV JDBC_DATABASE_USERNAME ${JDBC_DATABASE_USERNAME}
ENV JWT_SECRET ${JWT_SECRET}

WORKDIR /app
COPY ./heymart-be-authenticate-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java","-jar","heymart-be-authenticate-0.0.1-SNAPSHOT.jar"]