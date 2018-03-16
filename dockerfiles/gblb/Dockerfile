FROM java:8-jdk-alpine

WORKDIR /tmp

# wget https有効化　ライブラリインストール
RUN apk update && apk add openssl
RUN apk add openssh
RUN apk add bash
RUN apk add git
#JDKインストール
RUN apk --no-cache add openjdk8

# scala追加
RUN wget -O - 'http://downloads.typesafe.com/scala/2.12.3/scala-2.12.3.tgz' | tar zxvf - && mkdir /usr/local/scala && mv scala-2.12.3 /usr/local/scala
ENV PATH $PATH:/usr/local/scala/scala-2.12.3/bin

RUN echo $PATH
RUN which scala

# sbt追加
RUN wget -O - 'https://github.com/sbt/sbt/releases/download/v1.0.2/sbt-1.0.2.tgz' | tar zxvf - && mv /tmp/sbt /usr/bin
ENV PATH $PATH:/usr/bin/sbt/bin
RUN echo $PATH

# コンテナ起動時に実行するコマンド
# とりあえず即時終了しないコマンドを指定しておく
CMD ["top"]
