### Universidade Estadual de Feira de Santana
### Curso: Engenharia de Computação
### Disciplina: EXA 863 - MI de Algoritmos e Programação II
### Semestre: 2023.2
### Professores: Michele, Pâmela, Carlos, Rafael

### Tema do projeto PBL: Sistema de Gerenciamento de Biblioteca

#### Resumo do projeto:

O sistema permitirá aos usuários cadastrar livros, pesquisar por títulos, autores e
categorias, fazer empréstimos e devoluções.

#### Descrição do projeto:
Havia uma pequena biblioteca comunitária localizada em um bairro tranquilo. Os moradores
da região adoravam visitar o local para emprestar livros, participar de clubes de leitura e
aproveitar o ambiente acolhedor. No entanto, com o passar do tempo, a quantidade de
livros e usuários começou a crescer rapidamente, tornando o gerenciamento manual cada
vez mais desafiador.
A bibliotecária, Sra. Garcia, era responsável por administrar todas as operações da
biblioteca. Ela percebeu que o sistema atual de registro de empréstimos e devoluções, que
consistia em fichas de papel e planilhas, estava se tornando insuficiente para lidar com o
volume crescente de atividades. Era comum ocorrerem erros nos registros, extravios de
fichas e até mesmo problemas para identificar os usuários que haviam excedido o prazo de
devolução.
Com o novo sistema, ela poderia facilmente adicionar novos livros ao catálogo, registrar
informações importantes, como títulos, autores e categorias, e verificar a disponibilidade dos
exemplares. Além disso, os usuários teriam acesso a um computador, onde poderiam
pesquisar e reservar livros com facilidade.
Com o Sistema de Gerenciamento de Biblioteca em funcionamento, a Sra. Garcia poderia
concentrar seu tempo e esforços em melhorar ainda mais a experiência dos usuários na
biblioteca. Ela planejava organizar eventos literários, ampliar a variedade de livros
disponíveis e criar um ambiente acolhedor e estimulante para a comunidade.
A Sra. Garcia elaborou a seguinte lista de requisitos necessários para seu sistema:

1 Registro de Livros
O sistema deve permitir o registro de novos livros no
sistema, incluindo informações como título, autor,
editora, ISBN, ano de publicação e categoria.

2 Pesquisa de Livros
Os usuários devem ser capazes de pesquisar livros
por título, autor, ISBN ou categoria, a fim de
encontrar informações sobre disponibilidade,
localização e outras informações relevantes.

3 Empréstimo e Devolução
O sistema deve permitir o registro de empréstimos
de livros para os usuários da biblioteca. Isso inclui a
possibilidade de registrar a data de empréstimo, a
data de devolução esperada e a identificação do
usuário que realizou o empréstimo. Além disso, o
sistema deve permitir o registro da devolução dos
livros e a atualização da disponibilidade do livro.

4 Reserva de Livros
Os usuários devem ter a opção de reservar livros
que estejam emprestados por outros usuários. O
sistema deve registrar a reserva por ordem de
solicitação.

5 Renovação de Empréstimos
O sistema deve permitir a renovação dos
empréstimos de livros, desde que não haja outras
reservas para o mesmo livro e o limite de
renovações não tenha sido atingido.

6 Controle de Usuários
O sistema deve permitir o cadastro de novos
usuários, com informações como nome, endereço,
telefone e número de identificação. Além disso, deve
ser possível bloquear uma conta, não permitindo que
o usuário faça empréstimos e renovação.

7 Relatórios e Estatísticas
O sistema deve ser capaz de gerar relatórios e
estatísticas, como número de livros emprestados,
atrasados e reservados; histórico de empréstimos de
um usuário específico; e livros mais populares.

8 Gerenciamento de Multas
O sistema deve ser capaz de calcular e registrar
multas por atraso na devolução de livros. O usuário
deverá ser multado com o dobro de dias em atraso.

9 Gerenciamento de Acervo
O sistema deve permitir o gerenciamento do acervo
da biblioteca, incluindo adição, remoção e
atualização de informações sobre os livros, além do
controle de estoque.

10 Controle de operadores do
sistema
O sistema deve permitir o cadastro de novos
operadores, com informações como nome, número
de identificação, cargo e senha de acesso. Os
cargos podem ser do tipo Administrador ou
Bibliotecário. O Bibliotecário só terá acesso às
funcionalidades #1, #2 e #3.

Requisitos de desenvolvimento (obrigatório):
● Github como ferramenta para versionamento de código;
● Uma padronização de commits deverá ser adotada;
● A entrega do código deverá ser através da criação de uma release contendo:
○ Tag: número da versão (ex: v2.0)
○ Título: nome da fase (ex: Fase 2 -Implementação e testes)

○ Descrição: descrição de todos os requisitos desenvolvidos até o momento
● O código fonte deverá ser implementado na IDE IntelliJ IDEA
1
.

○ Facilita a integração com o JavaFX e o gerenciamento de dependências,
tornando a execução do código independente do ambiente de
desenvolvimento.
● Povoamento inicial dos dados
○ O sistema deve iniciar contendo dados fictícios;
○ Utilize ferramentas para geração de dados como o generatedata.com.

Produto:
● O produto poderá ser realizado individualmente ou em dupla e os artefatos
gerados a cada fase de desenvolvimento devem ser entregues conforme definido
pelo seu tutor.
● O código fonte deverá ser implementado na última versão estável do Java (utilize a
versão opensource do JDK, OpenJDK
2
) juntamente com o JavaFX
3
.

