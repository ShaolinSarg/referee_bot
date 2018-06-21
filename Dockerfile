FROM clojure:alpine

COPY . /usr/src/app

WORKDIR /usr/src/app

CMD ["lein", "ring", "server-headless"]