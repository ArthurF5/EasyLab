create database if not exists easylabDB;
use easylabDB;

create table if not exists uf(
	id_UF int primary key auto_increment not null,
    uf varchar(2) not null,
    estado varchar(30) not null
)engine = innodb;

create table if not exists cidade(
	id_Cidade int primary key auto_increment not null,
    cidade varchar(100) not null,
    id_UF int not null,
    constraint cidadeUF foreign key(id_UF) references uf(id_UF)
)engine = innodb;

create table if not exists laboratorio(
	id_Laboratorio int primary key auto_increment not null,
    laboratorio varchar(50) not null
)engine = innodb;

create table if not exists unidadeLaboratorio(
	id_UnidadeLaboratorio int primary key auto_increment not null,
    nomeUnidade varchar(50) not null,
    logradouro varchar(100) not null,
    complemento varchar(50),
    numero varchar(6),
    id_Cidade int not null,
    id_Laboratorio int not null,
    constraint unidadeCidade foreign key(id_Cidade) references cidade(id_Cidade),
    constraint unidadeLaboratorial foreign key(id_Laboratorio) references laboratorio(id_Laboratorio)
)engine = innodb;

create table if not exists exame(
	id_Exame int primary key auto_increment not null,
    exame varchar(60) not null,
    sigla varchar(6) not null
)engine = innodb;

create table if not exists convenio(
	id_Convenio int primary key auto_increment not null,
    convenio varchar(30) not null
)engine = innodb;

create table if not exists exameUnidade(
	id_exameUnidade int primary key auto_increment not null,
    id_Exame int not null,
    id_UnidadeLaboratorio int not null,
    id_Convenio int,
    valor decimal(10,2),
    constraint exameUniadeExame foreign key(id_Exame) references exame(id_Exame),
    constraint exameUnidadeUnidade foreign key(id_UnidadeLaboratorio) references unidadeLaboratorio(id_UnidadeLaboratorio),
    constraint exameUnidadeConvenio foreign key(id_Convenio) references convenio(id_Convenio)
)engine = innodb;

create table if not exists permissao(
	id_Permissao int primary key auto_increment not null,
    permissao varchar(30) not null
)engine = innodb;

create table if not exists perfilUsuario(
	id_PerfilUsuario int primary key auto_increment not null,
    perfilUsuario varchar(30) not null
)engine = innodb;

create table if not exists usuario(
	id_Usuario int primary key auto_increment not null,
    usuario varchar(20) not null,
    email varchar(100) not null,
    senha varchar(40) not null
)engine = innodb;

create table if not exists permissaoPerfil(
	id_PermissaoPerfil int primary key auto_increment not null,
    id_Permissao int not null,
    id_PerfilUsuario int not null,
    constraint permissaoPerfilPermissao foreign key(id_Permissao) references permissao(id_Permissao),
    constraint permissaoPerfilPerfilUsuario foreign key(id_PerfilUsuario) references perfilUsuario(id_PerfilUsuario)
)engine = innodb;

create table if not exists usuarioPerfil(
	id_UsuarioPerfil int primary key auto_increment not null,
    id_PerfilUsuario int not null,
    id_Usuario int not null,
    constraint usuarioPerfilPerfil foreign key(id_PerfilUsuario) references perfilUsuario(id_PerfilUsuario),
    constraint usuarioPerfilUsuario foreign key(id_Usuario) references usuario(id_Usuario)
)engine = innodb;