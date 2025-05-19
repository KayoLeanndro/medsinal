
# 📱 medSinal - Aplicativo Android

Este é um aplicativo Android desenvolvido em **Java**, com arquitetura padrão do Android Studio. Ele tem como objetivo oferecer uma base bem estruturada para o desenvolvimento de funcionalidades Android nativas, utilizando boas práticas e organização clara.

---

## 🧭 Estrutura do Projeto

```plaintext
medSinal/
├── app/
│   ├── manifests/
│   │   └── AndroidManifest.xml
│   ├── java/
│   │   ├── com.example.medsinal/              (Código principal)
│   │   ├── com.example.medsinal (androidTest)/ (Testes de Instrumentação)
│   │   └── com.example.medsinal (test)/       (Testes unitários locais)
│   ├── res/
│   │   ├── drawable/                          (Imagens e formas vetoriais)
│   │   ├── layout/                            (Arquivos XML de layout de UI)
│   │   ├── menu/                              (Menus da aplicação)
│   │   ├── mipmap/                            (Ícones do aplicativo)
│   │   ├── navigation/                        (Gráficos de navegação)
│   │   ├── values/                            (Strings, estilos, temas etc.)
│   │   └── xml/                               (Outros recursos em XML)
├── build.gradle (Project)
├── build.gradle (Module: app)
├── proguard-rules.pro
├── gradle.properties
├── gradle-wrapper.properties
├── libs.versions.toml
├── local.properties
└── settings.gradle
```

---

## 📁 Explicação das Pastas

### `manifests/`
- **AndroidManifest.xml**: Define informações essenciais do app (permissões, atividades, serviços, etc).

### `java/`
- `com.example.medsinal`: Código principal do app.
- `com.example.medsinal (androidTest)`: Testes de instrumentação (executados em emulador/dispositivo).
- `com.example.medsinal (test)`: Testes unitários locais (executados na JVM).

### `res/`
Contém os recursos visuais e auxiliares do app:
- `drawable/`: Imagens, formas e vetores.
- `layout/`: Arquivos de interface do usuário em XML.
- `menu/`: Definições de menus.
- `mipmap/`: Ícones do aplicativo em várias resoluções.
- `navigation/`: Gráficos de navegação do Jetpack.
- `values/`: Strings, temas, cores, dimensões e estilos.
- `xml/`: Arquivos de configuração extra (por exemplo, preferências).

---

## ⚙️ Arquivos de Configuração

- **build.gradle (Project)**: Configurações globais do projeto.
- **build.gradle (Module)**: Dependências e configurações específicas do app.
- **proguard-rules.pro**: Regras para otimização e ofuscação de código.
- **gradle.properties**: Parâmetros globais de build.
- **gradle-wrapper.properties**: Versão do Gradle usada no projeto.
- **libs.versions.toml**: Catálogo de versões das bibliotecas utilizadas.
- **local.properties**: Caminho local do Android SDK (**não deve ser versionado**).
- **settings.gradle**: Declaração dos módulos do projeto.

---

## 🚀 Como Executar o Projeto

### Pré-requisitos:
- Android Studio instalado
- Java JDK 11 ou superior
- SDK do Android configurado

### Passos:

1. Clone o repositório:
   ```bash
   git clone https://github.com/usuario/projeto-medSinal.git
   ```

2. Abra o Android Studio e selecione a pasta do projeto.

3. Aguarde a sincronização do Gradle.

4. Execute o app em um emulador ou dispositivo físico:
   - Clique no botão **Run** (ícone de play).

---

## 🧪 Executando os Testes

- **Testes unitários locais:**
  ```bash
  ./gradlew test
  ```

- **Testes instrumentados (emulador/dispositivo):**
  ```bash
  ./gradlew connectedAndroidTest
  ```

---

## 🤝 Contribuindo

1. Crie uma branch:
   ```bash
   git checkout -b minha-feature
   ```

2. Faça commits:
   ```bash
   git commit -m "Adiciona nova funcionalidade"
   ```

3. Envie seu código:
   ```bash
   git push origin minha-feature
   ```

4. Crie um Pull Request para a branch `main`.

---

## 📌 Observações

- Mantenha o código limpo e comentado.
- Verifique as versões do Gradle e SDK no Android Studio.
- Variáveis locais como `local.properties` não devem ser adicionadas ao controle de versão.

---

