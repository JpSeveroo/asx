# Proposta de Evolução — Sistema de Crédito ao Investidor

## Status

**Backlog — Pós MVP**

---

# Objetivo

Adicionar um sistema financeiro ao Anime Stock Exchange (ASX), permitindo que investidores utilizem crédito fornecido pela própria plataforma para ampliar seu poder de investimento.

O objetivo é introduzir mecânicas de alavancagem, gestão de risco e planejamento financeiro, tornando a experiência mais estratégica e aproximando-a de mercados financeiros reais.

---

# Visão Geral

O ASX atuará como uma instituição financeira dentro da plataforma, oferecendo linhas de crédito em Anicoins aos investidores.

O crédito poderá ser utilizado para aquisição de ativos e demais operações permitidas pelo sistema.

Cada operação deverá possuir regras próprias de contratação, cobrança e encerramento.

---

# Objetivos da Funcionalidade

- Introduzir uma camada estratégica de gerenciamento financeiro.
- Permitir operações de investimento utilizando capital emprestado.
- Criar uma relação de risco e recompensa mais significativa.
- Estimular planejamento financeiro por parte dos investidores.
- Diferenciar o ASX de simuladores tradicionais de bolsa.

---

# Funcionalidades Previstas

## Sistema de Empréstimos

Permitir que investidores solicitem crédito diretamente ao sistema.

Cada operação deverá registrar, no mínimo:

- valor concedido;
- saldo devedor;
- taxa de juros;
- data da contratação;
- prazo de pagamento;
- status da operação.

---

## Sistema de Juros

Aplicar juros automaticamente sobre todas as operações de crédito ativas.

O modelo de cálculo (juros simples ou compostos), a periodicidade da incidência e as taxas serão definidos durante a fase de projeto desta funcionalidade.

---

## Índice de Crédito

Cada investidor possuirá um Índice de Crédito responsável por representar sua confiabilidade financeira perante o sistema.

O índice poderá considerar fatores como:

- histórico de pagamentos;
- quantidade de empréstimos contratados;
- atrasos no pagamento;
- liquidações compulsórias;
- patrimônio líquido;
- tempo de atividade na plataforma.

O Índice de Crédito influenciará futuras operações financeiras do investidor.

---

## Limite de Crédito

Cada investidor possuirá um limite máximo de crédito calculado automaticamente pelo sistema.

Esse limite poderá variar conforme critérios definidos pela plataforma, como:

- Índice de Crédito;
- patrimônio líquido;
- histórico financeiro;
- regras da temporada.

---

## Liquidação Compulsória

Caso o patrimônio do investidor não seja suficiente para garantir sua dívida, o sistema poderá executar automaticamente a venda de ativos do portfólio para amortizar parcial ou totalmente o saldo devedor.

Toda liquidação compulsória deverá ser registrada para fins de auditoria.

---

## Inadimplência

Caso o investidor permaneça com dívida em aberto após os critérios estabelecidos pela plataforma, o sistema poderá aplicar penalidades, como:

- redução do Índice de Crédito;
- bloqueio de novos empréstimos;
- aumento das taxas de juros em operações futuras;
- restrições temporárias para novas operações financeiras.

As regras específicas de inadimplência serão definidas durante a implementação desta funcionalidade.

---

# Benefícios Esperados

- Maior profundidade estratégica para os investidores.
- Economia mais dinâmica.
- Incentivo ao gerenciamento de risco.
- Diferencial competitivo em relação a simuladores tradicionais de bolsa.
- Base para futuras mecânicas financeiras.

---

# Impactos Arquiteturais

A implementação desta funcionalidade exigirá novos módulos e serviços, incluindo:

- Serviço de Crédito;
- Serviço de Juros;
- Serviço de Índice de Crédito;
- Serviço de Cobrança;
- Serviço de Liquidação;
- Auditoria Financeira.

Também será necessária a modelagem de novas entidades relacionadas às operações de crédito, histórico financeiro e indicadores de risco.

---

# Dependências

Esta funcionalidade depende da estabilização dos principais módulos do MVP, incluindo:

- Sistema de Autenticação;
- Carteira;
- Portfólio;
- Mercado de Ações;
- Precificação;
- Histórico de Transações;
- Sistema de Temporadas.

---

# Prioridade

**Baixa (Pós MVP)**

Esta funcionalidade deverá ser implementada apenas após a consolidação do núcleo do ASX, garantindo que a economia principal da plataforma esteja estável antes da introdução de mecanismos avançados de crédito e gestão financeira.

---

# Possíveis Expansões Futuras

O Sistema de Crédito poderá servir como base para novas funcionalidades, como:

- diferentes modalidades de empréstimo;
- programas de fidelidade financeira;
- eventos econômicos que afetem taxas de juros;
- políticas dinâmicas de concessão de crédito;
- conquistas relacionadas à gestão financeira;
- rankings de investidores por eficiência financeira;
- integração com futuras mecânicas econômicas do ASX.

---