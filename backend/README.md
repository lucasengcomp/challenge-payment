# Projeto ChallengePayment

---


## Descrição do problema:
A ideia deste desafio é resolver um problema comum no dia-a-dia de quem divide almoços/lanches com a equipe de trabalho. Vamos imaginar que você e mais um colega queiram dividir um lanche que estão pedindo pelo iFood/Uber Eats utilizando seu smartphone. Fica fácil descobrir quanto seu colega deverá lhe pagar quando não existe nenhum desconto ou valor de entrega, porém quando estes fatores entram em questão, simplesmente dividir o valor no meio pode não ser o mais justo.

Para ilustrar melhor esta situação, vamos supor que você pediu um hamburguer de R$40,00 e uma sobremesa de R$2,00, enquanto seu amigo pediu apenas um sanduíche de R$8,00. Logo, você pagará inicialmente um total de R$42,00 enquanto seu amigo pagará R$8,00. Porém, considere também que o pedido total teve um valor adicional de R$8,00 pela entrega e que houve um desconto de R$20,00 no total do pedido. Sendo assim, é justo que a entrega e o desconto sejam proporcionais ao valor dos itens que cada um comprou. Neste caso, temos o seguinte:

Hamburguer = 40,00
Sobremesa = 2,00
Sanduíche (amigo) = 8,00
Total = 50,00
Entrega = 8,00
Desconto = 20,00
Total a pagar = 38,00
Logo, dos R$38,00, o seu amigo deverá pagar R$6,08, enquanto você pagará R$31,92, que corresponde ao desconto e entrega proporcionais aos itens que foram solicitados por cada um.

Com o objetivo de facilitar esta conta, você deverá criar uma pequena aplicação que irá calcular o total que seus amigos deverão lhe pagar quando dividirem um almoço. Ao final, você deverá simplificar o pagamento gerando um link do Picpay (ou outra carteira de sua preferência), para enviar a cobrança a seus amigos. *Obs.: Podem existir inúmeras formas de facilitar esta cobrança, e o Picpay aqui mencionado é apenas uma delas, portanto deixe seu código adaptável para receber quaisquer outras formas de pagamento que poderão ser posteriormente integráveis à sua aplicação.

Requisitos necessários
Back-end deve ser feito em Java, utilizando frameworks de sua escolha
Deverão haver testes unitários
Considerar que você pode dividir a conta com um ou mais amigos
Considerar que podem haver descontos e acréscimos em reais, e também em porcentagem (por exemplo os 10% do garçom, quando o almoço for em um restaurante físico)
Front-end não será avaliado, já que o foco deste desafio é o back-end, porém deverá conter o mínimo necessário para inputar os dados e interagir com o back-end
Back/front devem estar totalmente desacoplados
Código deve ser disponibilizado em um repositório git (bitbucket, github e afins)

---

## Arquitetura usada no projeto:

Alistair Cockburn é o pai da Arquitetura hexagonal em 2005. Também conhecida como Arquitetura de Portas e Adaptadores. 
Poucos autores marcaram a Arquitetura Hexagonal como origem da Arquitetura de Microsserviços. 
É um sistema de plug-in que consiste em vários componentes fracamente acoplados que você pode conectar ao núcleo. 
A vantagem dessa divisão está na fácil troca de cada componente.
Os componentes se comunicam entre si por meio de interfaces públicas expostas (portas). 
Essas interfaces são normalmente usadas para notificações ou consulta e armazenamento de banco de dados. 
Os adaptadores são a cola entre os componentes e o mundo exterior. Mais adaptadores podem ser colados em uma porta. 
Por exemplo, a implantação de um serviço na AWS pode ser gerenciada por meio de CLI, Console ou Shell.

![Exemplo Arquitetura Hexagonal](https://herbertograca.files.wordpress.com/2018/11/100-explicit-architecture-svg.png?w=1200)

### Padrões usados no projeto:

#### Padrão strategy

O padrão Strategy é um padrão de projeto de software que pertence ao grupo de padrões comportamentais. 
Ele permite definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis. 
Dessa forma, o padrão Strategy permite que o algoritmo varie independentemente dos clientes que o utilizam.

1. **Encapsulação de Algoritmos**: O padrão Strategy encapsula algoritmos em classes separadas, permitindo que cada algoritmo seja tratado como uma entidade.

2. **Interchangeability (Intercambialidade)**: As estratégias são intercambiáveis, ou seja, podem ser trocadas dinamicamente durante a execução do programa sem que o cliente perceba. Isso permite uma maior flexibilidade.

3. **Client-Agnostic (Agnóstico ao Cliente)**: O cliente que utiliza a estratégia não precisa conhecer os detalhes da implementação dos algoritmos. Ele interage com a estratégia por meio de uma interface comum.

4. **Facilita Adição de Novas Estratégias**: É fácil adicionar novas estratégias sem modificar o cliente existente, desde que as estratégias sigam a mesma interface.

5. **Separation of Concerns (Separação de Preocupações)**: O padrão Strategy promove a separação das preocupações ao dividir a lógica do algoritmo da lógica do contexto que o utiliza.

O padrão Strategy é amplamente utilizado em situações em que é necessário escolher algoritmos ou comportamentos diferentes com base em condições específicas, 
sem a necessidade de modificar o código existente. Ele contribui para um design flexível, de fácil manutenção e extensível.


#### Padrão AAA

O padrão AAA é uma abordagem de estruturação de testes unitários amplamente reconhecida e adotada na comunidade de desenvolvimento de software. 
As letras "AAA" representam três fases principais que um teste unitário deve ter:

1. **Arrange (Preparação):**
Nesta fase, você configura o cenário de teste, preparando o ambiente para a execução do teste. 
Isso pode incluir a criação de objetos, a configuração de estados, a inicialização de variáveis e a definição de entradas necessárias para o teste.

2. **Act (Ação):**
Aqui, você executa a operação ou ação que deseja testar. Geralmente, é uma única chamada de método ou função que está sendo testada. 
Esta é a parte do teste onde o comportamento específico está sendo invocado.

3. **Assert (Validação):**
Nesta fase, você verifica se o resultado da ação realizada (a etapa "Act") é o esperado.
Você compara o resultado obtido com o resultado que você antecipou. Se os resultados correspondem, o teste passa; caso contrário, ele falha.

A estrutura AAA ajuda a tornar os testes mais organizados, legíveis e fáceis de entender.


#### Design pattern Data Transfer Objects (DTO)
Os DTOs são classes que contêm dados, geralmente sem lógica de negócios, e são usados para transferir dados entre sistemas, 
camadas ou componentes de um aplicativo.

---


## O que este repositório contém

1. Cadastros e consultas das entidades: Person, Order, Item

---

## O que foi usado de tecnologias: 

* `Spring`
* `JPA`
* `Validation`
* `h2-database`
* `Postgres`
* `Projectlombok`
* `Junit5`
* `Flywaydb`
* `Mapstruct`
* `Swagger`

---

## O que é necessário para startar o projeto

### Requisitos de Funcionamento

| Tecnologia | Main version (dev) |
|------------|--------------------|
| Java       | 11                 |
| Spring     | 3.0.4              |
| PostgreSQL | 12                 |

1. Criar uma base de dados com o nome `db_challenge`

---

## Modelo do diagrama usado

![Class diagram.png](docs%2FClass%20diagram.png)

---

## Arquivo para importação de endpoints do Postman, faça a importação do arquivo:
[CHALLENGE-Softexpert.postman_collection.json](docs%2FCHALLENGE-Softexpert.postman_collection.json)

## Com a aplicação acesso o swagger:

```
http://localhost:8080/api/v1/swagger-ui/index.html
```

---

