# Sistema de Vendas de Loja de Maquiagem

Um sistema simples de vendas de loja de maquiagem feito para a disciplina de Banco de Dados 1 do Curso de Sistemas e Mídias Digitais - UFC.




## Pré-requisitos




* **Tenha o Docker instalado**

* **Tenha o Docker Compose Plugin instalado**

    Cenário 1: Não tem nada baixado, nem docker nem docker compose

    - Instale o [Docker Desktop][docker] ai ele ja vem com o Docker Compose

    Cenário 2: Tem o docker, mas n tem o docker compose

    - Instale o Plugin [Compose][docker-compose]


### Instalação

* Com docker Instalado:

    - Entre na pasta do projeto
    - Crie as variáveis de ambiente em um arquivo .env de acordo com o .env.example que
    deixei no projeto

    ```sh
    docker-compose up
    ```

    **Pronto**

    - O servidor backend está rodando em um container não está exposto para
    acesso local

    - O banco de dados postgres em outro container não está exposto para acesso
    local

    - O frontend está rodando em um outro container que não está exposto para
    acesso local

    - Um proxy reverso está exposto na porta 80 que faz os devidos
    encaminhamentos para o frontend e backend


## Uso


Link: [Aplicação]( http://locahost/)

Prefere ver o swagger com as rotas? Link: [Swagger UI]( http://localhost/swagger-ui/index.html )

** Atenção: ** O Swagger contem todas as rotas da API


## Documentação adicional e agradecimento


#### Requisitos

---

| Requisito                          | Status   | ENDPOINT/DESC                   | METODO                                             |
|-----------                         |--------  |-----                            |-----                                               |
| 5 Tabelas                          | OK       |                                 |                                                    |
| 5 PK                               | OK       |                                 |                                                    |
| 3 FK                               | OK       |                                 |                                                    |
|-----------                         |--------  |-----                            |-----                                               |
| 5 SELECT                           | OK       |                                 |                                                    |
|-----------                         |--------  |-----                            |-----                                               |
| 1 SELECT VENDEDOR                  | OK       | /api/v1/seller                  | [ GET ]( http://localhost:6969/api/v1/seller )     |
| 1 SELECT VENDAL                    | OK       | /api/v1/sell                    | [ GET ]( http://localhost:6969/api/v1/sell )       |
| 1 SELECT PRODUTO                   | OK       | /api/v1/product                 | [ GET ]( http://localhost:6969/api/v1/product )    |
| 1 SELECT CLIENTE                   | OK       | /api/v1/client                  | [ GET ]( http://localhost:6969/api/v1/client )     |
| 1 SELECT FILIAL                    | OK       | /api/v1/branch                  | [ GET ]( http://localhost:6969/api/v1/branch )     |
|-----------                         |--------  |-----                            |-----                                               |
| 3 INSERT                           |          |                                 |                                                    |
|-----------                         |--------  |-----                            |-----                                               |
| 1 INSERT PRODUTO                   |  OK      | /api/v1/product/                | POST                                               |
| 1 INSERT FILIAL                    |  OK      | /api/v1/branch/                 | POST                                               |
|-----------                         |--------  |-----                            |-----                                               |
| 2 UPDATE                           |          |                                 |                                                    |
|-----------                         |--------  |-----                            |-----                                               |
| 1 UPDATE VENDEDOR                  |  OK      | /api/v1/seller/{id}             | PATCH                                              |
| 1 UPDATE CLIENTE                   |  OK      | /api/v1/client/{id}             | PATCH                                              |
|-----------                         |--------  |-----                            |-----                                               |
| 2 DELETE                           |          |                                 |                                                    |
|-----------                         |--------  |-----                            |-----                                               |
| 1 DELETE VENDEDOR                  |  OK      | /api/v1/seller/{id}             | DELETE                                             |
| 1 DELETE PRODUTO                   |  OK      | /api/v1/client/{id}             | DELETE                                             |


### Estrutura do projeto

```

.
├── backend
│   ├── backup
│   │   └── maykdb2023-12-03.sql
│   ├── Dockerfile
│   ├── HELP.md
│   ├── maykdb2023-11-20.sql
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── smd
│   │   │   │           └── umake
│   │   │   │               ├── controllers
│   │   │   │               │   ├── BranchController.java
│   │   │   │               │   ├── ClientController.java
│   │   │   │               │   ├── ProductController.java
│   │   │   │               │   ├── SaleController.java
│   │   │   │               │   └── SellerController.java
│   │   │   │               ├── dtos
│   │   │   │               │   ├── BranchDTO.java
│   │   │   │               │   ├── CategoryDTO.java
│   │   │   │               │   ├── ClientDTO.java
│   │   │   │               │   ├── ProductDTO.java
│   │   │   │               │   ├── ProductSaleDTO.java
│   │   │   │               │   ├── SaleDTO.java
│   │   │   │               │   └── SellerDTO.java
│   │   │   │               ├── entities
│   │   │   │               │   ├── Branch.java
│   │   │   │               │   ├── ClientContact.java
│   │   │   │               │   ├── Client.java
│   │   │   │               │   ├── ProductCat.java
│   │   │   │               │   ├── Product.java
│   │   │   │               │   ├── Sale.java
│   │   │   │               │   ├── SaleProduct.java
│   │   │   │               │   ├── SaleProductKey.java
│   │   │   │               │   ├── Seller.java
│   │   │   │               │   ├── Stock.java
│   │   │   │               │   └── StockKey.java
│   │   │   │               ├── exceptions
│   │   │   │               │   ├── ApplicationExceptionHandler.java
│   │   │   │               │   ├── ArgumentInvalidException.java
│   │   │   │               │   ├── EntityAlreadyExistsException.java
│   │   │   │               │   └── EntityNotFoundException.java
│   │   │   │               ├── repositories
│   │   │   │               │   ├── BranchRepository.java
│   │   │   │               │   ├── ClientRepository.java
│   │   │   │               │   ├── ProductCatRepository.java
│   │   │   │               │   ├── ProductRepository.java
│   │   │   │               │   ├── SaleProductRepository.java
│   │   │   │               │   ├── SaleRepository.java
│   │   │   │               │   ├── SellerRepository.java
│   │   │   │               │   └── StockRepository.java
│   │   │   │               ├── services
│   │   │   │               │   ├── BranchService.java
│   │   │   │               │   ├── ClientService.java
│   │   │   │               │   ├── ProductCategoryService.java
│   │   │   │               │   ├── ProductService.java
│   │   │   │               │   ├── SaleService.java
│   │   │   │               │   ├── SellerService.java
│   │   │   │               │   └── StockService.java
│   │   │   │               └── UmakeApplication.java
│   │   │   └── resources
│   │   │       ├── application.properties
│   │   │       ├── static
│   │   │       └── templates
│   │   └── test
│   │       └── java
│   │           └── com
│   │               └── smd
│   │                   └── umake
│   │                       └── UmakeApplicationTests.java
│   └── target
│       ├── classes
│       │   ├── application.properties
│       │   └── com
│       │       └── smd
│       │           └── umake
│       │               ├── controllers
│       │               │   ├── BranchController.class
│       │               │   ├── ClientController.class
│       │               │   ├── ProductController.class
│       │               │   ├── SaleController.class
│       │               │   └── SellerController.class
│       │               ├── dtos
│       │               │   ├── BranchDTO.class
│       │               │   ├── CategoryDTO.class
│       │               │   ├── ClientDTO.class
│       │               │   ├── ProductDTO.class
│       │               │   ├── ProductSaleDTO.class
│       │               │   ├── SaleDTO.class
│       │               │   └── SellerDTO.class
│       │               ├── entities
│       │               │   ├── Branch.class
│       │               │   ├── Client.class
│       │               │   ├── ClientContact.class
│       │               │   ├── ProductCat.class
│       │               │   ├── Product.class
│       │               │   ├── Sale.class
│       │               │   ├── SaleProduct.class
│       │               │   ├── SaleProductKey.class
│       │               │   ├── Seller.class
│       │               │   ├── Stock.class
│       │               │   └── StockKey.class
│       │               ├── exceptions
│       │               │   ├── ApplicationExceptionHandler.class
│       │               │   ├── ArgumentInvalidException.class
│       │               │   ├── EntityAlreadyExistsException.class
│       │               │   └── EntityNotFoundException.class
│       │               ├── repositories
│       │               │   ├── BranchRepository.class
│       │               │   ├── ClientRepository.class
│       │               │   ├── ProductCatRepository.class
│       │               │   ├── ProductRepository.class
│       │               │   ├── SaleProductRepository.class
│       │               │   ├── SaleRepository.class
│       │               │   ├── SellerRepository.class
│       │               │   └── StockRepository.class
│       │               ├── services
│       │               │   ├── BranchService.class
│       │               │   ├── ClientService.class
│       │               │   ├── ProductCategoryService.class
│       │               │   ├── ProductService.class
│       │               │   ├── SaleService.class
│       │               │   ├── SellerService.class
│       │               │   └── StockService.class
│       │               ├── UmakeApplication$1.class
│       │               └── UmakeApplication.class
│       ├── generated-sources
│       │   └── annotations
│       ├── generated-test-sources
│       │   └── test-annotations
│       ├── maven-status
│       │   └── maven-compiler-plugin
│       │       └── compile
│       │           └── default-compile
│       │               ├── createdFiles.lst
│       │               └── inputFiles.lst
│       └── test-classes
│           └── com
│               └── smd
│                   └── umake
│                       └── UmakeApplicationTests.class
├── docker-compose.yml
├── nginx.conf
├── README.md
├── tree.txt
└── web_bd_system
    ├── analysis_options.yaml
    ├── android
    │   ├── app
    │   │   ├── build.gradle
    │   │   └── src
    │   │       ├── debug
    │   │       │   └── AndroidManifest.xml
    │   │       ├── main
    │   │       │   ├── AndroidManifest.xml
    │   │       │   ├── java
    │   │       │   │   └── io
    │   │       │   │       └── flutter
    │   │       │   │           └── plugins
    │   │       │   │               └── GeneratedPluginRegistrant.java
    │   │       │   ├── kotlin
    │   │       │   │   └── com
    │   │       │   │       └── example
    │   │       │   │           └── web_bd_system
    │   │       │   │               └── MainActivity.kt
    │   │       │   └── res
    │   │       │       ├── drawable
    │   │       │       │   └── launch_background.xml
    │   │       │       ├── drawable-v21
    │   │       │       │   └── launch_background.xml
    │   │       │       ├── mipmap-hdpi
    │   │       │       │   └── ic_launcher.png
    │   │       │       ├── mipmap-mdpi
    │   │       │       │   └── ic_launcher.png
    │   │       │       ├── mipmap-xhdpi
    │   │       │       │   └── ic_launcher.png
    │   │       │       ├── mipmap-xxhdpi
    │   │       │       │   └── ic_launcher.png
    │   │       │       ├── mipmap-xxxhdpi
    │   │       │       │   └── ic_launcher.png
    │   │       │       ├── values
    │   │       │       │   └── styles.xml
    │   │       │       └── values-night
    │   │       │           └── styles.xml
    │   │       └── profile
    │   │           └── AndroidManifest.xml
    │   ├── build.gradle
    │   ├── gradle
    │   │   └── wrapper
    │   │       ├── gradle-wrapper.jar
    │   │       └── gradle-wrapper.properties
    │   ├── gradle.properties
    │   ├── gradlew
    │   ├── gradlew.bat
    │   ├── local.properties
    │   └── settings.gradle
    ├── build
    │   ├── 25c7fdbd37e2353f978846c51150293c.cache.dill.track.dill
    │   ├── 96e74c4b56d7ae5e5ba2180790adf14d
    │   │   ├── _composite.stamp
    │   │   ├── gen_dart_plugin_registrant.stamp
    │   │   └── gen_localizations.stamp
    │   ├── flutter_assets
    │   │   ├── AssetManifest.bin
    │   │   ├── AssetManifest.json
    │   │   ├── FontManifest.json
    │   │   ├── fonts
    │   │   │   └── MaterialIcons-Regular.otf
    │   │   ├── kernel_blob.bin
    │   │   ├── NOTICES.Z
    │   │   ├── packages
    │   │   │   └── cupertino_icons
    │   │   │       └── assets
    │   │   │           └── CupertinoIcons.ttf
    │   │   ├── shaders
    │   │   │   └── ink_sparkle.frag
    │   │   └── version.json
    │   ├── linux
    │   │   └── x64
    │   │       └── debug
    │   │           ├── build.ninja
    │   │           ├── bundle
    │   │           │   ├── data
    │   │           │   │   ├── flutter_assets
    │   │           │   │   │   ├── AssetManifest.bin
    │   │           │   │   │   ├── AssetManifest.json
    │   │           │   │   │   ├── FontManifest.json
    │   │           │   │   │   ├── fonts
    │   │           │   │   │   │   └── MaterialIcons-Regular.otf
    │   │           │   │   │   ├── kernel_blob.bin
    │   │           │   │   │   ├── NOTICES.Z
    │   │           │   │   │   ├── packages
    │   │           │   │   │   │   └── cupertino_icons
    │   │           │   │   │   │       └── assets
    │   │           │   │   │   │           └── CupertinoIcons.ttf
    │   │           │   │   │   ├── shaders
    │   │           │   │   │   │   └── ink_sparkle.frag
    │   │           │   │   │   └── version.json
    │   │           │   │   └── icudtl.dat
    │   │           │   ├── lib
    │   │           │   │   └── libflutter_linux_gtk.so
    │   │           │   └── web_bd_system
    │   │           ├── CMakeCache.txt
    │   │           ├── CMakeFiles
    │   │           │   ├── 3.27.9
    │   │           │   │   ├── CMakeCXXCompiler.cmake
    │   │           │   │   ├── CMakeDetermineCompilerABI_CXX.bin
    │   │           │   │   ├── CMakeSystem.cmake
    │   │           │   │   └── CompilerIdCXX
    │   │           │   │       ├── a.out
    │   │           │   │       ├── CMakeCXXCompilerId.cpp
    │   │           │   │       └── tmp
    │   │           │   ├── cmake.check_cache
    │   │           │   ├── CMakeConfigureLog.yaml
    │   │           │   ├── pkgRedirects
    │   │           │   ├── rules.ninja
    │   │           │   ├── TargetDirectories.txt
    │   │           │   └── web_bd_system.dir
    │   │           │       ├── flutter
    │   │           │       │   └── generated_plugin_registrant.cc.o
    │   │           │       ├── main.cc.o
    │   │           │       └── my_application.cc.o
    │   │           ├── cmake_install.cmake
    │   │           ├── flutter
    │   │           │   ├── CMakeFiles
    │   │           │   └── cmake_install.cmake
    │   │           ├── install_manifest.txt
    │   │           └── intermediates_do_not_run
    │   │               └── web_bd_system
    │   └── native_assets
    │       └── linux
    ├── Dockerfile
    ├── ios
    │   ├── Flutter
    │   │   ├── AppFrameworkInfo.plist
    │   │   ├── Debug.xcconfig
    │   │   ├── flutter_export_environment.sh
    │   │   ├── Generated.xcconfig
    │   │   └── Release.xcconfig
    │   ├── Runner
    │   │   ├── AppDelegate.swift
    │   │   ├── Assets.xcassets
    │   │   │   ├── AppIcon.appiconset
    │   │   │   │   ├── Contents.json
    │   │   │   │   ├── Icon-App-1024x1024@1x.png
    │   │   │   │   ├── Icon-App-20x20@1x.png
    │   │   │   │   ├── Icon-App-20x20@2x.png
    │   │   │   │   ├── Icon-App-20x20@3x.png
    │   │   │   │   ├── Icon-App-29x29@1x.png
    │   │   │   │   ├── Icon-App-29x29@2x.png
    │   │   │   │   ├── Icon-App-29x29@3x.png
    │   │   │   │   ├── Icon-App-40x40@1x.png
    │   │   │   │   ├── Icon-App-40x40@2x.png
    │   │   │   │   ├── Icon-App-40x40@3x.png
    │   │   │   │   ├── Icon-App-60x60@2x.png
    │   │   │   │   ├── Icon-App-60x60@3x.png
    │   │   │   │   ├── Icon-App-76x76@1x.png
    │   │   │   │   ├── Icon-App-76x76@2x.png
    │   │   │   │   └── Icon-App-83.5x83.5@2x.png
    │   │   │   └── LaunchImage.imageset
    │   │   │       ├── Contents.json
    │   │   │       ├── LaunchImage@2x.png
    │   │   │       ├── LaunchImage@3x.png
    │   │   │       ├── LaunchImage.png
    │   │   │       └── README.md
    │   │   ├── Base.lproj
    │   │   │   ├── LaunchScreen.storyboard
    │   │   │   └── Main.storyboard
    │   │   ├── GeneratedPluginRegistrant.h
    │   │   ├── GeneratedPluginRegistrant.m
    │   │   ├── Info.plist
    │   │   └── Runner-Bridging-Header.h
    │   ├── RunnerTests
    │   │   └── RunnerTests.swift
    │   ├── Runner.xcodeproj
    │   │   ├── project.pbxproj
    │   │   ├── project.xcworkspace
    │   │   │   ├── contents.xcworkspacedata
    │   │   │   └── xcshareddata
    │   │   │       ├── IDEWorkspaceChecks.plist
    │   │   │       └── WorkspaceSettings.xcsettings
    │   │   └── xcshareddata
    │   │       └── xcschemes
    │   │           └── Runner.xcscheme
    │   └── Runner.xcworkspace
    │       ├── contents.xcworkspacedata
    │       └── xcshareddata
    │           ├── IDEWorkspaceChecks.plist
    │           └── WorkspaceSettings.xcsettings
    ├── lib
    │   ├── categories
    │   │   ├── home
    │   │   │   ├── api
    │   │   │   │   ├── categories_model.dart
    │   │   │   │   └── categories_service.dart
    │   │   │   ├── bloc
    │   │   │   │   ├── categories_bloc.dart
    │   │   │   │   ├── categories_event.dart
    │   │   │   │   └── categories_state.dart
    │   │   │   └── widgets
    │   │   │       ├── categories_card.dart
    │   │   │       └── categories.dart
    │   │   ├── register
    │   │   │   ├── api
    │   │   │   │   ├── categories_post_model.dart
    │   │   │   │   ├── categories_post_response_model.dart
    │   │   │   │   └── categories_register_service.dart
    │   │   │   ├── bloc
    │   │   │   │   ├── categories_register_bloc.dart
    │   │   │   │   ├── categories_register_event.dart
    │   │   │   │   └── categories_register_state.dart
    │   │   │   └── widgets
    │   │   │       └── categories_register.dart
    │   │   └── update
    │   │       ├── api
    │   │       │   ├── categories_update_model.dart
    │   │       │   ├── categories_update_response_model.dart
    │   │       │   └── categories_update_service.dart
    │   │       ├── bloc
    │   │       │   ├── categories_update_bloc.dart
    │   │       │   ├── categories_update_event.dart
    │   │       │   └── categories_update_state.dart
    │   │       └── widgets
    │   │           └── categories_update.dart
    │   ├── clients
    │   │   ├── home
    │   │   │   ├── api
    │   │   │   │   ├── client_model.dart
    │   │   │   │   └── client_service.dart
    │   │   │   ├── bloc
    │   │   │   │   ├── client_bloc.dart
    │   │   │   │   ├── client_event.dart
    │   │   │   │   └── client_state.dart
    │   │   │   └── widgets
    │   │   │       ├── client_card.dart
    │   │   │       └── clients.dart
    │   │   └── register
    │   │       ├── api
    │   │       │   ├── client_post_model.dart
    │   │       │   ├── client_post_response_model.dart
    │   │       │   └── client_register_service.dart
    │   │       ├── bloc
    │   │       │   ├── client_register_bloc.dart
    │   │       │   ├── client_register_event.dart
    │   │       │   └── client_register_state.dart
    │   │       └── client_register.dart
    │   ├── main.dart
    │   ├── my_home_page.dart
    │   ├── products
    │   │   └── home
    │   │       ├── api
    │   │       │   ├── products_model.dart
    │   │       │   └── products_service.dart
    │   │       ├── bloc
    │   │       │   ├── products_bloc.dart
    │   │       │   ├── products_event.dart
    │   │       │   └── produts_state.dart
    │   │       └── widgets
    │   │           ├── products_card.dart
    │   │           └── products.dart
    │   ├── sales
    │   │   ├── api
    │   │   │   ├── sales_model.dart
    │   │   │   └── sales_service.dart
    │   │   ├── bloc
    │   │   │   ├── sales_bloc.dart
    │   │   │   ├── sales_event.dart
    │   │   │   └── sales_state.dart
    │   │   └── widgets
    │   │       ├── sales_card.dart
    │   │       └── sales.dart
    │   ├── sellers
    │   │   ├── home
    │   │   │   ├── api
    │   │   │   │   ├── sellers_model.dart
    │   │   │   │   └── sellers_service.dart
    │   │   │   ├── bloc
    │   │   │   │   ├── sellers_bloc.dart
    │   │   │   │   ├── sellers_event.dart
    │   │   │   │   └── sellers_state.dart
    │   │   │   └── widgets
    │   │   │       ├── sellers_card.dart
    │   │   │       └── sellers.dart
    │   │   ├── register
    │   │   │   ├── api
    │   │   │   │   ├── sellers_post_model.dart
    │   │   │   │   ├── sellers_post_response.dart
    │   │   │   │   └── sellers_register_service.dart
    │   │   │   ├── bloc
    │   │   │   │   ├── sellers_register_bloc.dart
    │   │   │   │   ├── sellers_register_event.dart
    │   │   │   │   └── sellers_register_state.dart
    │   │   │   └── sellers_register.dart
    │   │   └── update
    │   │       ├── api
    │   │       │   ├── sellers_update_model.dart
    │   │       │   ├── sellers_update_response_model.dart
    │   │       │   └── sellers_update_service.dart
    │   │       ├── bloc
    │   │       │   ├── sellers_update_bloc.dart
    │   │       │   ├── sellers_update_event.dart
    │   │       │   └── sellers_update_state.dart
    │   │       └── widgets
    │   │           └── seller_update.dart
    │   └── widgets
    │       ├── error_page.dart
    │       └── loading_page.dart
    ├── linux
    │   ├── CMakeLists.txt
    │   ├── flutter
    │   │   ├── CMakeLists.txt
    │   │   ├── ephemeral
    │   │   │   ├── flutter_linux
    │   │   │   │   ├── fl_basic_message_channel.h
    │   │   │   │   ├── fl_binary_codec.h
    │   │   │   │   ├── fl_binary_messenger.h
    │   │   │   │   ├── fl_dart_project.h
    │   │   │   │   ├── fl_engine.h
    │   │   │   │   ├── fl_event_channel.h
    │   │   │   │   ├── fl_json_message_codec.h
    │   │   │   │   ├── fl_json_method_codec.h
    │   │   │   │   ├── fl_message_codec.h
    │   │   │   │   ├── fl_method_call.h
    │   │   │   │   ├── fl_method_channel.h
    │   │   │   │   ├── fl_method_codec.h
    │   │   │   │   ├── fl_method_response.h
    │   │   │   │   ├── fl_pixel_buffer_texture.h
    │   │   │   │   ├── fl_plugin_registrar.h
    │   │   │   │   ├── fl_plugin_registry.h
    │   │   │   │   ├── fl_standard_message_codec.h
    │   │   │   │   ├── fl_standard_method_codec.h
    │   │   │   │   ├── fl_string_codec.h
    │   │   │   │   ├── fl_texture_gl.h
    │   │   │   │   ├── fl_texture.h
    │   │   │   │   ├── fl_texture_registrar.h
    │   │   │   │   ├── flutter_linux.h
    │   │   │   │   ├── fl_value.h
    │   │   │   │   └── fl_view.h
    │   │   │   ├── generated_config.cmake
    │   │   │   ├── icudtl.dat
    │   │   │   └── libflutter_linux_gtk.so
    │   │   ├── generated_plugin_registrant.cc
    │   │   ├── generated_plugin_registrant.h
    │   │   └── generated_plugins.cmake
    │   ├── main.cc
    │   ├── my_application.cc
    │   └── my_application.h
    ├── macos
    │   ├── Flutter
    │   │   ├── ephemeral
    │   │   │   ├── flutter_export_environment.sh
    │   │   │   └── Flutter-Generated.xcconfig
    │   │   ├── Flutter-Debug.xcconfig
    │   │   ├── Flutter-Release.xcconfig
    │   │   └── GeneratedPluginRegistrant.swift
    │   ├── Runner
    │   │   ├── AppDelegate.swift
    │   │   ├── Assets.xcassets
    │   │   │   └── AppIcon.appiconset
    │   │   │       ├── app_icon_1024.png
    │   │   │       ├── app_icon_128.png
    │   │   │       ├── app_icon_16.png
    │   │   │       ├── app_icon_256.png
    │   │   │       ├── app_icon_32.png
    │   │   │       ├── app_icon_512.png
    │   │   │       ├── app_icon_64.png
    │   │   │       └── Contents.json
    │   │   ├── Base.lproj
    │   │   │   └── MainMenu.xib
    │   │   ├── Configs
    │   │   │   ├── AppInfo.xcconfig
    │   │   │   ├── Debug.xcconfig
    │   │   │   ├── Release.xcconfig
    │   │   │   └── Warnings.xcconfig
    │   │   ├── DebugProfile.entitlements
    │   │   ├── Info.plist
    │   │   ├── MainFlutterWindow.swift
    │   │   └── Release.entitlements
    │   ├── RunnerTests
    │   │   └── RunnerTests.swift
    │   ├── Runner.xcodeproj
    │   │   ├── project.pbxproj
    │   │   ├── project.xcworkspace
    │   │   │   └── xcshareddata
    │   │   │       └── IDEWorkspaceChecks.plist
    │   │   └── xcshareddata
    │   │       └── xcschemes
    │   │           └── Runner.xcscheme
    │   └── Runner.xcworkspace
    │       ├── contents.xcworkspacedata
    │       └── xcshareddata
    │           └── IDEWorkspaceChecks.plist
    ├── pubspec.lock
    ├── pubspec.yaml
    ├── README.md
    ├── web
    │   ├── favicon.png
    │   ├── icons
    │   │   ├── Icon-192.png
    │   │   ├── Icon-512.png
    │   │   ├── Icon-maskable-192.png
    │   │   └── Icon-maskable-512.png
    │   ├── index.html
    │   └── manifest.json
    └── windows
        ├── CMakeLists.txt
        ├── flutter
        │   ├── CMakeLists.txt
        │   ├── ephemeral
        │   ├── generated_plugin_registrant.cc
        │   ├── generated_plugin_registrant.h
        │   └── generated_plugins.cmake
        └── runner
            ├── CMakeLists.txt
            ├── flutter_window.cpp
            ├── flutter_window.h
            ├── main.cpp
            ├── resource.h
            ├── resources
            │   └── app_icon.ico
            ├── runner.exe.manifest
            ├── Runner.rc
            ├── utils.cpp
            ├── utils.h
            ├── win32_window.cpp
            └── win32_window.h

191 directories, 380 files

```

[docker-compose]: https://docs.docker.com/compose/install/linux/#install-the-plugin-manually
[Docker]: https://docs.docker.com/engine/install/
