/**
 * Sistema para Gestão de OS
 * @author Gustavo Cavalcante Moreira
 */
 
 create database dbsistema;
 
 use dbsistema;
 select * from usuarios where login = 'gusta' and senha = md5('123');
 
 show databases;

 show tables;
 
 describe usuarios;
 
 select * from usuarios;
 
 select * from clientes;
 
 insert into usuarios (nome,login,senha)
 values ('Gustavo Cavalcante','gusta', md5('123'));
 
 insert into usuarios (nome,login,senha,perfil)
 values ('Administrador','admin',md5('123@senac'), 'admin');
 
  insert into usuarios (nome,login,senha,perfil)
 values ('Chaves','chaves',md5('123@senac'), 'chaves');
 
 insert into usuarios (nome,login,senha)
 values ('Gustavo Lima','lima',md5('123@senac'));
 
 insert into usuarios (nome,login,senha)
 values ('João Vitor','joao',md5('123@senac'));
 
 
 select * from usuarios order by nome;
 
 alter table clientes add column endereco varchar(100);
 
 create table clientes (
	id int primary key auto_increment,
    nome varchar(50) not null,
    cpf varchar(15) not null unique,
    contato varchar(20),
    endereco varchar(100) );
    
    
    drop table clientes;
    
    delete from usuarios where id = 2;
    delete from clientes where id = 3;
    
     update contatos set fone = '99999-2341' where id = 2;
    
    update contatos set fone = '99999-9998', email = 'vava@gmail.com' where id = 5;
    
    update contatos set nome = 'Mario Gates', fone = '11 989637284', email = 'mariogates@outlook.com' where id = 6;
    
    select * from usuarios where login = 'admin' and senha = md5('admin');
    
    create table clientes (
     idcli int primary key auto_increment,
     nome varchar (50) not null,
     fone varchar (12) not null,
     endereco varchar (50) not null,
     cep varchar (10) not null,
     bairro varchar (30) not null,
	 complemento varchar (20),
     numero varchar (10) not null,
	 cidade varchar (30) not null,
     uf char (2) not null
);


describe clientes;
alter table clientes modify endereco varchar(100) not null;
alter table servicos modify valor decimal(0000000000000000.00) not null;

 select * from clientes;
 select * from usuarios;

-- busca avançada pelo nome (estilo google)
select nome from clientes where nome like 'a%' order by nome;
select nome from clientes where nome like 'a%' order by nome;

/* Relacionamento de tabelas 1- N */
-- timestamp default current_timestamp (data e hora automática)
-- decimal (números não inteiros) 10,2 (dígitos, casas decimais)
-- 1 (FK) --------- N (PK)
create table servicos (
     os int primary key auto_increment,
     dataOS timestamp default current_timestamp,
     equipamento varchar(200) not null,
     defeito varchar(200) not null,
     valor decimal(10,2),
     idcli int not null,
     foreign key (idcli) references clientes(idcli)
);
insert into servicos (equipamento,defeito,valor,idcli)
values ('Notebook LeNovo G90','Troca da fonte',250,3);
select * from servicos;
-- selecionando o conteúdo de 2 ou mais tabelas
select * from servicos
inner join clientes
on servicos.idcli = clientes.idcli;

/** RELATÓRIOS **/
-- clientes
select nome,fone from clientes order by nome ;
-- servicos
select servicos.os,servicos.dataOS,servicos.veiculo,servicos.problema,servicos.valor,clientes.nome from servicos inner join clientes on servicos.idcli = clientes.idcli order by os;

create table fornecedor (
    idfor int primary key auto_increment,
    nome varchar(50) not null,
    cnpj decimal(18) not null,
    fone varchar(15)not null,
    cep varchar (10),
    endereco varchar(50) not null,
    numero varchar(10) not null,
    complemento varchar (20),
    bairro varchar(30) not null,
    cidade varchar(30) not null,
    uf char(2) not null
);

drop table fornecedor;

drop table usuarios;
create table usuarios (
     id int primary key auto_increment,
     nome varchar (250) not null,
     login varchar (250) not null unique,
     senha varchar (250) not null,
     perfil varchar(10) not null
);