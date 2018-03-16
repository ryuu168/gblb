# ～準備～
JDKがインストールされているか確認
```
javac -version
```
なかったら以下urlからインストールする<br>
http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

docker for mac またはdocker for windows
をインストールし、dockerコマンドが使えるようにしておく。

# ～環境構築～
前提条件ローカルで**docker**が起動していること<br>

### KoDoのリポジトリをクローンする
    git clone このリポジトリURL
### アプリケーション起動 
-dはバックグラウンドで起動

    $ docker-compose up -d
### コンテナが起動してるか確認
```
$ docker-compose ps

      Name                    Command             State           Ports
--------------------------------------------------------------------------------
kodo_kodo_mysql_1   docker-entrypoint.sh mysqld   Up      0.0.0.0:3306->3306/tcp
kodo_play           top                           Up      0.0.0.0:9000->9000/tcp
```

### 起動したコンテナに接続 kodo_play
    $ docker-compose exec kodo_play bash
### kodo_playコンテナの中からアプリケーション起動
```
# cd ../app
# sbt run
```
最初の起動は時間がかかります
```$xslt
--- (Running the application, auto-reloading is enabled) ---

[info] p.c.s.AkkaHttpServer - Listening for HTTP on /0.0.0.0:9000

(Server started, use Enter to stop and go back to the console...)
```
上記のようになったら、 http://localhost:9000/ にアクセスして確認

### 起動したコンテナに接続 kodo_mysql
    docker-compose exec kodo_mysql bash


# よく使うコマンド
### yamlの更新
```
$ docker-compose build --no-cache kodo_play  //指定したコンテナをビルド
$ docker-compose stop kodo_play　　　　　　　 //指定したコンテナ停止　
$ docker-compose rm kodo_play                //指定したコンテナ削除
$ docker-compose up -d　　　　　　　　　　　   //コンテナ起動
```

### アプリケーション起動 (コンテナを一度起動している場合)
    
    docker-compose start
### アプリケーション終了
    
    docker-compose stop






# gblb
