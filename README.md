# Sobre o projeto 

# 🏥 clinic-health-care

A clinic-health-care é uma API para clínicas médicas que permite o cadastro de médicos, pacientes e o agendamento de consultas de forma eficiente. Com funcionalidades abrangentes, facilita o gerenciamento de informações dos profissionais de saúde, pacientes e o agendamento preciso de consultas, contribuindo para uma operação mais organizada e eficaz da clínica.

## 🎬 Vídeo de demonstração do projeto
Confira nosso vídeo detalhado onde cada recurso é explicado e demonstrado em ação! Você pode assistir ao vídeo [aqui]


https://github.com/Diog007/clinic-health-care/assets/151067241/539d708d-cefc-4dd0-b61f-c340ed2c1b2c




## 🚀 Deploy 
A API foi implantada na AWS para facilitar o teste. Você pode acessar a aplicação através deste [Swagger for application](http://3.142.99.151:8080/swagger-ui/index.html#/).

Aqui estão as credenciais padrão para obter o Token JWT :
```
{
  "login": "test@test.com",
  "senha": "123"
}
```
Depois de fazer a requisição de login, copie o token fornecido e cole-o na janela de diálogo do Swagger. Assim, você terá acesso a todas as requisições da aplicação.

## 🛠️ Compilação
Para gerar os arquivos-fonte, siga o padrão de um projeto Maven: `mvn clean install`.

Aqui estão alguns links úteis para a aplicação local:
- Login: http://localhost:8080/login
- Pacientes: http://localhost:8080/pacientes
- Médicos: http://localhost:8080/medicos
- Consultas: http://localhost:8080/consultas

## 🧰 Tecnologias utilizadas
Aqui estão algumas das principais tecnologias utilizadas no desenvolvimento do Clinic Med:

| Tecnologia | Versão |
| --- | --- |
| Java | 17 |
| Spring Boot | 3.2.1 |
| Spring MVC | 3.1.0 |
| Spring Security | 3.1.0 |
| JPA | 3.1.0 |
| Maven | 3.9.6 |
| Lombok | 3.1.0 |
| Auth0 JWT | 4.2.1 |
| MySQL | 8.0 |
| Flyway Core | 9.21.1 |

## 🎯 Funcionalidades
O Clinic health care oferece uma variedade de funcionalidades, incluindo:
- Gerenciamento completo de consultas (CRUD);
- Gerenciamento completo de médicos (CRUD);
- Gerenciamento completo de pacientes (CRUD).

## 📚 Como rodar o Projeto
Existem duas maneiras principais de começar com o Clinic Med:
1. [Baixe o ZIP do projeto](https://github.com/Diog007/clinic-health-care/archive/refs/heads/main.zip) e abra-o em uma IDE de sua escolha.
2. Clone o repositório usando o seguinte comando: `https://github.com/Diog007/clinic-health-care.git`.

Depois de obter o código-fonte, você pode instalar as dependências do projeto com `mvn clean install` e iniciar a aplicação com `mvn spring-boot:run`. A aplicação estará disponível na porta 8080. Para alterar a porta, modifique o `server.port` no arquivo `application.properties`.
