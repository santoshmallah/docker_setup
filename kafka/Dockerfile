FROM apache/kafka-native:3.9.0

USER root
RUN apt-get update && \
    apt-get install -y curl tar && \
    curl -O https://downloads.apache.org/kafka/3.9.0/kafka_2.13-3.9.0.tgz && \
    tar -xzf kafka_2.13-3.9.0.tgz && \
    mv kafka_2.13-3.9.0 /opt/kafka-cli && \
    ln -s /opt/kafka-cli/bin/* /usr/bin/

RUN rm kafka_2.13-3.9.0.tgz

USER 1001
