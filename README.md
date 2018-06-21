# referee_bot

A referee for deciding who wins in a round of rock paper and scissors

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server


## Docker

You can build the image with
> docker build -t referee_bot .

You can run the image with
docker run -it --rm --name refBot1 -p 3000:3000 referee_bot