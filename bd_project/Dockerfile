FROM cirrusci/flutter:stable

RUN mkdir /app/
WORKDIR /app
COPY . .

RUN git clone --depth=1 --branch=stable https://github.com/flutter/flutter.git /usr/local/flutter
ENV PATH="/usr/local/flutter/bin:/usr/local/flutter/bin/cache/dart-sdk/bin:${PATH}"
RUN flutter channel stable && flutter upgrade
RUN flutter config --enable-web
RUN flutter pub get
RUN flutter build web --release --web-renderer=auto

