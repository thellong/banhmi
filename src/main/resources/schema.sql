drop database banhmi;
create database banhmi;
use banhmi;

create table if not exists Ingredient (
    id varchar(4) not null primary key,
    name varchar(25) not null,
    type varchar(10) not null
);
create table if not exists Banhmi (
    id bigint primary key,
    name varchar(50) not null,
    createdAt timestamp not null
);
create table if not exists Banhmi_Ingredients (
    banhmi bigint not null,
    ingredient varchar(4) not null
);
alter table Banhmi_Ingredients
add foreign key (banhmi) references Banhmi(id);
alter table Banhmi_Ingredients
add foreign key (ingredient) references Ingredient(id);

create table if not exists Banhmi_Order (
    id bigint primary key,
    deliveryName varchar(50) not null,
    deliveryStreet varchar(50) not null,
    deliveryCity varchar(50) not null,
    deliveryState varchar(2) not null,
    deliveryZip varchar(10) not null,
    ccNumber varchar(16) not null,
    ccExpiration varchar(5) not null,
    ccCVV varchar(3) not null,
    placedAt timestamp not null
);
create table if not exists Banhmi_Order_Banhmis (
    banhmiOrder bigint not null,
    banhmi bigint not null
);
alter table Banhmi_Order_Banhmis
add foreign key (banhmiOrder) references Banhmi_Order(id);
alter table Banhmi_Order_Banhmis
add foreign key (banhmi) references Banhmi(id);