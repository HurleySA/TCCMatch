# TCCMatch
O curso de Ciência da Computação da UFCG precisa de um sistema para facilitar a definição de temas e orientações de TCC a partir de interesses comuns entre docentes e discentes. O sistema TCC Match tem o objetivo de permitir que alunos busquem e sugiram temas, encontrem professores dispostos a orientar em áreas específicas, de forma a facilitar o processo de orientação nas disciplinas de Pré-TCC e TCC, tanto para alunos e professores quanto para a coordenação.

User Stories que devem ser implementadas

Eu, como coordenador e administrador, gostaria de ter o sistema armazenando todos os seus dados de forma persistente em um banco de dados.
Eu, como coordenador e administrador, gostaria de logar no sistema, para ter acesso às funcionalidades destinadas ao administrador.
Eu, como administrador, gostaria de acessar o sistema através de um link na web, preferencialmente usando o Heroku (outras opções de deploy podem ser usadas). Obs.: esta US é opcional, mas recomenda-se que seja realizada.
Eu, como coordenador e administrador, gostaria de cadastrar um aluno do curso de Ciência da Computação no sistema, informando nome completo, matrícula, email e período previsto para a conclusão do curso.
Eu, como coordenador e administrador, gostaria de atualizar ou remover o cadastro de um aluno do curso. Para tal, o aluno deve estar cadastrado no sistema.
Eu, como coordenador e administrador, gostaria de cadastrar um professor do curso de Ciência da Computação no sistema, informando nome completo, email e laboratórios do qual faz parte.
Eu, como coordenador e administrador, gostaria de atualizar ou remover o cadastro de um professor do curso. Para tal, o professor deve estar cadastrado no sistema.
Eu, como coordenador e administrador, gostaria de cadastrar áreas de estudo em Ciência da Computação (e.g. engenharia de software, banco de dados, etc.) disponíveis para o desenvolvimento de TCCs.
Eu, como aluno, gostaria de logar no sistema, para ter acesso às funcionalidades destinadas aos alunos.
Eu, como aluno, gostaria de selecionar áreas de estudo, em Ciência da Computação, que tenho interesse em realizar meu TCC.
Eu, como aluno, gostaria de listar professores, com seus respectivos contatos, que tenham interesse e disponibilidade (quota) para orientar temas de TCC nas minhas áreas de interesse.
Eu, como aluno, gostaria de cadastrar uma proposta de tema de TCC, informando título, descrição, status do trabalho e áreas de estudo relacionadas.
Eu, como aluno, gostaria de listar temas de TCC cadastrados pelos professores do curso, com informações de título, áreas de conhecimento e professor responsável.
Eu, como aluno, gostaria de solicitar orientação em um tema de TCC cadastrado por um professor.
Eu, como aluno, gostaria de ser notificado por email caso um novo tema de TCC nas minhas áreas de interesse seja cadastrado por um professor. Obs.: o email não precisa de fato ser enviado, mas a informação de envio deve ser apresentada pelo sistema.
Eu, como aluno, gostaria de ser notificado por email caso um professor manifeste interesse em orientar um tema de TCC cadastrado por mim. Obs.: o email não precisa de fato ser enviado, mas a informação de envio deve ser apresentada pelo sistema.
Eu, como aluno, gostaria de reportar à coordenação algum problema de orientação (e.g. indisponibilidade, comunicação, etc.)
Eu, como professor, gostaria de logar no sistema, para ter acesso às funcionalidades destinadas aos professores.
Eu, como professor, gostaria de selecionar áreas de estudo, em Ciência da Computação, que tenho interesse em orientar temas de TCC.
Eu, como professor, gostaria de configurar / atualizar minha disponibilidade para orientação de alunos no TCC (quota).
Eu, como professor, gostaria de cadastrar um tema de TCC, informando título, descrição e áreas de estudo relacionadas.
Eu, como professor, gostaria de listar os temas de TCC que eu cadastrei no sistema, com informações de título e áreas de conhecimento relacionadas.
Eu, como professor, gostaria de listar os temas de TCC cadastrados pelos alunos, com informações de título e áreas de conhecimento relacionadas.
Eu, como professor, gostaria de ser notificado por email caso um aluno solicite orientação em um tema de TCC cadastrado por mim. Obs.: o email não precisa de fato ser enviado, mas a informação de envio deve ser apresentada pelo sistema.
Eu, como professor, gostaria de poder listar solicitações de alunos para a orientação de temas de TCC cadastrados por mim.
Eu, como professor, gostaria de poder aprovar ou negar uma solicitação de aluno para a orientação de um tema de TCC cadastrado por mim. A resposta a solicitação deve ser obrigatoriamente acompanhada de uma mensagem.
Eu, como professor, gostaria de manifestar interesse em orientar um tema de TCC cadastrado por um aluno.
Eu, como coordenador e administrador, gostaria de ser notificado por email caso um professor aceite uma solicitação de orientação realizada por um aluno. Obs.: o email não precisa de fato ser enviado, mas a informação de envio deve ser apresentada pelo sistema.
Eu, como coordenador e administrador, gostaria de cadastrar uma orientação de TCC de um professor para um aluno, informado o período de realização do TCC.
Eu, como coordenador e administrador, gostaria de finalizar uma orientação de TCC realizada, indicando o período do TCC.
Eu, como professor, gostaria de listar minhas orientações em curso, que foram cadastradas pela coordenação.
Eu, como professor, gostaria de reportar à coordenação algum problema na orientação (e.g. indisponibilidade, comunicação, frequência, etc.)
Eu, como coordenador e administrador, gostaria de listar orientações em curso e finalizadas por semestre, com informações sobre aluno, orientador, tema e semestre do TCC.
Eu, como coordenador e administrador, gostaria de gerar um relatório com as informações sobre as orientações de TCC em curso e finalizadas por semestre, destacando as áreas do conhecimento relacionadas.
Eu, como coordenador e administrador, gostaria de gerar um relatório com os problemas de orientação apresentados no período, com separação de problemas reportados por alunos e professores.
