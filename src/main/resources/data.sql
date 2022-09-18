delete from Taco;
delete from Ingredient;
delete from Taco_Ingredients;
delete from Taco_Order_Tacos;
delete from Ingredient;

insert into Ingredient (id, name, type) values ('TUONG', 'Tuong ot', 'SAUCE');
insert into Ingredient (id, name, type) values ('OT_TRAI', 'Ot trai', 'SAUCE');
insert into Ingredient (id, name, type) values ('P_HEO', 'Pate Heo', 'SAUCE');
insert into Ingredient (id, name, type) values ('TH_LUOC', 'Thit heo luoc', 'PORK');
insert into Ingredient (id, name, type) values ('TH_NUONG', 'Thit heo nuong', 'PORK');
insert into Ingredient (id, name, type) values ('TB_NUONG_T', 'Thit bo nuong thuong', 'BEEF');
insert into Ingredient (id, name, type) values ('TB_NUONG_D', 'Thit bo nuong dac biet', 'BEEF');
insert into Ingredient (id, name, type) values ('OMELET', 'Tuong ot', 'EGG');
insert into Ingredient (id, name, type) values ('OMELET_N', 'Tuong ot', 'EGG');
insert into Ingredient (id, name, type) values ('RAU_T', 'Co rau', 'VEGES');
insert into Ingredient (id, name, type) values ('RAU_K', 'Khong rau', 'VEGES');