# 🤝 Guia de Contribuição - Equipe Jogo da Velha

Bem-vindos ao projeto! Para que todos possam contribuir de forma organizada e para que a professora veja o uso correto de **Branches** e **Pull Requests**, sigam este passo a passo:

---

### 1. Preparação do Ambiente
Antes de iniciar qualquer tarefa, garanta que seu repositório local está sincronizado com a versão oficial:
```bash
git checkout main
git pull origin main
```
---
### 2. Criando sua Branch
Nunca faça alterações diretamente na branch main. Crie uma ramificação específica para a sua tarefa:

```Bash
# Exemplo: git checkout -b feature-placar-yuri
git checkout -b feature-[nome-da-sua-tarefa]
```
---
### 3. Desenvolvimento
Realize as alterações combinadas no IntelliJ:

- Ana: Implementação de cores ANSI no console.

- Yuri: Sistema de placar e loop de "Jogar Novamente".

- Lucas: Refatoração da lógica de verificação ou "Quase Vitória".

---
### 4. Enviando as Alterações
Após testar se o jogo está funcionando sem erros:

```Bash
git add .
git commit -m "Explique brevemente o que você adicionou/mudou"
git push origin feature-[nome-da-sua-tarefa]
```
---
### 5. Abrindo o Pull Request (PR)
1. Vá até a página do repositório no GitHub.

2. Você verá um banner verde: "Compare & pull request". Clique nele.

3. Descreva o que foi feito e clique em "Create pull request".

4. Um membro da equipe fará a Revisão e a Aprovação.
   Pois quem abre a (PR) "Não pode aprová-la", só então será possível o (merge) para a branch principal.  

---
