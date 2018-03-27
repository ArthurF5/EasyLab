<p align="center">
    <img src="./docs/Apoio ao Projeto/LogoEasyLab/logo.png" width="25%" alt="Uma plataforma que promete modificar a forma de buscar laboratórios que realizam determinados exames">
</p>

## Site e Android APK

## Justificativa do Projeto

<p>Com uma proposta de facilitar na forma que um Paciente/Cliente procura por laboratórios que realizem seu exame. Com o EasyLab ele informa ao sistema todos os exames que necessita de um diagnóstico, e o mesmo mostra a lista de laboratórios que realizam tais exames, exibindo uma unidade (Laboratório), para que possa realizar o exame, evitando transtornos nos quais teria se tivesse que procurar a cada laboratório. <p>
<p>Uma plataforma que promete aumentar a velocidade e a praticidade, na busca e no trajeto até o laboratório mais próximo.<p>


## Escopo

```
Administrador do Sistema
1. Manter Laboratório
2. Manter Unidade 
3. Manter Usuários 
4. Manter Exames

Administrador do Laboratório
1. Editar Informações do Laboratório
2. Manter Unidade
3. Manter Colaboradores
4. Atribuir Exames

Colaborador do Laboratório
1. Editar Informações da Unidade
2. Atribuir Exames

Paciente
1. Busca por exames

```

### Instalação:

Este é um projeto ionic, para realizar a instalação, baixe o projeto entre e instale as dependencias do nodejs, lembre-se é necessario possuir o ionic instalado, saiba mais em: https://ionicframework.com/getting-started/
```bash
$ npm install
$ ionic serve
```

Depois, para compilar para algum dispositivo, entre no terminal e digite:

```bash
$ ionic cordova platform add android
$ ionic cordova build android 
```

